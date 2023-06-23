package net.wltd.cosmeticmod.item;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wltd.cosmeticmod.CosmeticMod;
import net.wltd.cosmeticmod.item.custom.GenericArmorItem;

import java.util.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CosmeticMod.MOD_ID);
    public static List<RegistryObject<Item>> ARMOR_ITEMS = new ArrayList<>();

    static {
        List<String> armorSetNames = Arrays.asList("baseyi", "jamesbond");

        for (String armorName : armorSetNames) {
            Map<ArmorItem.Type, Integer> defensePoints = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266655_) -> {
                p_266655_.put(ArmorItem.Type.BOOTS, 1);
                p_266655_.put(ArmorItem.Type.LEGGINGS, 2);
                p_266655_.put(ArmorItem.Type.CHESTPLATE, 3);
                p_266655_.put(ArmorItem.Type.HELMET, 1);
            });
            ModArmorMaterials.add(armorName, 5, defensePoints, 19, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.of(Items.LEATHER));
            ArmorMaterial modArmorMaterial = ModArmorMaterials.get(armorName);

            ARMOR_ITEMS.add(ITEMS.register(armorName + "_helmet", () -> new GenericArmorItem(modArmorMaterial, ArmorItem.Type.HELMET, new Item.Properties(), armorName)));
            ARMOR_ITEMS.add(ITEMS.register(armorName + "_chestplate", () -> new GenericArmorItem(modArmorMaterial, ArmorItem.Type.CHESTPLATE, new Item.Properties(), armorName)));
            ARMOR_ITEMS.add(ITEMS.register(armorName + "_leggings", () -> new GenericArmorItem(modArmorMaterial, ArmorItem.Type.LEGGINGS, new Item.Properties(), armorName)));
            ARMOR_ITEMS.add(ITEMS.register(armorName + "_boots", () -> new GenericArmorItem(modArmorMaterial, ArmorItem.Type.BOOTS, new Item.Properties(), armorName)));
        }
    }

    public static Item getDefaultHelmet() {
        if (!ARMOR_ITEMS.isEmpty())
            return ARMOR_ITEMS.get(0).get();
         else
            return Items.IRON_HELMET;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}