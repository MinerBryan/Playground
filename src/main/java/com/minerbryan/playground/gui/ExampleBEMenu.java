package com.minerbryan.playground.gui;

import com.minerbryan.playground.entity.ExampleBlockEntityEntity;
import com.minerbryan.playground.registries.BlockRegistry;
import com.minerbryan.playground.registries.MenuRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

// Adds functionality to the screen
public class ExampleBEMenu extends AbstractContainerMenu {
    public final ExampleBlockEntityEntity blockEntity;
    private final Level level;

    public ExampleBEMenu(int containerID, Inventory inv, FriendlyByteBuf extraData){
        this(containerID, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));    //Allows us to give the menu extra data upon registration
    }

    public ExampleBEMenu(int containerID, Inventory inv, BlockEntity blockEntity) {
        super(MenuRegistry.EXAMPLE_BE_MENU.get(), containerID);
        this.blockEntity = ((ExampleBlockEntityEntity) blockEntity);
        this.level = inv.player.level();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 0, 80, 35));
    }

    //  (Hotbar, Player, ModBlock)  -> Index:([0,8],[9,35],[36,))
    private static final int BE_SLOT_AMOUNT = 1;
    private static final int VANILLA_SLOT_AMOUNT = 36;
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot clickedSlot = slots.get(index);    // get the slot the item is in
        if(clickedSlot != null && clickedSlot.hasItem()){ // check if slot has an item or exists
            ItemStack item = clickedSlot.getItem(); // get the itemstack
            ItemStack itemCopy = item.copy();   // Copy the itemstack

            if(index < VANILLA_SLOT_AMOUNT){ // vanilla container
                if(!moveItemStackTo(item, VANILLA_SLOT_AMOUNT, (VANILLA_SLOT_AMOUNT+BE_SLOT_AMOUNT), false)){
                    return ItemStack.EMPTY;
                }
            } else if (index < (VANILLA_SLOT_AMOUNT + BE_SLOT_AMOUNT)){
                if(!moveItemStackTo(item, 0,VANILLA_SLOT_AMOUNT , false)){
                    return ItemStack.EMPTY;
                }
            } else {
                return ItemStack.EMPTY;
            }

            if(item.isEmpty()) {
                clickedSlot.set(ItemStack.EMPTY);
            } else {
                clickedSlot.setChanged();
            }

            if(item.getCount() == itemCopy.getCount()){
                return ItemStack.EMPTY;
            }

            clickedSlot.onTake(player, item);
        }
        return  ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, BlockRegistry.EXAMPLE_BLOCK_ENTITY.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++){
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));    // #s are the (x,y) of the top left pixel of each slot (top left anchoring)
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
