package net.wltd.cosmeticmod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {
    private static final Map<String, ArmorMaterial> armorMaterials = new HashMap<>();

    public static ArmorMaterial get(String name) {
        return armorMaterials.getOrDefault(name, ArmorMaterials.LEATHER); // Default to LEATHER if not found
    }

    public static void add(String name, int durabilityMultiplier, Map<ArmorItem.Type, Integer> defensePoints, int enchantmentValue,
                           SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        ArmorMaterial newMaterial = new CustomArmorMaterial(name, durabilityMultiplier, defensePoints, enchantmentValue,
                equipSound, toughness, knockbackResistance, repairIngredient);
        armorMaterials.put(name, newMaterial);
    }
    private static class CustomArmorMaterial implements ArmorMaterial {
        private final String name;
        private final int durabilityMultiplier;
        private final Map<ArmorItem.Type, Integer> defensePoints;
        private final int enchantmentValue;
        private final SoundEvent equipSound;
        private final float toughness;
        private final float knockbackResistance;
        private final Supplier<Ingredient> repairIngredient;

        public CustomArmorMaterial(String name, int durabilityMultiplier, Map<ArmorItem.Type, Integer> defensePoints, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
            this.name = name;
            this.defensePoints = defensePoints;
            this.enchantmentValue = enchantmentValue;
            this.durabilityMultiplier = durabilityMultiplier;
            this.equipSound = equipSound;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairIngredient = repairIngredient;
        }

        @Override
        public int getDurabilityForType(ArmorItem.Type p_266807_) {
            return 0;
        }

        @Override
        public int getDefenseForType(ArmorItem.Type p_267168_) {
            return 0;
        }

        @Override
        public int getEnchantmentValue() {
            return 0;
        }

        @Override
        public SoundEvent getEquipSound() {
            return null;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return repairIngredient.get();
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return knockbackResistance;
        }

        public String getSerializedName() {
            return this.name;
        }
        // Implement your custom ArmorMaterial here...
        // Assume this class is fully implemented and compatible with ArmorMaterial interface
    }
}
