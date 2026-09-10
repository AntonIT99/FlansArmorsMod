//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WW2.MG;

import com.flansmod.client.model.ModelMG;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelWW2_MG_GunPlaneGeneric_1 extends ModelMG {
   int textureX = 128;
   int textureY = 32;

   public ModelWW2_MG_GunPlaneGeneric_1() {
      this.bipodModel = new ModelRendererTurbo[0];
      this.gunModel = new ModelRendererTurbo[14];
      this.gunModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[1] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.gunModel[2] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.gunModel[3] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
      this.gunModel[4] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.gunModel[5] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.gunModel[6] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
      this.gunModel[7] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.gunModel[8] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
      this.gunModel[9] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.gunModel[10] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.gunModel[11] = new ModelRendererTurbo(this, 113, 1, this.textureX, this.textureY);
      this.gunModel[12] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.gunModel[13] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.gunModel[0].addBox(-1.0F, -4.0F, -8.0F, 2, 3, 13, 0.0F);
      this.gunModel[1].addShapeBox(-1.5F, -4.5F, 5.0F, 3, 4, 3, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F);
      this.gunModel[2].addBox(-1.0F, -3.5F, 8.0F, 2, 2, 3, 0.0F);
      this.gunModel[3].addShapeBox(-1.0F, -3.5F, 11.0F, 2, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F);
      this.gunModel[4].addBox(-0.5F, -3.0F, 11.0F, 1, 1, 17, 0.0F);
      this.gunModel[5].addShapeBox(-1.0F, -1.0F, -8.0F, 2, 2, 16, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, -2.0F, -0.4F, 0.0F, -2.0F, -0.4F, 0.0F, -2.0F, -0.4F, 0.0F, -2.0F);
      this.gunModel[6].addShapeBox(-2.0F, -3.5F, 1.0F, 4, 2, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
      this.gunModel[7].addShapeBox(-0.5F, -4.3F, 7.5F, 1, 1, 2, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F);
      this.gunModel[8].addShapeBox(-0.5F, -1.7F, 7.5F, 1, 1, 2, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F);
      this.gunModel[9].addBox(-1.5F, -3.5F, -7.0F, 1, 2, 7, 0.0F);
      this.gunModel[10].addBox(1.0F, -3.8F, -6.0F, 2, 2, 1, 0.0F);
      this.gunModel[11].addShapeBox(1.0F, -3.8F, -5.0F, 2, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
      this.gunModel[12].addShapeBox(1.0F, -3.8F, -7.0F, 2, 2, 1, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.gunModel[13].addShapeBox(-0.5F, -3.0F, 25.0F, 1, 1, 1, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F);
      this.ammoModel = new ModelRendererTurbo[0];
      this.ammoBoxModel = new ModelRendererTurbo[5];
      this.ammoBoxModel[0] = new ModelRendererTurbo(this, 1, 20, this.textureX, this.textureY);
      this.ammoBoxModel[1] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.ammoBoxModel[2] = new ModelRendererTurbo(this, 25, 9, this.textureX, this.textureY);
      this.ammoBoxModel[3] = new ModelRendererTurbo(this, 41, 9, this.textureX, this.textureY);
      this.ammoBoxModel[4] = new ModelRendererTurbo(this, 57, 9, this.textureX, this.textureY);
      this.ammoBoxModel[0].addBox(4.0F, -4.0F, 0.5F, 7, 4, 4, 0.0F);
      this.ammoBoxModel[1].addShapeBox(3.0F, -5.0F, 1.5F, 1, 1, 2, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F);
      this.ammoBoxModel[2].addShapeBox(4.0F, -5.0F, 1.5F, 2, 1, 2, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.4F, 0.0F);
      this.ammoBoxModel[3].addShapeBox(1.0F, -3.0F, 1.5F, 1, 1, 2, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F);
      this.ammoBoxModel[4].addShapeBox(2.0F, -5.0F, 1.5F, 1, 3, 2, 0.0F, -1.0F, -0.4F, 0.0F, 0.0F, -0.6F, 0.0F, 0.0F, -0.6F, 0.0F, -1.0F, -0.4F, 0.0F, 0.0F, -0.6F, 0.0F, -1.0F, -0.4F, 0.0F, -1.0F, -0.4F, 0.0F, 0.0F, -0.6F, 0.0F);
      this.flipAll();
   }
}
