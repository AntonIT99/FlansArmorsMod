package com.wolff.armormod;

import com.wolff.armormod.common.types.EnumType;
import com.wolff.armormod.common.types.InfoType;
import com.wolff.armormod.common.types.TypeFile;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
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
            ArmorMod.LOG.error("Failed to load content packs from flan folder.", e);
        }
    }

    private void loadFlanFolder()
    {
        Path flanPath = FMLPaths.GAMEDIR.get().resolve("flan");
        Path fallbackFlanPath = FMLPaths.GAMEDIR.get().resolve("Flan");

        if(!Files.exists(flanPath) && !Files.exists(fallbackFlanPath))
        {
            try
            {
                Files.createDirectories(flanPath);
            }
            catch (Exception e)
            {
                ArmorMod.LOG.error("Failed to create the flan directory.", e);
                return;
            }
        }
        else if(!Files.exists(flanPath) && Files.exists(fallbackFlanPath))
        {
            flanPath = fallbackFlanPath;
        }

        flanFolder = flanPath;
    }

    private Map<String, Path> loadFoldersAndJarZipFiles(Path rootPath) throws IOException
    {
        Set<String> processedNames = new HashSet<>();

        try (Stream<Path> stream = Files.walk(rootPath))
        {
            return stream
                .filter(path ->
                {
                    if (path.equals(rootPath))
                        return false;

                    if (Files.isDirectory(path) || path.toString().endsWith(".jar") || path.toString().endsWith(".zip"))
                    {
                        String name = FilenameUtils.getBaseName(path.getFileName().toString());
                        if (!processedNames.contains(name))
                        {
                            ArmorMod.LOG.info("Loaded content pack from flan folder: '{}'", path.getFileName());
                            processedNames.add(name);
                            return true;

                        }
                        else
                        {
                            ArmorMod.LOG.info("Skipping loading content pack from flan folder as it is duplicated: '{}'", path.getFileName());
                            return false;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toMap(path -> path.getFileName().toString(), path -> path));
        }
    }

    public void loadTypes()
    {
        for (IContentProvider provider : contentPacks)
            loadTypes(provider);
    }

    private void loadTypes(IContentProvider provider)
    {
        try (FileSystem fs = FileSystems.newFileSystem(provider.getPath()))
        {
            Path root = fs.getPath("/");

            try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(root, Files::isDirectory))
            {
                for (Path folder : dirStream)
                {
                    readTypeFolder(folder, provider);
                }
            }
        }
        catch (IOException e)
        {
            ArmorMod.LOG.error("Failed to load types in content pack '{}'", provider.getName());
        }
    }

    private void readTypeFolder(Path folder, IContentProvider provider)
    {
        String folderName = folder.getFileName().toString();
        if (EnumType.getFoldersList().contains(folderName))
        {
            try (DirectoryStream<Path> txtFileStream = Files.newDirectoryStream(folder, p -> Files.isRegularFile(p) && p.toString().endsWith(".txt")))
            {
                txtFileStream.forEach(file -> readTypeFile(file, folderName, provider));
            }
            catch (IOException e)
            {
                ArmorMod.LOG.error("Failed to read '{}' folder in content pack '{}'", folderName, provider.getName());
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
            ArmorMod.LOG.error("Failed to read '{}/{}' in content pack '{}'", folderName, file.getFileName(), provider.getName());
        }
    }

    private void loadTypeFile(TypeFile file)
    {
        files.get(file.getType()).add(file);
    }

    public void registerItems()
    {
        for (EnumType type : EnumType.values())
        {
            for (TypeFile typeFile : files.get(type))
            {
                try
                {
                    Class<? extends InfoType> typeClass = type.getTypeClass();
                    InfoType infoType = typeClass.getConstructor().newInstance();
                    infoType.read(typeFile);
                    if (!infoType.getShortName().isBlank())
                    {
                        ArmorMod.registerItem(infoType.getShortName(), () ->
                        {
                            try
                            {
                                return type.getItemClass().getConstructor(typeClass).newInstance(typeClass.cast(infoType));
                            }
                            catch (Exception e)
                            {
                                ArmorMod.LOG.error("Failed to instantiate item {}/{}/{}", typeFile.getContentPack().getName(), type.getFolderName(), typeFile.getName());
                                return null;
                            }
                        });
                    }
                    else
                    {
                        ArmorMod.LOG.error("ShortName not set: {}/{}/{}", typeFile.getContentPack().getName(), type.getFolderName(), typeFile.getName());
                    }

                }
                catch (Exception e)
                {
                    ArmorMod.LOG.error("Failed to add {} from '{}': {}", type.getDisplayName(), typeFile.getContentPack().getName(), typeFile.getName(), e);
                }
            }
            ArmorMod.LOG.info("Loaded {}.", type.getDisplayName());
        }
    }
}
