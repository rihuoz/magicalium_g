package com.zouhair.magicalium_g.fluids;

import com.zouhair.magicalium_g.Magicalium_g;
import com.zouhair.magicalium_g.blocks.InitBlocks;
import com.zouhair.magicalium_g.items.InitItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitFluids {
    public static final ResourceLocation WATER_STILL_TEXTURE = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_TEXTURE= new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_TEXTURE = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Magicalium_g.MOD_ID);

    public static final RegistryObject<FlowingFluid> STEAM_FLUID =
            FLUIDS.register("steam_fluid", () -> new ForgeFlowingFluid.Source(InitFluids.STEAM_PROPERTIES));

    public static final RegistryObject<FlowingFluid> STEAM_FLOWING =
            FLUIDS.register("steam_flowing", () -> new ForgeFlowingFluid.Flowing(InitFluids.STEAM_PROPERTIES));

    public static final ForgeFlowingFluid.Properties STEAM_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> STEAM_FLUID.get(), () -> STEAM_FLOWING.get(), FluidAttributes.builder(WATER_STILL_TEXTURE, WATER_FLOWING_TEXTURE)
            .density(600).gaseous().temperature(373).viscosity(13).overlay(WATER_OVERLAY_TEXTURE)
            .color(0xbfffffff)).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(() -> InitFluids.STEAM_BLOCK.get()).bucket(() -> InitItems.STEAM_BUCKET.get());

    public static final RegistryObject<LiquidBlock> STEAM_BLOCK = InitBlocks.BLOCKS.register("steam",
            () -> new LiquidBlock(() -> InitFluids.STEAM_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
