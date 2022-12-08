package com.zouhair.magicalium_g.data_generation.tags;

import com.zouhair.magicalium_g.Magicalium_g;
import com.zouhair.magicalium_g.blocks.InitBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GenerateBlockTags extends BlockTagsProvider {
    public GenerateBlockTags(DataGenerator pGenerator, ExistingFileHelper fileHelper) {
        super(pGenerator, Magicalium_g.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)

                .add(InitBlocks.ANTHRACITE_COAL_BLOCK.get())
                .add(InitBlocks.BITUMINOUS_COAL_BLOCK.get())
                .add(InitBlocks.LIGNITE_COAL_BLOCK.get())

                .add(InitBlocks.ANTHRACITE_COAL_ORE.get())
                .add(InitBlocks.BITUMINOUS_COAL_ORE.get())
                .add(InitBlocks.LIGNITE_COAL_ORE.get())
                .add(InitBlocks.MAGNETITE_ORE.get())
                .add(InitBlocks.TELLURIC_IRON_ORE.get())
                .add(InitBlocks.VANADIUM_MAGNETITE_ORE.get())
                .add(InitBlocks.BROWN_LIMONITE_ORE.get())
                .add(InitBlocks.YELLOW_LIMONITE_ORE.get())
                .add(InitBlocks.BANDED_IRON_ORE.get())

                .add(InitBlocks.DEEPSLATE_ANTHRACITE_COAL_ORE.get())
                .add(InitBlocks.DEEPSLATE_BITUMINOUS_COAL_ORE.get())
                .add(InitBlocks.DEEPSLATE_LIGNITE_COAL_ORE.get())
                .add(InitBlocks.DEEPSLATE_MAGNETITE_ORE.get())
                .add(InitBlocks.DEEPSLATE_TELLURIC_IRON_ORE.get())
                .add(InitBlocks.DEEPSLATE_VANADIUM_MAGNETITE_ORE.get())
                .add(InitBlocks.DEEPSLATE_BROWN_LIMONITE_ORE.get())
                .add(InitBlocks.DEEPSLATE_YELLOW_LIMONITE_ORE.get())
                .add(InitBlocks.DEEPSLATE_BANDED_IRON_ORE.get())
                ;


        tag(BlockTags.NEEDS_IRON_TOOL)

                .add(InitBlocks.ANTHRACITE_COAL_BLOCK.get())
                .add(InitBlocks.BITUMINOUS_COAL_BLOCK.get())
                .add(InitBlocks.LIGNITE_COAL_BLOCK.get())

                .add(InitBlocks.ANTHRACITE_COAL_ORE.get())
                .add(InitBlocks.BITUMINOUS_COAL_ORE.get())
                .add(InitBlocks.LIGNITE_COAL_ORE.get())
                .add(InitBlocks.MAGNETITE_ORE.get())
                .add(InitBlocks.TELLURIC_IRON_ORE.get())
                .add(InitBlocks.VANADIUM_MAGNETITE_ORE.get())
                .add(InitBlocks.BROWN_LIMONITE_ORE.get())
                .add(InitBlocks.YELLOW_LIMONITE_ORE.get())
                .add(InitBlocks.BANDED_IRON_ORE.get())

                .add(InitBlocks.DEEPSLATE_ANTHRACITE_COAL_ORE.get())
                .add(InitBlocks.DEEPSLATE_BITUMINOUS_COAL_ORE.get())
                .add(InitBlocks.DEEPSLATE_LIGNITE_COAL_ORE.get())
                .add(InitBlocks.DEEPSLATE_MAGNETITE_ORE.get())
                .add(InitBlocks.DEEPSLATE_TELLURIC_IRON_ORE.get())
                .add(InitBlocks.DEEPSLATE_VANADIUM_MAGNETITE_ORE.get())
                .add(InitBlocks.DEEPSLATE_BROWN_LIMONITE_ORE.get())
                .add(InitBlocks.DEEPSLATE_YELLOW_LIMONITE_ORE.get())
                .add(InitBlocks.DEEPSLATE_BANDED_IRON_ORE.get())
                ;

    }

    @Override
    public String getName() {
        return "Magicalium Tags";
    }
}
