package net.wltd.cosmeticmod.item.client.armor;

import net.wltd.cosmeticmod.item.custom.GenericArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GenericArmorRenderer extends GeoArmorRenderer<GenericArmorItem> {
    public GenericArmorRenderer(String armorName) {
        super(new GenericArmorModel(armorName));
    }
}