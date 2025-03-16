package com.wolff.armormod.common.types;

import com.wolff.armormod.ArmorMod;
import com.wolff.armormod.client.model.IModelBase;
import com.wolff.armormod.util.ClassLoaderUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.file.Path;

import static com.wolff.armormod.util.TypeReaderUtils.readValue;
import static com.wolff.armormod.util.TypeReaderUtils.readValues;

public abstract class InfoType
{
    protected static final String ICONS_RELATIVE_PATH = "assets" + File.separator + "flansmod" + File.separator + "textures" + File.separator + "items";
    protected static final String MODEL_RELATIVE_PATH = "com" + File.separator + "flansmod" + File.separator + "client" + File.separator + "model";
    protected static final String TEXTURES_RELATIVE_PATH = "assets" + File.separator + "flansmod";
    protected static final String MODEL_PACKAGE_NAME = "com.flansmod.client.model.";

    protected String contentPack = StringUtils.EMPTY;
    protected String shortName = StringUtils.EMPTY;
    protected String description = StringUtils.EMPTY;
    protected String modelName = StringUtils.EMPTY;
    protected String modelClassName = StringUtils.EMPTY;
    protected String icon = StringUtils.EMPTY;
    protected String texture = StringUtils.EMPTY;
    protected float modelScale = 1F;

    protected Path modelPath;
    protected Path texturePath;
    protected Path iconPath;

    protected IModelBase model;

    public void read(TypeFile file)
    {
        contentPack = file.getContentPack().getName();

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
        icon = readValue(split, "Icon", StringUtils.EMPTY, file);
        texture = readValue(split, "Texture", texture, file);
        modelName = readValue(split, "Model", modelClassName, file);
        modelScale = readValue(split, "ModelScale", modelScale, file);
    }

    protected void postRead(TypeFile file)
    {
        if (FMLEnvironment.dist.isClient())
        {
            iconPath = file.getContentPack().getPath().resolve(ICONS_RELATIVE_PATH).resolve(icon + ".png");
            texturePath = file.getContentPack().getPath().resolve(TEXTURES_RELATIVE_PATH).resolve(file.getType().getTextureFolderName()).resolve(getTextureFileName());

            modelClassName = MODEL_PACKAGE_NAME + modelName;
            String[] modelNameSplit = modelName.split("\\.");
            String modelPackageFolder = modelNameSplit.length > 1 ? modelNameSplit[0] : StringUtils.EMPTY;
            modelPath = file.getContentPack().getPath().resolve(MODEL_RELATIVE_PATH);
            if (!modelPackageFolder.isBlank())
            {
                modelPath = modelPath.resolve(modelPackageFolder);
            }
            modelPath = modelPath.resolve(modelName);

            try
            {
                if (ClassLoaderUtils.loadClassFromFile(modelPath, modelClassName).getConstructor().newInstance() instanceof IModelBase modelBase)
                {
                    model = modelBase;
                }
                else
                {
                    ArmorMod.LOG.error("Could not load model class at {}: class is not a Model.", modelPath);
                }
            }
            catch (Exception e)
            {
                ArmorMod.LOG.error("Could not load model class at {}.", modelPath, e);
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
    public Path getIconPath()
    {
        return iconPath;
    }

    @OnlyIn(Dist.CLIENT)
    public Path getTexturePath()
    {
        return texturePath;
    }

    @OnlyIn(Dist.CLIENT)
    public IModelBase getModel()
    {
        return model;
    }
}
