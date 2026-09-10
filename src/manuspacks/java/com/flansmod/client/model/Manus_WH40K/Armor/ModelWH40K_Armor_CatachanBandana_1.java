//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WH40K.Armor;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelWH40K_Armor_CatachanBandana_1 extends ModelCustomArmour {
   int textureX = 512;
   int textureY = 512;

   public ModelWH40K_Armor_CatachanBandana_1() {
      this.headModel = new ModelRendererTurbo[9];
      this.headModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 441, 1, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 121, 89, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 161, 105, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 353, 105, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 457, 105, this.textureX, this.textureY);
      this.headModel[7] = new ModelRendererTurbo(this, 497, 41, this.textureX, this.textureY);
      this.headModel[8] = new ModelRendererTurbo(this, 113, 49, this.textureX, this.textureY);
      this.headModel[0].addBox(-17.0F, -24.0F, -17.0F, 1, 6, 17, 0.0F);
      this.headModel[1].addShapeBox(-16.0F, -23.0F, 16.0F, 32, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[2].addBox(-2.5F, -23.5F, 16.0F, 5, 5, 2, 0.0F);
      this.headModel[3].addBox(16.0F, -24.0F, -17.0F, 1, 6, 17, 0.0F);
      this.headModel[4].addBox(-16.0F, -24.0F, -17.0F, 32, 6, 1, 0.0F);
      this.headModel[5].addShapeBox(-17.0F, -24.0F, 0.0F, 1, 6, 17, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F);
      this.headModel[6].addShapeBox(16.0F, -24.0F, 0.0F, 1, 6, 17, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F);
      this.headModel[7].addShapeBox(-2.0F, -18.5F, 16.0F, 4, 10, 1, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -1.5F, -1.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, -0.5F, -1.5F, -1.0F, -0.5F);
      this.headModel[8].addShapeBox(-2.0F, -18.5F, 16.0F, 4, 8, 1, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 2.0F, 0.0F, -0.5F, -1.5F, -1.0F, -0.5F, -1.5F, -1.0F, 0.0F, 2.0F, 0.0F, 0.0F);
   }
}
