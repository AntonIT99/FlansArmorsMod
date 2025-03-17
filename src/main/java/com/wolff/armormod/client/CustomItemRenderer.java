package com.wolff.armormod.client;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.wolff.armormod.ArmorMod;
import com.wolff.armormod.common.ICustomIconItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

@OnlyIn(Dist.CLIENT)
public class CustomItemRenderer extends BlockEntityWithoutLevelRenderer
{
    public static final CustomItemRenderer INSTANCE = new CustomItemRenderer();

    public CustomItemRenderer()
    {
        super(null, null);
    }

    @Override
    public void renderByItem(ItemStack pStack, @NotNull ItemDisplayContext pDisplayContext, @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay)
    {
        Item item = pStack.getItem();
        if (item instanceof ICustomIconItem customIconItem)
        {
            ResourceLocation icon = loadExternalTexture(customIconItem.getIconPath());
            if (icon != null)
            {
                RenderSystem.setShaderTexture(0, icon);
                GuiGraphics guiGraphics = new GuiGraphics(Minecraft.getInstance(), Minecraft.getInstance().renderBuffers().bufferSource());
                guiGraphics.blit(icon, 0, 0, 16, 16, 16, 16);
            }
        }
    }

    @Nullable
    public static ResourceLocation loadExternalTexture(Path path) {
        try
        {
            File file = path.toFile();
            if (!file.exists())
            {
                ArmorMod.LOG.error("File not found: {}", path);
                return null;
            }

            FileInputStream fileInputStream = new FileInputStream(file);
            NativeImage nativeImage = NativeImage.read(fileInputStream);
            fileInputStream.close();

            DynamicTexture texture = new DynamicTexture(nativeImage);
            ResourceLocation location = new ResourceLocation(ArmorMod.MOD_ID, file.getName());
            Minecraft.getInstance().getTextureManager().register(location, texture);

            return location;
        }
        catch (IOException e)
        {
            ArmorMod.LOG.error("Failed to load file: {}", path);
            return null;
        }
    }
}
