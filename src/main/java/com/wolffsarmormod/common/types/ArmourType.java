package com.wolffsarmormod.common.types;

import com.flansmod.client.model.ModelCustomArmour;
import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.client.model.armor.DefaultArmor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.StringUtils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;

import static com.wolffsarmormod.util.TypeReaderUtils.readValue;

public class ArmourType extends InfoType
{
    protected String rawType;
    protected ArmorItem.Type armorType;
    protected double defence;
    protected int damageReductionAmount;
    protected int durability;
    protected int toughness;
    protected int enchantability = 10;


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
            texture = ResourceLocation.fromNamespaceAndPath(ArmorMod.FLANSMOD_ID, "textures/models/armor/" + textureName + (armorType != ArmorItem.Type.LEGGINGS ? "_1" : "_2") + ".png");
            model.setTexture(texture);
        }
    }

    public ArmorItem.Type getArmorType()
    {
        return armorType;
    }

    @OnlyIn(Dist.CLIENT)
    public ModelCustomArmour getModel()
    {
        return (ModelCustomArmour) model;
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

    public int getToughness()
    {
        return toughness;
    }

    public int getEnchantability()
    {
        return enchantability;
    }
}