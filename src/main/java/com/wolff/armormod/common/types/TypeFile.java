package com.wolff.armormod.common.types;

import com.wolff.armormod.IContentProvider;

import java.util.ArrayList;
import java.util.List;

public class TypeFile
{
    private final String name;
    private final EnumType type;
    private final IContentProvider contentPack;
    private final List<String> lines = new ArrayList<>();

    public TypeFile(String name, EnumType type, IContentProvider contentPack, List<String> lines)
    {
        this.name = name;
        this.type = type;
        this.contentPack = contentPack;
        this.lines.addAll(lines);
    }

    public String getName()
    {
        return name;
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
