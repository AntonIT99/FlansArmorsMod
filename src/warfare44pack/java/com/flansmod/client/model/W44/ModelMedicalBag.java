//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;

public class ModelMedicalBag extends ModelBase {
   int textureX = 64;
   int textureY = 64;
   public ModelRendererTurbo[] medicalbagModel = new ModelRendererTurbo[16];

   public ModelMedicalBag() {
      this.medicalbagModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.medicalbagModel[1] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.medicalbagModel[2] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.medicalbagModel[3] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.medicalbagModel[4] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.medicalbagModel[5] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.medicalbagModel[6] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.medicalbagModel[7] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.medicalbagModel[8] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.medicalbagModel[9] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.medicalbagModel[10] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.medicalbagModel[11] = new ModelRendererTurbo(this, 57, 9, this.textureX, this.textureY);
      this.medicalbagModel[12] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.medicalbagModel[13] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.medicalbagModel[14] = new ModelRendererTurbo(this, 25, 33, this.textureX, this.textureY);
      this.medicalbagModel[15] = new ModelRendererTurbo(this, 33, 41, this.textureX, this.textureY);
      this.medicalbagModel[0].addShapeBox(-6.0F, 0.0F, -5.5F, 10, 2, 11, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.medicalbagModel[0].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[0].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[1].addShapeBox(-6.0F, -2.0F, -5.5F, 10, 2, 11, 0.0F, -2.0F, -0.75F, 0.0F, -2.0F, -0.75F, 0.0F, -2.0F, -0.75F, 0.0F, -2.0F, -0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.medicalbagModel[1].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[1].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[2].addShapeBox(0.0F, -1.0F, -6.0F, 4, 1, 12, 0.0F, 0.0F, 1.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 1.0F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -1.0F, -0.3F);
      this.medicalbagModel[2].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[2].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[3].addShapeBox(-2.0F, -1.0F, -6.0F, 2, 1, 12, 0.0F, 0.0F, 0.5F, -1.5F, 0.0F, 1.0F, -0.3F, 0.0F, 1.0F, -0.3F, 0.0F, 0.5F, -1.5F, 0.0F, -0.9F, -1.5F, 0.0F, -1.0F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F, -0.9F, -1.5F);
      this.medicalbagModel[3].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[3].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[4].addShapeBox(1.0F, -1.5F, -4.0F, 3, 1, 1, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.medicalbagModel[4].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[4].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[5].addShapeBox(1.0F, -1.5F, 3.0F, 3, 1, 1, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.medicalbagModel[5].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[5].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[6].addShapeBox(-1.0F, -1.5F, 3.0F, 2, 1, 1, 0.0F, -1.0F, 0.75F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -1.0F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.medicalbagModel[6].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[6].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[7].addShapeBox(-1.0F, -1.5F, -4.0F, 2, 1, 1, 0.0F, -1.0F, 0.75F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -1.0F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.medicalbagModel[7].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[7].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[8].addShapeBox(0.0F, -2.4F, 3.0F, 1, 1, 1, 0.0F, -0.25F, -0.1F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.1F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F);
      this.medicalbagModel[8].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[8].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[9].addShapeBox(0.0F, -2.4F, -4.0F, 1, 1, 1, 0.0F, -0.25F, -0.1F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.1F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F);
      this.medicalbagModel[9].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[9].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[10].addShapeBox(-6.0F, 2.0F, -5.5F, 10, 1, 11, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F);
      this.medicalbagModel[10].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[10].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[11].addShapeBox(4.25F, -1.0F, -3.5F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, 1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, 1.0F, 0.0F, -0.3F, 0.0F);
      this.medicalbagModel[11].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[11].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[12].addShapeBox(4.25F, -1.0F, 2.5F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, 0.0F);
      this.medicalbagModel[12].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[12].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[13].addShapeBox(6.25F, -1.0F, -2.5F, 1, 1, 5, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, 0.0F);
      this.medicalbagModel[13].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[13].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[14].addShapeBox(-0.5F, -1.8F, -2.5F, 5, 1, 5, 0.0F, -0.75F, 0.2F, -0.75F, -0.75F, -0.5F, -0.75F, -0.75F, -0.5F, -0.75F, -0.75F, 0.2F, -0.75F, -0.75F, 0.0F, -0.75F, -0.75F, 0.0F, -0.75F, -0.75F, 0.0F, -0.75F, -0.75F, 0.0F, -0.75F);
      this.medicalbagModel[14].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[14].rotateAngleZ = (float) Math.PI;
      this.medicalbagModel[15].addShapeBox(4.0F, -1.0F, -6.0F, 1, 1, 12, 0.0F, 0.0F, 0.0F, -0.3F, -0.6F, -0.25F, -0.3F, -0.6F, -0.25F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -0.6F, -0.25F, -0.3F, -0.6F, -0.25F, -0.3F, 0.0F, 0.0F, -0.3F);
      this.medicalbagModel[15].setRotationPoint(0.0F, 3.0F, 0.0F);
      this.medicalbagModel[15].rotateAngleZ = (float) Math.PI;
   }

   @Override
   public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
   {
       poseStack.pushPose();
      for (int i = 0; i < 16; i++) {
         this.medicalbagModel[i].render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());
      }

       poseStack.popPose();
   }
}
