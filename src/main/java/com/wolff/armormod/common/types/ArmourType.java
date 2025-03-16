package com.wolff.armormod.common.types;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.StringUtils;

import net.minecraft.world.item.ArmorItem;

import static com.wolff.armormod.util.TypeReaderUtils.readValue;

public class ArmourType extends InfoType
{
    protected ArmorItem.Type type;

    @Override
    protected void readLine(String[] split, TypeFile file)
    {
        super.readLine(split, file);

        switch (readValue(split, "Type", StringUtils.EMPTY, file))
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