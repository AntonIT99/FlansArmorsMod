package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.wolffsarmormod.client.model.IFlanModel;
import com.wolffsarmormod.common.types.GunType;
import com.wolffsmod.client.model.ModelRenderer;
import com.wolffsmod.client.model.TextureOffset;
import org.jetbrains.annotations.NotNull;

import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelGun extends Model implements IFlanModel<GunType>
{
    protected static final Vector3f invalid = new Vector3f(0f, Float.MAX_VALUE, 0f);

    protected GunType type;

    /** Static models with no animation */
    protected ModelRendererTurbo[] gunModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] backpackModel = new ModelRendererTurbo[0]; //For flamethrowers and such like. Rendered on the player's back

    /** These models appear when no attachment exists */
    protected ModelRendererTurbo[] defaultBarrelModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] defaultScopeModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] defaultStockModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] defaultGripModel = new ModelRendererTurbo[0];
    protected ModelRendererTurbo[] defaultGadgetModel = new ModelRendererTurbo[0];

    /** Animated models */
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
    /** For Adv Bullet Counter. Reads in numbers from left hand side when false */
    protected boolean countOnRightHandSide;
    /** Toggle the counters active. Saves render performance. */
    protected boolean isBulletCounterActive;
    protected boolean isAdvBulletCounterActive;

    /** The point about which the minigun barrel rotates. Rotation is along the line of the gun through this point */
    protected Vector3f minigunBarrelOrigin = new Vector3f();
    protected Vector3f minigunBarrelSpinDirection = new Vector3f(1F, 0F, 0F);
    protected float minigunBarrelSpinSpeed = 1F;

    /** These designate the locations of 3D attachment models on the gun */
    protected Vector3f barrelAttachPoint = new Vector3f();
    protected Vector3f scopeAttachPoint = new Vector3f();
    protected Vector3f stockAttachPoint = new Vector3f();
    protected Vector3f gripAttachPoint = new Vector3f();
    protected Vector3f gadgetAttachPoint = new Vector3f();
    protected Vector3f slideAttachPoint = new Vector3f();
    protected Vector3f pumpAttachPoint = new Vector3f();
    protected Vector3f accessoryAttachPoint = new Vector3f();

    /** Muzzle flash models */
    protected Vector3f defaultBarrelFlashPoint = null;
    protected Vector3f muzzleFlashPoint = null;
    protected boolean hasFlash;

    /** Arms rendering */
    protected boolean hasArms;
    /** Changes the rotation point to be the hand for easier animation setup */
    protected boolean easyArms;
    protected Vector3f armScale = new Vector3f(0.8F,0.8F,0.8F);
    protected Vector3f leftArmPos = new Vector3f(0,0,0);
    protected Vector3f leftArmRot = new Vector3f(0,0,0);
    protected Vector3f leftArmScale = new Vector3f(1,1,1);
    protected Vector3f rightArmPos = new Vector3f(0,0,0);
    protected Vector3f rightArmRot = new Vector3f(0,0,0);
    protected Vector3f rightArmScale = new Vector3f(1,1,1);
    protected Vector3f rightArmReloadPos = new Vector3f(0,0,0);
    protected Vector3f rightArmReloadRot = new Vector3f(0,0,0);
    protected Vector3f leftArmReloadPos = new Vector3f(0,0,0);
    protected Vector3f leftArmReloadRot = new Vector3f(0,0,0);
    protected Vector3f rightArmChargePos = new Vector3f(0,0,0);
    protected Vector3f rightArmChargeRot = new Vector3f(0,0,0);
    protected Vector3f leftArmChargePos = new Vector3f(0,0,0);
    protected Vector3f leftArmChargeRot = new Vector3f(0,0,0);
    protected Vector3f stagedrightArmReloadPos = new Vector3f(0,0,0);
    protected Vector3f stagedrightArmReloadRot = new Vector3f(0,0,0);
    protected Vector3f stagedleftArmReloadPos = new Vector3f(0,0,0);
    protected Vector3f stagedleftArmReloadRot = new Vector3f(0,0,0);
    protected boolean rightHandAmmo;
    protected boolean leftHandAmmo;

    /** Casing and muzzle flash parameters */
    //  Total distance to translate
    protected Vector3f casingAnimDistance = new Vector3f(0, 0, 16);
    //  Total range in variance for random motion
    protected Vector3f casingAnimSpread = new Vector3f(2, 4, 4);
    //  Number of ticks (I guess?) to complete movement
    protected int casingAnimTime = 20;
    //  Rotation of the casing, 180 is the total rotation. If you do not understand rotation vectors, like me, just use the standard value here.
    protected Vector3f casingRotateVector = new Vector3f(0.1F, 1F, 0.1F);
    protected Vector3f casingAttachPoint = new Vector3f(0F, 0F, 0F);
    // Time before the casing is ejected from gun
    protected int casingDelay = 0;
    // Scale the bullet casing separately from gun
    protected float caseScale = 1F;
    protected float flashScale = 1F;

    /** Recoil and slide based parameters */
    protected float gunSlideDistance = 1F / 4F;
    protected float altgunSlideDistance = 1F / 4F;
    protected float RecoilSlideDistance = 2F / 16F;
    protected float RotateSlideDistance = -3F;
    protected float ShakeDistance = 0F;
    /** Select an amount of recoil per shot, between 0 and 1 */
    protected float recoilAmount = 0.33F;

    /** Charge handle distance/delay/time */
    protected float chargeHandleDistance = 0F;
    protected int chargeDelay = 0;
    protected int chargeDelayAfterReload = 0;
    protected int chargeTime = 1;

    protected EnumAnimationType animationType = EnumAnimationType.NONE;
    protected EnumMeleeAnimation meleeAnimation = EnumMeleeAnimation.DEFAULT;
    protected float tiltGunTime = 0.15F, unloadClipTime = 0.35F, loadClipTime = 0.35F, untiltGunTime = 0.15F;
    /** If true, then the scope attachment will move with the top slide */
    protected boolean scopeIsOnSlide;
    /** If true, then the scope attachment will move with the break action. Can be combined with the above */
    protected boolean scopeIsOnBreakAction;
    /** For rifles and shotguns. Currently a generic reload animation regardless of how full the internal magazine already is */
    protected float numBulletsInReloadAnimation = 1;
    /** For shotgun pump handles, rifle bolts and hammer pullbacks */
    protected int pumpDelay = 0, pumpDelayAfterReload = 0, pumpTime = 1, hammerDelay = 0;
    /** For shotgun pump handle */
    protected float pumpHandleDistance = 4F / 16F;
    /** For end loaded projectiles */
    protected float endLoadedAmmoDistance = 1F;
    /** For break action projectiles */
    protected float breakActionAmmoDistance = 1F;
    /** If true, then the grip attachment will move with the shotgun pump */
    protected boolean gripIsOnPump;
    /** If true, then the gadget attachment will move with the shotgun pump */
    protected boolean gadgetIsOnPump;
    /** The rotation point for the barrel break */
    protected Vector3f barrelBreakPoint = new Vector3f();
    protected Vector3f altbarrelBreakPoint = new Vector3f();
    /** The amount the revolver barrel flips out by */
    protected float revolverFlipAngle = 15F;
    /** The amount the revolver2 barrel flips out by */
    protected float revolver2FlipAngle = 15F;
    /** The rotation point for the revolver flip */
    protected Vector3f revolverFlipPoint = new Vector3f();
    /** The rotation point for the revolver2 flip */
    protected Vector3f revolver2FlipPoint = new Vector3f();
    /** The angle the gun is broken by for break actions */
    protected float breakAngle = 45F;
    protected float altbreakAngle = 45F;
    /** If true, then the gun will perform a spinning reload animation */
    protected boolean spinningCocking;
    /** The point, in model co-ordinates, about which the gun is spun */
    protected Vector3f spinPoint = new Vector3f();
    /** The point where the hammer will pivot and spin from */
    protected Vector3f hammerSpinPoint = new Vector3f();
    protected Vector3f althammerSpinPoint = new Vector3f();
    protected float hammerAngle = 75F;
    protected float althammerAngle = 75F;
    /** Single action cocking check */
    protected boolean isSingleAction;
    /** If true, lock the slide when the last bullet is fired */
    protected boolean slideLockOnEmpty;
    /** If true, move the hands with the pump action */
    protected boolean lefthandPump;
    protected boolean righthandPump;
    /** If true, move the hands with the charge action */
    protected boolean rightHandCharge;
    protected boolean leftHandCharge;
    /** If true, move the hands with the bolt action */
    protected boolean rightHandBolt;
    protected boolean leftHandBolt;
    /** How far to rotate the bolt */
    protected float boltRotationAngle = 0F;
    /** How far to translate the bolt */
    protected float boltCycleDistance = 1F;
    /** Offsets the bolt rotation point to help align it properly */
    protected Vector3f boltRotationOffset = new Vector3f(0F, 0F, 0F);
    protected float pumpModifier = 4F;
    /** Hand offset when gun is charging */
    protected Vector3f chargeModifier = new Vector3f(8F, 4F, 4F);
    /**If true, gun will translate when equipped with a sight attachment */
    protected float gunOffset = 0F;
    protected float crouchZoom = 0F;
    protected boolean fancyStance = true;
    /** deprecated, do not use, use sprintStanceTranslate */
    protected Vector3f stanceTranslate = new Vector3f();
    /** deprecated, do not use, use sprintStanceRotate */
    protected Vector3f stanceRotate = new Vector3f();
    protected Vector3f sprintStanceTranslate = new Vector3f();
    protected Vector3f sprintStanceRotate = new Vector3f();

    /** Custom reload Parameters. If Enum.CUSTOM is set, these parameters can build an animation within the gun model classes */
    protected float rotateGunVertical = 0F;
    protected float rotateGunHorizontal = 0F;
    protected float tiltGun = 0F;
    protected Vector3f translateGun = new Vector3f(0F, 0F, 0F);
    /** Ammo Model reload parameters */
    protected float rotateClipVertical = 0F;
    protected float stagedrotateClipVertical = 0F;
    protected float rotateClipHorizontal = 0F;
    protected float stagedrotateClipHorizontal = 0F;
    protected float tiltClip = 0F;
    protected float stagedtiltClip = 0F;
    protected Vector3f translateClip = new Vector3f(0F, 0F, 0F);
    protected Vector3f stagedtranslateClip = new Vector3f(0F, 0F, 0F);
    protected boolean stagedReload;

    /** Disables moving gun back when ADS. */
    protected boolean stillRenderGunWhenScopedOverlay;
    /** Multiplier for ADS effect (moving gun to middle, e.t.c.) */
    protected float adsEffectMultiplier = 1;
    /** This offsets the render position for third person */
    protected Vector3f thirdPersonOffset = new Vector3f();
    /** This offsets the render position for item frames */
    protected Vector3f itemFrameOffset = new Vector3f();
    /** Allows you to move the rotation helper to determine the required offsets for moving parts */
    protected Vector3f rotationToolOffset = new Vector3f(0F, 0F, 0F);

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
        flip(leverActionModel);
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
        translate(leverActionModel, x, y, z);
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
        float modelScale = type != null ? type.getModelScale() : 1F;
        // TODO
        renderGun(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, modelScale);
    }

    public void renderGun(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha, float scale)
    {
        render(gunModel, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, scale);
    }

    public void render(ModelRendererTurbo[] models, PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha, float scale)
    {
        for (ModelRendererTurbo mod : models)
        {
            mod.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha, scale);
        }
    }
}
