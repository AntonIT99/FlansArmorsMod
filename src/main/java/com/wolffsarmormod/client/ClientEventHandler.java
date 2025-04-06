package com.wolffsarmormod.client;

import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.ContentManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

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
        if (Files.exists(ContentManager.flanFolder))
        {
            event.addRepositorySource(new ModRepositorySource(ContentManager.flanFolder));
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SubscribeEvent
    public static void registerArmorLayer(EntityRenderersEvent.AddLayers event)
    {
        for (String skin : event.getSkins())
        {
            LivingEntityRenderer<?, ?> renderer = event.getSkin(skin);
            if (renderer instanceof PlayerRenderer playerRenderer)
            {
                playerRenderer.addLayer(new CustomArmorLayer<>(playerRenderer));
            }
        }

        for (EntityType<?> entityType : ForgeRegistries.ENTITY_TYPES.getValues())
        {
            if (LivingEntity.class.isAssignableFrom(entityType.getBaseClass()))
            {

                EntityType<? extends LivingEntity> livingEntityType = (EntityType<? extends LivingEntity>) entityType;
                EntityRenderer<? extends LivingEntity> renderer = event.getRenderer(livingEntityType);

                if (renderer instanceof LivingEntityRenderer<?, ?> livingEntityRenderer)
                {
                    livingEntityRenderer.addLayer(new CustomArmorLayer<>((RenderLayerParent) livingEntityRenderer));
                }
            }
        }
    }
}
