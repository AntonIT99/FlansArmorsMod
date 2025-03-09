package com.wolff.armormod;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import static com.wolff.armormod.ArmorMod.MOD_ID;

public class ModModelLayers
{
    public static final ModelLayerLocation CUSTOM_ARMOR = new ModelLayerLocation(new ResourceLocation(MOD_ID, "custom_armor"), "main");
}
