package com.wolffsarmormod.common.types;

import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.IContentProvider;
import com.wolffsarmormod.util.ClassLoaderUtils;
import com.wolffsarmormod.util.FileUtils;
import com.wolffsmod.client.model.IModelBase;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.wolffsarmormod.util.TypeReaderUtils.readValue;
import static com.wolffsarmormod.util.TypeReaderUtils.readValues;

public abstract class InfoType
{
    protected static final Map<String, IContentProvider> registeredModels = new HashMap<>();

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
        contentPack = FilenameUtils.getBaseName(file.getContentPack().getName());
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
        if (FMLEnvironment.dist == Dist.CLIENT)
            loadModel(file);
    }

    @OnlyIn(Dist.CLIENT)
    protected void loadModel(TypeFile file)
    {
        if (!modelName.isBlank() && !modelName.equalsIgnoreCase("null") && !modelName.equalsIgnoreCase("none"))
        {
            String[] modelNameSplit = modelName.split("\\.");
            Path classFile;
            FileSystem fs = FileUtils.createFileSystem(file.getContentPack());

            if (modelNameSplit.length > 1)
            {
                modelClassName = "com." + ArmorMod.FLANSMOD_ID + ".client.model." + modelNameSplit[0] + ".Model" + modelNameSplit[1];
                classFile = file.getContentPack().getModelPath(modelClassName, fs);

                // Handle 1.12.2 package format
                if (!Files.exists(classFile))
                {
                    modelClassName = "com." + ArmorMod.FLANSMOD_ID + "." + modelNameSplit[0] + ".client.model.Model" + modelNameSplit[1];
                    Path redirectFile = (fs != null) ? fs.getPath("redirect.info") : file.getContentPack().getPath().resolve("redirect.info");

                    if (Files.exists(redirectFile))
                    {
                        try
                        {
                            List<String> lines = Files.readAllLines(redirectFile);
                            if (lines.size() > 1)
                            {
                                if (modelNameSplit[0].equals(lines.get(0)))
                                {
                                    modelClassName = lines.get(1) + ".Model" + modelNameSplit[1];
                                }
                            }
                        }
                        catch (IOException e)
                        {
                            ArmorMod.log.error("Could not open {}", redirectFile, e);
                        }
                    }
                    classFile = file.getContentPack().getModelPath(modelClassName, fs);
                }
            }
            else
            {
                modelClassName = "com." + ArmorMod.FLANSMOD_ID + ".client.model.Model" + modelName;
                classFile = file.getContentPack().getModelPath(modelClassName, fs);
            }

            if (registeredModels.containsKey(modelClassName))
            {
                IContentProvider otherContentPack = registeredModels.get(modelClassName);
                FileSystem otherFs = FileUtils.createFileSystem(otherContentPack);
                Path otherClassFile = otherContentPack.getModelPath(modelClassName, otherFs);

                if (!FileUtils.hasSameFileBytesContent(classFile, otherClassFile))
                {
                    ArmorMod.log.warn("Duplicate model class name: {} and {}", classFile, registeredModels.get(modelClassName));
                }

                FileUtils.closeFileSystem(otherFs, otherContentPack);
            }

            FileUtils.closeFileSystem(fs, file.getContentPack());
            registeredModels.putIfAbsent(modelClassName, file.getContentPack());

            try
            {
                if (ClassLoaderUtils.loadAndModifyClass(file.getContentPack(), modelClassName).getConstructor().newInstance() instanceof IModelBase modelBase)
                {
                    model = modelBase;
                    model.setType(this);
                }
                else
                {
                    ArmorMod.log.error("Could not load model class {} from {}: class is not a Model.", modelClassName, file.getContentPack().getPath());
                }
            }
            catch (Exception e)
            {
                ArmorMod.log.error("Could not load model class {} from {}", modelClassName, file.getContentPack().getPath(), e);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public Optional<ResourceLocation> getTexture()
    {
        return Optional.ofNullable(texture);
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
