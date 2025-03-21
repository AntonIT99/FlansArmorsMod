package com.wolffsarmormod.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.resources.model.ModelBakery;

@Mixin(ModelBakery.class)
public class ModelBakeryMixin
{
    /*@ModifyVariable(method = "loadBlockModel", at = @At(value = "STORE"), ordinal = 0)
    protected BlockModel modifyBlockModel(BlockModel original, ResourceLocation pLocation)
    {
        if (pLocation.getNamespace().equals(ArmorMod.MOD_ID) && pLocation.getPath().contains("item/"))
        {
            String itemName = pLocation.getPath().split("/")[1];
            String json = String.format("""
            {
                "parent": "item/generated",
                "textures": {
                    "layer0": "%s:item/%s"
                }
            }
            """, ArmorMod.MOD_ID, itemName);
            return BlockModel.fromString(json);
        }
        return original;
    }*/
}
