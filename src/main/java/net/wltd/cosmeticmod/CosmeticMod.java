package net.wltd.cosmeticmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.wltd.cosmeticmod.block.ModBlocks;
import net.wltd.cosmeticmod.item.ModCreativeModeTabs;
import net.wltd.cosmeticmod.item.ModItems;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

@Mod(CosmeticMod.MOD_ID)
public class CosmeticMod {
    public static final String MOD_ID = "cosmeticmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CosmeticMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModeTabs.COSMETIC_TAB.get()) {
            for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                event.accept(item.get());
            }
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

}
