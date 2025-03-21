package com.wolffsarmormod;

import java.nio.file.Files;
import java.nio.file.Path;

public interface IContentProvider
{
    String name();

    Path path();

    boolean equals(Object obj);

    int hashCode();

    default boolean isArchive()
    {
        return isJarFile() && isZipFile();
    }

    default boolean isDirectory()
    {
        return Files.isDirectory(path());
    }

    default boolean isJarFile()
    {
        return path().toString().toLowerCase().endsWith(".jar");
    };

    default boolean isZipFile()
    {
        return path().toString().toLowerCase().endsWith(".zip");
    };
}
