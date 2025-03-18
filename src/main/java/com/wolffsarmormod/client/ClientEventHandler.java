package com.wolffsarmormod.client;

import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.common.ICustomIconItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.item.Item;

@Mod.EventBusSubscriber(modid = ArmorMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler
{
    private ClientEventHandler() {}

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        // Client Setup
        for (RegistryObject<Item> item : ArmorMod.items)
        {
            if (item.get() instanceof ICustomIconItem customIconItem)
                customIconItem.loadIcon();
        }
    }

    /*@SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(getCustomArmorLayerLocation(), ModelCustomArmour::createLayer);
    }*/

    /*@SubscribeEvent
    public static void registerArmorLayer(EntityRenderersEvent.AddLayers event)
    {
        for (String skin : event.getSkins())
        {
            LivingEntityRenderer<?, ?> renderer = event.getSkin(skin);
            if (renderer instanceof PlayerRenderer playerRenderer)
            {
                playerRenderer.addLayer(new CustomArmorLayer<>(playerRenderer, Minecraft.getInstance().getModelManager()));
            }
        }
    }*/

    /*public static ModelLayerLocation getCustomArmorLayerLocation()
    {
        return new ModelLayerLocation(new ResourceLocation(ArmorMod.MOD_ID, ""), "main"); //new ResourceLocation(ArmorMod.MOD_ID, "");
    }*/
}
