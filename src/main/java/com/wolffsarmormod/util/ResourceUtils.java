package com.wolffsarmormod.util;

import com.mojang.blaze3d.platform.NativeImage;
import com.wolffsarmormod.ArmorMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;

public class ResourceUtils
{
    private ResourceUtils() {}

    @Nullable
    public static ResourceLocation loadExternalTexture(Path path, String resourceLocPath)
    {
        try
        {
            File file = path.toFile();
            if (!file.exists())
            {
                ArmorMod.log.error("File not found: {}", path);
                return null;
            }

            FileInputStream fileInputStream = new FileInputStream(file);
            NativeImage nativeImage = NativeImage.read(fileInputStream);
            fileInputStream.close();

            String fileName = file.getName().split("\\.")[0].toLowerCase();
            DynamicTexture texture = new DynamicTexture(nativeImage);
            ResourceLocation location = ResourceLocation.fromNamespaceAndPath(ArmorMod.MOD_ID, resourceLocPath + fileName);
            Minecraft.getInstance().getTextureManager().register(location, texture);

            return location;
        }
        catch (Exception e)
        {
            ArmorMod.log.error("Failed to load file: {}", path);
            return null;
        }
    }
}
