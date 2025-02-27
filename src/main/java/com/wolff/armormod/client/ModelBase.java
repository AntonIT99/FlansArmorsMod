package com.wolff.armormod.client;

import net.minecraft.client.model.geom.ModelPart;

import java.util.List;
import java.util.Map;

public interface ModelBase
{
    List<ModelPart.Cube> getCubes();

    Map<String, ModelPart> getChildren();
}
