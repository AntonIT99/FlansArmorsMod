package com.wolff.armormod.common.types;

import java.util.Arrays;
import java.util.List;

public enum EnumType
{
    ARMOR("armorFiles");

    private final String folderName;

    EnumType(String s)
    {
        folderName = s;
    }

    public String getFolderName()
    {
        return folderName;
    }

    public static List<String> getFoldersList()
    {
        return Arrays.stream(EnumType.values()).map(EnumType::getFolderName).toList();
    }
}
