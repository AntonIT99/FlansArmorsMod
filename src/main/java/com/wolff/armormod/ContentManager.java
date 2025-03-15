package com.wolff.armormod;

import com.wolff.armormod.common.types.EnumType;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ContentManager
{
    private Path flan;
    private List<IContentProvider> contentPacks = new ArrayList<>();

    public void findContentInFlanFolder()
    {
        loadFlanFolder();
        if (flan == null)
            return;

        try
        {
            contentPacks = loadFoldersAndJarZipFiles(flan)
                .entrySet()
                .stream()
                .map(entry -> new ContentPack(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
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

        flan = flanPath;
    }

    private static Map<String, Path> loadFoldersAndJarZipFiles(Path rootPath) throws IOException
    {
        Set<String> processedNames = new HashSet<>();

        try (var stream = Files.walk(rootPath))
        {
            return stream
                .filter(path ->
                {
                    if (Files.isDirectory(path) || path.toString().endsWith(".jar") || path.toString().endsWith(".zip"))
                    {
                        String name = FilenameUtils.getBaseName(path.getFileName().toString());
                        if (!processedNames.contains(name))
                        {
                            ArmorMod.LOG.info("Loaded content pack from flan folder: {}", path.getFileName());
                            processedNames.add(name);
                            return true;

                        }
                        else
                        {
                            ArmorMod.LOG.info("Skipping loading content pack from flan folder as it is duplicated: {}", path.getFileName());
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
        {
            loadTypes(provider);
        }
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
                    readTypeFolder(folder, provider.getName());
                }
            }
        }
        catch (IOException e)
        {
            ArmorMod.LOG.error("Failed to load types in content pack: {}", provider.getName());
        }
    }

    private void readTypeFolder(Path folder, String contentPack)
    {
        String folderName = folder.getFileName().toString();
        if (EnumType.getFoldersList().contains(folderName))
        {
            try (var txtFileStream = Files.newDirectoryStream(folder, p -> Files.isRegularFile(p) && p.toString().endsWith(".txt")))
            {
                txtFileStream.forEach(this::readTypeFile);
            }
            catch (IOException e)
            {
                ArmorMod.LOG.error("Failed to read {} folder in content pack: {}", folderName, contentPack);
            }
        }

        /*
        for (EnumType type : EnumType.values())
        {
            if (entry.getFileName().toString().startsWith(type.getFolderName() + "/")
                    && entry.getFileName().toString().split(type.folderName + "/").length > 1
                    && entry.getFileName().toString().split(type.folderName + "/")[1].length() > 0)
            {
                String[] splitName = entry.getFileName().toString().split("/");
                typeFile = new TypeFile(contentPack.toString(), type, splitName[splitName.length - 1].split("\\.")[0]);
            }
        }
        */
    }

    private void readTypeFile(Path file)
    {
        //TODO: implement
        /*try (BufferedReader reader = Files.newBufferedReader(entry))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                typeFile.parseLine(line);
            }
        }
        catch (IOException e)
        {
            FlansMod.log.throwing(e);
        }*/
    }
}
