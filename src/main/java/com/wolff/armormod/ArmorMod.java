package com.wolff.armormod;

import com.flansmod.client.model.ModelCustomArmour;
import com.mojang.logging.LogUtils;
import com.wolff.armormod.item.ModItems;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ArmorMod.MOD_ID)
public class ArmorMod {
    public static final String MOD_ID = "armormod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ArmorMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register items (armor pieces)
        ModItems.register(modEventBus);

        // Register model layers for custom armor rendering
        modEventBus.addListener(this::registerLayerDefinitions);
    }

    private void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CUSTOM_ARMOR, ModelCustomArmour::createBodyLayer);
    }
}
