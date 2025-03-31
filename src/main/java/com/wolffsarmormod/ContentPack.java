package com.wolffsarmormod;

import com.google.common.base.Objects;

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

    public void update(String name, Path path)
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

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof IContentProvider provider)
        {
            return path.equals(provider.getPath());
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(path);
    }

    @Override
    public String toString()
    {
        return name + " [" + path.toString() + "]";
    }
}
