package com.zouhair.magicalium_g.blocks.entity.custom;

import com.zouhair.magicalium_g.blocks.custom.BoilerBlock;
import com.zouhair.magicalium_g.blocks.entity.InitBlockEntities;
import com.zouhair.magicalium_g.recipes.BoilerRecipe;
import com.zouhair.magicalium_g.screens.BoilerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BoilerBlockEntity extends BlockEntity implements MenuProvider {
    private int progress = 0;
    private int maxProgress = 72;
    protected final ContainerData data = createData();
    private final ItemStackHandler itemHandler = createItemHandler();
    private LazyOptional<IItemHandler> lazyItemHandler;

    public BoilerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(InitBlockEntities.BRONZE_BOILER_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Boiler");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new BoilerMenu(pContainerId, pPlayerInventory, this, data);
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return lazyItemHandler.cast();
        }
        // we can check for other Capabilities and add them HERE!
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    // the load & saveAdditional : are used to read and save data form and to save files  called with chunks
    // on every data change setChanged() needs to be called
    @Override
    protected void saveAdditional(CompoundTag pTag) { // save data
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("boiler_block.progress", progress);
    }
    @Override
    public void load(CompoundTag pTag) { // load data
        if(pTag.contains("inventory")){
            itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        }
        if (pTag.contains("boiler_block.progress")) {
            progress = pTag.getInt("boiler_block.progress");
        }
        super.load(pTag);
    }

    // tick Method is called to make the BlockEntity a Ticking BlockEntity, and it will preform actions on every tick
    // But it has to be called in the Block (that this BlockEntity is assigned to) with the getTicker
    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, BoilerBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity)) {
            pBlockEntity.progress++;
            setChanged(pLevel, pPos, pState); // in case we logged out

            if(pBlockEntity.progress > pBlockEntity.maxProgress) {
                craftItem(pBlockEntity);
                pState.setValue(BoilerBlock.LIT, true);
            }
        } else {
            pBlockEntity.resetProgress();
            pState.setValue(BoilerBlock.LIT, false);
            setChanged(pLevel, pPos, pState);
        }
    }


    // helper Methods:
    private static boolean hasRecipe(BoilerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<BoilerRecipe> match = level.getRecipeManager()
                .getRecipeFor(BoilerRecipe.Type.INSTANCE, inventory, level);


        System.out.println("match.isPresent:" + match.isPresent());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem())
                && hasFuelInFuelSlot(entity);
    }


    private static boolean hasFuelInFuelSlot(BoilerBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(1).getItem() == Items.COAL_BLOCK;
    }

    private static void craftItem(BoilerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());

        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<BoilerRecipe> match = level.getRecipeManager()
                .getRecipeFor(BoilerRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()){
            entity.itemHandler.extractItem(0, 1, false);
            entity.itemHandler.extractItem(1, 1, false);

            entity.itemHandler.setStackInSlot(2, new ItemStack(Items.DIAMOND,
                    entity.itemHandler.getStackInSlot(2).getCount() + 1));

            entity.resetProgress();
        }
    }

    private ItemStackHandler createItemHandler() {
        return new ItemStackHandler(3) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged(); // to make sure the block is saved on change
            }
        };
    }
    private ContainerData createData() {
        return new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return BoilerBlockEntity.this.progress;
                    case 1:
                        return BoilerBlockEntity.this.maxProgress;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        BoilerBlockEntity.this.progress = value;
                        break;
                    case 1:
                        BoilerBlockEntity.this.maxProgress = value;
                        break;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i=0; i<itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private void resetProgress() {
        this.progress = 0;
    }
    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
        return inventory.getItem(2).getItem() == output.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}
