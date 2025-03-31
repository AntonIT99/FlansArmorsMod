package com.wolffsarmormod;

import org.apache.commons.io.FilenameUtils;

import javax.annotation.Nullable;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

public interface IContentProvider
{
    String getName();

    Path getPath();

    void update(String name, Path path);

    default Path getExtractedPath()
    {
        if (isArchive())
        {
            return getPath().getParent().resolve(FilenameUtils.getBaseName(getName()));
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
        return getPath().resolve("assets").resolve(ArmorMod.FLANSMOD_ID);
    }

    default Path getModelPath(String modelFullClassName, @Nullable FileSystem fs)
    {
        if (isArchive() && fs != null)
        {
            return fs.getPath("/" + modelFullClassName.replace(".", "/") + ".class");
        }
        return getPath().resolve(modelFullClassName.replace(".", "/") + ".class");
    }

    boolean equals(Object obj);

    int hashCode();

    default boolean isArchive()
    {
        return isJarFile() || isZipFile();
    }

    default boolean isDirectory()
    {
        return Files.isDirectory(getPath());
    }

    default boolean isJarFile()
    {
        return getPath().toString().toLowerCase().endsWith(".jar");
    }

    default boolean isZipFile()
    {
        return getPath().toString().toLowerCase().endsWith(".zip");
    }
}
