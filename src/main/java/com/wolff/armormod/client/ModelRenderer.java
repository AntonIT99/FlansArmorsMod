package com.wolff.armormod.client;

import net.minecraft.client.model.geom.ModelPart;

import java.util.List;
import java.util.Map;

public class ModelRenderer
{
    public float rotateAngleX;
    public float rotateAngleY;
    public float rotateAngleZ;
    public final String boxName;

    private final ModelBase baseModel;

    private List<ModelPart.Cube> cubeList;
    private Map<String, ModelPart> childModels;

    // Constructor to wrap around the ModelPart
    public ModelRenderer(ModelBase model, String boxNameIn)
    {
        baseModel = model;
        boxName = boxNameIn;
    }

    public void setRotationPoint(float rotationPointX, float rotationPointY, float rotationPointZ)
    {
        //TODO: implement
    }

    public ModelPart toModelPart()
    {
        return new ModelPart(cubeList, childModels);
    }
}
