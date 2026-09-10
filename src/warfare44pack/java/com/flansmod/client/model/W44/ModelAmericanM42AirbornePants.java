//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelAmericanM42AirbornePants extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 128;

   public ModelAmericanM42AirbornePants() {
      this.leftLegModel = new ModelRendererTurbo[5];
      this.leftLegModel[0] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 57, 57, this.textureX, this.textureY);
      this.leftLegModel[2] = new ModelRendererTurbo(this, 97, 57, this.textureX, this.textureY);
      this.leftLegModel[3] = new ModelRendererTurbo(this, 1, 65, this.textureX, this.textureY);
      this.leftLegModel[4] = new ModelRendererTurbo(this, 17, 65, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 11, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F);
      this.leftLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftLegModel[1].addShapeBox(-2.0F, 1.9F, -2.15F, 4, 4, 1, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F);
      this.leftLegModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftLegModel[2].addShapeBox(1.1F, 1.5F, -1.5F, 1, 3, 3, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -0.25F, 0.1F, 0.1F, -0.25F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.leftLegModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftLegModel[3].addShapeBox(1.15F, 0.5F, -1.5F, 1, 1, 3, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F);
      this.leftLegModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftLegModel[4].addShapeBox(-2.0F, 2.0F, -2.0F, 4, 1, 4, 0.0F, 0.2F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F);
      this.leftLegModel[4].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel = new ModelRendererTurbo[5];
      this.rightLegModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 1, 57, this.textureX, this.textureY);
      this.rightLegModel[2] = new ModelRendererTurbo(this, 97, 49, this.textureX, this.textureY);
      this.rightLegModel[3] = new ModelRendererTurbo(this, 73, 57, this.textureX, this.textureY);
      this.rightLegModel[4] = new ModelRendererTurbo(this, 41, 65, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 11, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F);
      this.rightLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel[1].addShapeBox(-2.0F, 1.9F, -2.15F, 4, 4, 1, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F, 0.25F, 0.0F);
      this.rightLegModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel[2].addShapeBox(-2.15F, 0.5F, -1.5F, 1, 1, 3, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F);
      this.rightLegModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel[3].addShapeBox(-2.1F, 1.5F, -1.5F, 1, 3, 3, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -0.25F, 0.1F, 0.1F, -0.25F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
      this.rightLegModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel[4].addShapeBox(-2.0F, 2.0F, -2.0F, 4, 1, 4, 0.0F, 0.3F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F);
      this.rightLegModel[4].setRotationPoint(0.0F, 0.0F, 0.0F);
   }
}
