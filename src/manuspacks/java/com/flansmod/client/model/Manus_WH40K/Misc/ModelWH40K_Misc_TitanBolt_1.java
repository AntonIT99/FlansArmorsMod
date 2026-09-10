//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WH40K.Misc;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;

public class ModelWH40K_Misc_TitanBolt_1 extends ModelBase {
   int textureX = 32;
   int textureY = 32;
   public ModelRendererTurbo[] titanboltModel = new ModelRendererTurbo[2];

   public ModelWH40K_Misc_TitanBolt_1() {
      this.titanboltModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.titanboltModel[1] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.titanboltModel[0].addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
      this.titanboltModel[0].setRotationPoint(-1.0F, 0.0F, -1.0F);
      this.titanboltModel[1].addTrapezoid(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F, -0.75F, 5);
      this.titanboltModel[1].setRotationPoint(-1.0F, 4.0F, -1.0F);
   }

   @Override
   public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
   {
       poseStack.pushPose();
      for (int i = 0; i < 2; i++) {
         this.titanboltModel[i].render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());
      }

       poseStack.popPose();
   }
}
