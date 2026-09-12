package com.flansmodultimate.mixin;

import com.flansmodultimate.config.ModCommonConfig;
import net.minecraftforge.client.ForgeHooksClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

@Mixin(EntityRenderer.class)
public abstract class EntityNameTagRenderDistanceMixin
{
    @Redirect(method = "renderNameTag", at = @At(value = "INVOKE",
        target = "Lnet/minecraftforge/client/ForgeHooksClient;isNameplateInRenderDistance(Lnet/minecraft/world/entity/Entity;D)Z",
        remap = false))
    private boolean flansmodultimate$nameTagRenderDistance(Entity entity, double squareDistance)
    {
        if (!(entity instanceof LivingEntity livingEntity))
            return ForgeHooksClient.isNameplateInRenderDistance(entity, squareDistance);

        float range = ModCommonConfig.nameTagRenderRange(livingEntity.isDiscrete());
        return squareDistance < (double)(range * range);
    }
}
