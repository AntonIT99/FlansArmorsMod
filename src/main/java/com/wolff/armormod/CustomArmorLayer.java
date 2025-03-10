package com.wolff.armormod;

import com.flansmod.client.model.ModelCustomArmour;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.world.entity.LivingEntity;

public class CustomArmorLayer<T extends LivingEntity, M extends HumanoidModel<T>> extends HumanoidArmorLayer<T, M, HumanoidModel<T>> {

    public CustomArmorLayer(RenderLayerParent<T, M> parent, EntityModelSet modelSet, ModelManager modelManager)
    {
        super(parent, (HumanoidModel<T>) new ModelCustomArmour(modelSet.bakeLayer(ModModelLayers.CUSTOM_ARMOR)), (HumanoidModel<T>) new ModelCustomArmour(modelSet.bakeLayer(ModModelLayers.CUSTOM_ARMOR)), modelManager);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        //TODO. implement
    }
}