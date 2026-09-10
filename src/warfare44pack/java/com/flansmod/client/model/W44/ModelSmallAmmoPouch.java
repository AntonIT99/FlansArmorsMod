//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmodultimate.client.model.ModelBase;

public class ModelSmallAmmoPouch extends ModelBase {
   int textureX = 128;
   int textureY = 32;
   public ModelRendererTurbo[] smallammopouchModel = new ModelRendererTurbo[4];

   public ModelSmallAmmoPouch() {
      this.smallammopouchModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.smallammopouchModel[1] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.smallammopouchModel[2] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
      this.smallammopouchModel[3] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.smallammopouchModel[0].addShapeBox(-10.5F, -3.75F, -9.5F, 20, 1, 21, 0.0F, -8.5F, -0.6F, -8.5F, -8.5F, -0.6F, -8.5F, -8.5F, -0.6F, -8.5F, -8.5F, -0.6F, -8.5F, -8.5F, 0.0F, -8.5F, -8.5F, 0.0F, -8.5F, -8.5F, 0.0F, -8.5F, -8.5F, 0.0F, -8.5F);
      this.smallammopouchModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smallammopouchModel[0].rotateAngleZ = (float) Math.PI;
      this.smallammopouchModel[1].addBox(-2.4F, -3.0F, -2.0F, 4, 3, 6, 0.0F);
      this.smallammopouchModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smallammopouchModel[1].rotateAngleZ = (float) Math.PI;
      this.smallammopouchModel[2].addShapeBox(1.6F, -3.5F, -2.0F, 1, 4, 6, 0.0F, 0.15F, -0.4F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.4F, 0.15F, 0.15F, -0.4F, 0.15F, 0.15F, -0.4F, 0.15F, 0.15F, -0.4F, 0.15F, 0.15F, -0.4F, 0.15F);
      this.smallammopouchModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smallammopouchModel[2].rotateAngleZ = (float) Math.PI;
      this.smallammopouchModel[3].addShapeBox(1.55F, -3.25F, 0.5F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.smallammopouchModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.smallammopouchModel[3].rotateAngleZ = (float) Math.PI;
   }

}
