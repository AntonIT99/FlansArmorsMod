package com.wolffsarmormod.common;

import com.flansmod.client.model.ModelCustomArmour;
import com.wolffsarmormod.client.CustomItemRenderer;
import com.wolffsarmormod.common.types.ArmourType;
import com.wolffsarmormod.util.ResourceUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.function.Consumer;

public class CustomArmorItem extends ArmorItem implements ICustomIconItem
{
    private final Path iconPath;
    private final Path texturePath;
    private final ModelCustomArmour model;

    private ResourceLocation icon;

    public CustomArmorItem(ArmourType type)
    {
        super(CustomArmorMaterial.CUSTOM, type.getType(), new Item.Properties());
        iconPath = type.getIconPath();
        texturePath = type.getTexturePath();
        model = type.getModel();
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

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer()
            {
                return CustomItemRenderer.INSTANCE;
            }
        });
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void loadIcon()
    {
        icon = ResourceUtils.loadExternalTexture(iconPath, "textures/items/");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @Nullable
    public ResourceLocation getIcon()
    {
        return icon;
    }

    @OnlyIn(Dist.CLIENT)
    public Path getTexturePath()
    {
        return texturePath;
    }
}