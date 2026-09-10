//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WH40K.Misc;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmodultimate.client.model.ModelBase;

public class ModelWH40K_Misc_BoltBullet_1 extends ModelBase {
   int textureX = 32;
   int textureY = 32;
   public ModelRendererTurbo[] boltbulletModel = new ModelRendererTurbo[2];

   public ModelWH40K_Misc_BoltBullet_1() {
      this.boltbulletModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.boltbulletModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.boltbulletModel[0].addShapeBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F);
      this.boltbulletModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.boltbulletModel[1].addShapeBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.35F, -0.5F, -0.35F, -0.35F, -0.5F, -0.35F, -0.35F, -0.5F, -0.35F, -0.35F, -0.5F, -0.35F);
      this.boltbulletModel[1].setRotationPoint(0.0F, 1.0F, 0.0F);
   }
}
