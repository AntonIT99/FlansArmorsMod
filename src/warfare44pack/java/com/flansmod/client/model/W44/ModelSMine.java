//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmodultimate.client.model.ModelBase;
import com.flansmodultimate.client.render.EnumRenderPass;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.jetbrains.annotations.NotNull;


public class ModelSMine extends ModelBase {
   int textureX = 64;
   int textureY = 64;
   public ModelRendererTurbo[] smineModel = new ModelRendererTurbo[24];

   public ModelSMine() {
      this.smineModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.smineModel[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.smineModel[2] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.smineModel[3] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.smineModel[4] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.smineModel[5] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.smineModel[6] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.smineModel[7] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.smineModel[8] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.smineModel[9] = new ModelRendererTurbo(this, 33, 25, this.textureX, this.textureY);
      this.smineModel[10] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
      this.smineModel[11] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.smineModel[12] = new ModelRendererTurbo(this, 57, 25, this.textureX, this.textureY);
      this.smineModel[13] = new ModelRendererTurbo(this, 33, 33, this.textureX, this.textureY);
      this.smineModel[14] = new ModelRendererTurbo(this, 41, 33, this.textureX, this.textureY);
      this.smineModel[15] = new ModelRendererTurbo(this, 49, 33, this.textureX, this.textureY);
      this.smineModel[16] = new ModelRendererTurbo(this, 57, 33, this.textureX, this.textureY);
      this.smineModel[17] = new ModelRendererTurbo(this, 33, 41, this.textureX, this.textureY);
      this.smineModel[18] = new ModelRendererTurbo(this, 41, 41, this.textureX, this.textureY);
      this.smineModel[19] = new ModelRendererTurbo(this, 49, 41, this.textureX, this.textureY);
      this.smineModel[20] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.smineModel[21] = new ModelRendererTurbo(this, 38, 48, this.textureX, this.textureY);
      this.smineModel[22] = new ModelRendererTurbo(this, 21, 44, this.textureX, this.textureY);
      this.smineModel[23] = new ModelRendererTurbo(this, 57, 41, this.textureX, this.textureY);
      this.smineModel[0].addShapeBox(-5.0F, -1.8F, -5.0F, 3, 13, 10, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F);
      this.smineModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[0].rotateAngleZ = (float) Math.PI;
      this.smineModel[1].addShapeBox(2.0F, -1.8F, -5.0F, 3, 13, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F);
      this.smineModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[1].rotateAngleZ = (float) Math.PI;
      this.smineModel[2].addShapeBox(-2.0F, -1.8F, -5.0F, 4, 13, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.smineModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[2].rotateAngleZ = (float) Math.PI;
      this.smineModel[3].addShapeBox(-3.8F, -2.25F, -1.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.smineModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[3].rotateAngleZ = (float) Math.PI;
      this.smineModel[4].addShapeBox(-4.8F, -2.25F, -1.0F, 1, 1, 2, 0.0F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F);
      this.smineModel[4].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[4].rotateAngleZ = (float) Math.PI;
      this.smineModel[5].addShapeBox(-2.8F, -2.25F, -1.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.smineModel[5].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[5].rotateAngleZ = (float) Math.PI;
      this.smineModel[6].addShapeBox(2.5F, -2.25F, -3.65F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.smineModel[6].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[6].rotateAngleZ = (float) Math.PI;
      this.smineModel[7].addShapeBox(1.5F, -2.25F, -3.65F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.smineModel[7].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[7].rotateAngleZ = (float) Math.PI;
      this.smineModel[8].addShapeBox(0.5F, -2.25F, -3.65F, 1, 1, 2, 0.0F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F);
      this.smineModel[8].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[8].rotateAngleZ = (float) Math.PI;
      this.smineModel[9].addShapeBox(2.5F, -2.25F, 1.65F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.smineModel[9].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[9].rotateAngleZ = (float) Math.PI;
      this.smineModel[10].addShapeBox(1.5F, -2.25F, 1.65F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.smineModel[10].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[10].rotateAngleZ = (float) Math.PI;
      this.smineModel[11].addShapeBox(0.5F, -2.25F, 1.65F, 1, 1, 2, 0.0F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F);
      this.smineModel[11].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[11].rotateAngleZ = (float) Math.PI;
      this.smineModel[12].addShapeBox(4.0F, -2.25F, -1.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.smineModel[12].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[12].rotateAngleZ = (float) Math.PI;
      this.smineModel[13].addShapeBox(3.0F, -2.25F, -1.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.smineModel[13].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[13].rotateAngleZ = (float) Math.PI;
      this.smineModel[14].addShapeBox(2.0F, -2.25F, -1.0F, 1, 1, 2, 0.0F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F);
      this.smineModel[14].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[14].rotateAngleZ = (float) Math.PI;
      this.smineModel[15].addShapeBox(-0.5F, -8.0F, -0.5F, 1, 6, 1, 0.0F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F);
      this.smineModel[15].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[15].rotateAngleZ = (float) Math.PI;
      this.smineModel[16].addShapeBox(-0.5F, -9.5F, -0.5F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.smineModel[16].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[16].rotateAngleZ = (float) Math.PI;
      this.smineModel[17].addShapeBox(-0.5F, -10.5F, -0.5F, 1, 1, 1, 0.0F, -0.25F, -0.75F, -0.25F, -0.25F, -0.75F, -0.25F, -0.25F, -0.75F, -0.25F, -0.25F, -0.75F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.smineModel[17].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[17].rotateAngleZ = (float) Math.PI;
      this.smineModel[18].addShapeBox(-0.5F, -12.5F, 0.5F, 1, 3, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, 0.7F, -0.3F, 0.0F, 0.7F, -0.3F, 0.0F, -1.3F, -0.3F, 0.0F, -1.3F);
      this.smineModel[18].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[18].rotateAngleZ = (float) Math.PI;
      this.smineModel[19].addShapeBox(-0.5F, -12.5F, -1.5F, 1, 3, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -1.3F, -0.3F, 0.0F, -1.3F, -0.3F, 0.0F, 0.7F, -0.3F, 0.0F, 0.7F);
      this.smineModel[19].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[19].rotateAngleZ = (float) Math.PI;
      this.smineModel[20].addShapeBox(-2.0F, -2.0F, -4.5F, 4, 1, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.smineModel[20].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[20].rotateAngleZ = (float) Math.PI;
      this.smineModel[21].addShapeBox(-5.0F, -2.0F, -4.5F, 3, 1, 9, 0.0F, -0.35F, 0.0F, -2.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.35F, 0.0F, -2.75F, -0.35F, 0.0F, -2.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.35F, 0.0F, -2.75F);
      this.smineModel[21].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[21].rotateAngleZ = (float) Math.PI;
      this.smineModel[22].addShapeBox(2.0F, -2.0F, -4.5F, 3, 1, 9, 0.0F, 0.0F, 0.0F, 0.0F, -0.35F, 0.0F, -2.75F, -0.35F, 0.0F, -2.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.35F, 0.0F, -2.75F, -0.35F, 0.0F, -2.75F, 0.0F, 0.0F, 0.0F);
      this.smineModel[22].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[22].rotateAngleZ = (float) Math.PI;
      this.smineModel[23].addShapeBox(-0.5F, -8.75F, -1.0F, 1, 1, 2, 0.0F, -0.3F, -0.3F, 0.25F, -0.3F, -0.3F, 0.25F, -0.3F, -0.3F, 0.25F, -0.3F, -0.3F, 0.25F, -0.3F, -0.3F, 0.25F, -0.3F, -0.3F, 0.25F, -0.3F, -0.3F, 0.25F, -0.3F, -0.3F, 0.25F);
      this.smineModel[23].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smineModel[23].rotateAngleZ = (float) Math.PI;
   }

   @Override
   public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha, EnumRenderPass renderPass)
   {
       poseStack.pushPose();
       poseStack.scale(0.3F, 0.3F, 0.3F);
       super.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, renderPass);
       poseStack.popPose();
   }
}
