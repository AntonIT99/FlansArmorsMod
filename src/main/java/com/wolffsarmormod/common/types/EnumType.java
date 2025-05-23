package com.wolffsarmormod.common.types;

import com.wolffsarmormod.common.CustomArmorItem;
import org.apache.commons.lang3.StringUtils;

import net.minecraft.world.item.Item;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum EnumType
{
    ARMOR("armor", "armorFiles", ArmourType.class, CustomArmorItem.class, true, false);

    private final String displayName;
    private final String configFolderName;
    private final Class<? extends InfoType> typeClass;
    private final Class<? extends Item> itemClass;
    private final boolean isItemType;
    private final boolean isBlockType;

    EnumType(String name, String configFolder, Class<? extends InfoType> type, Class<? extends Item> item, boolean isItem, boolean isBlock)
    {
        displayName = name;
        configFolderName = configFolder;
        typeClass = type;
        itemClass = item;
        isItemType = isItem;
        isBlockType = isBlock;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getConfigFolderName()
    {
        return configFolderName;
    }

    public Class<? extends InfoType> getTypeClass()
    {
        return typeClass;
    }

    public Class<? extends Item> getItemClass()
    {
        return itemClass;
    }

    public boolean isItemType()
    {
        return isItemType;
    }

    public boolean isBlockType()
    {
        return isBlockType;
    }

    public static List<String> getFoldersList()
    {
        return Arrays.stream(EnumType.values()).map(EnumType::getConfigFolderName).toList();
    }

    public static Optional<EnumType> getType(String folderName)
    {
        return Arrays.stream(EnumType.values()).filter(type -> StringUtils.equals(type.getConfigFolderName(), folderName)).findFirst();
    }
}
