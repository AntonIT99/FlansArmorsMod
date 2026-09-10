//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WW2.Misc;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;

public class ModelWW2_Misc_BulletSmall_1 extends ModelBase {
   int textureX = 64;
   int textureY = 64;
   public ModelRendererTurbo[] bulletsmallModel = new ModelRendererTurbo[1];

   public ModelWW2_Misc_BulletSmall_1() {
      this.bulletsmallModel[0] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.bulletsmallModel[0].addTrapezoid(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F, -0.5F, 3);
      this.bulletsmallModel[0].setRotationPoint(-4.0F, -0.5F, -0.5F);
   }

   @Override
   public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
   {
       poseStack.pushPose();
      for (int i = 0; i < 2; i++) {
         this.bulletsmallModel[i].render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());
      }

       poseStack.popPose();
   }
}
