package com.wolff.armormod;

import java.nio.file.Path;

public class ContentPack implements IContentProvider
{
    private String name;
    private Path path;

    public ContentPack(String name, Path path)
    {
        this.name = name;
        this.path = path;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Path getPath()
    {
        return path;
    }
}
