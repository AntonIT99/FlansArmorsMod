//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.manus_modern_warfare;

import com.flansmod.client.model.ModelMG;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelM148Javelin extends ModelMG {
   int textureX = 128;
   int textureY = 64;

   public ModelM148Javelin() {
      this.bipodModel = new ModelRendererTurbo[4];
      this.bipodModel[0] = new ModelRendererTurbo(this, 0, 25, this.textureX, this.textureY);
      this.bipodModel[1] = new ModelRendererTurbo(this, 21, 20, this.textureX, this.textureY);
      this.bipodModel[2] = new ModelRendererTurbo(this, 26, 20, this.textureX, this.textureY);
      this.bipodModel[3] = new ModelRendererTurbo(this, 21, 16, this.textureX, this.textureY);
      this.bipodModel[0].addBox(0.0F, 0.0F, 0.0F, 6, 1, 4, 0.0F);
      this.bipodModel[0].setRotationPoint(-3.0F, 0.0F, -2.0F);
      this.bipodModel[1].addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
      this.bipodModel[1].setRotationPoint(-2.5F, 1.0F, -0.5F);
      this.bipodModel[1].rotateAngleZ = (float) (-Math.PI / 12);
      this.bipodModel[2].addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
      this.bipodModel[2].setRotationPoint(2.5F, 1.0F, -0.5F);
      this.bipodModel[2].rotateAngleZ = (float) (Math.PI / 12);
      this.bipodModel[3].addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
      this.bipodModel[3].setRotationPoint(-1.0F, 7.0F, -0.5F);
      this.gunModel = new ModelRendererTurbo[8];
      this.gunModel[0] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 0, 14, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 45, 0, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 21, 10, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 45, 11, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 45, 14, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 45, 20, this.textureX, this.textureY);
      this.gunModel[0].addBox(5.0F, -2.0F, -8.0F, 4, 4, 32, 0.0F);
      this.gunModel[0].setRotationPoint(0.0F, 11.0F, 0.0F);
      this.gunModel[1].addBox(4.0F, -3.0F, 20.0F, 6, 6, 3, 0.0F);
      this.gunModel[1].setRotationPoint(0.0F, 11.0F, 0.0F);
      this.gunModel[1].rotateAngleZ = -0.01745329F;
      this.gunModel[2].addTrapezoid(4.0F, -3.0F, 23.0F, 6, 6, 1, 0.0F, -1.0F, 1);
      this.gunModel[2].setRotationPoint(0.0F, 11.0F, 0.0F);
      this.gunModel[3].addBox(-3.0F, -3.0F, -1.0F, 9, 4, 4, 0.0F);
      this.gunModel[3].setRotationPoint(0.0F, 11.0F, 0.0F);
      this.gunModel[4].addBox(3.0F, -6.0F, 0.0F, 1, 3, 1, 0.0F);
      this.gunModel[4].setRotationPoint(0.0F, 11.0F, 0.0F);
      this.gunModel[5].addBox(-3.0F, 1.0F, 3.0F, 6, 0, 1, 0.0F);
      this.gunModel[5].setRotationPoint(0.0F, 11.0F, 0.0F);
      this.gunModel[6].addBox(-3.0F, -2.0F, 3.0F, 0, 3, 1, 0.0F);
      this.gunModel[6].setRotationPoint(0.0F, 11.0F, 0.0F);
      this.gunModel[7].addBox(-2.0F, -2.0F, -1.5F, 4, 2, 1, 0.0F);
      this.gunModel[7].setRotationPoint(0.0F, 11.0F, 0.0F);
      this.ammoModel = new ModelRendererTurbo[0];
   }
}
