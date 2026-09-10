//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.manus_sifi;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelLightSaber_A extends ModelGun {
   int textureX = 512;
   int textureY = 512;

   public ModelLightSaber_A() {
      this.gunModel = new ModelRendererTurbo[20];
      this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 0, 325, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 38, 325, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 77, 325, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 0, 345, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 35, 345, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 70, 345, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 35, 345, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 70, 345, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 35, 345, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 70, 345, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 35, 345, this.textureX, this.textureY);
      this.gunModel[12] = new ModelRendererTurbo(this, 70, 345, this.textureX, this.textureY);
      this.gunModel[13] = new ModelRendererTurbo(this, 0, 365, this.textureX, this.textureY);
      this.gunModel[14] = new ModelRendererTurbo(this, 35, 365, this.textureX, this.textureY);
      this.gunModel[15] = new ModelRendererTurbo(this, 0, 395, this.textureX, this.textureY);
      this.gunModel[16] = new ModelRendererTurbo(this, 15, 395, this.textureX, this.textureY);
      this.gunModel[17] = new ModelRendererTurbo(this, 25, 395, this.textureX, this.textureY);
      this.gunModel[18] = new ModelRendererTurbo(this, 38, 395, this.textureX, this.textureY);
      this.gunModel[19] = new ModelRendererTurbo(this, 0, 409, this.textureX, this.textureY);
      this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 35, 208, 35, 0.0F, 0.0F, 0.0F, 0.0F, -30.0F, 0.0F, 0.0F, -30.0F, 0.0F, -30.0F, 0.0F, 0.0F, -30.0F, 0.0F, 0.0F, 0.0F, -30.0F, 0.0F, 0.0F, -30.0F, 0.0F, -30.0F, 0.0F, 0.0F, -30.0F);
      this.gunModel[0].setRotationPoint(-2.5F, -215.0F, -2.5F);
      this.gunModel[1].addBox(0.0F, 0.0F, 0.0F, 9, 4, 9, 0.0F);
      this.gunModel[1].setRotationPoint(-4.5F, -7.0F, -4.5F);
      this.gunModel[2].addBox(0.0F, 0.0F, 0.0F, 9, 2, 9, 0.0F);
      this.gunModel[2].setRotationPoint(-4.5F, -3.0F, -4.5F);
      this.gunModel[3].addBox(0.0F, 0.0F, 0.0F, 7, 12, 7, 0.0F);
      this.gunModel[3].setRotationPoint(-3.5F, -1.0F, -3.5F);
      this.gunModel[4].addBox(0.0F, 0.0F, 0.0F, 8, 9, 8, 0.0F);
      this.gunModel[4].setRotationPoint(-4.0F, 11.0F, -4.0F);
      this.gunModel[5].addTrapezoid(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F, -0.8F, 4);
      this.gunModel[5].setRotationPoint(-4.0F, 20.0F, -4.0F);
      this.gunModel[6].addTrapezoid(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F, -0.8F, 5);
      this.gunModel[6].setRotationPoint(-4.0F, 21.0F, -4.0F);
      this.gunModel[7].addTrapezoid(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F, -0.8F, 4);
      this.gunModel[7].setRotationPoint(-4.0F, 22.0F, -4.0F);
      this.gunModel[8].addTrapezoid(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F, -0.8F, 5);
      this.gunModel[8].setRotationPoint(-4.0F, 23.0F, -4.0F);
      this.gunModel[9].addTrapezoid(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F, -0.8F, 4);
      this.gunModel[9].setRotationPoint(-4.0F, 24.0F, -4.0F);
      this.gunModel[10].addTrapezoid(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F, -0.8F, 5);
      this.gunModel[10].setRotationPoint(-4.0F, 25.0F, -4.0F);
      this.gunModel[11].addTrapezoid(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F, -0.8F, 4);
      this.gunModel[11].setRotationPoint(-4.0F, 26.0F, -4.0F);
      this.gunModel[12].addTrapezoid(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F, -0.8F, 5);
      this.gunModel[12].setRotationPoint(-4.0F, 27.0F, -4.0F);
      this.gunModel[13].addBox(0.0F, 0.0F, 0.0F, 8, 18, 8, 0.0F);
      this.gunModel[13].setRotationPoint(-4.0F, 28.0F, -4.0F);
      this.gunModel[14].addTrapezoid(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F, -1.0F, 5);
      this.gunModel[14].setRotationPoint(-4.0F, 46.0F, -4.0F);
      this.gunModel[15].addBox(0.0F, 0.0F, 0.0F, 4, 8, 2, 0.0F);
      this.gunModel[15].setRotationPoint(-2.0F, 37.0F, -6.0F);
      this.gunModel[16].addBox(0.0F, 0.0F, 0.0F, 1, 8, 3, 0.0F);
      this.gunModel[16].setRotationPoint(3.5F, 1.0F, -1.5F);
      this.gunModel[17].addBox(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
      this.gunModel[17].setRotationPoint(-1.5F, 1.0F, -5.5F);
      this.gunModel[18].addBox(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
      this.gunModel[18].setRotationPoint(-1.5F, 5.0F, -5.5F);
      this.gunModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 9, 7, 9, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[19].setRotationPoint(-4.5F, -14.0F, -4.5F);
      this.translateAll(12.0F, -20.0F, 0.0F);
      this.gunSlideDistance = 0.0F;
      this.animationType = EnumAnimationType.NONE;
      this.flipAll();
   }
}
