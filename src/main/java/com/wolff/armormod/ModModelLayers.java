package com.wolff.armormod;

import com.flansmod.client.model.ModelCustomArmour;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;

import static com.wolff.armormod.ArmorMod.MOD_ID;

public class ModModelLayers
{
    private ModModelLayers() {}

    public static final ModelLayerLocation CUSTOM_ARMOR = new ModelLayerLocation(new ResourceLocation(MOD_ID, "custom_armor"), "main");

    public static LayerDefinition createCustomArmorLayer()
    {
        return ModelCustomArmour.createBodyLayer();
    }
}
