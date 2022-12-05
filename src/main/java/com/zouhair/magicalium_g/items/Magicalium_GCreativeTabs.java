package com.zouhair.magicalium_g.items;

import com.zouhair.magicalium_g.blocks.Magicalium_GBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Magicalium_GCreativeTabs {
    public static final CreativeModeTab MAGICALIUM_G_ORE_TAB = new CreativeModeTab("magicalium_g_ores") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Magicalium_GBlocks.ANTHRACITE_COAL_ORE.get());
        }
    };

    public static final CreativeModeTab MAGICALIUM_G_MATERIAL_TAB = new CreativeModeTab("magicalium_g_materials") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Magicalium_GItems.ANTHRACITE_COAL.get());
        }
    };
}
