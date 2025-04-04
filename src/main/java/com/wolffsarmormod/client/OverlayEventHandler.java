package com.wolffsarmormod.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.common.CustomArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.client.CameraType;
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
    public static void onRenderGuiOverlay(RenderGuiOverlayEvent.Pre event)
    {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player == null || mc.options.getCameraType() != CameraType.FIRST_PERSON || event.getOverlay() != VanillaGuiOverlay.HOTBAR.type())
        {
            return;
        }

        GuiGraphics guiGraphics = event.getGuiGraphics();
        int screenWidth = mc.getWindow().getGuiScaledWidth();
        int screenHeight = mc.getWindow().getGuiScaledHeight();

        for (EquipmentSlot slot : Arrays.stream(EquipmentSlot.values()).filter(EquipmentSlot::isArmor).toList())
        {
            if (player.getItemBySlot(slot).getItem() instanceof CustomArmorItem armorItem && armorItem.getOverlay().isPresent())
            {
                ResourceLocation overlayTexture = armorItem.getOverlay().get();

                RenderSystem.disableDepthTest();
                RenderSystem.depthMask(false);
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.disableCull();
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderTexture(0, overlayTexture);

                guiGraphics.blit(overlayTexture, 0, 0, 0, 0, screenWidth, screenHeight, screenWidth, screenHeight);

                RenderSystem.depthMask(true);
                RenderSystem.enableDepthTest();
                RenderSystem.enableCull();
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }
}
