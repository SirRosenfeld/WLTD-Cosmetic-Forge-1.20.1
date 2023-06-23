package net.wltd.cosmeticmod.item.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.wltd.cosmeticmod.CosmeticMod;
import net.wltd.cosmeticmod.item.custom.GenericArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class GenericArmorModel extends GeoModel<GenericArmorItem> {
    private final String armorName;

    public GenericArmorModel(String armorName) {
        this.armorName = armorName;
    }

    @Override
    public ResourceLocation getModelResource(GenericArmorItem animatable) {
        return new ResourceLocation(CosmeticMod.MOD_ID, "geo/" + armorName + "_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GenericArmorItem animatable) {
        return new ResourceLocation(CosmeticMod.MOD_ID, "textures/armor/" + armorName + "_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GenericArmorItem animatable) {
        return new ResourceLocation(CosmeticMod.MOD_ID, "animations/" + armorName + "_armor.animation.json");
    }
}