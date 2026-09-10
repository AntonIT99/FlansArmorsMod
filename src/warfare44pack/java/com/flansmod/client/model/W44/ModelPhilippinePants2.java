//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelPhilippinePants2 extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 128;

   public ModelPhilippinePants2() {
      this.leftLegModel = new ModelRendererTurbo[1];
      this.leftLegModel[0] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 5, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 3.5F, 0.1F, 0.1F, 3.5F, 0.1F, 0.1F, 3.5F, 0.1F, 0.1F, 3.5F, 0.1F);
      this.leftLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.rightLegModel = new ModelRendererTurbo[1];
      this.rightLegModel[0] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 5, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 3.5F, 0.1F, 0.1F, 3.5F, 0.1F, 0.1F, 3.5F, 0.1F, 0.1F, 3.5F, 0.1F);
      this.rightLegModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
   }
}
