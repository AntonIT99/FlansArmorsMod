//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;

public class ModelW44ShellSmall extends ModelBase {
   int textureX = 32;
   int textureY = 32;
   public ModelRendererTurbo[] w44shellsmallModel = new ModelRendererTurbo[3];

   public ModelW44ShellSmall() {
      this.w44shellsmallModel[0] = new ModelRendererTurbo(this, 8, 7, this.textureX, this.textureY);
      this.w44shellsmallModel[1] = new ModelRendererTurbo(this, 14, 7, this.textureX, this.textureY);
      this.w44shellsmallModel[2] = new ModelRendererTurbo(this, 20, 7, this.textureX, this.textureY);
      this.w44shellsmallModel[0].addShapeBox(-0.5F, 4.0F, -0.5F, 1, 5, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.w44shellsmallModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.w44shellsmallModel[1].addShapeBox(-0.5F, 9.0F, -0.5F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F);
      this.w44shellsmallModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.w44shellsmallModel[2].addShapeBox(-0.5F, -5.0F, -0.5F, 1, 9, 1, 0.0F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.w44shellsmallModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.w44shellsmallModel[0].glow = true;
      this.w44shellsmallModel[1].glow = true;
      this.w44shellsmallModel[2].glow = true;
   }

   @Override
   public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
   {
       poseStack.pushPose();
      for (int i = 0; i < 3; i++) {
         this.w44shellsmallModel[i].render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());
      }

       poseStack.popPose();
   }
}
