package com.wolff.armormod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Quaternionf;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModelRenderer
{
    public static final float PI = (float) Math.PI;
    public static final float DEGREE_CONVERSION_FACTOR = 180F / PI;
    
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

    public final List<ModelPart.Cube> cubeList = new ArrayList<>();
    public final List<ModelRenderer> childModels = new ArrayList<>();
    public final Map<String, ModelPart> children = new HashMap<>();
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
    private final IModelBase baseModel;

    public ModelRenderer(IModelBase model, String boxNameIn)
    {
        textureWidth = 64.0F;
        textureHeight = 32.0F;
        showModel = true;
        baseModel = model;
        model.getBoxList().add(this);
        boxName = boxNameIn;
        setTextureSize(model.getTextureWidth(), model.getTextureHeight());
    }

    public ModelRenderer(IModelBase model)
    {
        this(model, "");
    }

    public ModelRenderer(IModelBase model, int texOffX, int texOffY)
    {
        this(model);
        setTextureOffset(texOffX, texOffY);
    }

    /**
     * Sets the current box's rotation points and rotation angles to another box.
     */
    public void addChild(ModelRenderer renderer)
    {
        childModels.add(renderer);
        children.put(boxName + children.size(), renderer.toModelPart());
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

    @SuppressWarnings("ForLoopReplaceableByForEach")
    @OnlyIn(Dist.CLIENT)
    public void render(PoseStack pPoseStack, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha, float scale)
    {
        if (!isVisible() || (cubeList.isEmpty() && childModels.isEmpty())) return;

        pPoseStack.pushPose();
        pPoseStack.translate(offsetX, offsetY, offsetZ);
        translateAndRotate(pPoseStack, scale);
        compile(pPoseStack.last(), pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);

        for (int i = 0; i < childModels.size(); ++i)
        {
            childModels.get(i).render(pPoseStack, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, scale);
        }

        pPoseStack.translate(-offsetX, -offsetY, -offsetZ);
        pPoseStack.popPose();
    }

    public void translateAndRotate(PoseStack poseStack, float scale) {
        poseStack.translate(rotationPointX * 0.0625F, rotationPointY * 0.0625F, rotationPointZ * 0.0625F);

        if (rotateAngleX != 0.0F || rotateAngleY != 0.0F || rotateAngleZ != 0.0F)
        {
            poseStack.mulPose((new Quaternionf()).rotationZYX(rotateAngleZ, rotateAngleY, rotateAngleX));
        }

        if (scale != 1.0F)
        {
            poseStack.scale(scale, scale, scale);
        }
    }

    private void compile(PoseStack.Pose pPose, VertexConsumer pVertexConsumer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        for(ModelPart.Cube modelpart$cube : cubeList) {
            modelpart$cube.compile(pPose, pVertexConsumer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        }

    }

    /*@OnlyIn(Dist.CLIENT)
    public void renderWithRotation(float scale)
    {
        if (!isVisible() || (cubeList.isEmpty() && childModels.isEmpty())) return;

        if (!compiled)
        {
            compileDisplayList(scale);
        }

        GlStateManager.pushMatrix();
        GlStateManager.translate(rotationPointX * scale, rotationPointY * scale, rotationPointZ * scale);

        if (rotateAngleY != 0.0F)
        {
            GlStateManager.rotate(rotateAngleY * DEGREE_CONVERSION_FACTOR, 0.0F, 1.0F, 0.0F);
        }

        if (rotateAngleX != 0.0F)
        {
            GlStateManager.rotate(rotateAngleX * DEGREE_CONVERSION_FACTOR, 1.0F, 0.0F, 0.0F);
        }

        if (rotateAngleZ != 0.0F)
        {
            GlStateManager.rotate(rotateAngleZ * DEGREE_CONVERSION_FACTOR, 0.0F, 0.0F, 1.0F);
        }

        GlStateManager.callList(displayList);
        GlStateManager.popMatrix();
    }*/

    /**
     * Allows the changing of Angles after a box has been rendered
     */
    /*@OnlyIn(Dist.CLIENT)
    public void postRender(float scale)
    {
        if (!isVisible()) return;
        
        if (!compiled)
        {
            compileDisplayList(scale);
        }

        if (rotateAngleX == 0.0F && rotateAngleY == 0.0F && rotateAngleZ == 0.0F)
        {
            if (rotationPointX != 0.0F || rotationPointY != 0.0F || rotationPointZ != 0.0F)
            {
                GlStateManager.translate(rotationPointX * scale, rotationPointY * scale, rotationPointZ * scale);
            }
        }
        else
        {
            GlStateManager.translate(rotationPointX * scale, rotationPointY * scale, rotationPointZ * scale);

            if (rotateAngleZ != 0.0F)
            {
                GlStateManager.rotate(rotateAngleZ * (180F / PI), 0.0F, 0.0F, 1.0F);
            }

            if (rotateAngleY != 0.0F)
            {
                GlStateManager.rotate(rotateAngleY * (180F / PI), 0.0F, 1.0F, 0.0F);
            }

            if (rotateAngleX != 0.0F)
            {
                GlStateManager.rotate(rotateAngleX * (180F / PI), 1.0F, 0.0F, 0.0F);
            }
        }
    }*/

    public ModelRenderer setTextureSize(int textureWidthIn, int textureHeightIn)
    {
        textureWidth = textureWidthIn;
        textureHeight = textureHeightIn;
        return this;
    }
    
    public boolean isVisible() {
        return !isHidden && showModel;
    }

    public ModelPart toModelPart()
    {
        ModelPart part = new ModelPart(cubeList, children);
        part.setPos(rotationPointX, rotationPointY, rotationPointZ);
        part.setRotation(rotateAngleX, rotateAngleY, rotateAngleZ);
        part.visible = isVisible();
        return part;
    }
}
