package com.flansmod.client.model.nerf;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import com.wolffsmod.api.client.model.ModelRenderer;
import org.jetbrains.annotations.NotNull;


public class ModelDisc extends ModelBase
{
	public ModelRenderer bulletModel;

	public ModelDisc()
	{
		bulletModel = new ModelRenderer(this, 0, 0);
		bulletModel.addBox(-1F, -1F, -0.5F, 2, 2, 1);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
	    poseStack.pushPose();
		bulletModel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());

	    poseStack.popPose();
	}
}
