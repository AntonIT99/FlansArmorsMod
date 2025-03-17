package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolff.armormod.client.model.IModelBase;
import com.wolff.armormod.client.model.ModelRenderer;
import com.wolff.armormod.client.model.TextureOffset;
import com.wolff.armormod.common.types.ArmourType;
import com.wolff.armormod.common.types.InfoType;
import com.wolff.armormod.util.ReflectionUtils;
import org.jetbrains.annotations.NotNull;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.wolff.armormod.client.CustomItemRenderer.loadExternalTexture;

public class ModelCustomArmour extends HumanoidModel<LivingEntity> implements IModelBase
{
    private static ModelPart root;

    protected ArmourType type;
    protected ModelRendererTurbo[] headModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] bodyModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] leftArmModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] rightArmModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] leftLegModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] rightLegModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] skirtFrontModel = new ModelRendererTurbo[0]; //Acts like a leg piece, but its pitch is set to the maximum of the two legs
    protected ModelRendererTurbo[] skirtRearModel = new ModelRendererTurbo[0]; //Acts like a leg piece, but its pitch is set to the minimum of the two legs

    private final List<ModelRenderer> boxList = new ArrayList<>();
    private final Map<String, TextureOffset> modelTextureMap = new HashMap<>();

    private ResourceLocation texture;

    public ModelCustomArmour()
    {
        super(getRoot());
    }

    private static ModelPart getRoot()
    {
        if (root == null)
        {
            Map<String, ModelPart> children = new HashMap<>();
            ModelPart emptyPart = new ModelPart(new ArrayList<>(), new HashMap<>());
            children.put("head", emptyPart);
            children.put("hat", emptyPart);
            children.put("body", emptyPart);
            children.put("right_arm", emptyPart);
            children.put("left_arm", emptyPart);
            children.put("right_leg", emptyPart);
            children.put("left_leg", emptyPart);
            root = new ModelPart(new ArrayList<>(), children);
        }
        return root;
    }

    public static MeshDefinition createMesh()
    {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
        return meshdefinition;
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack pPoseStack, @NotNull VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha)
    {
        boolean scaleHead = ReflectionUtils.getBooleanValue("scaleHead", AgeableListModel.class, this, true);
        float babyYHeadOffset = ReflectionUtils.getFloatValue("babyYHeadOffset", AgeableListModel.class, this, 16.0F);
        float babyZHeadOffset = ReflectionUtils.getFloatValue("babyZHeadOffset", AgeableListModel.class, this, 0.0F);
        float babyHeadScale = ReflectionUtils.getFloatValue("babyHeadScale", AgeableListModel.class, this, 2.0F);
        float babyBodyScale = ReflectionUtils.getFloatValue("babyBodyScale", AgeableListModel.class, this, 2.0F);
        float bodyYOffset = ReflectionUtils.getFloatValue("bodyYOffset", AgeableListModel.class, this, 24.0F);

        if (young)
        {
            pPoseStack.pushPose();
            if (scaleHead) {
                float f = 1.5F / babyHeadScale;
                pPoseStack.scale(f, f, f);
            }

            pPoseStack.translate(0.0F, babyYHeadOffset * 0.0625F, babyZHeadOffset * 0.0625F);
            renderHeadModels(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
            pPoseStack.pushPose();
            float f1 = 1.0F / babyBodyScale;
            pPoseStack.scale(f1, f1, f1);
            pPoseStack.translate(0.0F, bodyYOffset * 0.0625F, 0.0F);
            renderBodyModels(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            pPoseStack.popPose();
        }
        else
        {
            renderHeadModels(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
            renderBodyModels(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
        }
    }

    protected void renderHeadModels(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha)
    {
        render(headModel, head, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, type.getModelScale());
    }

    protected void renderBodyModels(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha)
    {
        render(bodyModel, body, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, type.getModelScale());
        render(leftArmModel, leftArm, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, type.getModelScale());
        render(rightArmModel, rightArm, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, type.getModelScale());
        render(leftLegModel, leftLeg, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, type.getModelScale());
        render(rightLegModel, rightLeg, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, type.getModelScale());
        for (ModelRendererTurbo mod : skirtFrontModel)
        {
            mod.rotationPointX = (leftLeg.x + rightLeg.x) / 2F / type.getModelScale();
            mod.rotationPointY = (leftLeg.y + rightLeg.y) / 2F / type.getModelScale();
            mod.rotationPointZ = (leftLeg.z + rightLeg.z) / 2F / type.getModelScale();
            mod.rotateAngleX = Math.min(leftLeg.xRot, rightLeg.xRot);
            mod.rotateAngleY = leftLeg.yRot;
            mod.rotateAngleZ = leftLeg.zRot;
            mod.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, type.getModelScale());
        }
        for (ModelRendererTurbo mod : skirtRearModel)
        {
            mod.rotationPointX = (leftLeg.x + rightLeg.x) / 2F / type.getModelScale();
            mod.rotationPointY = (leftLeg.y + rightLeg.x) / 2F / type.getModelScale();
            mod.rotationPointZ = (leftLeg.z + rightLeg.z) / 2F / type.getModelScale();
            mod.rotateAngleX = Math.max(leftLeg.xRot, rightLeg.xRot);
            mod.rotateAngleY = leftLeg.yRot;
            mod.rotateAngleZ = leftLeg.zRot;
            mod.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, type.getModelScale());
        }
    }

    public void render(ModelRendererTurbo[] models, ModelPart bodyPart, PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha, float scale)
    {
        setBodyPart(models, bodyPart, scale);
        for(ModelRendererTurbo mod : models)
        {
            mod.rotateAngleX = bodyPart.xRot;
            mod.rotateAngleY = bodyPart.yRot;
            mod.rotateAngleZ = bodyPart.zRot;
            mod.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, scale);
        }
    }

    public void setBodyPart(ModelRendererTurbo[] models, ModelPart bodyPart, float scale)
    {
        for(ModelRendererTurbo mod : models)
        {
            mod.rotationPointX = bodyPart.x / scale;
            mod.rotationPointY = bodyPart.y / scale;
            mod.rotationPointZ = bodyPart.z / scale;
        }
    }

    @Override
    public List<ModelRenderer> getBoxList()
    {
        return boxList;
    }

    @Override
    public Map<String, TextureOffset> getModelTextureMap()
    {
        return modelTextureMap;
    }

    public static LayerDefinition createLayer()
    {
        MeshDefinition mesh = ModelCustomArmour.createMesh();
        return LayerDefinition.create(mesh, TEXTURE_WIDTH, TEXTURE_HEIGHT);
    }

    @Override
    public ResourceLocation getTexture()
    {
        if (texture == null && type != null)
        {
            loadExternalTexture(type.getTexturePath());
        }
        return texture;
    }

    @Override
    public void setType(InfoType type)
    {
        if (type instanceof ArmourType armourType)
            this.type = armourType;
    }
}
