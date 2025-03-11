package com.wolff.armormod.client;

import com.flansmod.client.model.ModelCustomArmour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.wolff.armormod.ArmorMod.MOD_ID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler
{
    private ClientEventHandler() {}

    public static final ModelLayerLocation CUSTOM_ARMOR = new ModelLayerLocation(new ResourceLocation(MOD_ID, "custom_armor"), "main");

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(CUSTOM_ARMOR, ModelCustomArmour::createLayer);
    }

    @SubscribeEvent
    public static void registerArmorLayer(EntityRenderersEvent.AddLayers event)
    {
        if (ModelCustomArmour.ROOT == null)
        {
            ModelCustomArmour.ROOT = event.getEntityModels().bakeLayer(CUSTOM_ARMOR);
        }

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
