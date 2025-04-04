package com.wolffsarmormod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.common.CustomArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = ArmorMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class OverlayEventHandler
{
    @SubscribeEvent
    public static void onRenderGuiOverlay(RenderGuiOverlayEvent.Post event)
    {
        //TODO: Fix transparency and put it in background
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player == null) return;

        GuiGraphics guiGraphics = event.getGuiGraphics();
        int screenWidth = mc.getWindow().getGuiScaledWidth();
        int screenHeight = mc.getWindow().getGuiScaledHeight();

        for (EquipmentSlot slot : Arrays.stream(EquipmentSlot.values()).filter(EquipmentSlot::isArmor).toList())
        {
            if (player.getItemBySlot(slot).getItem() instanceof CustomArmorItem armorItem && armorItem.getOverlay().isPresent())
            {
                ResourceLocation texture = armorItem.getOverlay().get();

                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderTexture(0, texture);
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.2F);

                guiGraphics.blit(texture, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);

                RenderSystem.disableBlend();
            }
        }
    }
}
