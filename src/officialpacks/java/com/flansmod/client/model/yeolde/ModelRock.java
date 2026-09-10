package com.flansmod.client.model.yeolde;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;


public class ModelRock extends ModelBase
{
	public ModelRendererTurbo rockModel;

	public ModelRock()
	{
		rockModel = new ModelRendererTurbo(this, 0, 0, 8, 8);
		rockModel.addBox(-1F, -1F, -1F, 2, 2, 2);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
	    poseStack.pushPose();
		rockModel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());

	    poseStack.popPose();
	}
}
