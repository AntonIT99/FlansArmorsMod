package com.wolff.armormod.common;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;

import static com.wolff.armormod.client.CustomItemRenderer.loadExternalTexture;

public interface ICustomIconItem
{
    @OnlyIn(Dist.CLIENT)
    Path getIconPath();

    @OnlyIn(Dist.CLIENT)
    default ResourceLocation getIcon()
    {
        return loadExternalTexture(getIconPath());
    }
}
