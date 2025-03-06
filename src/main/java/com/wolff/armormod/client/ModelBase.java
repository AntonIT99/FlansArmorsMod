package com.wolff.armormod.client;

import com.flansmod.client.tmt.ModelRendererTurbo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ModelBase
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
