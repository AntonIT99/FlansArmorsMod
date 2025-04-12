package com.wolffsarmormod.common.types;

import com.wolffsarmormod.common.item.CustomArmorItem;
import com.wolffsarmormod.common.item.GunItem;
import com.wolffsarmormod.common.item.IConfigurableItem;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum EnumType
{
    ARMOR("armor", "armorFiles", ArmourType.class, CustomArmorItem.class, false),
    GUN("gun", "guns", GunType.class, GunItem.class, false);

    @Getter
    private final String displayName;
    @Getter
    private final String configFolderName;
    @Getter
    private final Class<? extends InfoType> typeClass;
    @Getter
    private final Class<? extends IConfigurableItem<?>> itemClass;
    @Getter
    private final boolean itemType;
    @Getter
    private final boolean blockType;

    EnumType(String name, String configFolder, Class<? extends InfoType> type, @Nullable Class<? extends IConfigurableItem<?>> item, boolean isBlock)
    {
        displayName = name;
        configFolderName = configFolder;
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
