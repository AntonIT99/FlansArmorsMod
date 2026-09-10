//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;

public class ModelPistolBarrel extends ModelAttachment {
   int textureX = 256;
   int textureY = 64;

   public ModelPistolBarrel() {
      this.attachmentModel = new ModelRendererTurbo[21];
      this.attachmentModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.attachmentModel[1] = new ModelRendererTurbo(this, 145, 1, this.textureX, this.textureY);
      this.attachmentModel[2] = new ModelRendererTurbo(this, 169, 1, this.textureX, this.textureY);
      this.attachmentModel[3] = new ModelRendererTurbo(this, 185, 1, this.textureX, this.textureY);
      this.attachmentModel[4] = new ModelRendererTurbo(this, 201, 1, this.textureX, this.textureY);
      this.attachmentModel[5] = new ModelRendererTurbo(this, 1, 9, this.textureX, this.textureY);
      this.attachmentModel[6] = new ModelRendererTurbo(this, 233, 1, this.textureX, this.textureY);
      this.attachmentModel[7] = new ModelRendererTurbo(this, 33, 9, this.textureX, this.textureY);
      this.attachmentModel[8] = new ModelRendererTurbo(this, 249, 1, this.textureX, this.textureY);
      this.attachmentModel[9] = new ModelRendererTurbo(this, 49, 9, this.textureX, this.textureY);
      this.attachmentModel[10] = new ModelRendererTurbo(this, 121, 9, this.textureX, this.textureY);
      this.attachmentModel[11] = new ModelRendererTurbo(this, 193, 9, this.textureX, this.textureY);
      this.attachmentModel[12] = new ModelRendererTurbo(this, 209, 9, this.textureX, this.textureY);
      this.attachmentModel[13] = new ModelRendererTurbo(this, 225, 9, this.textureX, this.textureY);
      this.attachmentModel[14] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
      this.attachmentModel[15] = new ModelRendererTurbo(this, 9, 17, this.textureX, this.textureY);
      this.attachmentModel[16] = new ModelRendererTurbo(this, 233, 17, this.textureX, this.textureY);
      this.attachmentModel[17] = new ModelRendererTurbo(this, 25, 25, this.textureX, this.textureY);
      this.attachmentModel[18] = new ModelRendererTurbo(this, 249, 17, this.textureX, this.textureY);
      this.attachmentModel[19] = new ModelRendererTurbo(this, 97, 25, this.textureX, this.textureY);
      this.attachmentModel[20] = new ModelRendererTurbo(this, 105, 25, this.textureX, this.textureY);
      this.attachmentModel[0].addShapeBox(0.01F, -1.5F, -1.5F, 65, 3, 3, 0.0F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F);
      this.attachmentModel[0].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[1].addShapeBox(65.0F, -1.5F, -1.5F, 9, 1, 3, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F);
      this.attachmentModel[1].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[2].addShapeBox(65.0F, -1.9F, -0.5F, 5, 1, 1, 0.0F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F);
      this.attachmentModel[2].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[3].addShapeBox(65.0F, -4.5F, -0.5F, 5, 3, 1, 0.0F, -1.4F, 0.3F, -0.3F, -1.4F, 0.0F, -0.3F, -1.4F, 0.0F, -0.3F, -1.4F, 0.3F, -0.3F, -0.4F, 0.3F, -0.1F, -0.4F, 0.3F, -0.1F, -0.4F, 0.3F, -0.1F, -0.4F, 0.3F, -0.1F);
      this.attachmentModel[3].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[4].addShapeBox(65.0F, -0.5F, -1.5F, 9, 1, 3, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F);
      this.attachmentModel[4].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[5].addShapeBox(65.0F, 0.5F, -1.5F, 9, 1, 3, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F);
      this.attachmentModel[5].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[6].addShapeBox(1.0F, -0.5F, -0.5F, 3, 12, 1, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F);
      this.attachmentModel[6].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[7].addShapeBox(4.0F, -0.5F, -0.5F, 3, 12, 1, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, -1.0F, 0.1F, 0.0F, -1.0F, 0.1F, 0.0F, 0.0F, 0.1F);
      this.attachmentModel[7].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[8].addShapeBox(0.0F, -0.5F, -0.5F, 1, 12, 1, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 1.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 1.0F, 0.1F);
      this.attachmentModel[8].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[9].addShapeBox(8.0F, -0.5F, -0.5F, 32, 7, 1, 0.0F, 0.0F, 0.0F, 0.1F, 2.0F, -0.1F, 0.1F, 2.0F, -0.1F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, -4.0F, 0.1F, 0.0F, -4.0F, 0.1F, 0.0F, 0.0F, 0.1F);
      this.attachmentModel[9].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[10].addShapeBox(8.0F, -0.5F, 0.5F, 32, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, -0.1F, -0.1F, 2.0F, -1.1F, -0.1F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, -0.1F, 0.0F, -5.0F, -0.1F, 0.0F, -1.0F, 0.0F);
      this.attachmentModel[10].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[11].addShapeBox(4.0F, -0.5F, 0.5F, 3, 12, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -1.0F, 0.0F);
      this.attachmentModel[11].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[12].addShapeBox(1.0F, -0.5F, 0.5F, 3, 12, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F);
      this.attachmentModel[12].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[13].addShapeBox(0.0F, -0.5F, 0.5F, 1, 12, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.attachmentModel[13].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[14].addShapeBox(0.0F, -0.5F, -1.5F, 1, 12, 1, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
      this.attachmentModel[14].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[15].addShapeBox(1.0F, -0.5F, -1.5F, 3, 12, 1, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.attachmentModel[15].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[16].addShapeBox(4.0F, -0.5F, -1.5F, 3, 12, 1, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.attachmentModel[16].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[17].addShapeBox(8.0F, -0.5F, -1.5F, 32, 7, 1, 0.0F, 0.0F, -1.0F, 0.0F, 2.0F, -1.1F, -0.1F, 2.0F, -0.1F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -5.0F, -0.1F, 0.0F, -4.0F, -0.1F, 0.0F, 0.0F, 0.0F);
      this.attachmentModel[17].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[18].addShapeBox(7.0F, -0.5F, 0.5F, 1, 11, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -1.0F, 0.0F);
      this.attachmentModel[18].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[19].addShapeBox(7.0F, -0.5F, -0.5F, 1, 11, 1, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, -2.0F, 0.1F, 0.0F, -2.0F, 0.1F, 0.0F, 0.0F, 0.1F);
      this.attachmentModel[19].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentModel[20].addShapeBox(7.0F, -0.5F, -1.5F, 1, 11, 1, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.attachmentModel[20].setRotationPoint(0.0F, 0.0F, 0.0F);
      this.attachmentFlashOffset = new Vector3f(0.875F, 0.0F, 0.0F);
      this.flipAll();
   }
}
