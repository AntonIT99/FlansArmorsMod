package com.wolffsarmormod.common.types;

import com.flansmod.client.model.ModelCustomArmour;
import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.client.model.armor.DefaultArmor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.StringUtils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;

import java.util.Optional;

import static com.wolffsarmormod.util.TypeReaderUtils.readValue;

public class ArmourType extends InfoType
{
    protected ArmorItem.Type armorType;
    protected String rawType = StringUtils.EMPTY;;
    protected String overlayName = StringUtils.EMPTY;
    protected double defence;
    protected int damageReductionAmount;
    protected int durability;
    protected int toughness;
    protected int enchantability = 10;
    protected float moveSpeedModifier = 1F;
    protected float knockbackModifier = 0.2F;
    protected float jumpModifier = 1F;
    protected boolean nightVision;
    protected boolean invisible;
    protected boolean smokeProtection;
    protected boolean negateFallDamage;
    protected boolean fireResistance;
    protected boolean waterBreathing;
    protected boolean onWaterWalking;

    protected ResourceLocation overlay;

    @Override
    protected void readLine(String[] split, TypeFile file)
    {
        super.readLine(split, file);
        rawType = readValue(split, "Type", rawType, file);
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
        negateFallDamage = readValue(split, "NegateFallDamage", negateFallDamage, file);
        fireResistance = readValue(split, "FireResistance", fireResistance, file);
        waterBreathing = readValue(split, "WaterBreathing", waterBreathing, file);
        smokeProtection = readValue(split, "SmokeProtection", smokeProtection, file);
        onWaterWalking = readValue(split, "OnWaterWalking", onWaterWalking, file);
        overlayName = readValue(split, "Overlay", overlayName, file).toLowerCase();
    }

    @Override
    protected void postRead(TypeFile file)
    {
        super.postRead(file);

        switch (rawType)
        {
            case "Hat", "Helmet":
                armorType = ArmorItem.Type.HELMET;
                break;
            case "Chest", "Body":
                armorType = ArmorItem.Type.CHESTPLATE;
                break;
            case "Legs", "Pants":
                armorType = ArmorItem.Type.LEGGINGS;
                break;
            case "Shoes", "Boots":
                armorType = ArmorItem.Type.BOOTS;
                break;
            default:
                break;
        }

        if (model == null)
        {
            model = new DefaultArmor(armorType);
        }

        if (StringUtils.isNotBlank(textureName))
        {
            texture = ResourceLocation.fromNamespaceAndPath(ArmorMod.FLANSMOD_ID, "textures/armor/" + textureName + (armorType != ArmorItem.Type.LEGGINGS ? "_1" : "_2") + ".png");
            model.setTexture(texture);
        }

        if (StringUtils.isNotBlank(overlayName))
        {
            overlay = ResourceLocation.fromNamespaceAndPath(ArmorMod.FLANSMOD_ID, "textures/gui/" + overlayName + ".png");
        }
    }

    @OnlyIn(Dist.CLIENT)
    public ModelCustomArmour getModel()
    {
        return (ModelCustomArmour) model;
    }

    public ArmorItem.Type getArmorType()
    {
        return armorType;
    }

    /**
     * The amount of damage to absorb. From 0 to 1. Stacks additively between armour pieces
     */
    public double getDefence()
    {
        return defence;
    }

    public int getDamageReductionAmount()
    {
        return damageReductionAmount;
    }

    public int getDurability()
    {
        return durability;
    }

    public boolean hasDurability()
    {
        return durability > 0;
    }

    public int getToughness()
    {
        return toughness;
    }

    public int getEnchantability()
    {
        return enchantability;
    }

    /**
     * Modifier for jump
     */
    public float getJumpModifier()
    {
        return jumpModifier;
    }

    /**
     * Modifier for knockback
     */
    public float getKnockbackModifier()
    {
        return knockbackModifier;
    }

    /**
     * Modifier for move speed
     */
    public float getMoveSpeedModifier()
    {
        return moveSpeedModifier;
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
     * The overlay to display when using this helmet. Textures are pulled from the scopes directory
     */
    public Optional<ResourceLocation> getOverlay()
    {
        return Optional.ofNullable(overlay);
    }

    /**
     * If true, the player can walk on water
     */
    public boolean hasOnWaterWalking()
    {
        return onWaterWalking;
    }

    /**
     * If true, the player can breath under water
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
}