package com.wolffsarmormod.common.types;

import com.flansmod.client.model.ModelCustomArmour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.ArmorItem;

import static com.wolffsarmormod.util.TypeReaderUtils.readValue;

public class ArmourType extends InfoType
{
    protected String rawType;
    protected ArmorItem.Type armorType;

    @Override
    protected void readLine(String[] split, TypeFile file)
    {
        super.readLine(split, file);
        rawType = readValue(split, "Type", rawType, file);
        texture = readValue(split, "ArmourTexture", texture, file).toLowerCase();
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
    }

    public ArmorItem.Type getArmorType()
    {
        return armorType;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getTextureFileName()
    {
        return texture + (armorType != ArmorItem.Type.LEGGINGS ? "_1" : "_2") + ".png";
    }

    @OnlyIn(Dist.CLIENT)
    public ModelCustomArmour getModel()
    {
        return (ModelCustomArmour) model;
    }
}