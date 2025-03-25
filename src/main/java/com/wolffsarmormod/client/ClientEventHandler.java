package com.wolffsarmormod.client;

import com.wolffsarmormod.ArmorMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

import java.nio.file.Files;

@Mod.EventBusSubscriber(modid = ArmorMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler
{
    private ClientEventHandler() {}

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        // Client Setup
    }

    @SubscribeEvent
    public static void registerPack(AddPackFindersEvent event)
    {
        if (Files.exists(ArmorMod.flanPath))
        {
            event.addRepositorySource(new ModRepositorySource(ArmorMod.flanPath));
        }
        else if (Files.exists(ArmorMod.fallbackFlanPath))
        {
            event.addRepositorySource(new ModRepositorySource(ArmorMod.fallbackFlanPath));
        }
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

        for (EntityType<?> entityType : ForgeRegistries.ENTITY_TYPES.getValues())
        {
            if (LivingEntity.class.isAssignableFrom(entityType.getBaseClass()))
            {
                @SuppressWarnings("unchecked")
                EntityType<? extends LivingEntity> livingEntityType = (EntityType<? extends LivingEntity>) entityType;
                EntityRenderer<? extends LivingEntity> renderer = event.getRenderer(livingEntityType);

                if (renderer instanceof HumanoidMobRenderer<?, ?>)
                {
                    @SuppressWarnings("unchecked")
                    HumanoidMobRenderer<Mob, HumanoidModel<Mob>> humanoidRenderer = (HumanoidMobRenderer<Mob, HumanoidModel<Mob>>) renderer;
                    humanoidRenderer.addLayer(new CustomArmorLayer<>(humanoidRenderer, Minecraft.getInstance().getModelManager()));
                }
            }
        }

    }
}
