//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WH40K.Attachment;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelWH40K_Attachment_MKVbBoltgun_2 extends ModelAttachment {
   int textureX = 512;
   int textureY = 512;

   public ModelWH40K_Attachment_MKVbBoltgun_2() {
      this.attachmentModel = new ModelRendererTurbo[6];
      this.attachmentModel[0] = new ModelRendererTurbo(this, 0, 100, this.textureX, this.textureY);
      this.attachmentModel[1] = new ModelRendererTurbo(this, 46, 100, this.textureX, this.textureY);
      this.attachmentModel[2] = new ModelRendererTurbo(this, 92, 100, this.textureX, this.textureY);
      this.attachmentModel[3] = new ModelRendererTurbo(this, 0, 130, this.textureX, this.textureY);
      this.attachmentModel[4] = new ModelRendererTurbo(this, 145, 130, this.textureX, this.textureY);
      this.attachmentModel[5] = new ModelRendererTurbo(this, 292, 130, this.textureX, this.textureY);
      this.attachmentModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 4, 5, 18, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.attachmentModel[0].setRotationPoint(0.0F, -9.0F, -9.0F);
      this.attachmentModel[1].addBox(0.0F, 0.0F, 0.0F, 4, 8, 18, 0.0F);
      this.attachmentModel[1].setRotationPoint(0.0F, -4.0F, -9.0F);
      this.attachmentModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 4, 5, 18, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F);
      this.attachmentModel[2].setRotationPoint(0.0F, 4.0F, -9.0F);
      this.attachmentModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 51, 6, 21, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.attachmentModel[3].setRotationPoint(4.0F, -10.5F, -10.5F);
      this.attachmentModel[4].addBox(0.0F, 0.0F, 0.0F, 51, 9, 21, 0.0F);
      this.attachmentModel[4].setRotationPoint(4.0F, -4.5F, -10.5F);
      this.attachmentModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 51, 6, 21, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F);
      this.attachmentModel[5].setRotationPoint(4.0F, 4.5F, -10.5F);
      this.flipAll();
   }
}
