package com.zouhair.magicalium_g.setup;

import com.zouhair.magicalium_g.blocks.InitBlocks;
import com.zouhair.magicalium_g.screens.BoilerScreen;
import com.zouhair.magicalium_g.screens.InitMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {
    public static void init(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(InitBlocks.BRONZE_BENCH.get(), RenderType.cutout());

        MenuScreens.register(InitMenuTypes.BOILER_MENU.get(), BoilerScreen::new);
    }
}
