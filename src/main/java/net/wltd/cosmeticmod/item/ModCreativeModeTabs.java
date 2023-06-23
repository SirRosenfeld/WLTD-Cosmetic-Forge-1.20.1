package net.wltd.cosmeticmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.wltd.cosmeticmod.CosmeticMod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CosmeticMod.MOD_ID);

    public static RegistryObject<CreativeModeTab> COSMETIC_TAB = CREATIVE_MODE_TABS.register("cosmetic_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.getDefaultHelmet()))
                    .title(Component.translatable("creativemodetab.cosmetic_tab")).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
