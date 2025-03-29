package com.wolffsarmormod;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.FileSystem;
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
