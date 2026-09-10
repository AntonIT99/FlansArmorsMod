//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsmod.api.client.model.ModelBase;
import org.jetbrains.annotations.NotNull;


public class ModelDynamite extends ModelBase {
   int textureX = 256;
   int textureY = 128;
   public ModelRendererTurbo[] dynamiteModel = new ModelRendererTurbo[27];

   public ModelDynamite() {
      this.dynamiteModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.dynamiteModel[1] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.dynamiteModel[2] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.dynamiteModel[3] = new ModelRendererTurbo(this, 145, 1, this.textureX, this.textureY);
      this.dynamiteModel[4] = new ModelRendererTurbo(this, 193, 1, this.textureX, this.textureY);
      this.dynamiteModel[5] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.dynamiteModel[6] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.dynamiteModel[7] = new ModelRendererTurbo(this, 97, 25, this.textureX, this.textureY);
      this.dynamiteModel[8] = new ModelRendererTurbo(this, 145, 25, this.textureX, this.textureY);
      this.dynamiteModel[9] = new ModelRendererTurbo(this, 193, 25, this.textureX, this.textureY);
      this.dynamiteModel[10] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.dynamiteModel[11] = new ModelRendererTurbo(this, 49, 49, this.textureX, this.textureY);
      this.dynamiteModel[12] = new ModelRendererTurbo(this, 97, 49, this.textureX, this.textureY);
      this.dynamiteModel[13] = new ModelRendererTurbo(this, 145, 49, this.textureX, this.textureY);
      this.dynamiteModel[14] = new ModelRendererTurbo(this, 193, 49, this.textureX, this.textureY);
      this.dynamiteModel[15] = new ModelRendererTurbo(this, 1, 73, this.textureX, this.textureY);
      this.dynamiteModel[16] = new ModelRendererTurbo(this, 49, 73, this.textureX, this.textureY);
      this.dynamiteModel[17] = new ModelRendererTurbo(this, 97, 73, this.textureX, this.textureY);
      this.dynamiteModel[18] = new ModelRendererTurbo(this, 145, 73, this.textureX, this.textureY);
      this.dynamiteModel[19] = new ModelRendererTurbo(this, 193, 73, this.textureX, this.textureY);
      this.dynamiteModel[20] = new ModelRendererTurbo(this, 1, 97, this.textureX, this.textureY);
      this.dynamiteModel[21] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.dynamiteModel[22] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.dynamiteModel[23] = new ModelRendererTurbo(this, 129, 1, this.textureX, this.textureY);
      this.dynamiteModel[24] = new ModelRendererTurbo(this, 177, 1, this.textureX, this.textureY);
      this.dynamiteModel[25] = new ModelRendererTurbo(this, 225, 1, this.textureX, this.textureY);
      this.dynamiteModel[26] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.dynamiteModel[0].addShapeBox(0.0F, -3.0F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[0].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[0].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[0].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[1].addShapeBox(0.0F, -4.0F, -10.0F, 3, 1, 20, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[1].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[1].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[1].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[2].addShapeBox(0.0F, -2.0F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
      this.dynamiteModel[2].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[2].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[2].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[3].addShapeBox(3.0F, -2.0F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
      this.dynamiteModel[3].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[3].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[3].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[4].addShapeBox(3.0F, -3.0F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[4].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[4].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[4].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[5].addShapeBox(3.0F, -4.0F, -10.0F, 3, 1, 20, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[5].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[5].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[5].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[6].addShapeBox(6.0F, -2.0F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
      this.dynamiteModel[6].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[6].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[6].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[7].addShapeBox(6.0F, -3.0F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[7].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[7].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[7].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[8].addShapeBox(6.0F, -4.0F, -10.0F, 3, 1, 20, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[8].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[8].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[8].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[9].addShapeBox(4.5F, -4.5F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
      this.dynamiteModel[9].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[9].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[9].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[10].addShapeBox(4.5F, -5.5F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[10].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[10].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[10].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[11].addShapeBox(4.5F, -6.5F, -10.0F, 3, 1, 20, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[11].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[11].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[11].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[12].addShapeBox(1.5F, -4.5F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
      this.dynamiteModel[12].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[12].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[12].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[13].addShapeBox(1.5F, -5.5F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[13].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[13].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[13].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[14].addShapeBox(1.5F, -6.5F, -10.0F, 3, 1, 20, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[14].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[14].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[14].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[15].addShapeBox(1.5F, 0.5F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
      this.dynamiteModel[15].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[15].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[15].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[16].addShapeBox(1.5F, -0.5F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[16].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[16].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[16].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[17].addShapeBox(1.5F, -1.5F, -10.0F, 3, 1, 20, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[17].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[17].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[17].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[18].addShapeBox(4.5F, 0.5F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
      this.dynamiteModel[18].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[18].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[18].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[19].addShapeBox(4.5F, -0.5F, -10.0F, 3, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[19].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[19].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[19].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[20].addShapeBox(4.5F, -1.5F, -10.0F, 3, 1, 20, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[20].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[20].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[20].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[21].addShapeBox(-0.5F, -7.0F, -7.0F, 10, 3, 2, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[21].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[21].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[21].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[22].addShapeBox(-0.5F, -4.0F, -7.0F, 10, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[22].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[22].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[22].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[23].addShapeBox(-0.5F, -1.0F, -7.0F, 10, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
      this.dynamiteModel[23].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[23].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[23].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[24].addShapeBox(-0.5F, -7.0F, 5.0F, 10, 3, 2, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[24].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[24].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[24].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[25].addShapeBox(-0.5F, -4.0F, 5.0F, 10, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.dynamiteModel[25].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[25].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[25].rotateAngleZ = (float) (-Math.PI / 12);
      this.dynamiteModel[26].addShapeBox(-0.5F, -1.0F, 5.0F, 10, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
      this.dynamiteModel[26].setRotationPoint(1.0F, -4.0F, 0.0F);
      this.dynamiteModel[26].rotateAngleX = (float) (-Math.PI * 5.0 / 12.0);
      this.dynamiteModel[26].rotateAngleZ = (float) (-Math.PI / 12);
   }

   @Override
   public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
   {
       poseStack.pushPose();
      poseStack.scale(0.35F, 0.35F, 0.35F);

      for (int i = 0; i < 27; i++) {
         this.dynamiteModel[i].render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha, getScale());
      }

       poseStack.popPose();
   }
}
