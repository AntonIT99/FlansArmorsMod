//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.Manus_WH40K.Misc;

import org.lwjgl.opengl.GL11;

import com.wolffsmod.api.client.model.ModelBase;
import com.wolffsmod.api.client.model.ModelRenderer;

import net.minecraft.world.entity.Entity;

public class ModelWH40K_Misc_Laser_1 extends ModelBase {
   public ModelRenderer laserModel = new ModelRenderer(this, 0, 0);

   public ModelWH40K_Misc_Laser_1() {
      this.laserModel.addBox(-1.5F, -16.0F, -1.5F, 3, 32, 3);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      this.laserModel.render(f5);
   }
}
