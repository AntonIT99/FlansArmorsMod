package com.wolff.armormod.common.types;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.world.item.ArmorItem;

import static com.wolff.armormod.util.TypeReaderUtils.readValue;

public class ArmourType extends InfoType
{
    protected String rawType;
    protected ArmorItem.Type type;

    @Override
    protected void readLine(String[] split, TypeFile file)
    {
        super.readLine(split, file);
        rawType = readValue(split, "Type", rawType, file);
        texture = readValue(split, "ArmourTexture", texture, file);
    }

    @Override
    protected void postRead(TypeFile file)
    {
        super.postRead(file);
        switch (rawType)
        {
            case "Hat", "Helmet":
                type = ArmorItem.Type.HELMET;
                break;
            case "Chest", "Body":
                type = ArmorItem.Type.CHESTPLATE;
                break;
            case "Legs", "Pants":
                type = ArmorItem.Type.LEGGINGS;
                break;
            case "Shoes", "Boots":
                type = ArmorItem.Type.BOOTS;
                break;
            default:
                break;
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getTextureFileName()
    {
        return texture + (type != ArmorItem.Type.LEGGINGS ? "_1" : "_2") + ".png";
    }

    public ArmorItem.Type getType()
    {
        return type;
    }
}