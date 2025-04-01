package com.wolffsarmormod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wolffsarmormod.common.types.EnumType;
import com.wolffsarmormod.common.types.InfoType;
import com.wolffsarmormod.common.types.TypeFile;
import com.wolffsarmormod.util.FileUtils;
import com.wolffsarmormod.util.ResourceUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.io.FilenameUtils;

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
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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

    private final List<IContentProvider> contentPacks = new ArrayList<>();
    private final Map<EnumType, ArrayList<TypeFile>> files = new EnumMap<>(EnumType.class);
    private final Map<IContentProvider, ArrayList<InfoType>> configs = new HashMap<>();
    private final Map<String, Path> registeredItemShortnames = new HashMap<>();
    private final Map<String, Map<String, IContentProvider>> textures = new HashMap<>();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

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
        if(!Files.exists(ArmorMod.flanPath) && !Files.exists(ArmorMod.fallbackFlanPath))
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
        else if(!Files.exists(ArmorMod.flanPath) && Files.exists(ArmorMod.fallbackFlanPath))
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
        try (DirectoryStream<Path> dirStream = FileUtils.createDirectoryStream(provider, Files::isDirectory))
        {
            dirStream.forEach(folder -> readTypeFolder(folder, provider));
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
            loadTypeFile(new TypeFile(file.getFileName().toString(), file, EnumType.getType(folderName).orElse(null), provider, Files.readAllLines(file)));
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
                try
                {
                    Class<? extends InfoType> typeClass = type.getTypeClass();
                    InfoType config = typeClass.getConstructor().newInstance();
                    config.read(typeFile);
                    if (!config.getShortName().isBlank())
                    {
                        if (type.isItemType())
                        {
                            if (registeredItemShortnames.containsKey(config.getShortName()))
                            {
                                ArmorMod.log.warn("Trying to register item id {} for {} but id is already registered by {}", config.getShortName(), typeFile.getFullPath(), registeredItemShortnames.get(config.getShortName()));
                            }
                            registeredItemShortnames.putIfAbsent(config.getShortName(), typeFile.getFullPath());
                        }
                        configs.putIfAbsent(typeFile.getContentPack(), new ArrayList<>());
                        configs.get(typeFile.getContentPack()).add(config);
                        if (typeFile.getType().isItemType())
                        {
                            registerItem(config, typeFile, typeClass);
                        }
                    }
                    else
                    {
                        ArmorMod.log.error("ShortName not set: {}/{}/{}", typeFile.getContentPack().getName(), type.getConfigFolderName(), typeFile.getName());
                    }
                }
                catch (Exception e)
                {
                    ArmorMod.log.error("Failed to add {} from '{}': {}", type.getDisplayName(), typeFile.getContentPack().getName(), typeFile.getName(), e);
                }
            }
            ArmorMod.log.info("Loaded {}.", type.getDisplayName());
        }
    }

    private void registerItem(InfoType config, TypeFile typeFile, Class<? extends InfoType> typeClass)
    {
        ArmorMod.registerItem(config.getShortName(), () ->
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
    public void prepareAssets()
    {
        for (IContentProvider provider : contentPacks)
        {
            boolean archiveExtracted = unpackArchive(provider);
            if (Files.exists(provider.getAssetsPath()))
            {
                createItemJsonFiles(provider);
                copyItemIcons(provider);
                copyTextures(provider, "armor");
                copyTextures(provider, "gui");
                createLocalization(provider);
                createSounds(provider);
            }
            if (archiveExtracted)
            {
                FileUtils.repackArchive(provider);
            }
        }
    }

    private boolean unpackArchive(IContentProvider provider)
    {
        if (provider.isArchive())
        {
            try (FileSystem fs = FileSystems.newFileSystem(provider.getPath()))
            {
                if (provider.isJarFile()
                    || !Files.exists(provider.getAssetsPath(fs).resolve("models").resolve("item"))
                    || !Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("item"))
                    || !Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("armor"))
                    || !Files.exists(provider.getAssetsPath(fs).resolve("textures").resolve("gui"))
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

        if (Files.exists(jsonItemFolderPath))
        {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(jsonItemFolderPath, "*.json"))
            {
                for (Path jsonFile : stream)
                {
                    processJsonItemFile(jsonFile);
                }
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not open {}", jsonItemFolderPath, e);
            }
        }
        else
        {
            try
            {
                Files.createDirectories(jsonItemFolderPath);
                for (InfoType config : listItems(provider))
                {
                    generateItemJson(config, jsonItemFolderPath);
                }
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not create {}", jsonItemFolderPath, e);
            }
        }

        if (Files.exists(jsonBlockFolderPath))
        {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(jsonBlockFolderPath, "*.json"))
            {
                for (Path jsonFile : stream)
                {
                    lowercaseFile(jsonFile);
                }
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Could not open {}", jsonBlockFolderPath, e);
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

    private void generateItemJson(InfoType config, Path outputFolder)
    {
        ResourceUtils.ItemModel model = new ResourceUtils.ItemModel("item/generated", new ResourceUtils.Textures(ArmorMod.FLANSMOD_ID + ":item/" + config.getIcon()));
        String jsonContent = gson.toJson(model);
        Path outputFile = outputFolder.resolve(config.getShortName() + ".json");

        try
        {
            Files.write(outputFile, jsonContent.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
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
        copyPngFilesAndLowercaseNames(sourcePath, destPath);
    }

    private void copyTextures(IContentProvider provider, String folderName)
    {
        Path sourcePath = provider.getAssetsPath().resolve(folderName);
        Path destPath = provider.getAssetsPath().resolve("textures").resolve(folderName);
        copyPngFilesAndLowercaseNames(sourcePath, destPath);

        try (Stream<Path> stream = Files.list(destPath))
        {
            stream.filter(p -> p.toString().toLowerCase().endsWith(".png"))
                .forEach(p -> checkForDuplicateTextures(p, provider, folderName));
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Could not read {}", destPath, e);
        }
    }

    private void checkForDuplicateTextures(Path texturePath, IContentProvider provider, String folderName)
    {
        {
            String fileName = texturePath.getFileName().toString();

            if (textures.get(folderName).containsKey(fileName))
            {
                IContentProvider otherContentPack = textures.get(folderName).get(fileName);
                FileSystem fs = FileUtils.createFileSystem(otherContentPack);
                Path otherPath = otherContentPack.getAssetsPath(fs).resolve("textures").resolve(folderName).resolve(fileName);

                if (!FileUtils.hasSameFileBytesContent(texturePath, otherPath) && !FileUtils.isSameImage(texturePath, otherPath))
                {
                    ArmorMod.log.warn("Duplicate texture detected: {} and {}", texturePath, otherPath);
                }

                FileUtils.closeFileSystem(fs, otherContentPack);
            }
            else
            {
                textures.get(folderName).put(fileName, provider);
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
            translations.putIfAbsent(generateTranslationKey(config.getShortName(), config.getType().isBlockType()), config.getName());
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

    private void copyPngFilesAndLowercaseNames(Path sourcePath, Path destPath)
    {
        if (!Files.exists(destPath) && Files.exists(sourcePath))
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

            try (Stream<Path> paths = Files.walk(sourcePath))
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

        lowercaseFile(soundsJsonFile);
    }

    private void lowercaseFile(Path file)
    {
        try
        {
            String content = Files.readString(file);
            Files.writeString(file, content.toLowerCase(), StandardOpenOption.TRUNCATE_EXISTING);
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Could not process {}", file, e);
        }
    }
}
