package com.wolffsarmormod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wolffsarmormod.common.types.EnumType;
import com.wolffsarmormod.common.types.InfoType;
import com.wolffsarmormod.common.types.TypeFile;
import com.wolffsarmormod.util.ResourceUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.io.Writer;
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
    private Path flanFolder;
    private final List<IContentProvider> contentPacks = new ArrayList<>();
    private final Map<EnumType, ArrayList<TypeFile>> files = new EnumMap<>(EnumType.class);
    private final Map<IContentProvider, ArrayList<InfoType>> configs = new HashMap<>();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ContentManager()
    {
        for (EnumType type : EnumType.values())
            files.put(type, new ArrayList<>());
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
        if (provider.isDirectory())
        {
            try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(provider.path(), Files::isDirectory))
            {
                dirStream.forEach(folder -> readTypeFolder(folder, provider));
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Failed to load types in content pack '{}'", provider.name(), e);
            }
        }
        else if (provider.isArchive())
        {
            try (FileSystem fs = FileSystems.newFileSystem(provider.path());
                 DirectoryStream<Path> dirStream = Files.newDirectoryStream(fs.getPath("/"), Files::isDirectory))
            {
                dirStream.forEach(folder -> readTypeFolder(folder, provider));
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Failed to load types in content pack '{}'", provider.name(), e);
            }
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
                ArmorMod.log.error("Failed to read '{}' folder in content pack '{}'", folderName, provider.name());
            }
        }
    }

    private void readTypeFile(Path file, String folderName, IContentProvider provider)
    {
        try
        {
            loadTypeFile(new TypeFile(file.getFileName().toString(), EnumType.getType(folderName).orElse(null), provider, Files.readAllLines(file)));
        }
        catch (IOException e)
        {
            ArmorMod.log.error("Failed to read '{}/{}' in content pack '{}'", folderName, file.getFileName(), provider.name());
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
                        configs.putIfAbsent(typeFile.getContentPack(), new ArrayList<>());
                        configs.get(typeFile.getContentPack()).add(config);
                        if (typeFile.getType().isItemType())
                        {
                            registerItem(config, typeFile, typeClass);
                        }
                    }
                    else
                    {
                        ArmorMod.log.error("ShortName not set: {}/{}/{}", typeFile.getContentPack().name(), type.getConfigFolderName(), typeFile.getName());
                    }
                }
                catch (Exception e)
                {
                    ArmorMod.log.error("Failed to add {} from '{}': {}", type.getDisplayName(), typeFile.getContentPack().name(), typeFile.getName(), e);
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
            catch (Exception e)
            {
                ArmorMod.log.error("Failed to instantiate item {}/{}/{}", typeFile.getContentPack().name(), typeFile.getType().getConfigFolderName(), typeFile.getName());
                return null;
            }
        });
    }

    @OnlyIn(Dist.CLIENT)
    public void prepareAssets()
    {
        for (IContentProvider provider : contentPacks)
        {
            createItemJsonFiles(provider);
            copyItemIcons(provider);
            copyTextures(provider);
            createLocalization(provider);
        }
    }

    private List<InfoType> listItems(IContentProvider provider)
    {
        return configs.get(provider).stream()
            .filter(config -> config.getType().isItemType())
            .toList();
    }

    private void createItemJsonFiles(IContentProvider provider)
    {
        if (provider.isDirectory())
        {
            Path jsonItemFolderPath = provider.getAssetsPath().resolve("models").resolve("item");
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

                for (InfoType config : listItems(provider))
                {
                    generateItemJson(config, jsonItemFolderPath);
                }
            }

        }
        //TODO: implement for Archives
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
        if (provider.isDirectory())
        {
            Path sourcePath = provider.getAssetsPath().resolve("textures").resolve("items");
            Path destPath = provider.getAssetsPath().resolve("textures").resolve("item");
            copyPngFilesAndLowercaseNames(sourcePath, destPath);
        }
        //TODO: implement for Archives
    }

    private void copyTextures(IContentProvider provider)
    {
        if (provider.isDirectory())
        {
            Path sourcePath = provider.getAssetsPath().resolve("armor");
            Path destPath = provider.getAssetsPath().resolve("textures").resolve("models").resolve("armor");
            copyPngFilesAndLowercaseNames(sourcePath, destPath);
        }
        //TODO: implement for Archives
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
        //TODO: implement for Archives
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
}
