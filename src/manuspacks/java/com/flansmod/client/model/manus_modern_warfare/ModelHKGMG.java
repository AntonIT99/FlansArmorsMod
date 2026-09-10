//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.manus_modern_warfare;

import com.flansmod.client.model.ModelMG;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelHKGMG extends ModelMG {
   int textureX = 256;
   int textureY = 32;

   public ModelHKGMG() {
      this.bipodModel = new ModelRendererTurbo[8];
      this.bipodModel[0] = new ModelRendererTurbo(this, 248, 0, this.textureX, this.textureY);
      this.bipodModel[1] = new ModelRendererTurbo(this, 248, 0, this.textureX, this.textureY);
      this.bipodModel[2] = new ModelRendererTurbo(this, 248, 0, this.textureX, this.textureY);
      this.bipodModel[3] = new ModelRendererTurbo(this, 242, 4, this.textureX, this.textureY);
      this.bipodModel[4] = new ModelRendererTurbo(this, 242, 4, this.textureX, this.textureY);
      this.bipodModel[5] = new ModelRendererTurbo(this, 242, 4, this.textureX, this.textureY);
      this.bipodModel[6] = new ModelRendererTurbo(this, 243, 0, this.textureX, this.textureY);
      this.bipodModel[7] = new ModelRendererTurbo(this, 230, 0, this.textureX, this.textureY);
      this.bipodModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
      this.bipodModel[0].setRotationPoint(-1.0F, -0.5F, 6.0F);
      this.bipodModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
      this.bipodModel[1].setRotationPoint(-6.0F, -0.5F, -8.0F);
      this.bipodModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
      this.bipodModel[2].setRotationPoint(4.0F, -0.5F, -8.0F);
      this.bipodModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.9999F, 0.0F, 0.0F, -4.9999F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
      this.bipodModel[3].setRotationPoint(-0.5F, -5.0F, 1.0F);
      this.bipodModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 6, 0.0F, 3.5F, -5.0F, 0.0F, -3.5F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.5F, 0.0F, -1.0F, -3.5F, 0.0F, -1.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F);
      this.bipodModel[4].setRotationPoint(-2.0F, -5.0F, -7.0F);
      this.bipodModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 6, 0.0F, -3.5F, -5.0F, 0.0F, 3.5F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.5F, 0.0F, -1.0F, 3.5F, 0.0F, -1.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F);
      this.bipodModel[5].setRotationPoint(1.0F, -5.0F, -7.0F);
      this.bipodModel[6].addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
      this.bipodModel[6].setRotationPoint(-0.5F, -7.0F, -0.5F);
      this.bipodModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F);
      this.bipodModel[7].setRotationPoint(-2.0F, -5.0F, -1.0F);
      this.gunModel = new ModelRendererTurbo[10];
      this.gunModel[0] = new ModelRendererTurbo(this, 215, 0, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 213, 0, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 196, 0, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 191, 0, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 174, 0, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 169, 0, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 158, 0, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 158, 0, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 81, 0, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.gunModel[0].addBox(-1.5F, -3.5F, -7.0F, 3, 3, 8, 0.0F);
      this.gunModel[0].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[1].addBox(1.0F, -3.0F, -3.0F, 1, 2, 3, 0.0F);
      this.gunModel[1].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[2].addShapeBox(-0.5F, -2.5F, 1.0F, 1, 1, 7, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F);
      this.gunModel[2].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[3].addBox(-0.5F, -2.5F, 8.0F, 1, 1, 4, 0.0F);
      this.gunModel[3].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[4].addShapeBox(-4.5F, -1.0F, -6.0F, 9, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F);
      this.gunModel[4].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[5].addBox(-2.0F, -3.0F, -5.5F, 1, 2, 1, 0.0F);
      this.gunModel[5].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[6].addShapeBox(-2.0F, -6.0F, -11.5F, 1, 3, 7, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -2.9999F, 0.0F, 0.0F, -2.9999F, 0.0F, 0.0F, -2.5F, 0.0F, -0.5F, -2.5F, 0.0F, -0.5F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
      this.gunModel[6].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[7].addShapeBox(-0.5F, -4.0F, -6.0F, 1, 1, 2, 0.0F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[7].setRotationPoint(0.0F, -5.999F, 0.0F);
      this.gunModel[8].addShapeBox(-0.5F, -5.0F, -6.0F, 30, 30, 2, 0.0F, 0.0F, 0.0F, 0.0F, -29.0F, 0.0F, 0.0F, -29.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -29.0F, 0.0F, -29.0F, -29.0F, 0.0F, -29.0F, -29.0F, 0.0F, 0.0F, -29.0F, 0.0F);
      this.gunModel[8].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[9].flip = true;
      this.gunModel[9].addShapeBox(-0.5F, -5.0F, -6.0F, 30, 30, 2, 0.0F, 0.0F, 0.0F, 0.0F, -29.0F, 0.0F, 0.0F, -29.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -29.0F, 0.0F, -29.0F, -29.0F, 0.0F, -29.0F, -29.0F, 0.0F, 0.0F, -29.0F, 0.0F);
      this.gunModel[9].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.ammoModel = new ModelRendererTurbo[5];
      this.ammoModel[0] = new ModelRendererTurbo(this, 66, 0, this.textureX, this.textureY);
      this.ammoModel[1] = new ModelRendererTurbo(this, 66, 6, this.textureX, this.textureY);
      this.ammoModel[2] = new ModelRendererTurbo(this, 66, 9, this.textureX, this.textureY);
      this.ammoModel[3] = new ModelRendererTurbo(this, 66, 12, this.textureX, this.textureY);
      this.ammoModel[4] = new ModelRendererTurbo(this, 66, 15, this.textureX, this.textureY);
      this.ammoModel[0].addBox(-6.5F, -1.5F, -2.0F, 5, 3, 2, 0.0F);
      this.ammoModel[0].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.ammoModel[1].addShapeBox(-3.3F, -2.0F, -0.9F, 1, 1, 1, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.25F, -0.25F, -0.2F, -0.25F, -0.25F, -0.2F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.25F, -0.25F, -0.2F, -0.25F, -0.25F, -0.2F);
      this.ammoModel[1].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.ammoModel[2].addShapeBox(-3.3F, -2.0F, -1.9F, 1, 1, 1, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F);
      this.ammoModel[2].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.ammoModel[3].addShapeBox(-2.3F, -2.8F, -0.9F, 1, 1, 1, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.25F, -0.25F, -0.2F, -0.25F, -0.25F, -0.2F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.25F, -0.25F, -0.2F, -0.25F, -0.25F, -0.2F);
      this.ammoModel[3].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.ammoModel[4].addShapeBox(-2.3F, -2.8F, -1.9F, 1, 1, 1, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F);
      this.ammoModel[4].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.flipAll();
   }
}
