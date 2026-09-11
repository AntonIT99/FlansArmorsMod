//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelWaffenM44CamoPants extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 128;

   public ModelWaffenM44CamoPants() {
      leftLegModel = new ModelRendererTurbo[1];
      leftLegModel[0] = new ModelRendererTurbo(this, 89, 49, textureX, textureY);
      leftLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 8, 4, 0.0F, 0.12F, 0.0F, 0.12F, 0.12F, 0.0F, 0.12F, 0.12F, 0.0F, 0.12F, 0.12F, 0.0F, 0.12F, 0.12F, 2.0F, 0.12F, 0.12F, 2.0F, 0.12F, 0.12F, 2.0F, 0.12F, 0.12F, 2.0F, 0.12F);
      leftLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      rightLegModel = new ModelRendererTurbo[1];
      rightLegModel[0] = new ModelRendererTurbo(this, 65, 49, textureX, textureY);
      rightLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 8, 4, 0.0F, 0.121F, 0.0F, 0.121F, 0.121F, 0.0F, 0.121F, 0.121F, 0.0F, 0.121F, 0.121F, 0.0F, 0.121F, 0.121F, 2.0F, 0.121F, 0.121F, 2.0F, 0.121F, 0.121F, 2.0F, 0.121F, 0.121F, 2.0F, 0.121F);
      rightLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
   }
}
