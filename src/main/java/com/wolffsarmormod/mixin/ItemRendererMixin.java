package com.wolffsarmormod.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.renderer.entity.ItemRenderer;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin
{
    /*@Inject(method = "render", at = @At("HEAD"))
    private void onRender(ItemStack pItemStack, ItemDisplayContext pDisplayContext, boolean pLeftHand, PoseStack pPoseStack, MultiBufferSource pBuffer, int pCombinedLight, int pCombinedOverlay, BakedModel pModel, CallbackInfo ci)
    {
        if (!pItemStack.isEmpty())
        {
            pPoseStack.pushPose();
            pPoseStack.translate(-0.5F, -0.5F, -0.5F);
            IClientItemExtensions.of(pItemStack).getCustomRenderer().renderByItem(pItemStack, pDisplayContext, pPoseStack, pBuffer, pCombinedLight, pCombinedOverlay);
            pPoseStack.popPose();
            //TODO: this is somehow not cancelable
            ci.cancel();
        }
    }*/


}
