package com.wolff.armormod.item;

import com.wolff.armormod.ArmorMod;
import com.wolff.armormod.CustomArmorMaterial;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class ModItems
{
    private ModItems() {}

    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ArmorMod.MOD_ID);

    public static final RegistryObject<Item> CUSTOM_HELMET = REGISTRY.register("custom_helmet", () -> new CustomArmorItem(CustomArmorMaterial.CUSTOM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CUSTOM_CHESTPLATE = REGISTRY.register("custom_chestplate", () -> new CustomArmorItem(CustomArmorMaterial.CUSTOM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CUSTOM_LEGGINGS = REGISTRY.register("custom_leggings", () -> new CustomArmorItem(CustomArmorMaterial.CUSTOM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CUSTOM_BOOTS = REGISTRY.register("custom_boots", () -> new CustomArmorItem(CustomArmorMaterial.CUSTOM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        REGISTRY.register(eventBus);
    }
}
