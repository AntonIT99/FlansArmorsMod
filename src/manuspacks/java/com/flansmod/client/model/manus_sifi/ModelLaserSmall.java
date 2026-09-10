//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "D:\Minecraft\Dev Tools\Deobfuscator\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

package com.flansmod.client.model.manus_sifi;

import org.lwjgl.opengl.GL11;

import com.wolffsmod.api.client.model.ModelBase;
import com.wolffsmod.api.client.model.ModelRenderer;

import net.minecraft.world.entity.Entity;

public class ModelLaserSmall extends ModelBase {
   public ModelRenderer laserSmallModel = new ModelRenderer(this, 0, 0);

   public ModelLaserSmall() {
      this.laserSmallModel.addBox(-1.0F, -8.0F, -1.0F, 2, 16, 2);
   }

   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      this.laserSmallModel.render(f5);
   }
}
