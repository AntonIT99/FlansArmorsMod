package com.wolff.armormod.client;

import com.flansmod.client.model.ModelCustomArmour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.model.ModelManager;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler
{
    private ClientEventHandler() {}

    @SubscribeEvent
    public static void registerArmorLayer(EntityRenderersEvent.AddLayers event)
    {
        ModelManager modelManager = Minecraft.getInstance().getModelManager();
        EntityModelSet modelSet = event.getEntityModels();

        if (ModelCustomArmour.ROOT == null)
        {
            ModelCustomArmour.ROOT = modelSet.bakeLayer(ModModelLayers.CUSTOM_ARMOR);
        }

        for (String skin : event.getSkins())
        {
            LivingEntityRenderer<?, ?> renderer = event.getSkin(skin);
            if (renderer instanceof PlayerRenderer playerRenderer)
            {
                playerRenderer.addLayer(new CustomArmorLayer<>(playerRenderer, modelManager));
            }
        }
    }
}
