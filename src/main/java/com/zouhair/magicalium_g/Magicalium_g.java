package com.zouhair.magicalium_g;

import com.mojang.logging.LogUtils;
import com.zouhair.magicalium_g.setup.ClientSetup;
import com.zouhair.magicalium_g.setup.InitRegister;
import com.zouhair.magicalium_g.setup.ModSetup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(Magicalium_g.MOD_ID)
public class Magicalium_g
{
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "magicalium_g";

    public Magicalium_g() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitRegister.init(eventBus);

        eventBus.addListener(ModSetup::init);
        eventBus.addListener(ClientSetup::init);


        MinecraftForge.EVENT_BUS.register(this);
    }


}
