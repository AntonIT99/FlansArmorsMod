package com.wolffsarmormod.event;

import com.wolffsarmormod.ArmorMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ArmorMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEventHandler
{
    private  CommonEventHandler() {}

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event)
    {
        // Common Setup
    }
}
