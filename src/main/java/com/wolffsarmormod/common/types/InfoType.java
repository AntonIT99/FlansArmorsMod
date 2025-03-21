package com.wolffsarmormod.common.types;

import com.flansmod.client.model.ModelCustomArmour;
import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.client.model.IModelBase;
import com.wolffsarmormod.util.ClassLoaderUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

import static com.wolffsarmormod.util.TypeReaderUtils.readValue;
import static com.wolffsarmormod.util.TypeReaderUtils.readValues;

public abstract class InfoType
{
    protected static final String ICONS_RELATIVE_PATH = "assets" + File.separator + ArmorMod.FLANSMOD_ID + File.separator + "textures" + File.separator + "items";
    protected static final String TEXTURES_RELATIVE_PATH = "assets" + File.separator + ArmorMod.FLANSMOD_ID;
    protected static final String MODEL_PACKAGE_NAME = "com.flansmod.client.model.";

    protected EnumType type;
    protected String contentPack = StringUtils.EMPTY;
    protected String shortName = StringUtils.EMPTY;
    protected String description = StringUtils.EMPTY;
    protected String modelName = StringUtils.EMPTY;
    protected String modelClassName = StringUtils.EMPTY;
    protected String icon = StringUtils.EMPTY;
    protected String texture = StringUtils.EMPTY;
    protected float modelScale = 1F;

    protected IModelBase model;

    public void read(TypeFile file)
    {
        contentPack = file.getContentPack().name();
        type = file.getType();

        for (String line : file.getLines())
        {
            if (line.startsWith("//"))
                continue;

            readLine(line.split(StringUtils.SPACE), file);
        }

        postRead(file);
    }

    protected void readLine(String[] split, TypeFile file)
    {
        shortName = readValue(split, "ShortName", shortName, file).toLowerCase();
        description = readValues(split, "Description", description, file);
        icon = readValue(split, "Icon", icon, file).toLowerCase();
        texture = readValue(split, "Texture", texture, file).toLowerCase();
        modelName = readValue(split, "Model", modelName, file);
        modelScale = readValue(split, "ModelScale", modelScale, file);
    }

    protected void postRead(TypeFile file)
    {
        if (!modelName.isBlank() && !modelName.equalsIgnoreCase("null") && !modelName.equalsIgnoreCase("none"))
        {
            String[] modelNameSplit = modelName.split("\\.");
            if (modelNameSplit.length > 1)
            {
                modelClassName = MODEL_PACKAGE_NAME + modelNameSplit[0] + ".Model" + modelNameSplit[1];
            }
            else
            {
                modelClassName = MODEL_PACKAGE_NAME + "Model" + modelName;
            }

            try
            {
                //TODO: Use default class loader
                Class<? extends ModelCustomArmour> modelClass = (Class<? extends ModelCustomArmour>) ClassLoaderUtils.loadAndModifyClass(file.getContentPack(), modelClassName);
                System.out.println("#############TEST " + modelClass.getSuperclass().getName());
                ModelCustomArmour modelInstance = modelClass.getConstructor().newInstance();
                if (modelInstance != null)
                {
                    model = modelInstance;
                    model.setType(this);
                }
                else
                {
                    ArmorMod.log.error("Could not load model class {} from {}: class is not a Model.", modelClassName, file.getContentPack().path());
                }
            }
            catch (Exception e)
            {
                ArmorMod.log.error("Could not load model class {} from {}", modelClassName, file.getContentPack().path(), e);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    protected String getTextureFileName()
    {
        return texture + ".png";
    }

    public String getContentPack()
    {
        return contentPack;
    }

    public String getShortName()
    {
        return shortName;
    }

    public String getDescription()
    {
        return description;
    }

    public float getModelScale()
    {
        return modelScale;
    }

    @OnlyIn(Dist.CLIENT)
    public String getIcon()
    {
        return icon;
    }

    @OnlyIn(Dist.CLIENT)
    public IModelBase getModel()
    {
        return model;
    }

    public EnumType getType()
    {
        return type;
    }
}
