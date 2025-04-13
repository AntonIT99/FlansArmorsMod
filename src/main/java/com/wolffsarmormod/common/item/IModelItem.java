package com.wolffsarmormod.common.item;

import com.wolffsarmormod.ArmorMod;
import com.wolffsarmormod.IContentProvider;
import com.wolffsarmormod.client.model.armor.IFlanModel;
import com.wolffsarmormod.common.types.InfoType;
import com.wolffsarmormod.util.ClassLoaderUtils;
import com.wolffsarmormod.util.DynamicReference;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public interface IModelItem<T extends InfoType, M extends IFlanModel<T>> extends IConfigurableItem<T>
{
    T getConfigType();

    @OnlyIn(Dist.CLIENT)
    void clientSideInit();

    @OnlyIn(Dist.CLIENT)
    String getTexturePath(String textureName);

    @OnlyIn(Dist.CLIENT)
    ResourceLocation getTexture();

    @OnlyIn(Dist.CLIENT)
    void setTexture(ResourceLocation texture);

    @OnlyIn(Dist.CLIENT)
    M getModel();

    @OnlyIn(Dist.CLIENT)
    void setModel(M model);

    @OnlyIn(Dist.CLIENT)
    boolean useCustomItemRendering();

    @OnlyIn(Dist.CLIENT)
    default void loadModel(@Nullable M defaultModel)
    {
        T configType = getConfigType();
        String className = configType.getModelClass();
        if (!className.isBlank())
        {
            IContentProvider contentPack = configType.getContentPack();
            DynamicReference actualClassName = configType.getActualModelClass();
            if (actualClassName != null)
            {
                try
                {
                    @SuppressWarnings("unchecked")
                    M model = (M) ClassLoaderUtils.loadAndModifyClass(contentPack, className, actualClassName.get()).getConstructor().newInstance();
                    model.setType(configType);
                }
                catch (Exception e)
                {
                    ArmorMod.log.error("{} item {}: Could not load model class {} from {}", configType.getType().getDisplayName(), configType.getShortName(), className, contentPack.getName(), e);
                }
            }

        }
        if (getModel() == null)
        {
            setModel(defaultModel);
        }
    }

    @OnlyIn(Dist.CLIENT)
    default void loadTexture()
    {
        T configType = getConfigType();
        DynamicReference texture = configType.getTexture();
        if (texture != null)
        {
            ResourceLocation textureRes = ResourceLocation.fromNamespaceAndPath(ArmorMod.FLANSMOD_ID, getTexturePath(texture.get()));
            setTexture(textureRes);
            getModel().setTexture(textureRes);
        }
        else
        {
            setTexture(TextureManager.INTENTIONAL_MISSING_TEXTURE);
            getModel().setTexture(TextureManager.INTENTIONAL_MISSING_TEXTURE);
        }

    }
}
