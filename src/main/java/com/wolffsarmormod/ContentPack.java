package com.wolffsarmormod;

import com.google.common.base.Objects;
import lombok.Getter;

import java.nio.file.Path;

public class ContentPack implements IContentProvider
{
    @Getter
    private String name;
    @Getter
    private Path path;

    private final int hashCode;

    public ContentPack(String name, Path path)
    {
        this.name = name;
        this.path = path;
        hashCode = Objects.hashCode(path);
    }

    @Override
    public void update(String name, Path path)
    {
        this.name = name;
        this.path = path;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof IContentProvider provider)
        {
            return hashCode == provider.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return hashCode;
    }

    @Override
    public String toString()
    {
        return name + " [" + path.toString() + "]";
    }
}
