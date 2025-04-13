package com.wolffsarmormod.common.types;

import com.wolffsarmormod.ContentManager;
import com.wolffsarmormod.common.item.CustomArmorItem;
import com.wolffsarmormod.common.item.GunItem;
import com.wolffsarmormod.common.item.IConfigurableItem;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Getter
public enum EnumType
{
    ARMOR("armor", "armorFiles", ContentManager.TEXTURES_ARMOR_FOLDER, ArmorType.class, CustomArmorItem.class, false),
    GUN("gun", "guns", ContentManager.TEXTURES_SKINS_FOLDER, GunType.class, GunItem.class, false);

    private final String displayName;
    private final String configFolderName;
    private final String textureFolderName;
    private final Class<? extends InfoType> typeClass;
    private final Class<? extends IConfigurableItem<?>> itemClass;
    private final boolean itemType;
    private final boolean blockType;

    EnumType(String name, String configFolder, String textureFolder, Class<? extends InfoType> type, @Nullable Class<? extends IConfigurableItem<?>> item, boolean isBlock)
    {
        displayName = name;
        configFolderName = configFolder;
        textureFolderName = textureFolder;
        typeClass = type;
        itemClass = item;
        itemType = (item != null);
        blockType = isBlock;
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
