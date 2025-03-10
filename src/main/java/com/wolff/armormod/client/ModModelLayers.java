package com.wolff.armormod.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import static com.wolff.armormod.ArmorMod.MOD_ID;

@OnlyIn(Dist.CLIENT)
public class ModModelLayers
{
    private ModModelLayers() {}

    public static final ModelLayerLocation CUSTOM_ARMOR = new ModelLayerLocation(new ResourceLocation(MOD_ID, "custom_armor"), "main");
}
