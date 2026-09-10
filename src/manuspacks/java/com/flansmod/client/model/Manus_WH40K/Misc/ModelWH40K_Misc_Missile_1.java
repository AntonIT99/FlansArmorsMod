//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WH40K.Misc;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.wolffsmod.api.client.model.ModelBase;
import net.minecraft.world.entity.Entity;

public class ModelWH40K_Misc_Missile_1 extends ModelBase {
   int textureX = 64;
   int textureY = 32;
   public ModelRendererTurbo[] hvarModel = new ModelRendererTurbo[4];

   public ModelWH40K_Misc_Missile_1() {
      this.hvarModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.hvarModel[1] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
      this.hvarModel[2] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
      this.hvarModel[3] = new ModelRendererTurbo(this, 17, 9, this.textureX, this.textureY);
      this.hvarModel[0].addShapeBox(-1.0F, -10.0F, -1.0F, 2, 20, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.hvarModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.hvarModel[1].addTrapezoid(-1.0F, 10.0F, -1.0F, 2, 3, 2, 0.0F, -1.0F, 5);
      this.hvarModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.hvarModel[2].addShapeBox(-2.0F, -10.0F, -2.0F, 4, 2, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.9F);
      this.hvarModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.hvarModel[3].addShapeBox(-2.0F, -10.0F, -2.0F, 4, 2, 4, 0.0F, 0.0F, 0.0F, -3.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.9F, 0.0F, 0.0F, 0.0F);
      this.hvarModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for (int i = 0; i < 4; i++) {
         this.hvarModel[i].render(f5);
      }
   }
}
