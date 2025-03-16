package com.wolff.armormod.common.types;

import com.flansmod.client.model.ModelCustomArmour;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.commons.lang3.StringUtils;

import net.minecraft.world.item.ArmorItem;

import java.io.File;
import java.nio.file.Path;

import static com.wolff.armormod.util.TypeReaderUtils.readValue;

public class ArmourType extends InfoType
{
    //TODO: not loading textures and icons when server-side

    protected static final String TEXTURES_RELATIVE_PATH = "assets" + File.separator + "flansmod" + File.separator + "armor";

    protected ArmorItem.Type type;
    protected ModelCustomArmour model;

    protected Path texturePath;

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
        }

        texturePath = file.getContentPack().getPath().resolve(TEXTURES_RELATIVE_PATH).resolve(getTextureFileName());


        if (FMLEnvironment.dist.isClient())
        {
            //TODO: load model
        }
        /*if(FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model"))
        {
            model = FlansMod.proxy.loadModel(split[1], shortName, ModelCustomArmour.class);
            model.type = this;
        }*/
    }

    /*@Nullable
    private <T> T loadModel(String s, String shortName, Class<T> typeClass)
    {
        if (StringUtils.isBlank(s) || StringUtils.isBlank(shortName))
            return null;

        try
        {
            return typeClass.cast(Class.forName(getModelName(s)).getConstructor().newInstance());
        }
        catch (Exception e)
        {
            ArmorMod.LOG.error("Failed to load model : {} ({})", shortName, s);
        }
        return null;
    }*/

    private String getTextureFileName()
    {
        return texture + (type != ArmorItem.Type.LEGGINGS ? "_1" : "_2") + ".png";
    }

    public ArmorItem.Type getType()
    {
        return type;
    }

    public Path getTexturePath()
    {
        return texturePath;
    }
}