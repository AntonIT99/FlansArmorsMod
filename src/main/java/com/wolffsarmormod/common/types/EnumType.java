package com.wolffsarmormod.common.types;

import com.wolffsarmormod.common.CustomArmorItem;
import org.apache.commons.lang3.StringUtils;

import net.minecraft.world.item.Item;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum EnumType
{
    ARMOR("armor", "armorFiles", "armor", ArmourType.class, CustomArmorItem.class, true);

    private final String displayName;
    private final String configFolderName;
    private final String textureFolderName;
    private final Class<? extends InfoType> typeClass;
    private final Class<? extends Item> itemClass;
    private final boolean isItemType;

    EnumType(String name, String configFolder, String textureFolder, Class<? extends InfoType> type, Class<? extends Item> item, boolean isItem)
    {
        displayName = name;
        configFolderName = configFolder;
        textureFolderName = textureFolder;
        typeClass = type;
        itemClass = item;
        isItemType = isItem;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getTextureFolderName()
    {
        return textureFolderName;
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

    public static List<String> getFoldersList()
    {
        return Arrays.stream(EnumType.values()).map(EnumType::getConfigFolderName).toList();
    }

    public static Optional<EnumType> getType(String folderName)
    {
        return Arrays.stream(EnumType.values()).filter(type -> StringUtils.equals(type.getConfigFolderName(), folderName)).findFirst();
    }
}
