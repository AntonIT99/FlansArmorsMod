//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WW2.MG;

import com.flansmod.client.model.ModelMG;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelWW2_MG_MG81ZB_1 extends ModelMG {
   int textureX = 128;
   int textureY = 32;

   public ModelWW2_MG_MG81ZB_1() {
      this.bipodModel = new ModelRendererTurbo[5];
      this.bipodModel[0] = new ModelRendererTurbo(this, 115, 0, this.textureX, this.textureY);
      this.bipodModel[1] = new ModelRendererTurbo(this, 120, 0, this.textureX, this.textureY);
      this.bipodModel[2] = new ModelRendererTurbo(this, 120, 0, this.textureX, this.textureY);
      this.bipodModel[3] = new ModelRendererTurbo(this, 124, 4, this.textureX, this.textureY);
      this.bipodModel[4] = new ModelRendererTurbo(this, 124, 4, this.textureX, this.textureY);
      this.bipodModel[0].addTrapezoid(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, 5);
      this.bipodModel[0].setRotationPoint(-0.5F, -6.0F, -0.5F);
      this.bipodModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
      this.bipodModel[1].setRotationPoint(-6.0F, -0.5F, -1.0F);
      this.bipodModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
      this.bipodModel[2].setRotationPoint(5.0F, -0.5F, -1.0F);
      this.bipodModel[3].addShapeBox(0.0F, 0.0F, -0.5F, 1, 8, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.0F, -0.4F, -0.6F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.0F, -0.4F, -0.6F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F);
      this.bipodModel[3].setRotationPoint(-0.5F, -6.0F, 0.0F);
      this.bipodModel[3].rotateAngleZ = -0.7504916F;
      this.bipodModel[4].addShapeBox(-1.0F, 0.0F, -0.5F, 1, 8, 1, 0.0F, -0.6F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.0F, -0.2F, -0.6F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.0F, -0.2F);
      this.bipodModel[4].setRotationPoint(0.5F, -6.0F, 0.0F);
      this.bipodModel[4].rotateAngleZ = 0.7504916F;
      this.gunModel = new ModelRendererTurbo[15];
      this.gunModel[0] = new ModelRendererTurbo(this, 99, 2, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 99, 2, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 83, 0, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 77, 0, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 99, 0, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 99, 6, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 104, 6, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 89, 0, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 77, 0, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 77, 0, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 115, 4, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 115, 4, this.textureX, this.textureY);
      this.gunModel[12] = new ModelRendererTurbo(this, 115, 9, this.textureX, this.textureY);
      this.gunModel[13] = new ModelRendererTurbo(this, 69, 5, this.textureX, this.textureY);
      this.gunModel[14] = new ModelRendererTurbo(this, 69, 0, this.textureX, this.textureY);
      this.gunModel[0].addBox(-0.5F, -1.0F, -7.0F, 1, 1, 13, 0.0F);
      this.gunModel[0].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[1].flip = true;
      this.gunModel[1].addBox(-0.5F, -1.0F, -7.0F, 1, 1, 13, 0.0F);
      this.gunModel[1].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[2].addShapeBox(-0.5F, -1.0F, -7.0F, 1, 1, 13, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F, -0.15F, -0.15F, 0.0F);
      this.gunModel[2].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[3].addBox(-1.0F, -1.5F, -14.0F, 2, 2, 7, 0.0F);
      this.gunModel[3].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[4].addShapeBox(-1.0F, -2.0F, -11.0F, 2, 1, 4, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
      this.gunModel[4].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[5].addShapeBox(-0.5F, -3.0F, 4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.1F, -0.4F, 0.0F, -0.1F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
      this.gunModel[5].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[6].addShapeBox(-0.5F, -3.0F, -9.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.1F, -0.4F, 0.0F, -0.1F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
      this.gunModel[6].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[7].addShapeBox(-0.5F, 0.5F, -13.2F, 1, 3, 2, 0.0F, -0.1F, 0.0F, -1.0F, -0.1F, 0.0F, -1.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, -1.0F, 0.0F, -0.1F, -1.0F, 0.0F, -0.1F, 0.0F, -1.0F, -0.1F, 0.0F, -1.0F);
      this.gunModel[7].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[8].addShapeBox(-0.5F, 0.5F, -12.0F, 1, 1, 2, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
      this.gunModel[8].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[9].flip = true;
      this.gunModel[9].addShapeBox(-0.5F, 0.5F, -12.0F, 1, 1, 2, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
      this.gunModel[9].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[10].addBox(-1.2F, -1.0F, -10.5F, 1, 1, 3, 0.0F);
      this.gunModel[10].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[11].addBox(0.2F, -1.0F, -10.5F, 1, 1, 3, 0.0F);
      this.gunModel[11].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[12].addShapeBox(-1.0F, -1.5F, -7.0F, 2, 2, 2, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F);
      this.gunModel[12].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[13].addShapeBox(-0.5F, -0.3F, -18.0F, 1, 1, 5, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F);
      this.gunModel[13].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.gunModel[14].addShapeBox(-0.5F, -2.3F, -19.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, -1.9F, 0.0F, -0.1F, -1.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, -0.9F, 0.0F, -0.1F, -0.9F, 0.0F);
      this.gunModel[14].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.ammoModel = new ModelRendererTurbo[5];
      this.ammoModel[0] = new ModelRendererTurbo(this, 47, 0, this.textureX, this.textureY);
      this.ammoModel[1] = new ModelRendererTurbo(this, 58, 0, this.textureX, this.textureY);
      this.ammoModel[2] = new ModelRendererTurbo(this, 47, 4, this.textureX, this.textureY);
      this.ammoModel[3] = new ModelRendererTurbo(this, 47, 8, this.textureX, this.textureY);
      this.ammoModel[4] = new ModelRendererTurbo(this, 58, 8, this.textureX, this.textureY);
      this.ammoModel[0].addShapeBox(-3.0F, -0.5F, -10.0F, 3, 1, 2, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.ammoModel[0].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.ammoModel[1].addShapeBox(0.0F, -0.5F, -10.0F, 3, 1, 2, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.ammoModel[1].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.ammoModel[2].addBox(-3.0F, 0.5F, -10.0F, 6, 1, 2, 0.0F);
      this.ammoModel[2].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.ammoModel[3].addShapeBox(-3.0F, 1.5F, -10.0F, 3, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F);
      this.ammoModel[3].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.ammoModel[4].addShapeBox(0.0F, 1.5F, -10.0F, 3, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F);
      this.ammoModel[4].setRotationPoint(0.0F, -6.0F, 0.0F);
      this.flipAll();
   }
}
