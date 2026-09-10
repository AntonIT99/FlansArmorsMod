package com.flansmod.client.model.mw;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;

public class ModelClaymore extends ModelBase
{
	public ModelRendererTurbo[] claymoreModel;
	
	public ModelClaymore()
	{
		claymoreModel = new ModelRendererTurbo[2];
		claymoreModel[0] = new ModelRendererTurbo(this, 0, 0, 32, 16);
		claymoreModel[0].addBox(-1F, 2F, -4F, 2, 4, 8);
		claymoreModel[1] = new ModelRendererTurbo(this, 12, 4, 32, 16);
		claymoreModel[1].addBox(0F, -2F, -4F, 0, 4, 8);
	}
	
	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
	    poseStack.pushPose();
		for(ModelRendererTurbo claymoreModelBit : claymoreModel)
			claymoreModelBit.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());

	    poseStack.popPose();
	}
	
}
