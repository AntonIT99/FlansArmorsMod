//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WH40K.Attachment;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelWH40K_Attachment_M36Bayonett_1 extends ModelAttachment {
   int textureX = 512;
   int textureY = 512;

   public ModelWH40K_Attachment_M36Bayonett_1() {
      this.attachmentModel = new ModelRendererTurbo[5];
      this.attachmentModel[0] = new ModelRendererTurbo(this, 0, 308, this.textureX, this.textureY);
      this.attachmentModel[1] = new ModelRendererTurbo(this, 33, 313, this.textureX, this.textureY);
      this.attachmentModel[2] = new ModelRendererTurbo(this, 116, 299, this.textureX, this.textureY);
      this.attachmentModel[3] = new ModelRendererTurbo(this, 148, 306, this.textureX, this.textureY);
      this.attachmentModel[4] = new ModelRendererTurbo(this, 148, 315, this.textureX, this.textureY);
      this.attachmentModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 6, 12, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.attachmentModel[0].setRotationPoint(0.0F, 5.0F, -5.0F);
      this.attachmentModel[1].addBox(0.0F, 0.0F, 0.0F, 33, 9, 8, 0.0F);
      this.attachmentModel[1].setRotationPoint(5.0F, 5.0F, -4.0F);
      this.attachmentModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 5, 22, 10, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F);
      this.attachmentModel[2].setRotationPoint(34.0F, 1.0F, -5.0F);
      this.attachmentModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 85, 6, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.attachmentModel[3].setRotationPoint(39.0F, 4.0F, -1.0F);
      this.attachmentModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 85, 10, 2, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -25.0F, 0.0F, 0.0F, -25.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.attachmentModel[4].setRotationPoint(39.0F, 10.0F, -1.0F);
      this.renderOffset = 0.0F;
      this.flipAll();
   }
}
