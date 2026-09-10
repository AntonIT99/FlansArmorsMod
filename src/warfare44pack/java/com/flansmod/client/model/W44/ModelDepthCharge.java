//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;

public class ModelDepthCharge extends ModelBase {
   int textureX = 256;
   int textureY = 256;
   public ModelRendererTurbo[] depthchargeModel = new ModelRendererTurbo[45];

   public ModelDepthCharge() {
      this.depthchargeModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.depthchargeModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.depthchargeModel[2] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.depthchargeModel[3] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.depthchargeModel[4] = new ModelRendererTurbo(this, 161, 1, this.textureX, this.textureY);
      this.depthchargeModel[5] = new ModelRendererTurbo(this, 201, 1, this.textureX, this.textureY);
      this.depthchargeModel[6] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.depthchargeModel[7] = new ModelRendererTurbo(this, 41, 41, this.textureX, this.textureY);
      this.depthchargeModel[8] = new ModelRendererTurbo(this, 81, 41, this.textureX, this.textureY);
      this.depthchargeModel[9] = new ModelRendererTurbo(this, 121, 41, this.textureX, this.textureY);
      this.depthchargeModel[10] = new ModelRendererTurbo(this, 169, 41, this.textureX, this.textureY);
      this.depthchargeModel[11] = new ModelRendererTurbo(this, 209, 41, this.textureX, this.textureY);
      this.depthchargeModel[12] = new ModelRendererTurbo(this, 105, 65, this.textureX, this.textureY);
      this.depthchargeModel[13] = new ModelRendererTurbo(this, 145, 65, this.textureX, this.textureY);
      this.depthchargeModel[14] = new ModelRendererTurbo(this, 185, 65, this.textureX, this.textureY);
      this.depthchargeModel[15] = new ModelRendererTurbo(this, 209, 73, this.textureX, this.textureY);
      this.depthchargeModel[16] = new ModelRendererTurbo(this, 1, 81, this.textureX, this.textureY);
      this.depthchargeModel[17] = new ModelRendererTurbo(this, 41, 81, this.textureX, this.textureY);
      this.depthchargeModel[18] = new ModelRendererTurbo(this, 81, 81, this.textureX, this.textureY);
      this.depthchargeModel[19] = new ModelRendererTurbo(this, 105, 89, this.textureX, this.textureY);
      this.depthchargeModel[20] = new ModelRendererTurbo(this, 145, 89, this.textureX, this.textureY);
      this.depthchargeModel[21] = new ModelRendererTurbo(this, 185, 89, this.textureX, this.textureY);
      this.depthchargeModel[22] = new ModelRendererTurbo(this, 209, 97, this.textureX, this.textureY);
      this.depthchargeModel[23] = new ModelRendererTurbo(this, 1, 105, this.textureX, this.textureY);
      this.depthchargeModel[24] = new ModelRendererTurbo(this, 41, 105, this.textureX, this.textureY);
      this.depthchargeModel[25] = new ModelRendererTurbo(this, 81, 105, this.textureX, this.textureY);
      this.depthchargeModel[26] = new ModelRendererTurbo(this, 105, 113, this.textureX, this.textureY);
      this.depthchargeModel[27] = new ModelRendererTurbo(this, 153, 113, this.textureX, this.textureY);
      this.depthchargeModel[28] = new ModelRendererTurbo(this, 177, 121, this.textureX, this.textureY);
      this.depthchargeModel[29] = new ModelRendererTurbo(this, 217, 121, this.textureX, this.textureY);
      this.depthchargeModel[30] = new ModelRendererTurbo(this, 1, 129, this.textureX, this.textureY);
      this.depthchargeModel[31] = new ModelRendererTurbo(this, 41, 129, this.textureX, this.textureY);
      this.depthchargeModel[32] = new ModelRendererTurbo(this, 81, 129, this.textureX, this.textureY);
      this.depthchargeModel[33] = new ModelRendererTurbo(this, 105, 137, this.textureX, this.textureY);
      this.depthchargeModel[34] = new ModelRendererTurbo(this, 145, 137, this.textureX, this.textureY);
      this.depthchargeModel[35] = new ModelRendererTurbo(this, 169, 145, this.textureX, this.textureY);
      this.depthchargeModel[36] = new ModelRendererTurbo(this, 217, 145, this.textureX, this.textureY);
      this.depthchargeModel[37] = new ModelRendererTurbo(this, 1, 153, this.textureX, this.textureY);
      this.depthchargeModel[38] = new ModelRendererTurbo(this, 41, 153, this.textureX, this.textureY);
      this.depthchargeModel[39] = new ModelRendererTurbo(this, 81, 153, this.textureX, this.textureY);
      this.depthchargeModel[40] = new ModelRendererTurbo(this, 105, 161, this.textureX, this.textureY);
      this.depthchargeModel[41] = new ModelRendererTurbo(this, 145, 161, this.textureX, this.textureY);
      this.depthchargeModel[42] = new ModelRendererTurbo(this, 169, 169, this.textureX, this.textureY);
      this.depthchargeModel[43] = new ModelRendererTurbo(this, 209, 169, this.textureX, this.textureY);
      this.depthchargeModel[44] = new ModelRendererTurbo(this, 1, 177, this.textureX, this.textureY);
      this.depthchargeModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 3, 22, 16, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F);
      this.depthchargeModel[0].setRotationPoint(-1.5F, -22.0F, -8.0F);
      this.depthchargeModel[1].addShapeBox(3.0F, 0.0F, 0.0F, 2, 22, 16, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.depthchargeModel[1].setRotationPoint(-1.25F, -22.0F, -8.0F);
      this.depthchargeModel[2].addShapeBox(5.0F, 0.0F, 0.0F, 2, 22, 16, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F);
      this.depthchargeModel[2].setRotationPoint(-1.25F, -22.0F, -8.0F);
      this.depthchargeModel[3].addShapeBox(7.0F, 0.0F, 0.0F, 1, 22, 16, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F);
      this.depthchargeModel[3].setRotationPoint(-1.25F, -22.0F, -8.0F);
      this.depthchargeModel[4].addShapeBox(8.0F, 0.0F, 0.0F, 2, 22, 16, 0.0F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F);
      this.depthchargeModel[4].setRotationPoint(-1.25F, -22.0F, -8.0F);
      this.depthchargeModel[5].addShapeBox(-2.0F, 0.0F, 0.0F, 2, 22, 16, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F);
      this.depthchargeModel[5].setRotationPoint(-1.75F, -22.0F, -8.0F);
      this.depthchargeModel[6].addShapeBox(-4.0F, 0.0F, 0.0F, 2, 22, 16, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F);
      this.depthchargeModel[6].setRotationPoint(-1.75F, -22.0F, -8.0F);
      this.depthchargeModel[7].addShapeBox(-5.0F, 0.0F, 0.0F, 1, 22, 16, 0.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F);
      this.depthchargeModel[7].setRotationPoint(-1.75F, -22.0F, -8.0F);
      this.depthchargeModel[8].addShapeBox(-7.0F, 0.0F, 0.0F, 2, 22, 16, 0.0F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F);
      this.depthchargeModel[8].setRotationPoint(-1.75F, -22.0F, -8.0F);
      this.depthchargeModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 17, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F);
      this.depthchargeModel[9].setRotationPoint(-2.0F, -21.0F, -8.5F);
      this.depthchargeModel[10].addShapeBox(3.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.depthchargeModel[10].setRotationPoint(-0.75F, -21.0F, -8.5F);
      this.depthchargeModel[11].addShapeBox(5.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F);
      this.depthchargeModel[11].setRotationPoint(-0.75F, -21.0F, -8.5F);
      this.depthchargeModel[12].addShapeBox(7.0F, 0.0F, 0.0F, 1, 1, 17, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F);
      this.depthchargeModel[12].setRotationPoint(-0.75F, -21.0F, -8.5F);
      this.depthchargeModel[13].addShapeBox(8.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F);
      this.depthchargeModel[13].setRotationPoint(-0.75F, -21.0F, -8.5F);
      this.depthchargeModel[14].addShapeBox(-2.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F);
      this.depthchargeModel[14].setRotationPoint(-2.25F, -21.0F, -8.5F);
      this.depthchargeModel[15].addShapeBox(-4.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F);
      this.depthchargeModel[15].setRotationPoint(-2.25F, -21.0F, -8.5F);
      this.depthchargeModel[16].addShapeBox(-5.0F, 0.0F, 0.0F, 1, 1, 17, 0.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F);
      this.depthchargeModel[16].setRotationPoint(-2.25F, -21.0F, -8.5F);
      this.depthchargeModel[17].addShapeBox(-7.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F);
      this.depthchargeModel[17].setRotationPoint(-2.25F, -21.0F, -8.5F);
      this.depthchargeModel[18].addShapeBox(-7.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F);
      this.depthchargeModel[18].setRotationPoint(-2.25F, -2.0F, -8.5F);
      this.depthchargeModel[19].addShapeBox(-5.0F, 0.0F, 0.0F, 1, 1, 17, 0.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F);
      this.depthchargeModel[19].setRotationPoint(-2.25F, -2.0F, -8.5F);
      this.depthchargeModel[20].addShapeBox(-4.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F);
      this.depthchargeModel[20].setRotationPoint(-2.25F, -2.0F, -8.5F);
      this.depthchargeModel[21].addShapeBox(-2.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F);
      this.depthchargeModel[21].setRotationPoint(-2.25F, -2.0F, -8.5F);
      this.depthchargeModel[22].addShapeBox(8.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F);
      this.depthchargeModel[22].setRotationPoint(-0.75F, -2.0F, -8.5F);
      this.depthchargeModel[23].addShapeBox(7.0F, 0.0F, 0.0F, 1, 1, 17, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F);
      this.depthchargeModel[23].setRotationPoint(-0.75F, -2.0F, -8.5F);
      this.depthchargeModel[24].addShapeBox(5.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F);
      this.depthchargeModel[24].setRotationPoint(-0.75F, -2.0F, -8.5F);
      this.depthchargeModel[25].addShapeBox(3.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.depthchargeModel[25].setRotationPoint(-0.75F, -2.0F, -8.5F);
      this.depthchargeModel[26].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 17, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F);
      this.depthchargeModel[26].setRotationPoint(-2.0F, -2.0F, -8.5F);
      this.depthchargeModel[27].addShapeBox(-7.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F);
      this.depthchargeModel[27].setRotationPoint(-2.25F, -9.0F, -8.5F);
      this.depthchargeModel[28].addShapeBox(-5.0F, 0.0F, 0.0F, 1, 1, 17, 0.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F);
      this.depthchargeModel[28].setRotationPoint(-2.25F, -9.0F, -8.5F);
      this.depthchargeModel[29].addShapeBox(-4.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F);
      this.depthchargeModel[29].setRotationPoint(-2.25F, -9.0F, -8.5F);
      this.depthchargeModel[30].addShapeBox(-2.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F);
      this.depthchargeModel[30].setRotationPoint(-2.25F, -9.0F, -8.5F);
      this.depthchargeModel[31].addShapeBox(8.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F);
      this.depthchargeModel[31].setRotationPoint(-0.75F, -9.0F, -8.5F);
      this.depthchargeModel[32].addShapeBox(7.0F, 0.0F, 0.0F, 1, 1, 17, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F);
      this.depthchargeModel[32].setRotationPoint(-0.75F, -9.0F, -8.5F);
      this.depthchargeModel[33].addShapeBox(5.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F);
      this.depthchargeModel[33].setRotationPoint(-0.75F, -9.0F, -8.5F);
      this.depthchargeModel[34].addShapeBox(3.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.depthchargeModel[34].setRotationPoint(-0.75F, -9.0F, -8.5F);
      this.depthchargeModel[35].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 17, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F);
      this.depthchargeModel[35].setRotationPoint(-2.0F, -9.0F, -8.5F);
      this.depthchargeModel[36].addShapeBox(-7.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F);
      this.depthchargeModel[36].setRotationPoint(-2.25F, -15.0F, -8.5F);
      this.depthchargeModel[37].addShapeBox(-5.0F, 0.0F, 0.0F, 1, 1, 17, 0.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F);
      this.depthchargeModel[37].setRotationPoint(-2.25F, -15.0F, -8.5F);
      this.depthchargeModel[38].addShapeBox(-4.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F);
      this.depthchargeModel[38].setRotationPoint(-2.25F, -15.0F, -8.5F);
      this.depthchargeModel[39].addShapeBox(-2.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F);
      this.depthchargeModel[39].setRotationPoint(-2.25F, -15.0F, -8.5F);
      this.depthchargeModel[40].addShapeBox(8.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, -1.0F, 0.0F, -5.5F, -1.0F, 0.0F, -5.5F, 0.0F, 0.0F, -3.5F);
      this.depthchargeModel[40].setRotationPoint(-0.75F, -15.0F, -8.5F);
      this.depthchargeModel[41].addShapeBox(7.0F, 0.0F, 0.0F, 1, 1, 17, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -2.0F);
      this.depthchargeModel[41].setRotationPoint(-0.75F, -15.0F, -8.5F);
      this.depthchargeModel[42].addShapeBox(5.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F);
      this.depthchargeModel[42].setRotationPoint(-0.75F, -15.0F, -8.5F);
      this.depthchargeModel[43].addShapeBox(3.0F, 0.0F, 0.0F, 2, 1, 17, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.depthchargeModel[43].setRotationPoint(-0.75F, -15.0F, -8.5F);
      this.depthchargeModel[44].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 17, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F);
      this.depthchargeModel[44].setRotationPoint(-2.0F, -15.0F, -8.5F);
   }

   @Override
   public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
   {
       poseStack.pushPose();
      for (int i = 0; i < 45; i++) {
         this.depthchargeModel[i].render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());
      }

       poseStack.popPose();
   }
}
