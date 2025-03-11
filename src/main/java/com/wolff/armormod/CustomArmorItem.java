package com.wolff.armormod;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.model.mw.ModelExoskeletonHelmet;
import com.wolff.armormod.client.ClientEventHandler;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

public class CustomArmorItem extends ArmorItem
{
    public CustomArmorItem(Type type) {
        super(CustomArmorMaterial.CUSTOM, type, new Item.Properties());
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
                if (ModelCustomArmour.ROOT == null)
                {
                    ModelCustomArmour.ROOT = Minecraft.getInstance().getEntityModels().bakeLayer(ClientEventHandler.CUSTOM_ARMOR);
                }
                return new ModelExoskeletonHelmet();
            }
        });
    }
}