package com.wolffsarmormod;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public interface IContentProvider
{
    String name();

    Path path();

    default Path getExtractedPath()
    {
        if (isArchive())
        {
            return path().getParent().resolve(FilenameUtils.getBaseName(name()));
        }
        throw new IllegalArgumentException("Content Pack is not an Archive");
    }

    default Path getAssetsPath()
    {
        return getAssetsPath(null);
    }

    default Path getAssetsPath(FileSystem fs)
    {
        if (isArchive())
        {
            return (fs != null) ? fs.getPath("/assets").resolve(ArmorMod.FLANSMOD_ID) : getExtractedPath().resolve("assets").resolve(ArmorMod.FLANSMOD_ID);
        }
        return path().resolve("assets").resolve(ArmorMod.FLANSMOD_ID);
    }

    default Path getModelsPath()
    {
        if (isArchive())
        {
            try (FileSystem fs = FileSystems.newFileSystem(path()))
            {
                return fs.getPath("/com").resolve(ArmorMod.FLANSMOD_ID).resolve("client").resolve("model");
            }
            catch (IOException e)
            {
                ArmorMod.log.error("Failed to read archive for content pack {}", path(), e);
            }
        }
        return path().resolve("com").resolve(ArmorMod.FLANSMOD_ID).resolve("client").resolve("model");
    }

    boolean equals(Object obj);

    int hashCode();

    default boolean isArchive()
    {
        return isJarFile() || isZipFile();
    }

    default boolean isDirectory()
    {
        return Files.isDirectory(path());
    }

    default boolean isJarFile()
    {
        return path().toString().toLowerCase().endsWith(".jar");
    }

    default boolean isZipFile()
    {
        return path().toString().toLowerCase().endsWith(".zip");
    }
}
