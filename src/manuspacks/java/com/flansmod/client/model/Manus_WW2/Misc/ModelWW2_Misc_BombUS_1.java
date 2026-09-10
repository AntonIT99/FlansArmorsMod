//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WW2.Misc;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;

public class ModelWW2_Misc_BombUS_1 extends ModelBase {
   int textureX = 128;
   int textureY = 32;
   public ModelRendererTurbo[] bombusModel = new ModelRendererTurbo[16];

   public ModelWW2_Misc_BombUS_1() {
      this.bombusModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bombusModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.bombusModel[2] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.bombusModel[3] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.bombusModel[4] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.bombusModel[5] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.bombusModel[6] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.bombusModel[7] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
      this.bombusModel[8] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.bombusModel[9] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.bombusModel[10] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.bombusModel[11] = new ModelRendererTurbo(this, 49, 9, this.textureX, this.textureY);
      this.bombusModel[12] = new ModelRendererTurbo(this, 65, 9, this.textureX, this.textureY);
      this.bombusModel[13] = new ModelRendererTurbo(this, 81, 9, this.textureX, this.textureY);
      this.bombusModel[14] = new ModelRendererTurbo(this, 97, 9, this.textureX, this.textureY);
      this.bombusModel[15] = new ModelRendererTurbo(this, 105, 9, this.textureX, this.textureY);
      this.bombusModel[0].addTrapezoid(-2.5F, -20.0F, -2.5F, 5, 10, 5, 0.0F, -2.0F, 4);
      this.bombusModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[1].addTrapezoid(-2.5F, 5.0F, -2.5F, 5, 5, 5, 0.0F, -1.5F, 5);
      this.bombusModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[2].addShapeBox(0.0F, -19.0F, -0.5F, 3, 3, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -2.0F, -0.4F, 0.0F, -2.0F, -0.4F, 0.0F, 0.0F, -0.4F);
      this.bombusModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[3].addShapeBox(1.0F, -22.0F, -0.5F, 2, 3, 1, 0.0F, -0.5F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F);
      this.bombusModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[4].addShapeBox(-3.0F, -19.0F, -0.5F, 3, 3, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -2.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -2.0F, -0.4F);
      this.bombusModel[4].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[5].addShapeBox(-3.0F, -22.0F, -0.5F, 2, 3, 1, 0.0F, 0.0F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F);
      this.bombusModel[5].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[6].addShapeBox(-0.5F, -19.0F, 0.0F, 1, 3, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F);
      this.bombusModel[6].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[7].addShapeBox(-0.5F, -22.0F, 1.0F, 1, 3, 2, 0.0F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
      this.bombusModel[7].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[8].addShapeBox(-0.5F, -19.0F, -3.0F, 1, 3, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
      this.bombusModel[8].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[9].addShapeBox(-0.5F, -22.0F, -3.0F, 1, 3, 2, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F);
      this.bombusModel[9].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[10].addBox(-0.5F, 9.5F, -0.5F, 1, 1, 1, 0.0F);
      this.bombusModel[10].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[11].addShapeBox(-2.0F, -22.0F, 0.0F, 2, 2, 2, 0.0F, -0.5F, 0.0F, -0.1F, -0.1F, 0.0F, -1.5F, -0.1F, 0.0F, -0.3F, -0.3F, 0.0F, -1.9F, -0.5F, 0.0F, -0.1F, -0.1F, 0.0F, -1.5F, -0.1F, 0.0F, -0.3F, -0.3F, 0.0F, -1.9F);
      this.bombusModel[11].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[12].addShapeBox(-2.0F, -22.0F, -2.0F, 2, 2, 2, 0.0F, -0.3F, 0.0F, -1.9F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -1.5F, -0.5F, 0.0F, -0.1F, -0.3F, 0.0F, -1.9F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -1.5F, -0.5F, 0.0F, -0.1F);
      this.bombusModel[12].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[13].addShapeBox(0.0F, -22.0F, -2.0F, 2, 2, 2, 0.0F, -0.1F, 0.0F, -0.3F, -0.3F, 0.0F, -1.9F, -0.5F, 0.0F, -0.1F, -0.1F, 0.0F, -1.5F, -0.1F, 0.0F, -0.3F, -0.3F, 0.0F, -1.9F, -0.5F, 0.0F, -0.1F, -0.1F, 0.0F, -1.5F);
      this.bombusModel[13].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[14].addShapeBox(0.0F, -22.0F, 0.0F, 2, 2, 2, 0.0F, -0.1F, 0.0F, -1.5F, -0.5F, 0.0F, -0.1F, -0.3F, 0.0F, -1.9F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -1.5F, -0.5F, 0.0F, -0.1F, -0.3F, 0.0F, -1.9F, -0.1F, 0.0F, -0.3F);
      this.bombusModel[14].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bombusModel[15].addBox(-2.5F, -10.0F, -2.5F, 5, 15, 5, 0.0F);
      this.bombusModel[15].setRotationPoint(0.0F, 0.0F, 0.0F);
   }

   @Override
   public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
   {
       poseStack.pushPose();
      for (int i = 0; i < 16; i++) {
         this.bombusModel[i].render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());
      }

       poseStack.popPose();
   }
}
