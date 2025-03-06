package com.wolff.armormod.client;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModelRenderer
{
    /** The size of the texture file's width in pixels. */
    public float textureWidth;
    /** The size of the texture file's height in pixels. */
    public float textureHeight;
    public float rotationPointX;
    public float rotationPointY;
    public float rotationPointZ;
    public float rotateAngleX;
    public float rotateAngleY;
    public float rotateAngleZ;
    //TODO: do something with mirror
    public boolean mirror;
    public boolean showModel;
    /** Hides the model. */
    public boolean isHidden;

    public List<ModelPart.Cube> cubeList;
    public Map<String, ModelPart> childModels;
    public final String boxName;
    //TODO: do something with offsets
    public float offsetX;
    public float offsetY;
    public float offsetZ;

    /** The X offset into the texture used for displaying this model */
    private int textureOffsetX;
    /** The Y offset into the texture used for displaying this model */
    private int textureOffsetY;
    /** The GL display list rendered by the Tessellator for this model */
    private int displayList;

    //TODO: do something with baseModel
    private final ModelBase baseModel;

    public ModelRenderer(ModelBase model, String boxNameIn)
    {
        textureWidth = 64.0F;
        textureHeight = 32.0F;
        showModel = true;
        cubeList = new ArrayList<>();
        baseModel = model;
        model.getBoxList().add(this);
        boxName = boxNameIn;
        setTextureSize(model.getTextureWidth(), model.getTextureHeight());
    }

    public ModelRenderer(ModelBase model)
    {
        this(model, "");
    }

    public ModelRenderer(ModelBase model, int texOffX, int texOffY)
    {
        this(model);
        setTextureOffset(texOffX, texOffY);
    }

    /**
     * Sets the current box's rotation points and rotation angles to another box.
     */
    public void addChild(ModelRenderer renderer)
    {
        if (childModels == null)
        {
            childModels = new HashMap<>();
        }

        childModels.put(boxName + childModels.size(), renderer.toModelPart());
    }

    public ModelRenderer setTextureOffset(int x, int y)
    {
        textureOffsetX = x;
        textureOffsetY = y;
        return this;
    }

    public ModelRenderer addBox(String partName, float offX, float offY, float offZ, int width, int height, int depth)
    {
        partName = boxName + "." + partName;
        TextureOffset textureoffset = baseModel.getTextureOffset(partName);
        setTextureOffset(textureoffset.textureOffsetX, textureoffset.textureOffsetY);
        addBox(offX, offY, offZ, width, height, depth, 0.0F, mirror);
        return this;
    }

    public ModelRenderer addBox(float offX, float offY, float offZ, int width, int height, int depth)
    {
        addBox(offX, offY, offZ, width, height, depth, 0.0F, mirror);
        return this;
    }

    public ModelRenderer addBox(float offX, float offY, float offZ, int width, int height, int depth, boolean mirrored)
    {
        addBox(offX, offY, offZ, width, height, depth, 0.0F, mirrored);
        return this;
    }

    /**
     * Creates a textured box.
     */
    public void addBox(float offX, float offY, float offZ, int width, int height, int depth, float scaleFactor)
    {
        addBox(offX, offY, offZ, width, height, depth, scaleFactor, mirror);
    }

    protected void addBox(float offX, float offY, float offZ, int width, int height, int depth, float scaleFactor, boolean mirrored) {
        cubeList.add(new ModelPart.Cube(textureOffsetX, textureOffsetY, offX, offY, offZ, width, height, depth, scaleFactor, scaleFactor, scaleFactor, mirrored, 1.0F, 1.0F, Set.of(Direction.values())));
    }

    public void setRotationPoint(float rotationPointXIn, float rotationPointYIn, float rotationPointZIn)
    {
        rotationPointX = rotationPointXIn;
        rotationPointY = rotationPointYIn;
        rotationPointZ = rotationPointZIn;
    }

    public ModelRenderer setTextureSize(int textureWidthIn, int textureHeightIn)
    {
        textureWidth = textureWidthIn;
        textureHeight = textureHeightIn;
        return this;
    }

    public ModelPart toModelPart()
    {
        ModelPart part = new ModelPart(cubeList, childModels);
        part.setPos(rotationPointX, rotationPointY, rotationPointZ);
        part.setRotation(rotateAngleX, rotateAngleY, rotateAngleZ);
        part.visible = showModel && !isHidden;
        return part;
    }
}
