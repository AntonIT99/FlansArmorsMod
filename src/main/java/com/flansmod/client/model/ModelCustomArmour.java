package com.flansmod.client.model;

import org.lwjgl.opengl.GL11;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.wolff.armormod.ArmourType;
import com.wolff.armormod.client.ModelBase;
import com.wolff.armormod.client.ModelRenderer;
import com.wolff.armormod.client.TextureOffset;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelCustomArmour extends HumanoidModel<LivingEntity> implements ModelBase
{
    public ArmourType type;

    public ModelRendererTurbo[] headModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] bodyModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] leftArmModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] rightArmModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] leftLegModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] rightLegModel = new ModelRendererTurbo[0];
    public ModelRendererTurbo[] skirtFrontModel = new ModelRendererTurbo[0]; //Acts like a leg piece, but its pitch is set to the maximum of the two legs
    public ModelRendererTurbo[] skirtRearModel = new ModelRendererTurbo[0]; //Acts like a leg piece, but its pitch is set to the minimum of the two legs

    private final List<ModelRenderer> boxList = new ArrayList<>();
    private final Map<String, TextureOffset> modelTextureMap = new HashMap<>();

    public ModelCustomArmour() {
        super();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        GL11.glPushMatrix();
        GL11.glScalef(type.modelScale, type.modelScale, type.modelScale);
        isSneak = entity.isSneaking();
        ItemStack itemstack = ((LivingEntity)entity).getItemBySlot(EquipmentSlot.MAINHAND);
        heldItemRight = itemstack != ItemStack.EMPTY ? 1 : 0;

        aimedBow = false;
        if (itemstack != null && entity instanceof EntityPlayer && ((EntityPlayer)entity).getItemInUseCount() > 0)
        {
            EnumAction enumaction = itemstack.getItemUseAction();
            if (enumaction == EnumAction.block)
            {
                heldItemRight = 3;
            }
            else if (enumaction == EnumAction.bow)
            {
                aimedBow = true;
            }
        }
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        render(headModel, head, f5, type.modelScale);
        render(bodyModel, body, f5, type.modelScale);
        render(leftArmModel, leftArm, f5, type.modelScale);
        render(rightArmModel, rightArm, f5, type.modelScale);
        render(leftLegModel, leftLeg, f5, type.modelScale);
        render(rightLegModel, rightLeg, f5, type.modelScale);
        //Skirt front
        {
            for(ModelRendererTurbo mod : skirtFrontModel)
            {
                mod.rotationPointX = (leftLeg.x + rightLeg.x) / 2F / type.modelScale;
                mod.rotationPointY = (leftLeg.y + rightLeg.y) / 2F / type.modelScale;
                mod.rotationPointZ = (leftLeg.z + rightLeg.z) / 2F / type.modelScale;
                mod.rotateAngleX = Math.min(leftLeg.xRot, rightLeg.xRot);
                mod.rotateAngleY = leftLeg.yRot;
                mod.rotateAngleZ = leftLeg.zRot;
                mod.render(f5);
            }
        }
        //Skirt back
        {
            for(ModelRendererTurbo mod : skirtRearModel)
            {
                mod.rotationPointX = (leftLeg.x + rightLeg.x) / 2F / type.modelScale;
                mod.rotationPointY = (leftLeg.y + rightLeg.x) / 2F / type.modelScale;
                mod.rotationPointZ = (leftLeg.z + rightLeg.z) / 2F / type.modelScale;
                mod.rotateAngleX = Math.max(leftLeg.xRot, rightLeg.xRot);
                mod.rotateAngleY = leftLeg.yRot;
                mod.rotateAngleZ = leftLeg.zRot;
                mod.render(f5);
            }
        }
        GL11.glPopMatrix();
    }

    public void render(ModelRendererTurbo[] models, ModelPart bodyPart, float f5, float scale)
    {
        setBodyPart(models, bodyPart, scale);
        for(ModelRendererTurbo mod : models)
        {
            mod.rotateAngleX = bodyPart.xRot;
            mod.rotateAngleY = bodyPart.yRot;
            mod.rotateAngleZ = bodyPart.zRot;
            mod.render(f5);
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
}
