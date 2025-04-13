package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsarmormod.client.model.armor.IFlanModel;
import com.wolffsarmormod.common.types.GunType;
import com.wolffsmod.client.model.ModelRenderer;
import com.wolffsmod.client.model.TextureOffset;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelGun extends Model implements IFlanModel<GunType>
{
    protected GunType type;

    // Static models with no animation
    protected ModelRendererTurbo[] gunModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] backpackModel = new ModelRendererTurbo[0]; //For flamethrowers and such like. Rendered on the player's back

    // These models appear when no attachment exists
    protected ModelRendererTurbo[] defaultBarrelModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] defaultScopeModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] defaultStockModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] defaultGripModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] defaultGadgetModel = new ModelRendererTurbo[0];

    // Animated models
    protected ModelRendererTurbo[] ammoModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] fullammoModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] revolverBarrelModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] revolver2BarrelModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] breakActionModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] altbreakActionModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] slideModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] altslideModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] pumpModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] chargeModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] altpumpModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] boltActionModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] minigunBarrelModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] leverActionModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] hammerModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] althammerModel = new ModelRendererTurbo[0];

    /**
     * Bullet Counter Models. Can be used to display bullet count in-game interface.
     * Each part is represented by number of rounds remaining per magazine.
     * <p>
     * - Simple counter will loop through each part. Allows flexibility for bullet counter UI design.
     * <p>
     * - Adv counter used for counting mags of more than 10, to reduce texture parts. Divides count into digits.
     *	 Less flexibility as it requires 10 textures parts at maximum (numbers 0-9).
     */
    protected ModelRendererTurbo[] bulletCounterModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[][] advBulletCounterModel = new ModelRendererTurbo[0][0];

    // These designate the locations of 3D attachment models on the gun
    protected Vector3f barrelAttachPoint = new Vector3f();
    protected Vector3f scopeAttachPoint = new Vector3f();
    protected Vector3f stockAttachPoint = new Vector3f();
    protected Vector3f gripAttachPoint = new Vector3f();
    protected Vector3f gadgetAttachPoint = new Vector3f();
    protected Vector3f slideAttachPoint = new Vector3f();
    protected Vector3f pumpAttachPoint = new Vector3f();
    protected Vector3f accessoryAttachPoint = new Vector3f();

    private final List<ModelRenderer> boxList = new ArrayList<>();
    private final Map<String, TextureOffset> modelTextureMap = new HashMap<>();

    private ResourceLocation texture;

    public ModelGun()
    {
        super(RenderType::entityTranslucent);
    }

    /**
     * Flips the model. Generally only for backwards compatibility
     */
    public void flipAll()
    {
        flip(gunModel);
        flip(defaultBarrelModel);
        flip(defaultScopeModel);
        flip(defaultStockModel);
        flip(defaultGripModel);
        flip(defaultGadgetModel);
        flip(ammoModel);
        flip(fullammoModel);
        flip(slideModel);
        flip(altslideModel);
        flip(pumpModel);
        flip(altpumpModel);
        flip(boltActionModel);
        flip(chargeModel);
        flip(minigunBarrelModel);
        flip(revolverBarrelModel);
        flip(revolver2BarrelModel);
        flip(breakActionModel);
        flip(altbreakActionModel);
        flip(hammerModel);
        flip(althammerModel);
        flip(bulletCounterModel);

        for(ModelRendererTurbo[] mod : advBulletCounterModel)
            flip(mod);
    }

    protected void flip(ModelRendererTurbo[] model)
    {
        for(ModelRendererTurbo part : model)
        {
            part.doMirror(false, true, true);
            part.setRotationPoint(part.rotationPointX, -part.rotationPointY, -part.rotationPointZ);
        }
    }

    /**
     * Translates the model
     */
    public void translateAll(float x, float y, float z)
    {
        translate(gunModel, x, y, z);
        translate(defaultBarrelModel, x, y, z);
        translate(defaultScopeModel, x, y, z);
        translate(defaultStockModel, x, y, z);
        translate(defaultGripModel, x, y, z);
        translate(defaultGadgetModel, x, y, z);
        translate(ammoModel, x, y, z);
        translate(fullammoModel, x, y, z);
        translate(slideModel, x, y, z);
        translate(altslideModel, x, y, z);
        translate(pumpModel, x, y, z);
        translate(altpumpModel, x, y, z);
        translate(boltActionModel, x, y, z);
        translate(chargeModel, x, y, z);
        translate(minigunBarrelModel, x, y, z);
        translate(revolverBarrelModel, x, y, z);
        translate(revolver2BarrelModel, x, y, z);
        translate(breakActionModel, x, y, z);
        translate(altbreakActionModel, x, y, z);
        translate(hammerModel, x, y, z);
        translate(althammerModel, x, y, z);
        translate(bulletCounterModel, x, y, z);
        translateAttachment(barrelAttachPoint, x, y, z);
        translateAttachment(scopeAttachPoint, x, y, z);
        translateAttachment(gripAttachPoint, x, y, z);
        translateAttachment(stockAttachPoint, x, y, z);
        translateAttachment(gadgetAttachPoint, x, y, z);
        translateAttachment(slideAttachPoint, x, y, z);
        translateAttachment(pumpAttachPoint, x, y, z);
        translateAttachment(accessoryAttachPoint, x, y, z);
    }

    protected void translate(ModelRendererTurbo[] model, float x, float y, float z)
    {
        for(ModelRendererTurbo mod : model)
        {
            mod.rotationPointX += x;
            mod.rotationPointY += y;
            mod.rotationPointZ += z;
        }
    }

    protected void translateAttachment(Vector3f vector, float x, float y, float z)
    {
        vector.x -= x / 16F;
        vector.y -= y / 16F;
        vector.z -= z / 16F;
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

    @Override
    public ResourceLocation getTexture()
    {
        return texture;
    }

    @Override
    public void setTexture(ResourceLocation texture)
    {
        this.texture = texture;
    }

    @Override
    public void setType(GunType type)
    {
        this.type = type;
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack pPoseStack, @NotNull VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha)
    {
        //TODO
    }
}
