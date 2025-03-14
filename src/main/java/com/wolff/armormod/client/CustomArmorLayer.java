package com.wolff.armormod.client;

import com.flansmod.client.model.mw.ModelSuperHeavyHelmet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.world.entity.LivingEntity;

@OnlyIn(Dist.CLIENT)
public class CustomArmorLayer<T extends LivingEntity, M extends HumanoidModel<T>> extends HumanoidArmorLayer<T, M, HumanoidModel<T>>
{

    @SuppressWarnings("unchecked")
    public CustomArmorLayer(RenderLayerParent<T, M> parent, ModelManager modelManager)
    {
        super(parent, (HumanoidModel<T>) new ModelSuperHeavyHelmet(), (HumanoidModel<T>) new ModelSuperHeavyHelmet(), modelManager);
    }

    //@Override public ResourceLocation getArmorResource(net.minecraft.world.entity.Entity entity, ItemStack stack, EquipmentSlot slot, @Nullable String type) {}
}