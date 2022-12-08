package com.zouhair.magicalium_g.data_generation;

import com.zouhair.magicalium_g.Magicalium_g;
import com.zouhair.magicalium_g.data_generation.tags.GenerateBlockTags;
import com.zouhair.magicalium_g.data_generation.tags.GenerateItemTags;
import com.zouhair.magicalium_g.data_generation.tags.GenerateLootTables;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Magicalium_g.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent dataEvent) {
        DataGenerator dataGenerator = dataEvent.getGenerator();
        if(dataEvent.includeClient()) {

        }
        if(dataEvent.includeServer()) {
            GenerateBlockTags blockTags = new GenerateBlockTags(dataGenerator, dataEvent.getExistingFileHelper());

            dataGenerator.addProvider(blockTags);
            dataGenerator.addProvider(new GenerateRecipes(dataGenerator));
            dataGenerator.addProvider(new GenerateItemTags(dataGenerator, blockTags, dataEvent.getExistingFileHelper()));
        }
    }
}
