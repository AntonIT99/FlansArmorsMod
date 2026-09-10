//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.model.ModelFlash;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelW44MuzzleFlash extends ModelFlash {
   int textureX = 256;
   int textureY = 128;

   public ModelW44MuzzleFlash() {
      this.flashModel = new ModelRendererTurbo[3][1];
      this.flashModel[0][0] = new ModelRendererTurbo(this, 165, 2, this.textureX, this.textureY);
      this.flashModel[1][0] = new ModelRendererTurbo(this, 0, 2, this.textureX, this.textureY);
      this.flashModel[2][0] = new ModelRendererTurbo(this, 80, 0, this.textureX, this.textureY);
      this.flashModel[0][0].addShapeBox(0.0F, -8.0F, -0.5F, 1, 35, 35, 0.0F, -0.45F, -13.0F, -13.0F, -0.45F, -13.0F, -13.0F, -0.45F, -13.0F, -13.0F, -0.45F, -13.0F, -13.0F, -0.45F, -13.0F, -13.0F, -0.45F, -13.0F, -13.0F, -0.45F, -13.0F, -13.0F, -0.45F, -13.0F, -13.0F);
      this.flashModel[0][0].setRotationPoint(-0.5F, -9.5F, -17.0F);
      this.flashModel[1][0].addShapeBox(0.0F, -8.0F, -0.5F, 1, 35, 35, 0.0F, -0.45F, -13.25F, -13.25F, -0.45F, -13.25F, -13.25F, -0.45F, -13.25F, -13.25F, -0.45F, -13.25F, -13.25F, -0.45F, -13.25F, -13.25F, -0.45F, -13.25F, -13.25F, -0.45F, -13.25F, -13.25F, -0.45F, -13.25F, -13.25F);
      this.flashModel[1][0].setRotationPoint(-0.5F, -9.5F, -17.0F);
      this.flashModel[2][0].addShapeBox(0.0F, -8.0F, -0.5F, 1, 35, 35, 0.0F, -0.45F, -12.0F, -12.0F, -0.45F, -12.0F, -12.0F, -0.45F, -12.0F, -12.0F, -0.45F, -12.0F, -12.0F, -0.45F, -12.0F, -12.0F, -0.45F, -12.0F, -12.0F, -0.45F, -12.0F, -12.0F, -0.45F, -12.0F, -12.0F);
      this.flashModel[2][0].setRotationPoint(-0.5F, -9.5F, -17.0F);
      this.flipAll();
   }
}
