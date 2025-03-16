package com.wolff.armormod.common;

import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;

import static com.wolff.armormod.client.CustomItemRenderer.loadExternalTexture;

public interface ICustomIconItem
{
    Path getIconPath();

    default ResourceLocation getIcon()
    {
        return loadExternalTexture(getIconPath());
    }
}
