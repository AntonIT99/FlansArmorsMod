package com.wolffsarmormod.common.types;

import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.client.model.IModelBase;
import com.wolffsarmormod.util.ClassLoaderUtils;
import com.wolffsarmormod.util.FileUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.StringUtils;

import net.minecraft.resources.ResourceLocation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static com.wolffsarmormod.util.TypeReaderUtils.readValue;
import static com.wolffsarmormod.util.TypeReaderUtils.readValues;

public abstract class InfoType
{
    protected static final Map<String, Path> registeredModels = new HashMap<>();

    protected EnumType type;
    protected String contentPack = StringUtils.EMPTY;
    protected String name = StringUtils.EMPTY;
    protected String shortName = StringUtils.EMPTY;
    protected String description = StringUtils.EMPTY;
    protected String modelName = StringUtils.EMPTY;
    protected String modelClassName = StringUtils.EMPTY;
    protected String icon = StringUtils.EMPTY;
    protected String textureName = StringUtils.EMPTY;
    protected float modelScale = 1F;

    protected IModelBase model;
    protected ResourceLocation texture;

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
        name = readValues(split, "Name", name, file);
        shortName = readValue(split, "ShortName", shortName, file).toLowerCase();
        description = readValues(split, "Description", description, file);
        icon = readValue(split, "Icon", icon, file).toLowerCase();
        textureName = readValue(split, "Texture", textureName, file).toLowerCase();
        modelName = readValue(split, "Model", modelName, file);
        modelScale = readValue(split, "ModelScale", modelScale, file);
    }

    protected void postRead(TypeFile file)
    {
        if (!modelName.isBlank() && !modelName.equalsIgnoreCase("null") && !modelName.equalsIgnoreCase("none"))
        {
            String[] modelNameSplit = modelName.split("\\.");
            String fileName;
            Path classFile;

            if (modelNameSplit.length > 1)
            {
                fileName = "Model" + modelNameSplit[1];
                modelClassName = "com." + ArmorMod.FLANSMOD_ID + ".client.model." + modelNameSplit[0] + "." + fileName;
                classFile = file.getContentPack().getModelsPath(modelNameSplit[0], false).resolve(fileName + ".class");

                // Handle 1.12.2 package format
                if (!Files.exists(classFile))
                {
                    modelClassName = "com." + ArmorMod.FLANSMOD_ID + "." + modelNameSplit[0] + ".client.model." + fileName;
                    classFile = file.getContentPack().getModelsPath(modelNameSplit[0], true).resolve(fileName + ".class");
                }
            }
            else
            {
                fileName = "Model" + modelName;
                modelClassName = "com." + ArmorMod.FLANSMOD_ID + ".client.model.Model" + modelName;
                classFile = file.getContentPack().getModelsPath("", false).resolve(fileName + ".class");
            }

            if (registeredModels.containsKey(modelClassName))
            {
                if (!FileUtils.hasSameFileBytesContent(classFile, registeredModels.get(modelClassName)))
                {
                    ArmorMod.log.warn("Duplicate model class name: {} and {}", classFile, registeredModels.get(modelClassName));
                }
            }
            registeredModels.putIfAbsent(modelClassName, classFile);

            try
            {
                //TODO: read models from 1.12.2 Packs
                if (ClassLoaderUtils.loadAndModifyClass(file.getContentPack(), modelClassName).getConstructor().newInstance() instanceof IModelBase modelBase)
                {
                    model = modelBase;
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
    public ResourceLocation getTexture()
    {
        if (texture == null)
        {
            return ResourceLocation.withDefaultNamespace("");
        }
        return texture;
    }

    public String getContentPack()
    {
        return contentPack;
    }

    public String getName()
    {
        return name;
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
