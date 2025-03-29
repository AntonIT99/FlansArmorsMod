package com.wolffsarmormod.common;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.wolffsarmormod.common.types.ArmourType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;
import java.util.function.Consumer;

public class CustomArmorItem extends ArmorItem
{
    //TODO: make configurable:
    /*
    public static int breakableArmor = 0;
    public static int defaultArmorDurability = 500;
     */
    protected static final UUID[] uuid = new UUID[] { UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID() };
    protected final ArmourType type;

    public CustomArmorItem(ArmourType type)
    {
        super(new CustomArmorMaterial(type), type.getArmorType(), new Item.Properties());
        this.type = type;
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture()
    {
        return type.getTexture();
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
                if (type.getModel() != null)
                {
                    return type.getModel();
                }
                return defaultModel;
            }
        });
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        Multimap<Attribute, AttributeModifier> modifiers = super.getDefaultAttributeModifiers(pEquipmentSlot);

        if (pEquipmentSlot == type.getArmorType().getSlot())
        {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(modifiers);
            builder.put(Attributes.MOVEMENT_SPEED,
                    new AttributeModifier(uuid[type.getArmorType().getSlot().getIndex()], "Movement Speed", type.getMoveSpeedModifier() - 1F, AttributeModifier.Operation.MULTIPLY_TOTAL));
            builder.put(Attributes.KNOCKBACK_RESISTANCE,
                    new AttributeModifier(uuid[type.getArmorType().getSlot().getIndex()], "Knockback Resistance", type.getKnockbackModifier(), AttributeModifier.Operation.ADDITION));
            return builder.build();
        }

        return modifiers;
    }
}