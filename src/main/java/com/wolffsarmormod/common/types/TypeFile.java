package com.wolffsarmormod.common.types;

import com.wolffsarmormod.IContentProvider;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TypeFile
{
    private final String name;
    private final Path fullPath;
    private final EnumType type;
    private final IContentProvider contentPack;
    private final List<String> lines = new ArrayList<>();

    public TypeFile(String name, Path fullPath, EnumType type, IContentProvider contentPack, List<String> lines)
    {
        this.name = name;
        this.fullPath = fullPath;
        this.type = type;
        this.contentPack = contentPack;
        this.lines.addAll(lines);
    }

    public String getName()
    {
        return name;
    }

    public Path getFullPath()
    {
        return fullPath;
    }

    public EnumType getType()
    {
        return type;
    }

    public IContentProvider getContentPack()
    {
        return contentPack;
    }

    public List<String> getLines()
    {
        return lines;
    }
}
