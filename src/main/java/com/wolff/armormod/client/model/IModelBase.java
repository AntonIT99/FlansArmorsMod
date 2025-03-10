package com.wolff.armormod.client.model;

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

    List<ModelRenderer> getBoxList();

    Map<String, TextureOffset> getModelTextureMap();
}
