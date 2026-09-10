//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelGermanM42Stahlhelm extends ModelCustomArmour {
   int textureX = 128;
   int textureY = 128;

   public ModelGermanM42Stahlhelm() {
      this.headModel = new ModelRendererTurbo[7];
      this.headModel[0] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.headModel[1] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.headModel[2] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.headModel[3] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.headModel[4] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.headModel[5] = new ModelRendererTurbo(this, 25, 33, this.textureX, this.textureY);
      this.headModel[6] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.headModel[0].addShapeBox(-4.5F, -4.0F, -4.5F, 9, 4, 4, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -2.5F, -0.4F, 0.0F, -2.5F);
      this.headModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.headModel[1].addShapeBox(-4.5F, 0.0F, -4.0F, 9, 1, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.6F, -0.8F, 0.0F, -0.6F, -0.8F, 0.0F, -0.6F, -0.8F, 0.0F, -0.6F, -0.8F, 0.0F);
      this.headModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.headModel[2].addShapeBox(-4.5F, -8.0F, -4.5F, 9, 2, 9, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.1F, -0.5F, -0.1F, -0.1F, -0.5F, -0.1F, -0.1F, -0.5F, -0.1F, -0.1F, -0.5F, -0.1F);
      this.headModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.headModel[3].addShapeBox(-4.5F, -9.0F, -4.5F, 9, 1, 9, 0.0F, -1.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
      this.headModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.headModel[4].addShapeBox(-4.5F, -5.0F, -4.5F, 9, 1, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, -0.25F, 0.8F, 0.25F, -0.25F, 0.8F, 0.2F, -0.25F, 0.0F, 0.2F, -0.25F, 0.0F);
      this.headModel[4].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.headModel[5].addShapeBox(-4.5F, -7.0F, -4.5F, 9, 2, 9, 0.0F, -0.1F, -0.5F, -0.1F, -0.1F, -0.5F, -0.1F, -0.1F, -0.5F, -0.1F, -0.1F, -0.5F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.headModel[5].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.headModel[6].addShapeBox(-5.5F, -5.0F, -3.5F, 11, 3, 9, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -0.25F, -0.5F, -2.0F, -0.25F, -0.5F, -2.0F, -0.5F, -0.8F, -0.25F, -0.5F, -0.8F, -0.25F);
      this.headModel[6].setRotationPoint(0.0F, 0.0F, 0.0F);
   }
}
