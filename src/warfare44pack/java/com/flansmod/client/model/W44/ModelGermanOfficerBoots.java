//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelGermanOfficerBoots extends ModelCustomArmour {
   int textureX = 512;
   int textureY = 128;

   public ModelGermanOfficerBoots() {
      this.leftLegModel = new ModelRendererTurbo[1];
      this.leftLegModel[0] = new ModelRendererTurbo(this, 489, 1, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, 6.1F, -2.3F, 4, 6, 5, 0.0F, 0.41F, 0.0F, 0.0F, 0.41F, 0.0F, 0.0F, 0.41F, 0.0F, -0.4F, 0.41F, 0.0F, -0.4F, 0.41F, 0.0F, 0.0F, 0.41F, 0.0F, 0.0F, 0.41F, 0.0F, -0.4F, 0.41F, 0.0F, -0.4F);
      this.leftLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel = new ModelRendererTurbo[1];
      this.rightLegModel[0] = new ModelRendererTurbo(this, 385, 25, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, 6.1F, -2.3F, 4, 6, 5, 0.0F, 0.412F, 0.0F, 0.01F, 0.412F, 0.0F, 0.01F, 0.412F, 0.0F, -0.4F, 0.412F, 0.0F, -0.4F, 0.412F, 0.0F, 0.01F, 0.412F, 0.0F, 0.01F, 0.412F, 0.0F, -0.4F, 0.412F, 0.0F, -0.4F);
      this.rightLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
   }
}
