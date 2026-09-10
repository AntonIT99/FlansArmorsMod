package com.flansmod.client.model.mw;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;

public class ModelMolotov extends ModelBase
{
	public ModelRendererTurbo neckModel;
	public ModelRendererTurbo bodyModel;
	public ModelRendererTurbo clothModel;
	
	public ModelMolotov()
	{
		bodyModel = new ModelRendererTurbo(this, 0, 0, 32, 16);
		bodyModel.addBox(-1F, -2F, -1F, 2, 4, 2);
		neckModel = new ModelRendererTurbo(this, 8, 0, 32, 16);
		neckModel.addBox(-0.5F, 2F, -0.5F, 1, 2, 1);
		clothModel = new ModelRendererTurbo(this, 0, 6, 32, 16);
		clothModel.addShapeBox(-1F, -0.5F, -0.5F, 2, 1, 5, 0F, /* 0 */ -0.5F, 0F, 0F, /* 1 */ -0.5F, 0F, 0F, /* 2 */ 0F, 0F, 0F, /* 3 */ 0F, 0F, 0F, /* 4 */ -0.5F, 0F, 0F, /* 5 */ -0.5F, 0F, 0F, /* 6 */ 0F, 0F, 0F, /* 7 */ 0F, 0F, 0F);
		clothModel.setRotationPoint(0F, 4F, 0F);
		clothModel.rotateAngleX = 1F;
	}
	
	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
	    poseStack.pushPose();
		neckModel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());
		bodyModel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());
		clothModel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());

	    poseStack.popPose();
	}
}
