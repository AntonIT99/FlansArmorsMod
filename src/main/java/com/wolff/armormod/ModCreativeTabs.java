package com.wolff.armormod;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs
{
    private ModCreativeTabs() {}

    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArmorMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = REGISTRY.register("custom_tab", () -> CreativeModeTab.builder()
        .title(Component.translatable("creativetab.custom_tab"))
        .icon(() -> new ItemStack(ModItems.CUSTOM_HELMET.get()))
        .displayItems((parameters, output) -> {
            output.accept(ModItems.CUSTOM_HELMET.get());
            output.accept(ModItems.CUSTOM_CHESTPLATE.get());
            output.accept(ModItems.CUSTOM_LEGGINGS.get());
            output.accept(ModItems.CUSTOM_BOOTS.get());
        })
        .withSearchBar()
        .build());
}
