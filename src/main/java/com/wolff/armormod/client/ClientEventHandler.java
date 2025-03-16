package com.wolff.armormod.client;

import com.flansmod.client.model.ModelCustomArmour;
import com.wolff.armormod.ArmorMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;

@Mod.EventBusSubscriber(modid = ArmorMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler
{
    private ClientEventHandler() {}

    //TODO: make dynamic
    public static final ResourceLocation TEXTURE = new ResourceLocation(ArmorMod.MOD_ID, "");
    //public static final ResourceLocation TEXTURE = new ResourceLocation(ArmorMod.MOD_ID, "armor/exoskeleton_1.png");
    public static final ModelLayerLocation CUSTOM_ARMOR = new ModelLayerLocation(TEXTURE, "main");

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        // Client Setup
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(CUSTOM_ARMOR, ModelCustomArmour::createLayer);
    }

    @SubscribeEvent
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
    }
}
