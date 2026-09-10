//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import org.lwjgl.opengl.GL11;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.wolffsmod.api.client.model.ModelBase;

import net.minecraft.world.entity.Entity;

public class ModelStielhandgranate extends ModelBase {
   int textureX = 128;
   int textureY = 128;
   public ModelRendererTurbo[] stielhandgranateModel = new ModelRendererTurbo[20];

   public ModelStielhandgranate() {
      this.stielhandgranateModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.stielhandgranateModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.stielhandgranateModel[2] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.stielhandgranateModel[3] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.stielhandgranateModel[4] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.stielhandgranateModel[5] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.stielhandgranateModel[6] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.stielhandgranateModel[7] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
      this.stielhandgranateModel[8] = new ModelRendererTurbo(this, 49, 17, this.textureX, this.textureY);
      this.stielhandgranateModel[9] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
      this.stielhandgranateModel[10] = new ModelRendererTurbo(this, 97, 17, this.textureX, this.textureY);
      this.stielhandgranateModel[11] = new ModelRendererTurbo(this, 65, 33, this.textureX, this.textureY);
      this.stielhandgranateModel[12] = new ModelRendererTurbo(this, 81, 33, this.textureX, this.textureY);
      this.stielhandgranateModel[13] = new ModelRendererTurbo(this, 105, 33, this.textureX, this.textureY);
      this.stielhandgranateModel[14] = new ModelRendererTurbo(this, 1, 41, this.textureX, this.textureY);
      this.stielhandgranateModel[15] = new ModelRendererTurbo(this, 25, 41, this.textureX, this.textureY);
      this.stielhandgranateModel[16] = new ModelRendererTurbo(this, 49, 41, this.textureX, this.textureY);
      this.stielhandgranateModel[17] = new ModelRendererTurbo(this, 81, 41, this.textureX, this.textureY);
      this.stielhandgranateModel[18] = new ModelRendererTurbo(this, 105, 41, this.textureX, this.textureY);
      this.stielhandgranateModel[19] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.stielhandgranateModel[0].addShapeBox(-2.0F, 0.0F, -2.5F, 5, 2, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.stielhandgranateModel[0].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[0].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[1].addShapeBox(-2.0F, -4.0F, -2.5F, 5, 4, 5, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.stielhandgranateModel[1].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[1].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[2].addShapeBox(-2.0F, -21.0F, -2.5F, 5, 8, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
      this.stielhandgranateModel[2].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[2].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[3].addShapeBox(-1.5F, -13.0F, -2.0F, 4, 9, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.stielhandgranateModel[3].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[3].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[4].addShapeBox(-2.0F, -25.0F, -2.5F, 5, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.stielhandgranateModel[4].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[4].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[5].addShapeBox(-2.0F, -27.0F, -2.5F, 5, 2, 5, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
      this.stielhandgranateModel[5].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[5].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[6].addShapeBox(-1.5F, -39.0F, -3.5F, 4, 11, 7, 0.0F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F);
      this.stielhandgranateModel[6].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[6].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[7].addShapeBox(4.0F, -39.0F, -3.5F, 1, 11, 7, 0.0F, 1.0F, 0.0F, 1.5F, 0.5F, 0.0F, -1.5F, 0.5F, 0.0F, -1.5F, 1.0F, 0.0F, 1.5F, 1.0F, 0.0F, 1.5F, 0.5F, 0.0F, -1.5F, 0.5F, 0.0F, -1.5F, 1.0F, 0.0F, 1.5F);
      this.stielhandgranateModel[7].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[7].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[8].addShapeBox(-4.0F, -39.0F, -3.5F, 1, 11, 7, 0.0F, 0.5F, 0.0F, -1.5F, 1.0F, 0.0F, 1.5F, 1.0F, 0.0F, 1.5F, 0.5F, 0.0F, -1.5F, 0.5F, 0.0F, -1.5F, 1.0F, 0.0F, 1.5F, 1.0F, 0.0F, 1.5F, 0.5F, 0.0F, -1.5F);
      this.stielhandgranateModel[8].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[8].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[9].addShapeBox(-1.5F, -28.0F, -3.5F, 4, 1, 7, 0.0F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 2.0F);
      this.stielhandgranateModel[9].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[9].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[10].addShapeBox(4.0F, -28.0F, -3.5F, 1, 1, 7, 0.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, -1.5F, 1.0F, 0.0F, -1.5F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, -1.5F, 1.0F, 0.0F, -1.5F, 1.0F, 0.0F, 2.0F);
      this.stielhandgranateModel[10].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[10].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[11].addShapeBox(-4.0F, -28.0F, -3.5F, 1, 1, 7, 0.0F, 1.0F, 0.0F, -1.5F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, -1.5F, 1.0F, 0.0F, -1.5F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, -1.5F);
      this.stielhandgranateModel[11].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[11].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[12].addShapeBox(-2.0F, 2.8F, -2.5F, 5, 1, 5, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
      this.stielhandgranateModel[12].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[12].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[13].addShapeBox(-2.0F, 2.2F, -2.5F, 5, 1, 5, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
      this.stielhandgranateModel[13].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[13].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[14].addShapeBox(-2.0F, 2.0F, -2.5F, 5, 2, 5, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
      this.stielhandgranateModel[14].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[14].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[15].addShapeBox(-2.0F, -24.8F, -2.5F, 5, 1, 5, 0.0F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F);
      this.stielhandgranateModel[15].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[15].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[16].addShapeBox(-2.0F, -23.8F, -2.5F, 5, 1, 5, 0.0F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F, 0.25F, -0.3F, 0.25F);
      this.stielhandgranateModel[16].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[16].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[17].addShapeBox(-1.5F, -39.5F, -3.5F, 4, 1, 7, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
      this.stielhandgranateModel[17].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[17].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[18].addShapeBox(-4.0F, -39.5F, -3.5F, 1, 1, 7, 0.0F, 0.0F, 0.0F, -2.0F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 0.0F, 0.0F, -2.0F);
      this.stielhandgranateModel[18].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[18].rotateAngleZ = (float) -Math.PI;
      this.stielhandgranateModel[19].addShapeBox(4.0F, -39.5F, -3.5F, 1, 1, 7, 0.0F, 1.0F, 0.0F, 0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 1.0F, 0.0F, 0.5F);
      this.stielhandgranateModel[19].setRotationPoint(0.0F, -20.0F, 0.0F);
      this.stielhandgranateModel[19].rotateAngleZ = (float) -Math.PI;
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      GL11.glScalef(0.2F, 0.2F, 0.2F);

      for (int i = 0; i < 20; i++) {
         this.stielhandgranateModel[i].render(f5);
      }
   }
}
