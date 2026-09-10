//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelAmericanM1941CombatFieldUniformPants extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 128;

   public ModelAmericanM1941CombatFieldUniformPants() {
      this.leftLegModel = new ModelRendererTurbo[2];
      this.leftLegModel[0] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 97, 33, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 6, 4, 0.0F, 0.11F, 0.0F, 0.11F, 0.11F, 0.0F, 0.11F, 0.11F, 0.0F, 0.11F, 0.11F, 0.0F, 0.11F, 0.11F, -0.5F, 0.11F, 0.11F, -0.5F, 0.11F, 0.11F, -0.5F, 0.11F, 0.11F, -0.5F, 0.11F);
      this.leftLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 4, 4, 4, 0.0F, 0.051F, 0.0F, 0.051F, 0.051F, 0.0F, 0.051F, 0.051F, 0.0F, 0.051F, 0.051F, 0.0F, 0.051F, 0.051F, 0.0F, 0.051F, 0.051F, 0.0F, 0.051F, 0.051F, 0.0F, 0.051F, 0.051F, 0.0F, 0.051F);
      this.leftLegModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel = new ModelRendererTurbo[2];
      this.rightLegModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 57, 33, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F);
      this.rightLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 4, 4, 4, 0.0F, 0.05F, 0.0F, 0.05F, 0.05F, 0.0F, 0.05F, 0.05F, 0.0F, 0.05F, 0.05F, 0.0F, 0.05F, 0.05F, 0.0F, 0.05F, 0.05F, 0.0F, 0.05F, 0.05F, 0.0F, 0.05F, 0.05F, 0.0F, 0.05F);
      this.rightLegModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
   }
}
