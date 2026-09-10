//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelJapaneseHeadBand extends ModelCustomArmour {
   int textureX = 512;
   int textureY = 128;

   public ModelJapaneseHeadBand() {
      this.headModel = new ModelRendererTurbo[4];
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.0F, -6.75F, -4.0F, 8, 2, 8, 0.0F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, -0.8F, 0.1F, 0.1F, -0.8F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 1.2F, 0.1F, 0.1F, 1.2F, 0.1F);
      this.headModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-0.5F, -4.75F, 4.0F, 1, 1, 1, 0.0F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, -0.8F, 0.1F, 0.1F, -0.8F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 1.2F, 0.1F, 0.1F, 1.2F, 0.1F);
      this.headModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-0.75F, -4.5F, 3.5F, 1, 1, 1, 0.0F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 1.2F, 0.1F, 0.1F, 1.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, -0.8F, 0.1F, 0.1F, -0.8F, 0.1F);
      this.headModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-75.0F, -43.25F, -4.5F, 150, 75, 1, 0.0F, -71.5F, -35.85F, -0.3F, -71.5F, -35.85F, -0.3F, -71.5F, -35.85F, -0.3F, -71.5F, -35.85F, -0.3F, -71.5F, -35.85F, -0.3F, -71.5F, -35.85F, -0.3F, -71.5F, -35.85F, -0.3F, -71.5F, -35.85F, -0.3F);
      this.headModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
   }
}
