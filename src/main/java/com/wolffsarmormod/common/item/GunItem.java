package com.wolffsarmormod.common.item;

import com.wolffsarmormod.common.types.GunType;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

@Getter
public class GunItem extends Item implements IConfigurableItem<GunType>
{
    protected final GunType configType;

    public GunItem(GunType configType)
    {
        super(new Item.Properties());
        this.configType = configType;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced)
    {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        appendHoverText(tooltipComponents);
    }
}
