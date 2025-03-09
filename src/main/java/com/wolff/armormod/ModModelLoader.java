package com.wolff.armormod;

import com.flansmod.client.model.ModelCustomArmour;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ModModelLoader
{
    private static final Map<ArmorItem, ModelCustomArmour> MODELS = new HashMap<>();

    public static void registerArmorModel(ArmorItem item, ModelCustomArmour model) {
        MODELS.put(item, model);
    }

    public static ModelCustomArmour getModelForArmor(Item item) {
        return MODELS.getOrDefault(item, null); // Default to null if no custom model is found
    }
}
