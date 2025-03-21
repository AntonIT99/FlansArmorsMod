package com.wolffsarmormod.common;

import com.flansmod.client.model.ModelCustomArmour;
import com.wolffsarmormod.common.types.ArmourType;
import com.wolffsarmormod.util.ResourceUtils;
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

import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.function.Consumer;

public class CustomArmorItem extends ArmorItem implements ICustomIconItem
{
    private final String name;
    private final String textureName;
    private final Path iconPath;
    private final ModelCustomArmour model;

    private ResourceLocation icon;

    public CustomArmorItem(ArmourType type)
    {
        super(CustomArmorMaterial.CUSTOM, type.getType(), new Item.Properties());
        name = type.getShortName();
        iconPath = type.getIconPath();
        textureName = type.getTextureFileName();
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

            /*@Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer()
            {
                return CustomItemRenderer.INSTANCE;
            }*/
        });
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void loadIcon()
    {
        icon = ResourceUtils.loadExternalTexture(iconPath, "item/", name);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @Nullable
    public ResourceLocation getIcon()
    {
        return icon;
    }

    @OnlyIn(Dist.CLIENT)
    public String getTextureName()
    {
        return textureName;
    }
}