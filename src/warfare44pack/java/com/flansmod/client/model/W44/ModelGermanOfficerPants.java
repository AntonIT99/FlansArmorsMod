//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelGermanOfficerPants extends ModelCustomArmour {
   int textureX = 512;
   int textureY = 128;

   public ModelGermanOfficerPants() {
      this.leftLegModel = new ModelRendererTurbo[3];
      this.leftLegModel[0] = new ModelRendererTurbo(this, 1, 73, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 161, 73, this.textureX, this.textureY);
      this.leftLegModel[2] = new ModelRendererTurbo(this, 457, 33, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftLegModel[1].addShapeBox(-1.7F, -3.5F, -2.4F, 4, 5, 5, 0.0F, 0.3F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.1F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F);
      this.leftLegModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftLegModel[2].addShapeBox(-2.0F, 4.9F, -2.0F, 4, 2, 4, 0.0F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.305F, 0.0F, 0.25F, 0.305F, 0.0F, 0.25F, 0.305F, 0.0F, 0.25F, 0.305F, 0.0F, 0.25F);
      this.leftLegModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel = new ModelRendererTurbo[3];
      this.rightLegModel[0] = new ModelRendererTurbo(this, 409, 25, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 137, 73, this.textureX, this.textureY);
      this.rightLegModel[2] = new ModelRendererTurbo(this, 433, 33, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 8, 4, 0.0F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F);
      this.rightLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel[1].addShapeBox(-2.3F, -3.5F, -2.4F, 4, 5, 5, 0.0F, -0.2F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, 0.2F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F);
      this.rightLegModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel[2].addShapeBox(-2.0F, 4.9F, -2.0F, 4, 2, 4, 0.0F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.105F, 0.0F, 0.1F, 0.305F, 0.0F, 0.25F, 0.305F, 0.0F, 0.25F, 0.305F, 0.0F, 0.25F, 0.305F, 0.0F, 0.25F);
      this.rightLegModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
   }
}
