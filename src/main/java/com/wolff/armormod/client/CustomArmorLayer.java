package com.wolff.armormod.client;

import com.flansmod.client.model.ModelCustomArmour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

import static com.wolff.armormod.client.ClientEventHandler.TEXTURE;

@OnlyIn(Dist.CLIENT)
public class CustomArmorLayer<T extends LivingEntity, M extends HumanoidModel<T>> extends HumanoidArmorLayer<T, M, HumanoidModel<T>>
{

    @SuppressWarnings("unchecked")
    public CustomArmorLayer(RenderLayerParent<T, M> parent, ModelManager modelManager)
    {
        super(parent, (HumanoidModel<T>) new ModelCustomArmour(), (HumanoidModel<T>) new ModelCustomArmour(), modelManager);
    }

    @Override
    @NotNull
    public ResourceLocation getArmorResource(@NotNull Entity entity, @NotNull ItemStack stack, @NotNull EquipmentSlot slot, @Nullable String type)
    {
        return TEXTURE;
    }
}