//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.manus_sifi;

import com.flansmod.client.model.ModelAAGun;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelImperialThrone extends ModelAAGun {
   int textureX = 128;
   int textureY = 128;

   public ModelImperialThrone() {
      this.baseModel = new ModelRendererTurbo[4];
      this.baseModel[0] = new ModelRendererTurbo(this, 0, 99, this.textureX, this.textureY);
      this.baseModel[1] = new ModelRendererTurbo(this, 0, 82, this.textureX, this.textureY);
      this.baseModel[2] = new ModelRendererTurbo(this, 58, 90, this.textureX, this.textureY);
      this.baseModel[3] = new ModelRendererTurbo(this, 0, 99, this.textureX, this.textureY);
      this.baseModel[0].addBox(0.0F, 0.0F, 0.0F, 26, 1, 26, 0.0F);
      this.baseModel[0].setRotationPoint(-13.0F, -1.0F, -13.0F);
      this.baseModel[1].addTrapezoid(0.0F, 0.0F, 0.0F, 14, 2, 14, 0.0F, -3.0F, 4);
      this.baseModel[1].setRotationPoint(-7.0F, -3.0F, -7.0F);
      this.baseModel[2].addTrapezoid(0.0F, 0.0F, 0.0F, 7, 1, 7, 0.0F, -1.5F, 4);
      this.baseModel[2].setRotationPoint(-3.5F, -4.0F, -3.5F);
      this.baseModel[3].addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
      this.baseModel[3].setRotationPoint(-2.0F, -8.0F, -2.0F);
      this.seatModel = new ModelRendererTurbo[7];
      this.seatModel[0] = new ModelRendererTurbo(this, 0, 54, this.textureX, this.textureY);
      this.seatModel[1] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.seatModel[2] = new ModelRendererTurbo(this, 79, 0, this.textureX, this.textureY);
      this.seatModel[3] = new ModelRendererTurbo(this, 79, 18, this.textureX, this.textureY);
      this.seatModel[4] = new ModelRendererTurbo(this, 91, 59, this.textureX, this.textureY);
      this.seatModel[5] = new ModelRendererTurbo(this, 41, 0, this.textureX, this.textureY);
      this.seatModel[6] = new ModelRendererTurbo(this, 79, 36, this.textureX, this.textureY);
      this.seatModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 21, 3, 24, 0.0F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.seatModel[0].setRotationPoint(-8.0F, -11.0F, -12.0F);
      this.seatModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 6, 29, 24, 0.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.seatModel[1].setRotationPoint(-8.0F, -40.0F, -12.0F);
      this.seatModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 12, 8, 9, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -1.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.seatModel[2].setRotationPoint(1.0F, -19.0F, -15.0F);
      this.seatModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 12, 8, 9, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, -1.0F, -5.0F, 0.0F, -3.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F);
      this.seatModel[3].setRotationPoint(1.0F, -19.0F, 6.0F);
      this.seatModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 9, 8, 9, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.seatModel[4].setRotationPoint(-8.0F, -19.0F, -15.0F);
      this.seatModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 9, 8, 9, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F);
      this.seatModel[5].setRotationPoint(-8.0F, -19.0F, 6.0F);
      this.seatModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 7, 4, 17, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4827586F, 0.0F, 0.0F, 0.4827586F, 0.0F, 0.0F, 0.4827586F, 0.0F, 0.0F, 0.4827586F);
      this.seatModel[6].setRotationPoint(-2.0F, -40.0F, -8.5F);
      this.gunModel = new ModelRendererTurbo[0];
      this.barrelModel = new ModelRendererTurbo[0][0];
      this.ammoModel = new ModelRendererTurbo[0][0];
      this.barrelX = 0;
      this.barrelY = 0;
      this.barrelZ = 0;
      this.flipAll();
   }
}
