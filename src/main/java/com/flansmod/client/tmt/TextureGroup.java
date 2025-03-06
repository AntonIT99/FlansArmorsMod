package com.flansmod.client.tmt;

import com.mojang.blaze3d.systems.RenderSystem;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.resources.ResourceLocation;

public class TextureGroup
{
    public List<TexturedPolygon> poly;
    public String texture;

    public TextureGroup()
    {
        poly = new ArrayList<>();
        texture = "";
    }

    public void addPoly(TexturedPolygon polygon)
    {
        poly.add(polygon);
    }

    public void loadTexture()
    {
        loadTexture(-1);
    }

    public void loadTexture(int defaultTexture)
    {
        if(!texture.isEmpty())
        {
            RenderSystem.setShaderTexture(0, new ResourceLocation("", texture));
        }
        else if(defaultTexture > -1)
        {
            RenderSystem.setShaderTexture(0, new ResourceLocation("", ""));
        }
    }
}
