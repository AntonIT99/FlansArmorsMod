package com.flansmod.client.model.mw;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;

public class ModelC4 extends ModelBase
{
	public ModelRendererTurbo[] c4Model;

	public ModelC4()
	{
		c4Model = new ModelRendererTurbo[2];
		c4Model[0] = new ModelRendererTurbo(this, 0, 0, 32, 8);
		c4Model[0].addBox(-2F, 0F, -3F, 4, 2, 6);
		c4Model[1] = new ModelRendererTurbo(this, 20, 0, 32, 8);
		c4Model[1].addBox(-1F, 1.5F, -2F, 2, 1, 4);
	}
	
	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
	    poseStack.pushPose();
		for(ModelRendererTurbo mineModelBit : c4Model)
			mineModelBit.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());

	    poseStack.popPose();
	}
	
}
