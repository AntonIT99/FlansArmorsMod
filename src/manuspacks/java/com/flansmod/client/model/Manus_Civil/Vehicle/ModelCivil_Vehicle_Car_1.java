//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_Civil.Vehicle;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelCivil_Vehicle_Car_1 extends ModelVehicle {
   int textureX = 512;
   int textureY = 512;

   public ModelCivil_Vehicle_Car_1() {
      this.bodyModel = new ModelRendererTurbo[19];
      this.bodyModel[0] = new ModelRendererTurbo(this, 0, 225, this.textureX, this.textureY);
      this.bodyModel[1] = new ModelRendererTurbo(this, 0, 466, this.textureX, this.textureY);
      this.bodyModel[2] = new ModelRendererTurbo(this, 31, 372, this.textureX, this.textureY);
      this.bodyModel[3] = new ModelRendererTurbo(this, 0, 372, this.textureX, this.textureY);
      this.bodyModel[4] = new ModelRendererTurbo(this, 82, 270, this.textureX, this.textureY);
      this.bodyModel[5] = new ModelRendererTurbo(this, 0, 269, this.textureX, this.textureY);
      this.bodyModel[6] = new ModelRendererTurbo(this, 0, 450, this.textureX, this.textureY);
      this.bodyModel[7] = new ModelRendererTurbo(this, 0, 434, this.textureX, this.textureY);
      this.bodyModel[8] = new ModelRendererTurbo(this, 86, 394, this.textureX, this.textureY);
      this.bodyModel[9] = new ModelRendererTurbo(this, 0, 386, this.textureX, this.textureY);
      this.bodyModel[10] = new ModelRendererTurbo(this, 0, 359, this.textureX, this.textureY);
      this.bodyModel[11] = new ModelRendererTurbo(this, 27, 359, this.textureX, this.textureY);
      this.bodyModel[12] = new ModelRendererTurbo(this, 0, 311, this.textureX, this.textureY);
      this.bodyModel[13] = new ModelRendererTurbo(this, 86, 347, this.textureX, this.textureY);
      this.bodyModel[14] = new ModelRendererTurbo(this, 86, 311, this.textureX, this.textureY);
      this.bodyModel[15] = new ModelRendererTurbo(this, 155, 388, this.textureX, this.textureY);
      this.bodyModel[16] = new ModelRendererTurbo(this, 155, 348, this.textureX, this.textureY);
      this.bodyModel[17] = new ModelRendererTurbo(this, 82, 225, this.textureX, this.textureY);
      this.bodyModel[18] = new ModelRendererTurbo(this, 90, 225, this.textureX, this.textureY);
      this.bodyModel[0].addBox(8.0F, -8.0F, -14.0F, 12, 14, 28, 0.0F);
      this.bodyModel[1].addBox(-24.0F, 4.0F, -16.0F, 32, 2, 32, 0.0F);
      this.bodyModel[2].addBox(8.0F, -8.0F, -16.0F, 12, 9, 2, 0.0F);
      this.bodyModel[3].addBox(8.0F, -8.0F, 14.0F, 12, 9, 2, 0.0F);
      this.bodyModel[4].addBox(-6.0F, -7.0F, -14.0F, 1, 11, 28, 0.0F);
      this.bodyModel[5].addBox(-34.0F, -8.0F, -14.0F, 12, 12, 28, 0.0F);
      this.bodyModel[6].addBox(-24.0F, -8.0F, -16.0F, 32, 12, 2, 0.0F);
      this.bodyModel[7].addBox(-24.0F, -8.0F, 14.0F, 32, 12, 2, 0.0F);
      this.bodyModel[8].addBox(0.0F, 0.0F, 0.0F, 1, 13, 32, 0.0F);
      this.bodyModel[8].setRotationPoint(-20.0F, -19.0F, -16.0F);
      this.bodyModel[8].rotateAngleZ = (float) (-Math.PI / 6);
      this.bodyModel[9].addBox(20.0F, -8.0F, -16.0F, 10, 14, 32, 0.0F);
      this.bodyModel[10].addBox(-34.0F, -8.0F, 14.0F, 10, 9, 2, 0.0F);
      this.bodyModel[11].addBox(-34.0F, -8.0F, -16.0F, 10, 9, 2, 0.0F);
      this.bodyModel[12].addBox(-44.0F, -8.0F, -16.0F, 10, 14, 32, 0.0F);
      this.bodyModel[13].addBox(0.0F, 0.0F, 0.0F, 1, 12, 32, 0.0F);
      this.bodyModel[13].setRotationPoint(5.0F, -18.0F, -16.0F);
      this.bodyModel[13].rotateAngleZ = 0.4363323F;
      this.bodyModel[14].addBox(-21.0F, -19.0F, -16.0F, 27, 1, 32, 0.0F);
      this.bodyModel[15].addBox(-45.0F, 2.0F, -17.0F, 6, 4, 34, 0.0F);
      this.bodyModel[16].addBox(25.0F, 2.0F, -17.0F, 6, 4, 34, 0.0F);
      this.bodyModel[17].addBox(-7.0F, -18.0F, -16.0F, 2, 10, 1, 0.0F);
      this.bodyModel[18].addBox(-7.0F, -18.0F, 15.0F, 2, 10, 1, 0.0F);
      this.leftBackWheelModel = new ModelRendererTurbo[1];
      this.leftBackWheelModel[0] = new ModelRendererTurbo(this, 0, 502, this.textureX, this.textureY);
      this.leftBackWheelModel[0].addBox(-4.0F, -4.0F, -1.0F, 8, 8, 2, 0.0F);
      this.leftBackWheelModel[0].setRotationPoint(-29.0F, 6.0F, -15.0F);
      this.rightBackWheelModel = new ModelRendererTurbo[1];
      this.rightBackWheelModel[0] = new ModelRendererTurbo(this, 0, 502, this.textureX, this.textureY);
      this.rightBackWheelModel[0].addBox(-4.0F, -4.0F, -1.0F, 8, 8, 2, 0.0F);
      this.rightBackWheelModel[0].setRotationPoint(-29.0F, 6.0F, 15.0F);
      this.leftFrontWheelModel = new ModelRendererTurbo[1];
      this.leftFrontWheelModel[0] = new ModelRendererTurbo(this, 0, 502, this.textureX, this.textureY);
      this.leftFrontWheelModel[0].addBox(-4.0F, -4.0F, -1.0F, 8, 8, 2, 0.0F);
      this.leftFrontWheelModel[0].setRotationPoint(14.0F, 6.0F, -15.0F);
      this.rightFrontWheelModel = new ModelRendererTurbo[1];
      this.rightFrontWheelModel[0] = new ModelRendererTurbo(this, 0, 502, this.textureX, this.textureY);
      this.rightFrontWheelModel[0].addBox(-4.0F, -4.0F, -1.0F, 8, 8, 2, 0.0F);
      this.rightFrontWheelModel[0].setRotationPoint(14.0F, 6.0F, 15.0F);
      this.steeringWheelModel = new ModelRendererTurbo[1];
      this.steeringWheelModel[0] = new ModelRendererTurbo(this, 0, 200, this.textureX, this.textureY);
      this.steeringWheelModel[0].addBox(0.0F, -4.0F, -4.0F, 1, 8, 8, 0.0F);
      this.steeringWheelModel[0].setRotationPoint(7.0F, -7.0F, 8.0F);
      this.steeringWheelModel[0].rotateAngleZ = -0.1919862F;
      this.flipAll();
      this.translateAll(8, 0, 0);
   }
}
