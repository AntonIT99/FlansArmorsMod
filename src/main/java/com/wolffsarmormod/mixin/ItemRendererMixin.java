package com.wolffsarmormod.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.renderer.entity.ItemRenderer;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin
{

    /*@Inject(method = "render", at = @At("HEAD"))
    private void onRender(ItemStack pItemStack, ItemDisplayContext pDisplayContext, boolean pLeftHand, PoseStack pPoseStack, MultiBufferSource pBuffer, int pCombinedLight, int pCombinedOverlay, BakedModel pModel, CallbackInfo ci)
    {
        if (!pItemStack.isEmpty() && pItemStack.getItem() instanceof ICustomIconItem)
        {
            pPoseStack.pushPose();
            pPoseStack.translate(-0.5F, -0.5F, -0.5F);
            IClientItemExtensions.of(pItemStack).getCustomRenderer().renderByItem(pItemStack, pDisplayContext, pPoseStack, pBuffer, pCombinedLight, pCombinedOverlay);
            pPoseStack.popPose();
            itemCount = pItemStack.getCount();
            pItemStack.setCount(0);
        }
    }*/

    /*@ModifyVariable(
            method = "render",
            at = @At(value = "STORE"),
            ordinal = 0 // Targeting the first occurrence of pModel being stored
    )
    private BakedModel modifyModel(BakedModel original, ItemStack pItemStack, ItemDisplayContext pDisplayContext, boolean pLeftHand, PoseStack pPoseStack, MultiBufferSource pBuffer, int pCombinedLight, int pCombinedOverlay, BakedModel pModel)
    {
        if (pItemStack.getItem() instanceof ICustomIconItem)
        {
            return new BakedModel()
            {
                @Override
                public List<BakedQuad> getQuads(@Nullable BlockState pState, @Nullable Direction pDirection, RandomSource pRandom)
                {
                    return List.of();
                }

                @Override
                public boolean useAmbientOcclusion()
                {
                    return false;
                }

                @Override
                public boolean isGui3d()
                {
                    return false;
                }

                @Override
                public boolean usesBlockLight()
                {
                    return false;
                }

                @Override
                public boolean isCustomRenderer()
                {
                    return true;
                }

                @Override
                public TextureAtlasSprite getParticleIcon()
                {
                    return null;
                }

                @Override
                public ItemOverrides getOverrides()
                {
                    return null;
                }
            };
        }
        return original;
    }*/
}
