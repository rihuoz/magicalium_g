package com.zouhair.magicalium_g;

import com.mojang.logging.LogUtils;
import com.zouhair.magicalium_g.blocks.InitBlocks;
import com.zouhair.magicalium_g.blocks.entity.InitBlockEntities;
import com.zouhair.magicalium_g.items.InitItems;
import com.zouhair.magicalium_g.screen.BoilerScreen;
import com.zouhair.magicalium_g.screen.InitMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Magicalium_g.MOD_ID)
public class Magicalium_g
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "magicalium_g";

    public Magicalium_g() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitItems.register(eventBus);
        InitBlocks.register(eventBus);

        InitBlockEntities.register(eventBus);
        InitMenuTypes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(InitBlocks.BRONZE_BENCH.get(), RenderType.cutout());

        MenuScreens.register(InitMenuTypes.BOILER_MENU.get(), BoilerScreen::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
