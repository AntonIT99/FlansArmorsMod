package com.wolffsmod.client.model;

import com.wolffsarmormod.common.types.InfoType;

import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;

public interface IModelBase
{
    int TEXTURE_WIDTH = 64;
    int TEXTURE_HEIGHT = 32;

    default int getTextureWidth()
    {
        return TEXTURE_WIDTH;
    }

    default int getTextureHeight()
    {
        return TEXTURE_HEIGHT;
    }

    default TextureOffset getTextureOffset(String partName)
    {
        return getModelTextureMap().get(partName);
    }

    void setType(InfoType type);

    ResourceLocation getTexture();

    void setTexture(ResourceLocation texture);

    List<ModelRenderer> getBoxList();

    Map<String, TextureOffset> getModelTextureMap();
}
