//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.W44;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.wolffsmod.api.client.model.ModelBase;
import net.minecraft.world.entity.Entity;

public class ModelParachute extends ModelBase {
   int textureX = 256;
   int textureY = 128;
   public ModelRendererTurbo[] parachuteModel = new ModelRendererTurbo[36];

   public ModelParachute() {
      this.parachuteModel = new ModelRendererTurbo[36];
      this.parachuteModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
      this.parachuteModel[1] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
      this.parachuteModel[2] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
      this.parachuteModel[3] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
      this.parachuteModel[4] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
      this.parachuteModel[5] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
      this.parachuteModel[6] = new ModelRendererTurbo(this, 145, 1, this.textureX, this.textureY);
      this.parachuteModel[7] = new ModelRendererTurbo(this, 169, 1, this.textureX, this.textureY);
      this.parachuteModel[8] = new ModelRendererTurbo(this, 193, 1, this.textureX, this.textureY);
      this.parachuteModel[9] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
      this.parachuteModel[10] = new ModelRendererTurbo(this, 49, 25, this.textureX, this.textureY);
      this.parachuteModel[11] = new ModelRendererTurbo(this, 105, 25, this.textureX, this.textureY);
      this.parachuteModel[12] = new ModelRendererTurbo(this, 145, 25, this.textureX, this.textureY);
      this.parachuteModel[13] = new ModelRendererTurbo(this, 201, 25, this.textureX, this.textureY);
      this.parachuteModel[14] = new ModelRendererTurbo(this, 97, 33, this.textureX, this.textureY);
      this.parachuteModel[15] = new ModelRendererTurbo(this, 193, 33, this.textureX, this.textureY);
      this.parachuteModel[16] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
      this.parachuteModel[17] = new ModelRendererTurbo(this, 57, 49, this.textureX, this.textureY);
      this.parachuteModel[18] = new ModelRendererTurbo(this, 153, 49, this.textureX, this.textureY);
      this.parachuteModel[19] = new ModelRendererTurbo(this, 97, 57, this.textureX, this.textureY);
      this.parachuteModel[20] = new ModelRendererTurbo(this, 193, 57, this.textureX, this.textureY);
      this.parachuteModel[21] = new ModelRendererTurbo(this, 1, 65, this.textureX, this.textureY);
      this.parachuteModel[22] = new ModelRendererTurbo(this, 41, 65, this.textureX, this.textureY);
      this.parachuteModel[23] = new ModelRendererTurbo(this, 137, 65, this.textureX, this.textureY);
      this.parachuteModel[24] = new ModelRendererTurbo(this, 65, 73, this.textureX, this.textureY);
      this.parachuteModel[25] = new ModelRendererTurbo(this, 249, 33, this.textureX, this.textureY);
      this.parachuteModel[26] = new ModelRendererTurbo(this, 169, 73, this.textureX, this.textureY);
      this.parachuteModel[27] = new ModelRendererTurbo(this, 1, 81, this.textureX, this.textureY);
      this.parachuteModel[28] = new ModelRendererTurbo(this, 201, 81, this.textureX, this.textureY);
      this.parachuteModel[29] = new ModelRendererTurbo(this, 249, 73, this.textureX, this.textureY);
      this.parachuteModel[30] = new ModelRendererTurbo(this, 47, 81, this.textureX, this.textureY);
      this.parachuteModel[31] = new ModelRendererTurbo(this, 59, 81, this.textureX, this.textureY);
      this.parachuteModel[32] = new ModelRendererTurbo(this, 153, 81, this.textureX, this.textureY);
      this.parachuteModel[33] = new ModelRendererTurbo(this, 161, 81, this.textureX, this.textureY);
      this.parachuteModel[34] = new ModelRendererTurbo(this, 53, 81, this.textureX, this.textureY);
      this.parachuteModel[35] = new ModelRendererTurbo(this, 42, 81, this.textureX, this.textureY);
      this.parachuteModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 20, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[0].setRotationPoint(-10.0F, 65.0F, 28.0F);
      this.parachuteModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 20, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[1].setRotationPoint(-10.0F, 65.0F, -29.0F);
      this.parachuteModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[2].setRotationPoint(-29.0F, 65.0F, -10.0F);
      this.parachuteModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[3].setRotationPoint(28.0F, 65.0F, -10.0F);
      this.parachuteModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 18, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, -19.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, -19.0F, 0.0F, 1.0F);
      this.parachuteModel[4].setRotationPoint(-29.0F, 65.0F, 10.0F);
      this.parachuteModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 18, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 18.0F, 1.0F, 0.0F, -19.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 18.0F, 1.0F, 0.0F, -19.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[5].setRotationPoint(10.0F, 65.0F, 28.0F);
      this.parachuteModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 18, 0.0F, -19.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -19.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[6].setRotationPoint(-29.0F, 65.0F, -28.0F);
      this.parachuteModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 18, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, -19.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, -19.0F, 0.0F, 0.0F, 18.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[7].setRotationPoint(10.0F, 65.0F, -29.0F);
      this.parachuteModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[8].setRotationPoint(-28.0F, 65.0F, -10.0F);
      this.parachuteModel[8].flip = true;
      this.parachuteModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 13, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[9].setRotationPoint(-23.0F, 75.0F, -10.0F);
      this.parachuteModel[9].flip = true;
      this.parachuteModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 20, 1, 13, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[10].setRotationPoint(-10.0F, 75.0F, 10.0F);
      this.parachuteModel[10].flip = true;
      this.parachuteModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 20, 1, 5, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[11].setRotationPoint(-10.0F, 65.0F, 23.0F);
      this.parachuteModel[11].flip = true;
      this.parachuteModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 20, 1, 13, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F);
      this.parachuteModel[12].setRotationPoint(-10.0F, 75.0F, -23.0F);
      this.parachuteModel[12].flip = true;
      this.parachuteModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 20, 1, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 10.0F, 0.0F);
      this.parachuteModel[13].setRotationPoint(-10.0F, 65.0F, -28.0F);
      this.parachuteModel[13].flip = true;
      this.parachuteModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 13, 1, 20, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 0.0F);
      this.parachuteModel[14].setRotationPoint(10.0F, 75.0F, -10.0F);
      this.parachuteModel[14].flip = true;
      this.parachuteModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 20, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 0.0F);
      this.parachuteModel[15].setRotationPoint(23.0F, 65.0F, -10.0F);
      this.parachuteModel[15].flip = true;
      this.parachuteModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 13, 1, 13, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -13.0F, -13.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -13.0F, -13.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F);
      this.parachuteModel[16].setRotationPoint(10.0F, 75.0F, -23.0F);
      this.parachuteModel[16].flip = true;
      this.parachuteModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 13, 1, 13, 0.0F, -13.0F, 0.0F, 0.0F, 0.0F, -5.0F, -13.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.0F, 5.0F, -13.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[17].setRotationPoint(-23.0F, 75.0F, -23.0F);
      this.parachuteModel[17].flip = true;
      this.parachuteModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 13, 1, 13, 0.0F, 0.0F, -5.0F, 0.0F, -13.0F, -5.0F, 0.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 0.0F, -13.0F, 5.0F, 0.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[18].setRotationPoint(10.0F, 75.0F, 10.0F);
      this.parachuteModel[18].flip = true;
      this.parachuteModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 13, 1, 13, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, -13.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, -13.0F, -13.0F, 0.0F, 0.0F);
      this.parachuteModel[19].setRotationPoint(-23.0F, 75.0F, 10.0F);
      this.parachuteModel[19].flip = true;
      this.parachuteModel[20].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 13, 0.0F, -18.0F, 0.0F, 5.0F, 13.0F, -10.0F, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -18.0F, 0.0F, 5.0F, 13.0F, 10.0F, 0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[20].setRotationPoint(-28.0F, 65.0F, -23.0F);
      this.parachuteModel[20].flip = true;
      this.parachuteModel[21].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 13, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 13.0F, -10.0F, 0.0F, -18.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 0.0F, 13.0F, 10.0F, 0.0F, -18.0F, 0.0F, 5.0F);
      this.parachuteModel[21].setRotationPoint(-28.0F, 65.0F, 10.0F);
      this.parachuteModel[21].flip = true;
      this.parachuteModel[22].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 13, 0.0F, 13.0F, -10.0F, 0.0F, -18.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -10.0F, 0.0F, 13.0F, 10.0F, 0.0F, -18.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 0.0F);
      this.parachuteModel[22].setRotationPoint(23.0F, 65.0F, -23.0F);
      this.parachuteModel[22].flip = true;
      this.parachuteModel[23].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 13, 0.0F, 0.0F, -10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -18.0F, 0.0F, 5.0F, 13.0F, -10.0F, 0.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0F, -18.0F, 0.0F, 5.0F, 13.0F, 10.0F, 0.0F);
      this.parachuteModel[23].setRotationPoint(23.0F, 65.0F, 10.0F);
      this.parachuteModel[23].flip = true;
      this.parachuteModel[24].addShapeBox(0.0F, 0.0F, 0.0F, 20, 1, 20, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[24].setRotationPoint(-10.0F, 80.0F, -10.0F);
      this.parachuteModel[24].flip = true;
      this.parachuteModel[25].addShapeBox(0.0F, 0.0F, 0.0F, 1, 37, 1, 0.0F, -6.0F, 0.0F, -28.0F, 6.0F, 0.0F, -28.0F, 6.0F, 0.0F, 28.0F, -6.0F, 0.0F, 28.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[25].setRotationPoint(-10.0F, 28.0F, -29.0F);
      this.parachuteModel[26].addShapeBox(0.0F, 0.0F, 0.0F, 10, 7, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[26].setRotationPoint(-5.0F, 27.0F, -5.0F);
      this.parachuteModel[27].addShapeBox(0.0F, 0.0F, 0.0F, 10, 4, 10, 0.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[27].setRotationPoint(-5.0F, 23.0F, -5.0F);
      this.parachuteModel[28].addShapeBox(0.0F, 0.0F, 0.0F, 10, 2, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F);
      this.parachuteModel[28].setRotationPoint(-5.0F, 34.0F, -5.0F);
      this.parachuteModel[29].addShapeBox(0.0F, 0.0F, 0.0F, 1, 37, 1, 0.0F, 6.0F, 0.0F, -28.0F, -6.0F, 0.0F, -28.0F, -6.0F, 0.0F, 28.0F, 6.0F, 0.0F, 28.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[29].setRotationPoint(9.0F, 28.0F, -29.0F);
      this.parachuteModel[30].addShapeBox(0.0F, 0.0F, 0.0F, 1, 37, 1, 0.0F, -6.0F, 0.0F, 28.0F, 6.0F, 0.0F, 28.0F, 6.0F, 0.0F, -28.0F, -6.0F, 0.0F, -28.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[30].setRotationPoint(-10.0F, 28.0F, 28.0F);
      this.parachuteModel[31].addShapeBox(0.0F, 0.0F, 0.0F, 1, 37, 1, 0.0F, 6.0F, 0.0F, 28.0F, -6.0F, 0.0F, 28.0F, -6.0F, 0.0F, -28.0F, 6.0F, 0.0F, -28.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[31].setRotationPoint(9.0F, 28.0F, 28.0F);
      this.parachuteModel[32].addShapeBox(0.0F, 0.0F, 0.0F, 1, 37, 1, 0.0F, 28.0F, 0.0F, 6.0F, -28.0F, 0.0F, 6.0F, -28.0F, 0.0F, -6.0F, 28.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[32].setRotationPoint(28.0F, 28.0F, 9.0F);
      this.parachuteModel[33].addShapeBox(0.0F, 0.0F, 0.0F, 1, 37, 1, 0.0F, 28.0F, 0.0F, -6.0F, -28.0F, 0.0F, -6.0F, -28.0F, 0.0F, 6.0F, 28.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[33].setRotationPoint(28.0F, 28.0F, -10.0F);
      this.parachuteModel[34].addShapeBox(0.0F, 0.0F, 0.0F, 1, 37, 1, 0.0F, -28.0F, 0.0F, 6.0F, 28.0F, 0.0F, 6.0F, 28.0F, 0.0F, -6.0F, -28.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[34].setRotationPoint(-29.0F, 28.0F, 9.0F);
      this.parachuteModel[35].addShapeBox(0.0F, 0.0F, 0.0F, 1, 37, 1, 0.0F, -28.0F, 0.0F, -6.0F, 28.0F, 0.0F, -6.0F, 28.0F, 0.0F, 6.0F, -28.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.parachuteModel[35].setRotationPoint(-29.0F, 28.0F, -10.0F);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      for (ModelRendererTurbo part : this.parachuteModel) {
         part.render(f5);
      }
   }
}
