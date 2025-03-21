package com.wolffsarmormod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsarmormod.common.ICustomIconItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
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
    public void renderByItem(@NotNull ItemStack pStack, @NotNull ItemDisplayContext pDisplayContext, @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay)
    {
        /*Item item = pStack.getItem();
        if (item instanceof ICustomIconItem customIconItem && customIconItem.getIcon() != null)
        {
            RenderSystem.setShaderTexture(0, customIconItem.getIcon());
            GuiGraphics guiGraphics = new GuiGraphics(Minecraft.getInstance(), Minecraft.getInstance().renderBuffers().bufferSource());
            guiGraphics.blit(customIconItem.getIcon(), 0, 0, 16, 16, 16, 16);
        }*/

        /*for (var model : pModel.getRenderPasses(pItemStack, true))
        {
            for (var rendertype : model.getRenderTypes(pItemStack, flag1))
            {
                VertexConsumer vertexconsumer;
                if (hasAnimatedTexture(pItemStack) && pItemStack.hasFoil())
                {
                    pPoseStack.pushPose();
                    PoseStack.Pose posestack$pose = pPoseStack.last();
                    if (pDisplayContext == ItemDisplayContext.GUI)
                    {
                        MatrixUtil.mulComponentWise(posestack$pose.pose(), 0.5F);
                    }
                    else if (pDisplayContext.firstPerson())
                    {
                        MatrixUtil.mulComponentWise(posestack$pose.pose(), 0.75F);
                    }

                    vertexconsumer = getCompassFoilBufferDirect(pBuffer, rendertype, posestack$pose);

                    pPoseStack.popPose();
                }
                else
                {
                    vertexconsumer = getFoilBufferDirect(pBuffer, rendertype, true, pItemStack.hasFoil());
                }

                this.renderModelLists(model, pItemStack, pCombinedLight, pCombinedOverlay, pPoseStack, vertexconsumer);
            }
        }*/

        Item item = pStack.getItem();
        if (!(item instanceof ICustomIconItem customIconItem) || customIconItem.getIcon() == null) {
            return;
        }

        ResourceLocation icon = customIconItem.getIcon();
        pPoseStack.pushPose();

        if (pDisplayContext == ItemDisplayContext.GUI)
        {
            RenderSystem.setShaderTexture(0, icon);
            Minecraft mc = Minecraft.getInstance();
            GuiGraphics guiGraphics = new GuiGraphics(mc, mc.renderBuffers().bufferSource());

            guiGraphics.pose().pushPose();
            guiGraphics.pose().translate(0, 0, 100.0F); // Ensure it is drawn on top
            guiGraphics.blit(icon, 0, 0, 0, 16, 16, 16, 16, 16);
            guiGraphics.pose().popPose();
        }
        else
        {
            if (pDisplayContext.firstPerson())
            {
                pPoseStack.translate(0.5F, -0.1F, 0.0F); // 🔹 Raise the Y position in hand
            }
            else
            {
                pPoseStack.translate(0.5F, 0.5F, 0.0F); // 🔹 Default positioning for world
            }
            pPoseStack.scale(1.0F, 1.0F, 1.0F);

            VertexConsumer vertexConsumer = pBuffer.getBuffer(RenderType.entityTranslucent(icon));
            Matrix4f matrix = pPoseStack.last().pose();
            Matrix3f normalMatrix = pPoseStack.last().normal();

            // Define a quad with texture
            float minX = -0.25F, maxX = 0.25F;
            float minY = -0.25F, maxY = 0.25F;
            float minU = 0.0F, maxU = 1.0F;
            float minV = 0.0F, maxV = 1.0F;

            vertexConsumer.vertex(matrix, minX, minY, 0.0F).color(255, 255, 255, 255).uv(minU, maxV).overlayCoords(pPackedOverlay).uv2(pPackedLight).normal(normalMatrix, 0, 0, 1).endVertex();
            vertexConsumer.vertex(matrix, maxX, minY, 0.0F).color(255, 255, 255, 255).uv(maxU, maxV).overlayCoords(pPackedOverlay).uv2(pPackedLight).normal(normalMatrix, 0, 0, 1).endVertex();
            vertexConsumer.vertex(matrix, maxX, maxY, 0.0F).color(255, 255, 255, 255).uv(maxU, minV).overlayCoords(pPackedOverlay).uv2(pPackedLight).normal(normalMatrix, 0, 0, 1).endVertex();
            vertexConsumer.vertex(matrix, minX, maxY, 0.0F).color(255, 255, 255, 255).uv(minU, minV).overlayCoords(pPackedOverlay).uv2(pPackedLight).normal(normalMatrix, 0, 0, 1).endVertex();
        }

        pPoseStack.popPose();
    }
}
