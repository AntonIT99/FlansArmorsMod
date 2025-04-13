package com.wolffsarmormod.common.item;

import com.flansmod.client.model.ModelGun;
import com.wolffsarmormod.common.types.GunType;
import lombok.Getter;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.NotNull;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@Getter
public class GunItem extends Item implements IModelItem<GunType, ModelGun>, IOverlayItem<GunType>
{
    protected final GunType configType;

    public GunItem(GunType configType)
    {
        super(new Item.Properties());
        this.configType = configType;

        if (FMLEnvironment.dist == Dist.CLIENT)
            clientSideInit();
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced)
    {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        appendHoverText(tooltipComponents);
    }

    @Override
    public void clientSideInit()
    {

    }

    @Override
    public String getTexturePath(String textureName)
    {
        return "";
    }

    @Override
    public ResourceLocation getTexture()
    {
        return null;
    }

    @Override
    public void setTexture(ResourceLocation texture)
    {

    }

    @Override
    public ModelGun getModel()
    {
        return null;
    }

    @Override
    public void setModel(ModelGun model)
    {

    }

    @Override
    public boolean useCustomItemRendering()
    {
        return true;
    }

    @Override
    public Optional<ResourceLocation> getOverlay()
    {
        return Optional.empty();
    }

    @Override
    public void setOverlay(ResourceLocation overlay)
    {

    }
}
