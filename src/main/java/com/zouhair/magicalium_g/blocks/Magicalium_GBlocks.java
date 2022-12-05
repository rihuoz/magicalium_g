package com.zouhair.magicalium_g.blocks;

import com.zouhair.magicalium_g.Magicalium_g;
import com.zouhair.magicalium_g.items.Magicalium_GCreativeTabs;
import com.zouhair.magicalium_g.items.Magicalium_GItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Magicalium_GBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Magicalium_g.MOD_ID);

    public static final RegistryObject<Block> LIGNITE_COAL_BLOCK = registerBlock("lignite_coal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5.0f, 6.0f)
                    .requiresCorrectToolForDrops()
            ), Magicalium_GCreativeTabs.MAGICALIUM_G_MATERIAL_TAB);
    public static final RegistryObject<Block> BITUMINOUS_COAL_BLOCK = registerBlock("bituminous_coal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5.0f, 6.0f)
                    .requiresCorrectToolForDrops()
            ), Magicalium_GCreativeTabs.MAGICALIUM_G_MATERIAL_TAB);
    public static final RegistryObject<Block> ANTHRACITE_COAL_BLOCK = registerBlock("anthracite_coal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5.0f, 6.0f)
                    .requiresCorrectToolForDrops()
            ), Magicalium_GCreativeTabs.MAGICALIUM_G_MATERIAL_TAB);
    public static final RegistryObject<Block> LIGNITE_COAL_ORE = registerBlock("lignite_coal_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.5f, 3.0f)
                    .requiresCorrectToolForDrops()
            ), Magicalium_GCreativeTabs.MAGICALIUM_G_ORE_TAB);
    public static final RegistryObject<Block> BITUMINOUS_COAL_ORE = registerBlock("bituminous_coal_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.5f, 3.0f)
                    .requiresCorrectToolForDrops()
            ), Magicalium_GCreativeTabs.MAGICALIUM_G_ORE_TAB);
    public static final RegistryObject<Block> ANTHRACITE_COAL_ORE = registerBlock("anthracite_coal_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.5f, 3.0f)
                    .requiresCorrectToolForDrops()
            ), Magicalium_GCreativeTabs.MAGICALIUM_G_ORE_TAB);
    public static final RegistryObject<Block> DEEPSLATE_LIGNITE_COAL_ORE = registerBlock("deepslate_lignite_coal_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ), Magicalium_GCreativeTabs.MAGICALIUM_G_ORE_TAB);
    public static final RegistryObject<Block> DEEPSLATE_BITUMINOUS_COAL_ORE = registerBlock("deepslate_bituminous_coal_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ), Magicalium_GCreativeTabs.MAGICALIUM_G_ORE_TAB);
    public static final RegistryObject<Block> DEEPSLATE_ANTHRACITE_COAL_ORE = registerBlock("deepslate_anthracite_coal_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6.0f, 3.0f)
                    .requiresCorrectToolForDrops()
            ), Magicalium_GCreativeTabs.MAGICALIUM_G_ORE_TAB);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                                CreativeModeTab tab) {
       return Magicalium_GItems.ITEMS.register(name, () -> new BlockItem(block.get(),
               new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
