package com.wolffsarmormod.common;

import com.flansmod.client.model.ModelCustomArmour;
import com.wolffsarmormod.common.types.ArmourType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

public class CustomArmorItem extends ArmorItem
{
    protected final ModelCustomArmour model;
    protected final ResourceLocation texture;

    public CustomArmorItem(ArmourType type)
    {
        super(new CustomArmorMaterial(type), type.getArmorType(), new Item.Properties());
        model = type.getModel();
        texture = type.getTexture();
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture()
    {
        return texture;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer)
    {
        consumer.accept(new IClientItemExtensions()
        {
            @Override
            @NotNull
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel)
            {
                if (model != null)
                {
                    return model;
                }
                return defaultModel;
            }
        });
    }
}