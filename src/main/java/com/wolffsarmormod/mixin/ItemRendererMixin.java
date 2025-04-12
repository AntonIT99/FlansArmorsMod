package com.wolffsarmormod.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.wolffsarmormod.common.item.GunItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin
{
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void onRender(ItemStack stack, ItemDisplayContext transformType, boolean leftHanded, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay, BakedModel model, CallbackInfo ci)
    {
        if (stack.getItem() instanceof GunItem && (transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND
            || transformType == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND
            || transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND
            || transformType == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND))
        {

            ci.cancel();
        }
    }
}
