package com.wolffsarmormod.common.types;

import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.ContentManager;
import com.wolffsarmormod.IContentProvider;
import com.wolffsarmormod.util.DynamicReference;
import com.wolffsarmormod.util.FileUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.wolffsarmormod.util.TypeReaderUtils.readValue;
import static com.wolffsarmormod.util.TypeReaderUtils.readValues;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class InfoType
{
    protected static final Map<String, IContentProvider> registeredModels = new HashMap<>();

    @Getter
    protected EnumType type;
    @Getter
    protected IContentProvider contentPack;
    @Getter
    protected String name = StringUtils.EMPTY;
    @Getter
    protected String shortName = StringUtils.EMPTY;
    @Getter
    protected String description = StringUtils.EMPTY;
    protected String modelName = StringUtils.EMPTY;
    protected String modelClassName = StringUtils.EMPTY;
    protected String icon = StringUtils.EMPTY;
    protected String textureName = StringUtils.EMPTY;
    protected String overlayName = StringUtils.EMPTY;
    @Getter
    protected float modelScale = 1F;

    public void read(TypeFile file)
    {
        contentPack = file.getContentPack();
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
        overlayName = readValue(split, "Overlay", overlayName, file).toLowerCase();
        modelName = readValue(split, "Model", modelName, file);
        modelScale = readValue(split, "ModelScale", modelScale, file);
    }

    protected void postRead(TypeFile file)
    {
        if (FMLEnvironment.dist == Dist.CLIENT)
            findModelClass();
    }

    @OnlyIn(Dist.CLIENT)
    protected void findModelClass()
    {
        if (!modelName.isBlank() && !modelName.equalsIgnoreCase("null") && !modelName.equalsIgnoreCase("none"))
        {
            String[] modelNameSplit = modelName.split("\\.");
            Path classFile;
            FileSystem fs = FileUtils.createFileSystem(contentPack);

            if (modelNameSplit.length > 1)
            {
                modelClassName = "com." + ArmorMod.FLANSMOD_ID + ".client.model." + modelNameSplit[0] + ".Model" + modelNameSplit[1];
                classFile = contentPack.getModelPath(modelClassName, fs);

                // Handle 1.12.2 package format
                if (!Files.exists(classFile))
                {
                    modelClassName = "com." + ArmorMod.FLANSMOD_ID + "." + modelNameSplit[0] + ".client.model.Model" + modelNameSplit[1];
                    Path redirectFile = (fs != null) ? fs.getPath("redirect.info") : contentPack.getPath().resolve("redirect.info");

                    if (Files.exists(redirectFile))
                    {
                        try
                        {
                            List<String> lines = Files.readAllLines(redirectFile);
                            if (lines.size() > 1 && modelNameSplit[0].equals(lines.get(0)))
                            {
                                modelClassName = lines.get(1) + ".Model" + modelNameSplit[1];
                            }
                        }
                        catch (IOException e)
                        {
                            ArmorMod.log.error("Could not open {}", redirectFile, e);
                        }
                    }
                    classFile = contentPack.getModelPath(modelClassName, fs);
                }
            }
            else
            {
                modelClassName = "com." + ArmorMod.FLANSMOD_ID + ".client.model.Model" + modelName;
                classFile = contentPack.getModelPath(modelClassName, fs);
            }

            String actualClassName = modelClassName;

            if (registeredModels.containsKey(modelClassName) && !contentPack.equals(registeredModels.get(modelClassName)))
            {
                IContentProvider otherContentPack = registeredModels.get(modelClassName);
                FileSystem otherFs = FileUtils.createFileSystem(otherContentPack);
                Path otherClassFile = otherContentPack.getModelPath(modelClassName, otherFs);

                if (FileUtils.filesHaveDifferentBytesContent(classFile, otherClassFile))
                {
                    actualClassName = findValidClassName(modelClassName);
                    ArmorMod.log.info("Duplicate model class name {} renamed at runtime to {} in [{}] to avoid a conflict with [{}].", modelClassName, actualClassName, contentPack.getName(), otherContentPack.getName());
                }

                FileUtils.closeFileSystem(otherFs, otherContentPack);
            }

            registeredModels.putIfAbsent(actualClassName, contentPack);
            DynamicReference.storeOrUpdate(modelClassName, actualClassName, ContentManager.modelReferences.get(contentPack));

            FileUtils.closeFileSystem(fs, contentPack);
        }
    }

    protected String findValidClassName(String className)
    {
        String newClassName = className;
        for (int i = 2; registeredModels.containsKey(newClassName); i++)
        {
            newClassName = className + "_" + i;
        }
        return newClassName;
    }

    @OnlyIn(Dist.CLIENT)
    public String getIcon()
    {
        return icon;
    }

    @OnlyIn(Dist.CLIENT)
    public String getModelClass()
    {
        return modelClassName;
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public DynamicReference getActualModelClass()
    {
        if (!modelClassName.isBlank())
        {
            return ContentManager.modelReferences.get(contentPack).get(modelClassName);
        }
        return null;
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public DynamicReference getTexture()
    {
        if (!textureName.isBlank())
        {
            return ContentManager.skinsTextureReferences.get(contentPack).get(textureName);
        }
        return null;
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public DynamicReference getOverlay()
    {
        if (!overlayName.isBlank())
        {
            return ContentManager.guiTextureReferences.get(contentPack).get(overlayName);
        }
        return null;
    }
}
