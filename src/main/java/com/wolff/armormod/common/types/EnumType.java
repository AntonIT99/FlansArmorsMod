package com.wolff.armormod.common.types;

import com.wolff.armormod.common.CustomArmorItem;
import org.apache.commons.lang3.StringUtils;

import net.minecraft.world.item.Item;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum EnumType
{
    ARMOR("armor", "armorFiles", ArmourType.class, CustomArmorItem.class);

    private final String displayName;
    private final String folderName;
    private final Class<? extends InfoType> typeClass;
    private final Class<? extends Item> itemClass;

    EnumType(String name, String folder, Class<? extends InfoType> type, Class<? extends Item> item)
    {
        displayName = name;
        folderName = folder;
        typeClass = type;
        itemClass = item;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getFolderName()
    {
        return folderName;
    }

    public Class<? extends InfoType> getTypeClass()
    {
        return typeClass;
    }

    public Class<? extends Item> getItemClass()
    {
        return itemClass;
    }

    public static List<String> getFoldersList()
    {
        return Arrays.stream(EnumType.values()).map(EnumType::getFolderName).toList();
    }

    public static Optional<EnumType> getType(String folderName)
    {
        return Arrays.stream(EnumType.values()).filter(type -> StringUtils.equals(type.getFolderName(), folderName)).findFirst();
    }
}
