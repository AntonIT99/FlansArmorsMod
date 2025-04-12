package com.wolffsarmormod.common;

import com.flansmod.client.model.ModelCustomArmour;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.client.model.armor.DefaultArmor;
import com.wolffsarmormod.common.types.ArmourType;
import com.wolffsarmormod.config.ModClientConfigs;
import com.wolffsarmormod.config.ModCommonConfigs;
import com.wolffsarmormod.util.ClassLoaderUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
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
    protected static final UUID[] uuid = new UUID[] { UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID() };

    protected final ArmourType type;
    protected ModelCustomArmour model;
    protected ResourceLocation texture;
    protected ResourceLocation overlay;

    public CustomArmorItem(ArmourType type)
    {
        super(new CustomArmorMaterial(type), type.getArmorType(), new Item.Properties());
        this.type = type;

        if (FMLEnvironment.dist == Dist.CLIENT)
            clientSideInit();
    }

    @OnlyIn(Dist.CLIENT)
    protected void clientSideInit()
    {
        loadModel();

        if (StringUtils.isNotBlank(type.getTexture().get()))
        {
            texture = ResourceLocation.fromNamespaceAndPath(ArmorMod.FLANSMOD_ID, "textures/armor/" + type.getTexture().get() + (type.getArmorType() != ArmorItem.Type.LEGGINGS ? "_1" : "_2") + ".png");
            model.setTexture(texture);
        }

        if (StringUtils.isNotBlank(type.getOverlay().get()))
        {
            overlay = ResourceLocation.fromNamespaceAndPath(ArmorMod.FLANSMOD_ID, "textures/gui/" + type.getOverlay().get() + ".png");
        }
    }

    @OnlyIn(Dist.CLIENT)
    protected void loadModel()
    {
        if (!type.getModelClass().isBlank())
        {
            try
            {
                if (ClassLoaderUtils.loadAndModifyClass(type.getContentPack(), type.getModelClass(), type.getActualModelClass().get()).getConstructor().newInstance() instanceof ModelCustomArmour modelCustomArmour)
                {
                    model = modelCustomArmour;
                    model.setType(type);
                }
                else
                {
                    ArmorMod.log.error("Could not load model class {} from {}: class is not a Model.", type.getModelClass(), type.getContentPack().getPath());
                }
            }
            catch (Exception e)
            {
                ArmorMod.log.error("Could not load model class {} from {}", type.getModelClass(), type.getContentPack().getPath(), e);
            }
        }

        if (model == null)
        {
            model = new DefaultArmor(type.getArmorType());
        }
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex)
    {
        super.onInventoryTick(stack, level, player, slotIndex, selectedIndex);

        if (!level.isClientSide && isArmorSlot(slotIndex, player.getInventory()))
        {
            if (type.hasNightVision() && ArmorMod.ticker % 25 == 0)
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 250, 0, true, false));
            if (type.hasInvisiblility() && ArmorMod.ticker % 25 == 0)
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 250, 0, true, false));
            if (type.getJumpModifier() > 1.01F && ArmorMod.ticker % 25 == 0)
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 250, (int) ((type.getJumpModifier() - 1F) * 2F), true, false));
            if (type.hasFireResistance() && ArmorMod.ticker % 25 == 0)
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 250, 0, true, false));
            if (type.hasWaterBreathing() && ArmorMod.ticker % 25 == 0)
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 250, 0, true, false));
            if (type.hasHunger() && ArmorMod.ticker % 25 == 0)
                player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 250, 0, true, false));
            if (type.hasRegeneration() && ArmorMod.ticker % 25 == 0)
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 250, 0, true, false));
            if (!type.getEffects().isEmpty() && ArmorMod.ticker % 25 == 0)
            {
                type.getEffects().forEach((effect, amplifier) -> player.addEffect(new MobEffectInstance(effect, 250, amplifier, true, false)));
            }
            if (type.hasNegateFallDamage())
                player.fallDistance = 0F;
            if (type.hasOnWaterWalking())
            {
                if (player.isInWater())
                {
                    player.getAbilities().mayfly = true;   // Allow flying
                }
                else
                {
                    player.getAbilities().flying = false;  // Disable flying
                }
                player.onUpdateAbilities();
            }
        }
    }

    protected boolean isArmorSlot(int slotIndex, Inventory inv)
    {
        return (slotIndex >= inv.items.size()) && (slotIndex - inv.items.size() < inv.armor.size());
    }

    @Override
    public boolean isDamageable(ItemStack stack)
    {
        //0 = Non-breakable, 1 = All breakable, 2 = Refer to armor config
        int breakType = ModCommonConfigs.breakableArmor.get();
        return (breakType == 2 && type.hasDurability()) || breakType == 1;
    }

    @Override
    public int getMaxDamage(ItemStack stack)
    {
        if (ModCommonConfigs.breakableArmor.get() == 1)
        {
            return ModCommonConfigs.defaultArmorDurability.get();
        }
        return super.getMaxDamage(stack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced)
    {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);

        if (ModClientConfigs.showPackNameInItemDescriptions.get() && !getContentPack().isBlank())
            tooltipComponents.add(Component.literal(getContentPack()).withStyle(ChatFormatting.GRAY));

        for (String line : type.getDescription().split("_"))
        {
            if (!line.isBlank())
                tooltipComponents.add(Component.literal(line));
        }

        if (Math.abs(type.getJumpModifier() - 1F) > 0.01F)
            tooltipComponents.add(Component.literal("+" + (int)((type.getJumpModifier() - 1F) * 100F) + "% Jump Height").withStyle(ChatFormatting.AQUA));
        // TODO: Implement Smoke Protection with Flan's grenades
        //if (type.hasSmokeProtection())
        //    tooltipComponents.add(Component.literal("+Smoke Protection").withStyle(ChatFormatting.DARK_GREEN));
        if (type.hasNightVision())
            tooltipComponents.add(Component.literal("+Night Vision").withStyle(ChatFormatting.DARK_GREEN));
        if (type.hasInvisiblility())
            tooltipComponents.add(Component.literal("+Invisibility").withStyle(ChatFormatting.DARK_GREEN));
        if (type.hasNegateFallDamage())
            tooltipComponents.add(Component.literal("+Negates Fall Damage").withStyle(ChatFormatting.DARK_GREEN));
        if (type.hasFireResistance())
            tooltipComponents.add(Component.literal("+Fire Resistance").withStyle(ChatFormatting.DARK_GREEN));
        if (type.hasWaterBreathing())
            tooltipComponents.add(Component.literal("+Water Breathing").withStyle(ChatFormatting.DARK_GREEN));
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
                return model;
            }
        });
    }

    @Override
    @NotNull
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot pEquipmentSlot) {
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

    public String getContentPack()
    {
        return FilenameUtils.getBaseName(type.getContentPack().getName());
    }

    @OnlyIn(Dist.CLIENT)
    public ModelCustomArmour getModel()
    {
        return model;
    }

    @OnlyIn(Dist.CLIENT)
    public Optional<ResourceLocation> getTexture()
    {
        return Optional.ofNullable(texture);
    }

    @OnlyIn(Dist.CLIENT)
    public Optional<ResourceLocation> getOverlay()
    {
        return Optional.ofNullable(overlay);
    }
}