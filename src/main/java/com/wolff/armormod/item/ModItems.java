package com.wolff.armormod.item;

import com.wolff.armormod.CustomArmorMaterial;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, "modid");

    public static final RegistryObject<Item> CUSTOM_HELMET = ITEMS.register("custom_helmet", () -> new CustomArmorItem(CustomArmorMaterial.CUSTOM, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> CUSTOM_CHESTPLATE = ITEMS.register("custom_chestplate", () -> new CustomArmorItem(CustomArmorMaterial.CUSTOM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> CUSTOM_LEGGINGS = ITEMS.register("custom_leggings", () -> new CustomArmorItem(CustomArmorMaterial.CUSTOM, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> CUSTOM_BOOTS = ITEMS.register("custom_boots", () -> new CustomArmorItem(CustomArmorMaterial.CUSTOM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
