package com.wolffsarmormod;

import com.google.common.base.Objects;

import java.nio.file.Path;

public record ContentPack(String name, Path path) implements IContentProvider
{
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof IContentProvider provider)
        {
            return path.equals(provider.path());
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
