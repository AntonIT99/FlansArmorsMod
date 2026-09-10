//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.manus_modern_warfare;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.wolffsmod.api.client.model.ModelBase;
import net.minecraft.world.entity.Entity;

public class ModelLargeBomb extends ModelBase {
   int textureX = 128;
   int textureY = 64;
   public ModelRendererTurbo[] missleModel = new ModelRendererTurbo[5];

   public ModelLargeBomb() {
      this.missleModel[0] = new ModelRendererTurbo(this, 9, 0, this.textureX, this.textureY);
      this.missleModel[1] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
      this.missleModel[2] = new ModelRendererTurbo(this, 18, 0, this.textureX, this.textureY);
      this.missleModel[3] = new ModelRendererTurbo(this, 18, 10, this.textureX, this.textureY);
      this.missleModel[4] = new ModelRendererTurbo(this, 18, 15, this.textureX, this.textureY);
      this.missleModel[0].addTrapezoid(-3.0F, 0.0F, -3.0F, 6, 10, 6, 0.0F, -2.0F, 4);
      this.missleModel[1].addBox(-3.0F, 10.0F, -3.0F, 6, 16, 6, 0.0F);
      this.missleModel[2].addTrapezoid(-3.0F, 26.0F, -3.0F, 6, 3, 6, 0.0F, -1.5F, 4);
      this.missleModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 10, 4, 1, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F);
      this.missleModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.missleModel[3].rotateAngleY = (float) (-Math.PI / 4);
      this.missleModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 10, 4, 1, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F);
      this.missleModel[4].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.missleModel[4].rotateAngleY = (float) (Math.PI / 4);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for (int i = 0; i < 5; i++) {
         this.missleModel[i].render(f5);
      }
   }
}
