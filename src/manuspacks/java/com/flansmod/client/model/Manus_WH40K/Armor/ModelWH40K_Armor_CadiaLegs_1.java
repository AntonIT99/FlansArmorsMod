//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WH40K.Armor;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelWH40K_Armor_CadiaLegs_1 extends ModelCustomArmour {
   int textureX = 512;
   int textureY = 512;

   public ModelWH40K_Armor_CadiaLegs_1() {
      this.bodyModel = new ModelRendererTurbo[1];
      this.bodyModel[0] = new ModelRendererTurbo(this, 150, 224, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-16.0F, 36.0F, -8.0F, 32, 12, 16, 0.0F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F);
      this.rightLegModel = new ModelRendererTurbo[3];
      this.rightLegModel[0] = new ModelRendererTurbo(this, 0, 225, this.textureX, this.textureY);
      this.rightLegModel[1] = new ModelRendererTurbo(this, 0, 283, this.textureX, this.textureY);
      this.rightLegModel[2] = new ModelRendererTurbo(this, 0, 300, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-8.0F, 0.0F, -8.0F, 16, 39, 16, 0.0F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F);
      this.rightLegModel[1].addBox(-10.5F, 6.0F, -5.5F, 3, 4, 11, 0.0F);
      this.rightLegModel[2].addBox(-10.25F, 10.0F, -5.0F, 3, 10, 10, 0.0F);
      this.leftLegModel = new ModelRendererTurbo[3];
      this.leftLegModel[0] = new ModelRendererTurbo(this, 75, 225, this.textureX, this.textureY);
      this.leftLegModel[1] = new ModelRendererTurbo(this, 75, 283, this.textureX, this.textureY);
      this.leftLegModel[2] = new ModelRendererTurbo(this, 75, 300, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-8.0F, 0.0F, -8.0F, 16, 39, 16, 0.0F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F);
      this.leftLegModel[1].addBox(7.5F, 6.0F, -5.5F, 3, 4, 11, 0.0F);
      this.leftLegModel[2].addBox(7.25F, 10.0F, -5.0F, 3, 10, 10, 0.0F);
   }
}
