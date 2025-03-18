package com.wolffsarmormod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.wolffsarmormod.common.ICustomIconItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

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
        if (item instanceof ICustomIconItem customIconItem && customIconItem.getIcon() != null)
        {
            RenderSystem.setShaderTexture(0, customIconItem.getIcon());
            GuiGraphics guiGraphics = new GuiGraphics(Minecraft.getInstance(), Minecraft.getInstance().renderBuffers().bufferSource());
            guiGraphics.blit(customIconItem.getIcon(), 0, 0, 16, 16, 16, 16);
        }
    }
}
