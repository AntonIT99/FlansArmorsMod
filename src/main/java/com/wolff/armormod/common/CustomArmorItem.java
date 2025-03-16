package com.wolff.armormod.common;

import com.flansmod.client.model.mw.ModelExoskeletonHelmet;
import com.wolff.armormod.client.CustomItemRenderer;
import com.wolff.armormod.common.types.ArmourType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.fml.loading.FMLEnvironment;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.nio.file.Path;
import java.util.function.Consumer;

public class CustomArmorItem extends ArmorItem implements ICustomIconItem
{
    private Path iconPath;

    public CustomArmorItem(ArmourType type)
    {
        super(CustomArmorMaterial.CUSTOM, type.getType(), new Item.Properties());

        if (FMLEnvironment.dist.isClient())
        {
            iconPath = type.getIconPath();
        }
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer)
    {
        consumer.accept(new IClientItemExtensions()
        {
            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel)
            {
                return new ModelExoskeletonHelmet();
            }

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer()
            {
                return CustomItemRenderer.INSTANCE;
            }
        });
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public Path getIconPath()
    {
        return iconPath;
    }
}