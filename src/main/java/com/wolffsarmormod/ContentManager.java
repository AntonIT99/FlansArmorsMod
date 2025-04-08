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
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.io.FilenameUtils;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
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

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final List<IContentProvider> contentPacks = new ArrayList<>();
    private final Map<EnumType, ArrayList<TypeFile>> files = new EnumMap<>(EnumType.class);
    private final Map<IContentProvider, ArrayList<InfoType>> configs = new HashMap<>();

    private final Map<IContentProvider, Map<String, String>> duplicateShortnamesAliases = new HashMap<>(); // <content pack, <value from config file, alias value>>
    private final Map<String, String> registeredItemShortnamesAndPaths = new HashMap<>(); // <shortname, config file path>
    private final Map<String, Map<String, TextureFile>> textures = new HashMap<>(); // <folder name, <lowercase name, texture file>>

    private record TextureFile(String name, IContentProvider contentPack) {}

    public ContentManager()
    {
        for (EnumType type : EnumType.values())
            files.put(type, new ArrayList<>());

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
                        ArmorMod.log.info("Loaded content pack from flan folder: '{}'", path.getFileName());
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

    public void loadTypes()
    {
        for (IContentProvider provider : contentPacks)
            loadTypes(provider);
    }

    private void loadTypes(IContentProvider provider)
    {
        try (DirectoryStream<Path> dirStream = FileUtils.createDirectoryStream(provider))
        {
            dirStream.forEach(path ->
            {
                if (Files.isDirectory(path))
                {
                    readTypeFolder(path, provider);
                }
                else if (Files.isRegularFile(path) && path.getFileName().toString().equals("shortnames_alias.json"))
                {
                    try (AliasFileManager fileManager = new AliasFileManager(path.getFileName().toString(), provider))
                    {
                        fileManager.readFile().forEach((originalShortname, aliasShortname) -> storeOrUpdateReference(originalShortname, aliasShortname, provider, shortnameReferences));
                    }
                }
            });
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to load types in content pack '{}'", provider.getName(), e);
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
            loadTypeFile(new TypeFile(file.getFileName().toString(), provider.getPath() + "/" + file, EnumType.getType(folderName).orElse(null), provider, Files.readAllLines(file)));
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to read '{}/{}' in content pack '{}'", folderName, file.getFileName(), provider.getName());
        }
    }

    private void loadTypeFile(TypeFile file)
    {
        files.get(file.getType()).add(file);
    }

    public void registerConfigs()
    {
        for (EnumType type : EnumType.values())
        {
            for (TypeFile typeFile : files.get(type))
            {
                IContentProvider contentPack = typeFile.getContentPack();
                try
                {
                    Class<? extends InfoType> typeClass = type.getTypeClass();
                    InfoType config = typeClass.getConstructor().newInstance();
                    config.read(typeFile);
                    if (!config.getShortName().isBlank())
                    {

                        if (type.isItemType())
                        {
                            String shortName = findValidShortName(config.getShortName());
                            if (!shortName.equals(config.getShortName()))
                            {
                                ArmorMod.log.warn("Trying to register item id '{}' for {} but id is already registered by {}", config.getShortName(), typeFile.getFullPath(), registeredItemShortnamesAndPaths.get(shortName));
                                ArmorMod.log.warn("Creating shortname alias '{}' for {}", shortName, typeFile.getFullPath());
                                duplicateShortnamesAliases.putIfAbsent(contentPack, new HashMap<>());
                                duplicateShortnamesAliases.get(contentPack).put(config.getShortName(), shortName);
                            }
                            registeredItemShortnamesAndPaths.put(shortName, typeFile.getFullPath());
                            registerItem(shortName, config, typeFile, typeClass);
                            storeOrUpdateReference(config.getShortName(), shortName, contentPack, shortnameReferences);
                        }
                        configs.putIfAbsent(contentPack, new ArrayList<>());
                        configs.get(typeFile.getContentPack()).add(config);
                    }
                    else
                    {
                        ArmorMod.log.error("ShortName not set: {}/{}/{}", contentPack.getName(), type.getConfigFolderName(), typeFile.getName());
                    }
                }
                catch (Exception e)
                {
                    ArmorMod.log.error("Failed to add {} from '{}': {}", type.getDisplayName(), contentPack.getName(), typeFile.getName(), e);
                }
            }
            ArmorMod.log.info("Loaded {}.", type.getDisplayName());
        }
    }

    private String findValidShortName(String originalShortname)
    {
        String alias = originalShortname;
        for (int i = 2; registeredItemShortnamesAndPaths.containsKey(alias); i++)
            alias = originalShortname + "_" + i;
        return originalShortname;
    }

    private void registerItem(String shortName, InfoType config, TypeFile typeFile, Class<? extends InfoType> typeClass)
    {
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
                ArmorMod.log.error("Failed to instantiate item {}/{}/{}", typeFile.getContentPack().getName(), typeFile.getType().getConfigFolderName(), typeFile.getName(), e);
                return null;
            }
        });
    }

    @OnlyIn(Dist.CLIENT)
    public void preloadAssets()
    {
        for (IContentProvider provider : contentPacks)
        {
            long startTime = System.currentTimeMillis();

            Map<String, Map<String, String>> duplicateTexturesAliases = findDuplicateTexturesAndGenerateAliases(provider); // <folder name, <original name, alias name>>
            boolean archiveExtracted = unpackArchive(provider, areAliasMappingsUpToDate(provider, duplicateTexturesAliases));

            // if content pack was an archive, than getAssetsPath() only exist if the archive was extracted
            if (Files.exists(provider.getAssetsPath()))
            {
                writeToAliasMappingFiles(provider, duplicateTexturesAliases);
                createItemJsonFiles(provider);
                createLocalization(provider);
                copyItemIcons(provider);
                copyTextures(provider, "armor", duplicateTexturesAliases);
                copyTextures(provider, "gui", duplicateTexturesAliases);
                createSounds(provider);
            }

            if (archiveExtracted)
            {
                FileUtils.repackArchive(provider);
            }

            loadTextureReferences(provider, duplicateTexturesAliases);

            long endTime = System.currentTimeMillis();
            ArmorMod.log.info("Preloaded assets for content pack {} in {} ms.", provider.getName(), String.format("%,d", endTime - startTime));
        }
    }

    private void loadTextureReferences(IContentProvider provider, Map<String, Map<String, String>> duplicateTexturesAliases)
    {
        duplicateTexturesAliases.get("armor").forEach((originalName, aliasName) -> storeOrUpdateReference(originalName, aliasName, provider, armorTextureReferences));
        duplicateTexturesAliases.get("gui").forEach((originalName, aliasName) -> storeOrUpdateReference(originalName, aliasName, provider, guiTextureReferences));
    }

    private Map<String, Map<String, String>> findDuplicateTexturesAndGenerateAliases(IContentProvider provider)
    {
        Map<String, Map<String, String>> duplicateTexturesAliases = new HashMap<>();
        duplicateTexturesAliases.put("armor", new HashMap<>());
        duplicateTexturesAliases.put("gui", new HashMap<>());

        FileSystem fs = FileUtils.createFileSystem(provider);
        findDuplicateTexturesInFolder("armor", provider,fs, duplicateTexturesAliases);
        findDuplicateTexturesInFolder("gui", provider,fs, duplicateTexturesAliases);
        FileUtils.closeFileSystem(fs, provider);

        return duplicateTexturesAliases;
    }

    private void findDuplicateTexturesInFolder(String folderName, IContentProvider provider, FileSystem fs, Map<String, Map<String, String>> duplicateTexturesAliases)
    {
        Path textureFolderPath = provider.getAssetsPath(fs).resolve(folderName);

        if (Files.exists(textureFolderPath))
        {
            try (Stream<Path> stream = Files.list(textureFolderPath))
            {
                stream.filter(p -> p.toString().toLowerCase().endsWith(".png"))
                        .forEach(p -> checkForDuplicateTextures(p, provider, folderName, duplicateTexturesAliases.get(folderName)));
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not read {}", textureFolderPath, e);
            }
        }
    }

    private void checkForDuplicateTextures(Path texturePath, IContentProvider provider, String folderName, Map<String, String> duplicateTexturesAliases)
    {
        {
            String fileName = FilenameUtils.getBaseName(texturePath.getFileName().toString()).toLowerCase();

            if (textures.get(folderName).containsKey(fileName))
            {
                TextureFile otherFile = textures.get(folderName).get(fileName);
                FileSystem fs = FileUtils.createFileSystem(otherFile.contentPack());
                Path otherPath = otherFile.contentPack().getAssetsPath(fs).resolve(folderName).resolve(otherFile.name());

                if (!FileUtils.hasSameFileBytesContent(texturePath, otherPath) && !FileUtils.isSameImage(texturePath, otherPath))
                {
                    String aliasName = findValidTextureName(fileName, duplicateTexturesAliases);
                    ArmorMod.log.warn("Duplicate texture detected: {}/{} in {} and {}", folderName, fileName, provider.getName(), otherFile.contentPack().getName());
                    ArmorMod.log.warn("Creating texture name alias '{}' for {}/{} in {}", aliasName, folderName, fileName, provider.getName());
                    duplicateTexturesAliases.put(fileName, aliasName);
                }

                FileUtils.closeFileSystem(fs, otherFile.contentPack());
            }
            else
            {
                textures.get(folderName).put(fileName, new TextureFile(texturePath.getFileName().toString(), provider));
            }
        }
    }

    private String findValidTextureName(String originalName, Map<String, String> duplicateTexturesAliases)
    {
        String alias = originalName;
        for (int i = 2; duplicateTexturesAliases.containsKey(alias); i++)
            alias = originalName + "_" + i;
        return alias;
    }

    private boolean areAliasMappingsUpToDate(IContentProvider provider, Map<String, Map<String, String>> duplicateTexturesAliases)
    {
        return isSameAliasMapping("shortnames_alias.json", provider, duplicateShortnamesAliases.get(provider))
            && isSameAliasMapping("armor_textures_alias.json", provider, duplicateTexturesAliases.get("armor"))
            && isSameAliasMapping("gui_textures_alias.json", provider, duplicateTexturesAliases.get("gui"));
    }

    private void writeToAliasMappingFiles(IContentProvider provider, Map<String, Map<String, String>> duplicateTexturesAliases)
    {
        writeToAliasMappingFile("shortnames_alias.json", provider, duplicateShortnamesAliases.get(provider));
        writeToAliasMappingFile("armor_textures_alias.json", provider, duplicateTexturesAliases.get("armor"));
        writeToAliasMappingFile("gui_textures_alias.json", provider, duplicateTexturesAliases.get("gui"));
    }

    private boolean isSameAliasMapping(String fileName, IContentProvider provider, @Nullable Map<String, String> aliasMapping)
    {
        if (aliasMapping == null)
            aliasMapping = Collections.emptyMap();

        try (AliasFileManager fileManager = new AliasFileManager(fileName, provider))
        {
            return fileManager.readFile().equals(aliasMapping);
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

    private boolean unpackArchive(IContentProvider provider, boolean mappingsUpToDate)
    {
        if (provider.isArchive())
        {
            try (FileSystem fs = FileSystems.newFileSystem(provider.getPath()))
            {
                if (provider.isJarFile() || !mappingsUpToDate
                    || !Files.exists(provider.getAssetsPath(fs).resolve("models").resolve("item"))
                    || (!Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("item")) && Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("items")))
                    || (!Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("armor")) && Files.exists(provider.getAssetsPath(fs).resolve("armor")))
                    || (!Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("gui")) && Files.exists(provider.getAssetsPath(fs).resolve("gui")))
                    || !Files.exists(provider.getAssetsPath(fs).resolve("lang").resolve("en_us.json")))
                {
                    FileUtils.extractArchive(provider.getPath(), provider.getExtractedPath());
                    return true;
                }
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Failed to read archive for content pack {}", provider.getPath(), e);
            }
        }
        return false;
    }

    private void createItemJsonFiles(IContentProvider provider)
    {
        Path jsonItemFolderPath = provider.getAssetsPath().resolve("models").resolve("item");
        Path jsonBlockFolderPath = provider.getAssetsPath().resolve("models").resolve("block");

        convertExistingJsonFiles(jsonItemFolderPath);
        convertExistingJsonFiles(jsonBlockFolderPath);

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

        if (duplicateShortnamesAliases.get(provider).containsKey(shortName))
        {
            shortName = duplicateShortnamesAliases.get(provider).get(config.getShortName());
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

    private void copyTextures(IContentProvider provider, String folderName, Map<String, Map<String, String>> duplicateTexturesAliases)
    {
        Path sourcePath = provider.getAssetsPath().resolve(folderName);
        Path destPath = provider.getAssetsPath().resolve("textures").resolve(folderName);
        copyPngFilesAndLowercaseFileNames(sourcePath, destPath);
        renameTextureFilesWithAliases(destPath, duplicateTexturesAliases.get(folderName));
    }

    private void renameTextureFilesWithAliases(Path folder, Map<String, String> duplicateTexturesAliases)
    {
        if (Files.exists(folder))
        {
            try (Stream<Path> stream = Files.list(folder))
            {
                stream.filter(file -> file.toString().toLowerCase().endsWith(".png") && duplicateTexturesAliases.containsKey(FilenameUtils.getBaseName(file.getFileName().toString())))
                        .forEach(file ->
                        {
                            String aliasName = duplicateTexturesAliases.get(FilenameUtils.getBaseName(file.getFileName().toString()));
                            Path destFile = file.getParent().resolve(aliasName + ".png");
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
            if (duplicateShortnamesAliases.get(provider).containsKey(shortName))
            {
                shortName = duplicateShortnamesAliases.get(provider).get(shortName);
                translations.remove(generateTranslationKey(config.getShortName(), config.getType().isBlockType()));

            }
            translations.putIfAbsent(generateTranslationKey(shortName, config.getType().isBlockType()), config.getName());
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
            if (!Files.exists(destPath))
            {
                try
                {
                    Files.createDirectories(destPath);
                }
                catch (IOException e)
                {
                    ArmorMod.log.error("Could not create {}", destPath, e);
                    return;
                }
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

    public static void storeOrUpdateReference(String key, String value, IContentProvider provider, Map<IContentProvider, Map<String, DynamicReference>> references)
    {
        references.putIfAbsent(provider, new HashMap<>());
        if (references.get(provider).containsKey(key))
        {
            references.get(provider).get(key).update(value);
        }
        else
        {
            references.get(provider).put(key, new DynamicReference(value));
        }
    }
}
