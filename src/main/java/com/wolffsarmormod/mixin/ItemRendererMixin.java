package com.wolffsarmormod.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsarmormod.common.item.IModelItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin
{
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void onRender(ItemStack stack, ItemDisplayContext transformType, boolean leftHanded, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay, BakedModel model, CallbackInfo ci)
    {
        if (shouldRenderFlanItemModel(stack, transformType))
        {
            IModelItem<?, ?> item = (IModelItem<?, ?>) stack.getItem();
            VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityTranslucent(item.getTexture()));
            Objects.requireNonNull(item.getModel()).renderToBuffer(poseStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            ci.cancel();
        }
    }

    @Unique
    private boolean shouldRenderFlanItemModel(ItemStack stack, ItemDisplayContext transformType)
    {
        return transformType != ItemDisplayContext.NONE
                && transformType != ItemDisplayContext.GUI
                && transformType != ItemDisplayContext.HEAD
                && stack.getItem() instanceof IModelItem<?, ?> item
                && item.useCustomItemRendering()
                && item.getModel() != null;
    }
}
