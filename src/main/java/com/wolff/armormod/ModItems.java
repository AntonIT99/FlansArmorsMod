package com.wolff.armormod;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class ModItems
{
    private ModItems() {}

    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ArmorMod.MOD_ID);

    public static final RegistryObject<Item> CUSTOM_HELMET = REGISTRY.register("custom_helmet", () -> new CustomArmorItem(ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> CUSTOM_CHESTPLATE = REGISTRY.register("custom_chestplate", () -> new CustomArmorItem(ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> CUSTOM_LEGGINGS = REGISTRY.register("custom_leggings", () -> new CustomArmorItem(ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> CUSTOM_BOOTS = REGISTRY.register("custom_boots", () -> new CustomArmorItem(ArmorItem.Type.BOOTS));
}
