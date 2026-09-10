package com.flansmod.client.model.wolffstarwars;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;


public class ModelLaserBeam extends ModelBase
{
    public ModelRendererTurbo laserModel;

    int textureX = 32;
    int textureY = 32;

    public ModelLaserBeam()
    {
        laserModel = new ModelRendererTurbo(this, 0, 0);
        laserModel.addBox(-1.5F, -16.0F, -1.5F, 3, 32, 3);
        laserModel.glow = true;
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        poseStack.pushPose();
        poseStack.scale(0.5F, 0.5F, 0.5F);
        poseStack.translate(0F, 3F, 0F);
        laserModel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());

        poseStack.popPose();
    }
}
