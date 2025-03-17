package com.wolff.armormod.common;

import com.flansmod.client.model.ModelCustomArmour;
import com.wolff.armormod.client.CustomItemRenderer;
import com.wolff.armormod.common.types.ArmourType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

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
    private Path texturePath;
    private ModelCustomArmour model;

    public CustomArmorItem(ArmourType type)
    {
        super(CustomArmorMaterial.CUSTOM, type.getType(), new Item.Properties());
        iconPath = type.getIconPath();
        texturePath = type.getTexturePath();
        if (type.getModel() instanceof ModelCustomArmour modelCustomArmour)
            model = modelCustomArmour;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer)
    {
        consumer.accept(new IClientItemExtensions()
        {
            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel)
            {
                if (model != null)
                {
                    return model;
                }
                return defaultModel;
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

    @OnlyIn(Dist.CLIENT)
    public Path getTexturePath()
    {
        return texturePath;
    }
}