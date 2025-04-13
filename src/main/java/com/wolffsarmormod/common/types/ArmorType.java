package com.wolffsarmormod.common.types;

import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.ContentManager;
import com.wolffsarmormod.util.DynamicReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.commons.lang3.StringUtils;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ArmorItem;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.wolffsarmormod.util.TypeReaderUtils.readValue;
import static com.wolffsarmormod.util.TypeReaderUtils.readValues;

@NoArgsConstructor
public class ArmorType extends InfoType
{
    protected String rawArmorItemType = StringUtils.EMPTY;
    @Getter
    protected ArmorItem.Type armorItemType;
    /** The amount of damage to absorb. From 0 to 1. Stacks additively between armour pieces */
    @Getter
    protected double defence;
    @Getter
    protected int damageReductionAmount;
    @Getter
    protected int durability;
    @Getter
    protected int toughness;
    @Getter
    protected int enchantability = 10;
    /** Modifier for move speed */
    @Getter
    protected float moveSpeedModifier = 1F;
    /** Modifier for knockback */
    @Getter
    protected float knockbackModifier = 0.2F;
    /** Modifier for jump (jump boost effect every couple of seconds) */
    @Getter
    protected float jumpModifier = 1F;
    protected boolean nightVision;
    protected boolean invisible;
    protected boolean smokeProtection;
    protected boolean negateFallDamage;
    protected boolean fireResistance;
    protected boolean waterBreathing;
    protected boolean onWaterWalking;
    protected boolean hunger;
    protected boolean regeneration;
    /** Map of effects and effect Amplifiers */
    @Getter
    protected Map<MobEffect, Integer> effects = new HashMap<>();

    @Override
    protected void readLine(String[] split, TypeFile file)
    {
        super.readLine(split, file);
        rawArmorItemType = readValue(split, "Type", rawArmorItemType, file);
        textureName = readValue(split, "ArmourTexture", textureName, file).toLowerCase();
        textureName = readValue(split, "ArmorTexture", textureName, file).toLowerCase();
        defence = readValue(split, "DamageReduction", defence, file);
        defence = readValue(split, "Defence", defence, file);
        enchantability = readValue(split, "Enchantability", enchantability, file);
        toughness = readValue(split, "Toughness", toughness, file);
        durability = readValue(split, "Durability", durability, file);
        damageReductionAmount = readValue(split, "DamageReductionAmount", damageReductionAmount, file);
        moveSpeedModifier = readValue(split, "MoveSpeedModifier", moveSpeedModifier, file);
        moveSpeedModifier = readValue(split, "Slowness", moveSpeedModifier, file);
        jumpModifier = readValue(split, "JumpModifier", jumpModifier, file);
        knockbackModifier = readValue(split, "KnockbackReduction", knockbackModifier, file);
        knockbackModifier = readValue(split, "KnockbackModifier", knockbackModifier, file);
        nightVision = readValue(split, "NightVision", nightVision, file);
        invisible = readValue(split, "Invisible", invisible, file);
        invisible = readValue(split, "playermodel", invisible, file);
        negateFallDamage = readValue(split, "NegateFallDamage", negateFallDamage, file);
        fireResistance = readValue(split, "FireResistance", fireResistance, file);
        waterBreathing = readValue(split, "WaterBreathing", waterBreathing, file);
        waterBreathing = readValue(split, "submarine", waterBreathing, file);
        smokeProtection = readValue(split, "SmokeProtection", smokeProtection, file);
        onWaterWalking = readValue(split, "OnWaterWalking", onWaterWalking, file);
        hunger = readValue(split, "hunger", hunger, file);
        regeneration = readValue(split, "regenerate", regeneration, file);

        List<String> effectValues = readValues(split, "AddEffect", file);
        if (!effectValues.isEmpty())
        {
            try
            {
                int effectId = Integer.parseInt(effectValues.get(0));
                int amplifier = (effectValues.size() > 1) ? Integer.parseInt(effectValues.get(1)) : 0;
                MobEffect effect = MobEffect.byId(effectId);
                if (effect != null)
                {
                    effects.put(effect, amplifier);
                }
                else
                {
                    ArmorMod.log.error("Could not read line {}: Potion ID {} does not exist", String.join(StringUtils.SPACE, split), effectId);
                }
            }
            catch (NumberFormatException e)
            {
                ArmorMod.log.error("Could not read line {}", String.join(StringUtils.SPACE, split), e);
            }
        }
    }

    @Override
    protected void postRead(TypeFile file)
    {
        super.postRead(file);

        switch (rawArmorItemType.toLowerCase())
        {
            case "helmet", "hat", "head":
                armorItemType = ArmorItem.Type.HELMET;
                break;
            case "chestplate", "chest", "body":
                armorItemType = ArmorItem.Type.CHESTPLATE;
                break;
            case "leggings", "legs", "pants":
                armorItemType = ArmorItem.Type.LEGGINGS;
                break;
            case "boots", "shoes", "feet":
                armorItemType = ArmorItem.Type.BOOTS;
                break;
            default:
                ArmorMod.log.error("Armor Type '{}' not recognized! Defaulting to Helmet", rawArmorItemType);
                armorItemType = ArmorItem.Type.HELMET;
                break;
        }

        if (FMLEnvironment.dist == Dist.CLIENT)
        {
            ContentManager.armorTextureReferences.get(contentPack).putIfAbsent(textureName, new DynamicReference(textureName));
            ContentManager.guiTextureReferences.get(contentPack).putIfAbsent(overlayName, new DynamicReference(overlayName));
        }
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    @Override
    public DynamicReference getTexture()
    {
        if (!textureName.isBlank())
        {
            return ContentManager.armorTextureReferences.get(contentPack).get(textureName);
        }
        return null;
    }

    public boolean hasDurability()
    {
        return durability > 0;
    }

    /**
     * If true, then the player gets a night vision buff every couple of seconds
     */
    public boolean hasNightVision()
    {
        return nightVision;
    }

    /**
     * If true, then the player gets a invisiblity buff every couple of seconds
     */
    public boolean hasInvisiblility()
    {
        return invisible;
    }

    /**
     * If true, then smoke effects from grenades will have no effect on players wearing this
     */
    public boolean hasSmokeProtection()
    {
        return smokeProtection;
    }

    /**
     * If ture, the player will not receive fall damage
     */
    public boolean hasNegateFallDamage()
    {
        return negateFallDamage;
    }

    /**
     * If true, the player can walk on water
     */
    public boolean hasOnWaterWalking()
    {
        return onWaterWalking;
    }

    /**
     * If true, the player can breathe underwater
     */
    public boolean hasWaterBreathing()
    {
        return waterBreathing;
    }

    /**
     * If true, the player will not receive fire damage
     */
    public boolean hasFireResistance()
    {
        return fireResistance;
    }

    /**
     * If true, then the player gets a hunger de-buff every couple of seconds
     */
    public boolean hasHunger()
    {
        return hunger;
    }

    /**
     * If true, then the player gets a regeneration buff every couple of seconds
     */
    public boolean hasRegeneration()
    {
        return regeneration;
    }
}