package com.wolffsarmormod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wolffsarmormod.common.types.EnumType;
import com.wolffsarmormod.common.types.InfoType;
import com.wolffsarmormod.common.types.TypeFile;
import com.wolffsarmormod.util.AliasFileManager;
import com.wolffsarmormod.util.DynamicReference;
import com.wolffsarmormod.util.FileUtils;
import com.wolffsarmormod.util.ResourceUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.commons.io.FilenameUtils;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContentManager
{
    public static Path flanFolder;

    // Mappings which allow to use aliases for duplicate short names and texture names (also contain unmodified references)
    // The idea behind dynamic references is to allow references to shortnames and textures to change
    // even after configs are registered (as long as item classes have not been instantiated yet)
    public static final Map<IContentProvider, Map<String, DynamicReference>> shortnameReferences = new HashMap<>();
    public static final Map<IContentProvider, Map<String, DynamicReference>> armorTextureReferences = new HashMap<>();
    public static final Map<IContentProvider, Map<String, DynamicReference>> guiTextureReferences = new HashMap<>();
    public static final Map<IContentProvider, Map<String, DynamicReference>> modelReferences = new HashMap<>();

    private static final String shortnamesAliasFile = "id_alias.json";
    private static final String armorTexturesAliasFile = "armor_textures_alias.json";
    private static final String guiTexturesAliasFile = "gui_textures_alias.json";

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final List<IContentProvider> contentPacks = new ArrayList<>();
    private final Map<IContentProvider, ArrayList<TypeFile>> files = new HashMap<>();
    private final Map<IContentProvider, ArrayList<InfoType>> configs = new HashMap<>();

    // Keep track of registered items and loaded textures
    private final Map<String, String> registeredItems = new HashMap<>(); // <shortname, config file name>
    private final Map<String, Map<String, TextureFile>> textures = new HashMap<>(); // <folder name, <lowercase name, texture file>>

    private record TextureFile(String name, IContentProvider contentPack) {}

    public ContentManager()
    {
        textures.put("armor", new HashMap<>());
        textures.put("gui", new HashMap<>());
    }

    public void findContentInFlanFolder()
    {
        loadFlanFolder();
        if (flanFolder == null)
            return;

        try
        {
            contentPacks.addAll(loadFoldersAndJarZipFiles(flanFolder)
                .entrySet()
                .stream()
                .map(entry -> new ContentPack(entry.getKey(), entry.getValue()))
                .toList());
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to load content packs from flan folder.", e);
        }
    }

    public void readContentPacks()
    {
        for (IContentProvider provider : contentPacks)
        {
            long startTime = System.currentTimeMillis();

            files.putIfAbsent(provider, new ArrayList<>());
            configs.putIfAbsent(provider, new ArrayList<>());

            armorTextureReferences.putIfAbsent(provider, new HashMap<>());
            guiTextureReferences.putIfAbsent(provider, new HashMap<>());
            shortnameReferences.putIfAbsent(provider, new HashMap<>());
            modelReferences.putIfAbsent(provider, new HashMap<>());

            readFiles(provider);
            registerConfigs(provider);

            if (FMLEnvironment.dist == Dist.CLIENT)
            {
                findDuplicateTextures(provider);
            }

            boolean archiveExtracted = false;
            boolean preLoadAssets = shouldPreLoadAssets(provider);

            if (shouldUnpackArchive(provider, preLoadAssets))
            {
                FileUtils.extractArchive(provider.getPath(), provider.getExtractedPath());
                archiveExtracted = true;
            }

            if (archiveExtracted || !provider.isArchive())
            {
                createMcMeta(provider);
                writeToAliasMappingFile(shortnamesAliasFile, provider,DynamicReference.getAliasMapping(shortnameReferences.get(provider)));
            }

            // preLoadAssets -> archive extracted
            if (preLoadAssets)
            {
                writeToAliasMappingFile(armorTexturesAliasFile, provider, DynamicReference.getAliasMapping(armorTextureReferences.get(provider)));
                writeToAliasMappingFile(guiTexturesAliasFile, provider, DynamicReference.getAliasMapping(guiTextureReferences.get(provider)));
                createItemJsonFiles(provider);
                createLocalization(provider);
                copyItemIcons(provider);
                copyTextures(provider, "armor", armorTextureReferences.get(provider));
                copyTextures(provider, "gui", guiTextureReferences.get(provider));
                createSounds(provider);
            }

            if (archiveExtracted)
            {
                FileUtils.repackArchive(provider);
            }

            long endTime = System.currentTimeMillis();
            ArmorMod.log.info("Loaded content pack {} in {} ms.", provider.getName(), String.format("%,d", endTime - startTime));
        }
    }

    private void loadFlanFolder()
    {
        if (!Files.exists(ArmorMod.flanPath) && !Files.exists(ArmorMod.fallbackFlanPath))
        {
            try
            {
                Files.createDirectories(ArmorMod.flanPath);
            }
            catch (Exception e)
            {
                ArmorMod.log.error("Failed to create the flan directory.", e);
                return;
            }
        }
        else if (!Files.exists(ArmorMod.flanPath) && Files.exists(ArmorMod.fallbackFlanPath))
        {
            ArmorMod.flanPath = ArmorMod.fallbackFlanPath;
        }

        flanFolder = ArmorMod.flanPath;
    }

    private Map<String, Path> loadFoldersAndJarZipFiles(Path rootPath) throws IOException
    {
        Set<String> processedNames = new HashSet<>();

        try (Stream<Path> stream = Files.walk(rootPath, 1))
        {
            return stream.filter(path -> {
                if (path.equals(rootPath))
                    return false;

                if (Files.isDirectory(path) || path.toString().toLowerCase().endsWith(".jar") || path.toString().toLowerCase().endsWith(".zip"))
                {
                    String name = FilenameUtils.getBaseName(path.getFileName().toString());
                    if (!processedNames.contains(name))
                    {
                        ArmorMod.log.info("Content pack found in flan folder: '{}'", path.getFileName());
                        processedNames.add(name);
                        return true;

                    }
                    else
                    {
                        ArmorMod.log.info("Skipping loading content pack from flan folder as it is duplicated: '{}'", path.getFileName());
                        return false;
                    }
                }
                return false;
            }).collect(Collectors.toMap(path -> path.getFileName().toString(), path -> path));
        }
    }

    private void readFiles(IContentProvider provider)
    {
        try (DirectoryStream<Path> dirStream = FileUtils.createDirectoryStream(provider))
        {
            dirStream.forEach(path ->
            {
                if (Files.isDirectory(path))
                {
                    readTypeFolder(path, provider);
                }
                else if (Files.isRegularFile(path))
                {
                    if (path.getFileName().toString().equals(shortnamesAliasFile))
                    {
                        readAliasMappingFile(path.getFileName().toString(), provider, shortnameReferences);
                    }
                    if (FMLEnvironment.dist == Dist.CLIENT)
                    {
                        if (path.getFileName().toString().equals(armorTexturesAliasFile))
                        {
                            readAliasMappingFile(path.getFileName().toString(), provider, armorTextureReferences);
                        }
                        if (path.getFileName().toString().equals(guiTexturesAliasFile))
                        {
                            readAliasMappingFile(path.getFileName().toString(), provider, guiTextureReferences);
                        }
                    }
                }
            });
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to load types in content pack '{}'", provider.getName(), e);
        }
    }

    private static void readAliasMappingFile(String fileName, IContentProvider provider, Map<IContentProvider, Map<String, DynamicReference>> references)
    {
        try (AliasFileManager fileManager = new AliasFileManager(fileName, provider))
        {
            fileManager.readFile().forEach((originalShortname, aliasShortname) -> DynamicReference.storeOrUpdate(originalShortname, aliasShortname, references.get(provider)));
        }
    }

    private void readTypeFolder(Path folder, IContentProvider provider)
    {
        String folderName = folder.getFileName().toString();
        if (EnumType.getFoldersList().contains(folderName))
        {
            try (DirectoryStream<Path> txtFileStream = Files.newDirectoryStream(folder, p -> Files.isRegularFile(p) && p.toString().toLowerCase().endsWith(".txt")))
            {
                txtFileStream.forEach(file -> readTypeFile(file, folderName, provider));
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Failed to read '{}' folder in content pack '{}'", folderName, provider.getName());
            }
        }
    }

    private void readTypeFile(Path file, String folderName, IContentProvider provider)
    {
        try
        {
            files.get(provider).add(new TypeFile(file.getFileName().toString(), EnumType.getType(folderName).orElse(null), provider, Files.readAllLines(file)));
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to read '{}/{}' in content pack '{}'", folderName, file.getFileName(), provider.getName());
        }
    }

    private void registerConfigs(IContentProvider contentPack)
    {
        for (TypeFile typeFile : files.get(contentPack))
        {
            try
            {
                Class<? extends InfoType> typeClass = typeFile.getType().getTypeClass();
                InfoType config = typeClass.getConstructor().newInstance();
                config.read(typeFile);
                if (!config.getShortName().isBlank())
                {
                    if (typeFile.getType().isItemType())
                    {
                        String shortName = findValidShortName(config.getShortName(), contentPack, typeFile);
                        DynamicReference.storeOrUpdate(config.getShortName(), shortName, shortnameReferences.get(contentPack));
                        registerItem(shortName, config, typeFile, typeClass);
                    }
                    configs.get(typeFile.getContentPack()).add(config);
                }
                else
                {
                    ArmorMod.log.error("ShortName not set: {}", typeFile);
                }
            }
            catch (Exception e)
            {
                ArmorMod.log.error("Failed to add {}", typeFile, e);
            }
        }
    }

    private String findValidShortName(String originalShortname, IContentProvider provider, TypeFile typeFile)
    {
        String shortname = originalShortname;
        if (registeredItems.containsKey(originalShortname) && shortnameReferences.get(provider).containsKey(originalShortname)) {
            shortname = shortnameReferences.get(provider).get(originalShortname).get();
        }

        String newShortname = shortname;
        for (int i = 2; registeredItems.containsKey(newShortname); i++)
            newShortname = originalShortname + "_" + i;

        if (!shortname.equals(newShortname)) {
            ArmorMod.log.warn("Detected conflict for item id '{}': {} and {}. Creating id alias '{}' in [{}]", originalShortname, typeFile, registeredItems.get(originalShortname), newShortname, provider.getName());
            shortname = newShortname;
        }

        return shortname;
    }

    private void registerItem(String shortName, InfoType config, TypeFile typeFile, Class<? extends InfoType> typeClass)
    {
        registeredItems.put(shortName, typeFile.toString());
        ArmorMod.registerItem(shortName, () ->
        {
            try
            {
                return typeFile.getType().getItemClass().getConstructor(typeClass).newInstance(typeClass.cast(config));
            }
            catch (InvocationTargetException e)
            {
                ArmorMod.log.error("Constructor of {} threw an exception: {}", typeFile.getType().getItemClass(), e.getCause().getMessage(), e.getCause());
                return null;
            }
            catch (Exception e)
            {
                ArmorMod.log.error("Failed to instantiate item {}", typeFile, e);
                return null;
            }
        });
    }

    private void findDuplicateTextures(IContentProvider provider)
    {
        FileSystem fs = FileUtils.createFileSystem(provider);
        findDuplicateTexturesInFolder("armor", provider, fs, armorTextureReferences.get(provider));
        findDuplicateTexturesInFolder("gui", provider, fs, guiTextureReferences.get(provider));
        FileUtils.closeFileSystem(fs, provider);
    }

    private void findDuplicateTexturesInFolder(String folderName, IContentProvider provider, FileSystem fs, Map<String, DynamicReference> aliasMapping)
    {
        Path textureFolderPath = provider.getAssetsPath(fs).resolve(folderName);

        if (Files.exists(textureFolderPath))
        {
            try (Stream<Path> stream = Files.list(textureFolderPath))
            {
                stream.filter(p -> p.toString().toLowerCase().endsWith(".png"))
                        .forEach(p -> checkForDuplicateTextures(p, provider, folderName, aliasMapping));
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not read {}", textureFolderPath, e);
            }
        }
    }

    private void checkForDuplicateTextures(Path texturePath, IContentProvider provider, String folderName, Map<String, DynamicReference> aliasMapping)
    {
        String fileName = FilenameUtils.getBaseName(texturePath.getFileName().toString()).toLowerCase();
        if (folderName.equals("armor"))
            fileName = getArmorTextureBaseName(fileName);
        String aliasName = fileName;

        if (isTextureNameAlreadyRegistered(fileName, folderName, provider))
        {
            TextureFile otherFile = textures.get(folderName).get(fileName);
            FileSystem fs = FileUtils.createFileSystem(otherFile.contentPack());
            Path otherPath = otherFile.contentPack().getAssetsPath(fs).resolve(folderName).resolve(otherFile.name());
            if (FileUtils.filesHaveDifferentBytesContent(texturePath, otherPath) && !FileUtils.isSameImage(texturePath, otherPath))
            {
                aliasName = findValidTextureName(fileName, folderName, provider, otherFile.contentPack(), aliasMapping);
            }
            FileUtils.closeFileSystem(fs, otherFile.contentPack());
        }

        DynamicReference.storeOrUpdate(fileName, aliasName, aliasMapping);
        textures.get(folderName).put(aliasName, new TextureFile(texturePath.getFileName().toString(), provider));
    }

    private String getArmorTextureBaseName(String fileBaseName)
    {
        if (fileBaseName.endsWith("_1") || fileBaseName.endsWith("_2")) {
            return fileBaseName.substring(0, fileBaseName.length() - 2);
        }
        return fileBaseName;
    }

    private String findValidTextureName(String originalName, String folderName, IContentProvider thisContentPack, IContentProvider otherContentPack, Map<String, DynamicReference> aliasMapping)
    {
        String name = originalName;

        if (isTextureNameAlreadyRegistered(name, folderName, thisContentPack) && aliasMapping.containsKey(name))
        {
            name = aliasMapping.get(name).get();
        }

        String newName = name;
        for (int i = 2; isTextureNameAlreadyRegistered(newName, folderName, thisContentPack); i++)
            newName = originalName + "_" + i;

        if (!name.equals(newName))
        {
            name = newName;
            ArmorMod.log.warn("Duplicate texture detected: '{}/{}' in [{}] and [{}]. Creating texture alias '{}' in [{}]", folderName, originalName, thisContentPack.getName(), otherContentPack.getName(), name, thisContentPack.getName());
        }

        return name;
    }

    private boolean shouldUpdateAliasMappingFile(String fileName, IContentProvider provider, @Nullable Map<String, String> aliasMapping)
    {
        if (aliasMapping == null)
            aliasMapping = Collections.emptyMap();

        try (AliasFileManager fileManager = new AliasFileManager(fileName, provider))
        {
            return !fileManager.readFile().equals(aliasMapping);
        }
    }

    private void writeToAliasMappingFile(String fileName, IContentProvider provider, @Nullable Map<String, String> aliasMapping)
    {
        if (aliasMapping == null)
            aliasMapping = Collections.emptyMap();

        try (AliasFileManager fileManager = new AliasFileManager(fileName, provider))
        {
            fileManager.writeToFile(aliasMapping);
        }
    }

    private boolean shouldPreLoadAssets(IContentProvider provider)
    {
        if (FMLEnvironment.dist != Dist.CLIENT)
            return false;

        if (provider.isJarFile() // JAR File means it's the first time we load the pack
            || shouldUpdateAliasMappingFile(armorTexturesAliasFile, provider, DynamicReference.getAliasMapping(armorTextureReferences.get(provider)))
            || shouldUpdateAliasMappingFile(guiTexturesAliasFile, provider, DynamicReference.getAliasMapping(guiTextureReferences.get(provider))))
        {
            return true;
        }

        FileSystem fs = FileUtils.createFileSystem(provider);

        boolean missingAssets = !Files.exists(provider.getAssetsPath(fs).resolve("models").resolve("item"))
            || (!Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("item")) && Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("items")))
            || (!Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("armor")) && Files.exists(provider.getAssetsPath(fs).resolve("armor")))
            || (!Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("gui")) && Files.exists(provider.getAssetsPath(fs).resolve("gui")))
            || !Files.exists(provider.getAssetsPath(fs).resolve("lang").resolve("en_us.json"));

        FileUtils.closeFileSystem(fs, provider);
        return missingAssets;
    }

    private boolean shouldUnpackArchive(IContentProvider provider, boolean preLoadAssets)
    {
        return provider.isArchive() && (preLoadAssets || shouldUpdateAliasMappingFile(shortnamesAliasFile, provider, DynamicReference.getAliasMapping(shortnameReferences.get(provider))));
    }

    private void createItemJsonFiles(IContentProvider provider)
    {
        Path jsonItemFolderPath = provider.getAssetsPath().resolve("models").resolve("item");
        Path jsonBlockFolderPath = provider.getAssetsPath().resolve("models").resolve("block");
        Path jsonBlockstatesFolderPath = provider.getAssetsPath().resolve("blockstates");

        convertExistingJsonFiles(jsonItemFolderPath);
        convertExistingJsonFiles(jsonBlockFolderPath);
        convertExistingJsonFiles(jsonBlockstatesFolderPath);

        if (!Files.exists(jsonItemFolderPath))
        {
            try
            {
                Files.createDirectories(jsonItemFolderPath);
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not create {}", jsonItemFolderPath, e);
                return;
            }
        }

        for (InfoType config : listItems(provider))
        {
            generateItemJson(config, jsonItemFolderPath, provider);
        }
    }

    private void convertExistingJsonFiles(Path jsonFolderPath)
    {
        if (Files.exists(jsonFolderPath))
        {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(jsonFolderPath, "*.json"))
            {
                for (Path jsonFile : stream)
                {
                    processJsonItemFile(jsonFile);
                }
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not open {}", jsonFolderPath, e);
            }
        }
    }

    private void processJsonItemFile(Path jsonFile)
    {
        try
        {
            String content = Files.readString(jsonFile, StandardCharsets.UTF_8);
            String modified = content.replace("flansmod:items/", "flansmod:item/").toLowerCase();
            Files.writeString(jsonFile, modified, StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to process file: {}", jsonFile, e);
        }
    }

    private List<InfoType> listItems(IContentProvider provider)
    {
        return configs.get(provider).stream()
                .filter(config -> config.getType().isItemType())
                .toList();
    }

    private void generateItemJson(InfoType config, Path outputFolder, IContentProvider provider)
    {
        ResourceUtils.ItemModel model = new ResourceUtils.ItemModel("item/generated", new ResourceUtils.Textures(ArmorMod.FLANSMOD_ID + ":item/" + config.getIcon()));
        String jsonContent = gson.toJson(model);
        String shortName = config.getShortName();

        if (shortnameReferences.get(provider).containsKey(shortName))
        {
            shortName = shortnameReferences.get(provider).get(config.getShortName()).get();
            Path oldFile = outputFolder.resolve(config.getShortName() + ".json");
            try
            {
                Files.deleteIfExists(oldFile);
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not delete {}", oldFile, e);
            }
        }

        Path outputFile = outputFolder.resolve(shortName + ".json");
        try
        {
            Files.write(outputFile, jsonContent.getBytes());
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Could not create {}", outputFile, e);
        }
    }

    private void copyItemIcons(IContentProvider provider)
    {
        Path sourcePath = provider.getAssetsPath().resolve("textures").resolve("items");
        Path destPath = provider.getAssetsPath().resolve("textures").resolve("item");
        copyPngFilesAndLowercaseFileNames(sourcePath, destPath);
    }

    private void copyTextures(IContentProvider provider, String folderName, Map<String, DynamicReference> aliasMapping)
    {
        Path sourcePath = provider.getAssetsPath().resolve(folderName);
        Path destPath = provider.getAssetsPath().resolve("textures").resolve(folderName);
        copyPngFilesAndLowercaseFileNames(sourcePath, destPath);
        renameTextureFilesWithAliases(destPath, aliasMapping);
    }

    private void renameTextureFilesWithAliases(Path folder, Map<String, DynamicReference> aliasMapping)
    {
        if (Files.exists(folder))
        {
            try (Stream<Path> stream = Files.list(folder))
            {
                stream.filter(file ->
                    {
                        String baseFileName = FilenameUtils.getBaseName(file.getFileName().toString());
                        if (folder.getFileName().toString().equals("armor"))
                        {
                            baseFileName = getArmorTextureBaseName(baseFileName);
                        }
                        return file.toString().toLowerCase().endsWith(".png") && aliasMapping.containsKey(baseFileName);
                    })
                    .forEach(file ->
                    {
                        String baseFileName = FilenameUtils.getBaseName(file.getFileName().toString());
                        if (folder.getFileName().toString().equals("armor"))
                        {
                            baseFileName = getArmorTextureBaseName(baseFileName);
                        }
                        String newFileName = aliasMapping.get(baseFileName).get();
                        if (folder.getFileName().toString().equals("armor"))
                        {
                            if (file.getFileName().toString().endsWith("_1.png"))
                            {
                                newFileName += "_1";
                            }
                            else if (file.getFileName().toString().endsWith("_2.png"))
                            {
                                newFileName += "_2";
                            }
                        }
                        Path destFile = file.getParent().resolve(newFileName + ".png");
                        try
                        {
                            Files.move(file, destFile, StandardCopyOption.REPLACE_EXISTING);
                        }
                        catch (IOException e)
                        {
                            ArmorMod.log.error("Could not create {}", file, e);
                        }
                    });
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not read {}", folder, e);
            }
        }
    }

    private void createLocalization(IContentProvider provider)
    {
        Path langDir = provider.getAssetsPath().resolve("lang");
        if (!Files.isDirectory(langDir))
        {
            try
            {
                Files.createDirectories(langDir);
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not create directory for localization {}", langDir, e);
                return;
            }
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(langDir, "*.lang"))
        {
            for (Path langFile : stream)
            {
                generateLocalizationFile(provider, langFile);
            }
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to read localization files in {}", langDir, e);
        }
    }

    private void generateLocalizationFile(IContentProvider provider, Path langFile)
    {
        Map<String, String> translations = readLangFile(langFile);
        for (InfoType config : configs.get(provider))
        {
            String shortName = config.getShortName();
            if (shortnameReferences.get(provider).containsKey(shortName) && !shortName.equals(shortnameReferences.get(provider).get(shortName).get()))
            {
                shortName = shortnameReferences.get(provider).get(shortName).get();
                String keyToAdd = generateTranslationKey(shortName, config.getType().isBlockType());
                String keyToRemove = generateTranslationKey(config.getShortName(), config.getType().isBlockType());
                translations.putIfAbsent(keyToAdd, config.getName());
                translations.remove(keyToRemove);

            }
            else {
                translations.putIfAbsent(generateTranslationKey(shortName, config.getType().isBlockType()), config.getName());
            }
        }

        String jsonFileName = langFile.getFileName().toString().toLowerCase().replace(".lang", ".json");
        Path jsonPath = langFile.getParent().resolve(jsonFileName);

        try (Writer writer = Files.newBufferedWriter(jsonPath, StandardCharsets.UTF_8))
        {
            gson.toJson(translations, writer);
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to write to localization file {}", jsonPath, e);
        }
    }

    private Map<String, String> readLangFile(Path langFile)
    {
        Map<String, String> translations = new LinkedHashMap<>();
        try
        {
            List<String> lines = Files.readAllLines(langFile, StandardCharsets.UTF_8);

            for (String line : lines)
            {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#"))
                    continue;

                int equalsIndex = line.indexOf('=');
                if (equalsIndex < 0)
                    continue;

                String key = line.substring(0, equalsIndex).trim();
                String value = line.substring(equalsIndex + 1).trim();

                // Convert key to new format
                key = convertTranslationKey(key);

                // Unescape properties-style characters
                value = value.replace("\\n", "\n").replace("\\\"", "\"");

                translations.put(key, value);
            }
        }
        catch (Exception e)
        {
            ArmorMod.log.error("Failed to read localization file {}", langFile, e);
        }
        return translations;
    }

    private static String convertTranslationKey(String legacyKey)
    {
        if (legacyKey.startsWith("item.") && legacyKey.endsWith(".name")) {
            String id = legacyKey.substring(5, legacyKey.length() - 5).toLowerCase();
            return "item." + ArmorMod.FLANSMOD_ID + "." + id;
        }
        if ((legacyKey.startsWith("tile.") || legacyKey.startsWith("block.")) && legacyKey.endsWith(".name")) {
            String id = legacyKey.substring(legacyKey.indexOf('.') + 1, legacyKey.length() - 5).toLowerCase();
            return "block." + ArmorMod.FLANSMOD_ID + "." + id;
        }
        return legacyKey;
    }

    private String generateTranslationKey(String itemId, boolean isBlock)
    {
        return (isBlock ? "block." : "item.") + ArmorMod.FLANSMOD_ID + "." + itemId;
    }

    private void copyPngFilesAndLowercaseFileNames(Path sourcePath, Path destPath)
    {
        if (Files.exists(sourcePath))
        {
            if (Files.exists(destPath))
            {
                FileUtils.deleteRecursively(destPath);
            }

            try
            {
                Files.createDirectories(destPath);
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not create {}", destPath, e);
                return;
            }

            try (Stream<Path> paths = Files.walk(sourcePath, 1))
            {
                paths.filter(path -> path.toString().toLowerCase().endsWith(".png"))
                    .forEach(path ->
                    {
                        Path destinationFile = destPath.resolve(sourcePath.relativize(path).toString().toLowerCase());
                        try
                        {
                            Files.copy(path, destinationFile, StandardCopyOption.REPLACE_EXISTING);
                        }
                        catch (IOException e)
                        {
                            ArmorMod.log.error("Could not create {}", destinationFile, e);
                        }
                    });
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not read {}", sourcePath, e);
            }
        }
    }

    private void createSounds(IContentProvider provider)
    {
        Path soundsDir = provider.getAssetsPath().resolve("sounds");
        Path soundsJsonFile = provider.getAssetsPath().resolve("sounds.json");

        if (Files.isDirectory(soundsDir))
        {
            DirectoryStream.Filter<Path> filter = path -> {
                String fileName = path.getFileName().toString();
                return fileName.toLowerCase().endsWith(".ogg") && !fileName.equals(fileName.toLowerCase());
            };

            try (DirectoryStream<Path> stream = Files.newDirectoryStream(soundsDir, filter))
            {
                for (Path file : stream)
                {
                    String lowercaseName = file.getFileName().toString().toLowerCase();
                    Files.move(file, soundsDir.resolve(lowercaseName + ".tmp"), StandardCopyOption.REPLACE_EXISTING);
                    Files.move(soundsDir.resolve(lowercaseName + ".tmp"), soundsDir.resolve(lowercaseName), StandardCopyOption.REPLACE_EXISTING);
                }
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not process {}", soundsDir, e);
            }
        }

        if (Files.exists(soundsJsonFile))
            lowercaseFile(soundsJsonFile);
    }

    private void lowercaseFile(Path file)
    {
        try
        {
            String content = Files.readString(file);
            Files.writeString(file, content.toLowerCase());
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Could not process {}", file, e);
        }
    }

    private void createMcMeta(IContentProvider provider) {
        Path mcMetaFile = (provider.isArchive() ? provider.getExtractedPath() : provider.getPath()).resolve("pack.mcmeta");
        if (Files.notExists(mcMetaFile))
        {
            try
            {
                Files.createFile(mcMetaFile);
                String content = String.format("""
                    {
                        "pack": {
                            "pack_format": 15,
                            "description": "%s"
                        }
                    }""", FilenameUtils.getBaseName(provider.getName()));
                Files.writeString(mcMetaFile, content);
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Failed to create {}", mcMetaFile, e);
            }
        }
    }

    private boolean isTextureNameAlreadyRegistered(String name, String folderName, IContentProvider provider)
    {
        return textures.get(folderName).containsKey(name) && !textures.get(folderName).get(name).contentPack().equals(provider);
    }
}
