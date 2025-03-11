package com.wolff.armormod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ArmorMod.MOD_ID)
public class ArmorMod
{
    public static final String MOD_ID = "armormod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ArmorMod()
    {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.REGISTRY.register(eventBus);
        ModCreativeTabs.REGISTRY.register(eventBus);
    }
}
