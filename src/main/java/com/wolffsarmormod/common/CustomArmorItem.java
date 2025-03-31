package com.wolffsarmormod.common;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.wolffsarmormod.client.ModClientConfigs;
import com.wolffsarmormod.common.types.ArmourType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
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

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced)
    {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);

        if(ModClientConfigs.showPackNameInItemDescriptions.get() && !type.getContentPack().isBlank())
            tooltipComponents.add(Component.literal(type.getContentPack()).withStyle(ChatFormatting.GRAY));

        for (String line : type.getDescription().split("_"))
            tooltipComponents.add(Component.literal(line));

        if(Math.abs(type.getJumpModifier() - 1F) > 0.01F)
            tooltipComponents.add(Component.literal("+" + (int)((type.getJumpModifier() - 1F) * 100F) + "% Jump Height").withStyle(ChatFormatting.AQUA));
        if(type.hasSmokeProtection())
            tooltipComponents.add(Component.literal("+Smoke Protection").withStyle(ChatFormatting.DARK_GREEN));
        if(type.hasNightVision())
            tooltipComponents.add(Component.literal("+Night Vision").withStyle(ChatFormatting.DARK_GREEN));
        if(type.hasInvisiblility())
            tooltipComponents.add(Component.literal("+Invisibility").withStyle(ChatFormatting.DARK_GREEN));
        if(type.hasNegateFallDamage())
            tooltipComponents.add(Component.literal("+Negates Fall Damage").withStyle(ChatFormatting.DARK_GREEN));
        if(type.hasFireResistance())
            tooltipComponents.add(Component.literal("+Fire Resistance").withStyle(ChatFormatting.DARK_GREEN));
        if(type.hasWaterBreathing())
            tooltipComponents.add(Component.literal("+Water Breathing").withStyle(ChatFormatting.DARK_GREEN));
    }

    @OnlyIn(Dist.CLIENT)
    public Optional<ResourceLocation> getTexture()
    {
        return type.getTexture();
    }

    @OnlyIn(Dist.CLIENT)
    public Optional<ResourceLocation> getOverlay()
    {
        return type.getOverlay();
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