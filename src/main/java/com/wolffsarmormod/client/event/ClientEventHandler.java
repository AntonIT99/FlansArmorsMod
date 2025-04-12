package com.wolffsarmormod.client.event;

import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.ContentManager;
import com.wolffsarmormod.client.CustomArmorLayer;
import com.wolffsarmormod.client.ModRepositorySource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;

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
            try
            {
                EntityRenderer<?> renderer = event.getRenderer((EntityType)entityType);

                if (renderer instanceof LivingEntityRenderer<?, ?> livingEntityRenderer && livingEntityRenderer.getModel() instanceof HumanoidModel)
                {
                    livingEntityRenderer.addLayer(new CustomArmorLayer<>((RenderLayerParent) livingEntityRenderer));
                }
            }
            catch (ClassCastException e)
            {
                // Ignoring (Entity is not a LivingEntity)
            }
            catch (Exception e)
            {
                ArmorMod.log.error("Could not add armor layer to {}", entityType.getDescriptionId(), e);
            }
        }
    }
}
