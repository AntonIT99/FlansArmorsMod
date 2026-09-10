//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.wolffsmod.api.client.model.ModelBase;
import net.minecraft.world.entity.Entity;

public class ModelWarfarebomb extends ModelBase {
   int textureX = 128;
   int textureY = 128;
   public ModelRendererTurbo[] warfarebombModel = new ModelRendererTurbo[24];

   public ModelWarfarebomb() {
      this.warfarebombModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.warfarebombModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.warfarebombModel[2] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.warfarebombModel[3] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.warfarebombModel[4] = new ModelRendererTurbo(this, 41, 17, this.textureX, this.textureY);
      this.warfarebombModel[5] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
      this.warfarebombModel[6] = new ModelRendererTurbo(this, 1, 33, this.textureX, this.textureY);
      this.warfarebombModel[7] = new ModelRendererTurbo(this, 41, 33, this.textureX, this.textureY);
      this.warfarebombModel[8] = new ModelRendererTurbo(this, 81, 33, this.textureX, this.textureY);
      this.warfarebombModel[9] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.warfarebombModel[10] = new ModelRendererTurbo(this, 41, 49, this.textureX, this.textureY);
      this.warfarebombModel[11] = new ModelRendererTurbo(this, 81, 49, this.textureX, this.textureY);
      this.warfarebombModel[12] = new ModelRendererTurbo(this, 1, 65, this.textureX, this.textureY);
      this.warfarebombModel[13] = new ModelRendererTurbo(this, 33, 65, this.textureX, this.textureY);
      this.warfarebombModel[14] = new ModelRendererTurbo(this, 65, 65, this.textureX, this.textureY);
      this.warfarebombModel[15] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.warfarebombModel[16] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.warfarebombModel[17] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.warfarebombModel[18] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.warfarebombModel[19] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.warfarebombModel[20] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.warfarebombModel[21] = new ModelRendererTurbo(this, 121, 9, this.textureX, this.textureY);
      this.warfarebombModel[22] = new ModelRendererTurbo(this, 1, 81, this.textureX, this.textureY);
      this.warfarebombModel[23] = new ModelRendererTurbo(this, 41, 81, this.textureX, this.textureY);
      this.warfarebombModel[0].addBox(-8.0F, -2.0F, -4.5F, 9, 3, 9, 0.0F);
      this.warfarebombModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[0].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[0].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[1].addShapeBox(-8.0F, -5.0F, -4.5F, 9, 3, 9, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.warfarebombModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[1].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[1].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[2].addShapeBox(-8.0F, 1.0F, -4.5F, 9, 3, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F);
      this.warfarebombModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[2].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[2].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[3].addShapeBox(1.0F, -2.0F, -4.5F, 7, 3, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, -0.5F, 0.0F, -0.25F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, -0.5F, 0.0F, -0.25F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.warfarebombModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[3].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[3].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[4].addShapeBox(1.0F, -5.0F, -4.5F, 7, 3, 9, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, -0.5F, -3.5F, 0.0F, -0.5F, -3.5F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, -0.5F, 0.0F, 0.25F, -0.5F, 0.0F, 0.0F, 0.0F);
      this.warfarebombModel[4].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[4].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[4].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[5].addShapeBox(1.0F, 1.0F, -4.5F, 7, 3, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, -0.5F, 0.0F, 0.25F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, -0.5F, -3.5F, 0.0F, -0.5F, -3.5F, 0.0F, 0.0F, -3.0F);
      this.warfarebombModel[5].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[5].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[5].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[6].addShapeBox(-15.0F, -5.0F, -4.5F, 7, 3, 9, 0.0F, 0.0F, -0.5F, -3.5F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, -0.5F, -3.5F, 0.0F, 0.25F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, -0.5F);
      this.warfarebombModel[6].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[6].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[6].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[7].addShapeBox(-15.0F, 1.0F, -4.5F, 7, 3, 9, 0.0F, 0.0F, 0.25F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, -0.5F, 0.0F, -0.5F, -3.5F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, -0.5F, -3.5F);
      this.warfarebombModel[7].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[7].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[7].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[8].addShapeBox(-15.0F, -2.0F, -4.5F, 7, 3, 9, 0.0F, 0.0F, -0.25F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, -0.5F, 0.0F, -0.25F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, -0.5F);
      this.warfarebombModel[8].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[8].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[8].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[9].addShapeBox(8.0F, -2.0F, -4.5F, 7, 3, 9, 0.0F, 0.0F, -0.25F, -0.5F, 0.0F, -1.0F, -3.0F, 0.0F, -1.0F, -3.0F, 0.0F, -0.25F, -0.5F, 0.0F, -0.25F, -0.5F, 0.0F, -1.0F, -3.0F, 0.0F, -1.0F, -3.0F, 0.0F, -0.25F, -0.5F);
      this.warfarebombModel[9].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[9].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[9].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[10].addShapeBox(8.0F, -5.0F, -4.5F, 7, 3, 9, 0.0F, 0.0F, -0.5F, -3.5F, 0.0F, -3.0F, -4.0F, 0.0F, -3.0F, -4.0F, 0.0F, -0.5F, -3.5F, 0.0F, 0.25F, -0.5F, 0.0F, 1.0F, -3.0F, 0.0F, 1.0F, -3.0F, 0.0F, 0.25F, -0.5F);
      this.warfarebombModel[10].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[10].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[10].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[11].addShapeBox(8.0F, 1.0F, -4.5F, 7, 3, 9, 0.0F, 0.0F, 0.25F, -0.5F, 0.0F, 1.0F, -3.0F, 0.0F, 1.0F, -3.0F, 0.0F, 0.25F, -0.5F, 0.0F, -0.5F, -3.5F, 0.0F, -3.0F, -4.0F, 0.0F, -3.0F, -4.0F, 0.0F, -0.5F, -3.5F);
      this.warfarebombModel[11].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[11].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[11].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[12].addShapeBox(-20.0F, 1.0F, -4.5F, 5, 3, 9, 0.0F, 0.0F, 1.0F, -3.0F, 0.0F, 0.25F, -0.5F, 0.0F, 0.25F, -0.5F, 0.0F, 1.0F, -3.0F, 0.0F, -3.0F, -4.0F, 0.0F, -0.5F, -3.5F, 0.0F, -0.5F, -3.5F, 0.0F, -3.0F, -4.0F);
      this.warfarebombModel[12].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[12].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[12].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[13].addShapeBox(-20.0F, -2.0F, -4.5F, 5, 3, 9, 0.0F, 0.0F, -1.0F, -3.0F, 0.0F, -0.25F, -0.5F, 0.0F, -0.25F, -0.5F, 0.0F, -1.0F, -3.0F, 0.0F, -1.0F, -3.0F, 0.0F, -0.25F, -0.5F, 0.0F, -0.25F, -0.5F, 0.0F, -1.0F, -3.0F);
      this.warfarebombModel[13].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[13].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[13].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[14].addShapeBox(-20.0F, -5.0F, -4.5F, 5, 3, 9, 0.0F, 0.0F, -3.0F, -4.0F, 0.0F, -0.5F, -3.5F, 0.0F, -0.5F, -3.5F, 0.0F, -3.0F, -4.0F, 0.0F, 1.0F, -3.0F, 0.0F, 0.25F, -0.5F, 0.0F, 0.25F, -0.5F, 0.0F, 1.0F, -3.0F);
      this.warfarebombModel[14].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[14].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[14].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[15].addShapeBox(15.0F, -1.0F, -1.5F, 3, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, -1.2F, 0.0F, -0.4F, -1.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, -1.2F, 0.0F, -0.4F, -1.2F, 0.0F, 0.0F, 0.0F);
      this.warfarebombModel[15].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[15].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[15].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[16].addShapeBox(15.0F, -2.0F, -1.5F, 3, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -1.2F, -1.4F, 0.0F, -1.2F, -1.4F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, -1.2F, 0.0F, 0.4F, -1.2F, 0.0F, 0.0F, 0.0F);
      this.warfarebombModel[16].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[16].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[16].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[17].addShapeBox(15.0F, 0.0F, -1.5F, 3, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, -1.2F, 0.0F, 0.4F, -1.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -1.2F, -1.4F, 0.0F, -1.2F, -1.4F, 0.0F, 0.0F, -1.0F);
      this.warfarebombModel[17].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[17].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[17].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[18].addShapeBox(-21.0F, 0.0F, -1.5F, 1, 1, 3, 0.0F, 0.0F, 0.4F, -1.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, -1.2F, 0.0F, -1.2F, -1.4F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, -1.2F, -1.4F);
      this.warfarebombModel[18].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[18].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[18].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[19].addShapeBox(-21.0F, -2.0F, -1.5F, 1, 1, 3, 0.0F, 0.0F, -1.2F, -1.4F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, -1.2F, -1.4F, 0.0F, 0.4F, -1.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, -1.2F);
      this.warfarebombModel[19].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[19].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[19].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[20].addShapeBox(-21.0F, -1.0F, -1.5F, 1, 1, 3, 0.0F, 0.0F, -0.4F, -1.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, -1.2F, 0.0F, -0.4F, -1.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, -1.2F);
      this.warfarebombModel[20].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[20].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[20].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[21].addShapeBox(-22.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.warfarebombModel[21].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[21].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[21].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[22].addShapeBox(7.0F, -5.0F, -4.5F, 15, 9, 1, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -8.5F, 0.0F, 0.0F, -8.5F, 0.0F, -0.5F, 8.0F, 0.0F, -0.5F, 8.0F);
      this.warfarebombModel[22].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[22].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[22].rotateAngleZ = (float) (-Math.PI / 2);
      this.warfarebombModel[23].addShapeBox(7.0F, -5.0F, 3.5F, 15, 9, 1, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 8.0F, 0.0F, -0.5F, 8.0F, 0.0F, 0.0F, -8.5F, 0.0F, 0.0F, -8.5F);
      this.warfarebombModel[23].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.warfarebombModel[23].rotateAngleY = (float) (Math.PI / 2);
      this.warfarebombModel[23].rotateAngleZ = (float) (-Math.PI / 2);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for (int i = 0; i < 24; i++) {
         this.warfarebombModel[i].render(f5);
      }
   }
}
