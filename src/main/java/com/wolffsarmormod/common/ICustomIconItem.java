package com.wolffsarmormod.common;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public interface ICustomIconItem
{
    @OnlyIn(Dist.CLIENT)
    void loadIcon();

    @OnlyIn(Dist.CLIENT)
    @Nullable
    ResourceLocation getIcon();
}
