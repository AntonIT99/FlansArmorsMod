package com.wolff.armormod.common.types;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.file.Path;

import static com.wolff.armormod.util.TypeReaderUtils.readValue;
import static com.wolff.armormod.util.TypeReaderUtils.readValues;

public abstract class InfoType
{
    protected static final String ICONS_RELATIVE_PATH = "assets" + File.separator + "flansmod" + File.separator + "textures" + File.separator + "items";

    protected String contentPack = StringUtils.EMPTY;
    protected String shortName = StringUtils.EMPTY;
    protected String description = StringUtils.EMPTY;
    protected String texture = StringUtils.EMPTY;
    protected float modelScale = 1F;

    protected Path iconPath;

    public void read(TypeFile file)
    {
        contentPack = file.getContentPack().getName();

        for (String line : file.getLines())
        {
            if (line.startsWith("//"))
                continue;

            readLine(line.split(StringUtils.SPACE), file);
        }
    }

    protected void readLine(String[] split, TypeFile file)
    {
        shortName = readValue(split, "ShortName", shortName, file).toLowerCase();
        description = readValues(split, "Description", description, file);
        texture = readValue(split, "Texture", texture, file);
        String icon = readValue(split, "Icon", StringUtils.EMPTY, file);
        modelScale = readValue(split, "ModelScale", modelScale, file);

        iconPath = file.getContentPack().getPath().resolve(ICONS_RELATIVE_PATH).resolve(icon + ".png");
    }

    public String getContentPack()
    {
        return contentPack;
    }

    public String getShortName()
    {
        return shortName;
    }

    public String getTexture()
    {
        return texture;
    }

    public String getDescription()
    {
        return description;
    }

    public Path getIconPath()
    {
        return iconPath;
    }

    public float getModelScale()
    {
        return modelScale;
    }
}
