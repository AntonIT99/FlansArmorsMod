package com.wolff.armormod.client;

import com.flansmod.client.model.mw.ModelExoskeletonBody;
import com.flansmod.client.model.mw.ModelExoskeletonHelmet;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
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
        super(parent, (HumanoidModel<T>) new ModelExoskeletonHelmet(), (HumanoidModel<T>) new ModelExoskeletonHelmet(), modelManager);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch)
    {
        int test = 0;
        //TODO: implement
    }

    //@Override public ResourceLocation getArmorResource(net.minecraft.world.entity.Entity entity, ItemStack stack, EquipmentSlot slot, @Nullable String type) {}
}