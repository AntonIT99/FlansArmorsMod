//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import org.lwjgl.opengl.GL11;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.wolffsmod.api.client.model.ModelBase;

import net.minecraft.world.entity.Entity;

public class ModelNo73ATGrenade extends ModelBase {
   int textureX = 128;
   int textureY = 128;
   public ModelRendererTurbo[] no73atgrenadeModel = new ModelRendererTurbo[6];

   public ModelNo73ATGrenade() {
      this.no73atgrenadeModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.no73atgrenadeModel[1] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.no73atgrenadeModel[2] = new ModelRendererTurbo(this, 49, 9, this.textureX, this.textureY);
      this.no73atgrenadeModel[3] = new ModelRendererTurbo(this, 81, 9, this.textureX, this.textureY);
      this.no73atgrenadeModel[4] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.no73atgrenadeModel[5] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.no73atgrenadeModel[0].addShapeBox(-5.5F, 1.0F, -2.5F, 4, 4, 5, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
      this.no73atgrenadeModel[0].setRotationPoint(0.0F, 10.0F, 0.0F);
      this.no73atgrenadeModel[0].rotateAngleX = (float) Math.PI;
      this.no73atgrenadeModel[0].rotateAngleY = (float) -Math.PI;
      this.no73atgrenadeModel[1].addShapeBox(-6.0F, 1.0F, -2.5F, 1, 4, 5, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F);
      this.no73atgrenadeModel[1].setRotationPoint(0.0F, 10.0F, 0.0F);
      this.no73atgrenadeModel[1].rotateAngleX = (float) Math.PI;
      this.no73atgrenadeModel[1].rotateAngleY = (float) -Math.PI;
      this.no73atgrenadeModel[2].addShapeBox(-8.5F, 4.0F, -5.0F, 3, 30, 10, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F);
      this.no73atgrenadeModel[2].setRotationPoint(0.0F, 10.0F, 0.0F);
      this.no73atgrenadeModel[2].rotateAngleX = (float) Math.PI;
      this.no73atgrenadeModel[2].rotateAngleY = (float) -Math.PI;
      this.no73atgrenadeModel[3].addShapeBox(-1.5F, 4.0F, -5.0F, 3, 30, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F);
      this.no73atgrenadeModel[3].setRotationPoint(0.0F, 10.0F, 0.0F);
      this.no73atgrenadeModel[3].rotateAngleX = (float) Math.PI;
      this.no73atgrenadeModel[3].rotateAngleY = (float) -Math.PI;
      this.no73atgrenadeModel[4].addShapeBox(-5.5F, 4.0F, -5.0F, 4, 30, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.no73atgrenadeModel[4].setRotationPoint(0.0F, 10.0F, 0.0F);
      this.no73atgrenadeModel[4].rotateAngleX = (float) Math.PI;
      this.no73atgrenadeModel[4].rotateAngleY = (float) -Math.PI;
      this.no73atgrenadeModel[5].addShapeBox(-2.0F, 1.0F, -2.5F, 1, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
      this.no73atgrenadeModel[5].setRotationPoint(0.0F, 10.0F, 0.0F);
      this.no73atgrenadeModel[5].rotateAngleX = (float) Math.PI;
      this.no73atgrenadeModel[5].rotateAngleY = (float) -Math.PI;
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      GL11.glScalef(0.2F, 0.2F, 0.2F);

      for (int i = 0; i < 6; i++) {
         this.no73atgrenadeModel[i].render(f5);
      }
   }
}
