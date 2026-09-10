//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WH40K.Misc;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.wolffsmod.api.client.model.ModelBase;
import net.minecraft.world.entity.Entity;

public class ModelWH40K_Misc_GunGrenade_1 extends ModelBase {
   int textureX = 32;
   int textureY = 32;
   public ModelRendererTurbo[] gungrenadeModel = new ModelRendererTurbo[1];

   public ModelWH40K_Misc_GunGrenade_1() {
      this.gungrenadeModel[0] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
      this.gungrenadeModel[0].addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
      this.gungrenadeModel[0].setRotationPoint(0.0F, -2.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for (int i = 0; i < 1; i++) {
         this.gungrenadeModel[i].render(f5);
      }
   }
}
