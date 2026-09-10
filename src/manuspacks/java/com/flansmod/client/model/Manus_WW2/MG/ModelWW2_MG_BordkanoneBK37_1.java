//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WW2.MG;

import com.flansmod.client.model.ModelMG;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelWW2_MG_BordkanoneBK37_1 extends ModelMG {
   int textureX = 128;
   int textureY = 64;

   public ModelWW2_MG_BordkanoneBK37_1() {
      this.bipodModel = new ModelRendererTurbo[0];
      this.gunModel = new ModelRendererTurbo[5];
      this.gunModel[0] = new ModelRendererTurbo(this, 90, 0, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 52, 0, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 12, 0, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 24, 8, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 49, 0, this.textureX, this.textureY);
      this.gunModel[0].addTrapezoid(-4.0F, -4.0F, -20.0F, 8, 8, 11, 0.0F, -3.5F, 0);
      this.gunModel[0].setRotationPoint(0.0F, -3.0F, 0.0F);
      this.gunModel[1].addBox(-4.0F, -4.0F, -9.0F, 8, 8, 21, 0.0F);
      this.gunModel[1].setRotationPoint(0.0F, -3.0F, 0.0F);
      this.gunModel[2].addTrapezoid(-4.0F, -4.0F, 12.0F, 8, 8, 8, 0.0F, -3.0F, 1);
      this.gunModel[2].setRotationPoint(0.0F, -3.0F, 0.0F);
      this.gunModel[3].addBox(-0.5F, -0.5F, 20.0F, 1, 1, 22, 0.0F);
      this.gunModel[3].setRotationPoint(0.0F, -3.0F, 0.0F);
      this.gunModel[4].addTrapezoid(-1.0F, -1.0F, 42.0F, 2, 2, 10, 0.0F, -0.2F, 0);
      this.gunModel[4].setRotationPoint(0.0F, -3.0F, 0.0F);
      this.ammoModel = new ModelRendererTurbo[2];
      this.ammoModel[0] = new ModelRendererTurbo(this, 0, 32, this.textureX, this.textureY);
      this.ammoModel[1] = new ModelRendererTurbo(this, 0, 41, this.textureX, this.textureY);
      this.ammoModel[0].addBox(-15.0F, -1.0F, -2.0F, 11, 2, 6, 0.0F);
      this.ammoModel[0].setRotationPoint(0.0F, -3.0F, 0.0F);
      this.ammoModel[1].addBox(4.0F, -1.0F, -7.0F, 8, 2, 11, 0.0F);
      this.ammoModel[1].setRotationPoint(0.0F, -3.0F, 0.0F);
      this.flipAll();
   }
}
