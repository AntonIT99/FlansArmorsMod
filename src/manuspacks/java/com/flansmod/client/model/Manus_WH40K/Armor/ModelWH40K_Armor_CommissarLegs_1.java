package com.flansmod.client.model.Manus_WH40K.Armor;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;

public class ModelWH40K_Armor_CommissarLegs_1 extends ModelCustomArmour {
   int textureX = 512;
   int textureY = 512;

   public ModelWH40K_Armor_CommissarLegs_1() {
      this.bodyModel = new ModelRendererTurbo[1];
      this.bodyModel[0] = new ModelRendererTurbo(this, 416, 404, this.textureX, this.textureY);
      this.bodyModel[0].addShapeBox(-16.0F, 36.0F, -8.0F, 32, 12, 16, 0.0F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F);
      this.leftLegModel = new ModelRendererTurbo[1];
      this.leftLegModel[0] = new ModelRendererTurbo(this, 355, 456, this.textureX, this.textureY);
      this.leftLegModel[0].addShapeBox(-8.0F, 0.0F, -8.0F, 16, 40, 16, 0.0F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F);
      this.rightLegModel = new ModelRendererTurbo[1];
      this.rightLegModel[0] = new ModelRendererTurbo(this, 423, 456, this.textureX, this.textureY);
      this.rightLegModel[0].addShapeBox(-8.0F, 0.0F, -8.0F, 16, 40, 16, 0.0F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F);
   }
}
