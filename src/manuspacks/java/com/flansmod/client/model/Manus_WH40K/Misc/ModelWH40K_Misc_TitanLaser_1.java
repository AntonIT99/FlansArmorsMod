//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WH40K.Misc;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;

public class ModelWH40K_Misc_TitanLaser_1 extends ModelBase {
   int textureX = 32;
   int textureY = 64;
   public ModelRendererTurbo[] titanlaserModel = new ModelRendererTurbo[2];

   public ModelWH40K_Misc_TitanLaser_1() {
      this.titanlaserModel[0] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.titanlaserModel[1] = new ModelRendererTurbo(this, 16, 0, this.textureX, this.textureY);
      this.titanlaserModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 50, 7, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F);
      this.titanlaserModel[0].setRotationPoint(-0.5F, 0.0F, -3.5F);
      this.titanlaserModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 7, 50, 1, 0.0F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F, 0.0F, 0.0F, -0.49F);
      this.titanlaserModel[1].setRotationPoint(-3.5F, 0.0F, -0.5F);
   }

   @Override
   public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
   {
       poseStack.pushPose();
      for (int i = 0; i < 2; i++) {
         this.titanlaserModel[i].render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());
      }

       poseStack.popPose();
   }
}
