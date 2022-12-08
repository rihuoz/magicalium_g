package com.zouhair.magicalium_g.data_generation.tags;

import com.zouhair.magicalium_g.Magicalium_g;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GenerateItemTags extends ItemTagsProvider {
    public GenerateItemTags(DataGenerator pGenerator, BlockTagsProvider blockTags, ExistingFileHelper fileHelper) {
        super(pGenerator, blockTags, Magicalium_g.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags() {

    }

    @Override
    public String getName() {
        return "Magicalium tags";
    }
}
