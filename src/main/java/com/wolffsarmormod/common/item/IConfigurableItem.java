package com.wolffsarmormod.common.item;

import com.wolffsarmormod.common.types.InfoType;
import com.wolffsarmormod.config.ModClientConfigs;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.BooleanUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public interface IConfigurableItem<T extends InfoType> extends ItemLike
{
    T getConfigType();

    default String getContentPack()
    {
        return FilenameUtils.getBaseName(getConfigType().getContentPack().getName());
    }

    default void appendHoverText(List<Component> tooltipComponents)
    {
        if (BooleanUtils.isTrue(ModClientConfigs.showPackNameInItemDescriptions.get()) && !getContentPack().isBlank())
            tooltipComponents.add(Component.literal(getContentPack()).withStyle(ChatFormatting.GRAY));

        for (String line : getConfigType().getDescription().split("_"))
        {
            if (!line.isBlank())
                tooltipComponents.add(Component.literal(line));
        }
    }
}
