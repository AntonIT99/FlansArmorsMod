package com.wolff.armormod.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class CustomArmorItem extends ArmorItem
{
    public CustomArmorItem(ArmorMaterial material, ArmorItem.Type type, Properties properties) {
        super(material, type, properties);
    }

    /*@OnlyIn(Dist.CLIENT)
    public HumanoidModel<LivingEntity> getArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<LivingEntity> defaultModel) {
        return MyModelLoader.getModelForArmor(this);
    }*/
}
