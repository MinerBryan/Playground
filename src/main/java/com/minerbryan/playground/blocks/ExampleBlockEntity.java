package com.minerbryan.playground.blocks;

import com.minerbryan.playground.entity.ExampleBlockEntityEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ExampleBlockEntity extends BaseEntityBlock {
    public static final VoxelShape SHAPE = Block.box(2,0,2,14,13,14);
    public static final MapCodec<ExampleBlockEntity> CODEC = simpleCodec(ExampleBlockEntity::new);
    public ExampleBlockEntity(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    /*  BLOCK ENTITY STUFF */

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ExampleBlockEntityEntity(pos, state);
    }

    // Dropping inventory
    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {   // Check if the block is the same as a new one (I.E. if someone put an item in, then it's different from a new one)
            if(level.getBlockEntity(pos) instanceof ExampleBlockEntityEntity exampleBlockEntityEntity) {
                exampleBlockEntityEntity.drops();
                level.updateNeighbourForOutputSignal(pos, this);    // Output redstone signal?
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof ExampleBlockEntityEntity exampleBlockEntityEntity) {
            if(player.isCrouching() && !level.isClientSide()) {
                ((ServerPlayer) player).openMenu(new SimpleMenuProvider(exampleBlockEntityEntity, Component.literal("ExampleBlockEntityEntity")), pos);
                return ItemInteractionResult.SUCCESS;
            }

            if (exampleBlockEntityEntity.inventory.getStackInSlot(0).isEmpty() && !stack.isEmpty()) {
                exampleBlockEntityEntity.inventory.insertItem(0, stack.copy(), false); // Slot, ItemStack aka the item, Dont simulate-Meaning do the actual thing and dont fake it
                stack.shrink(1);
                level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 2f);
            } else if (stack.isEmpty()) {
                ItemStack stackOnBlock = exampleBlockEntityEntity.inventory.extractItem(0, 1, false);
                player.setItemInHand(InteractionHand.MAIN_HAND, stackOnBlock);
                exampleBlockEntityEntity.clearContents();
                level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 1f);
            }
        }
        return ItemInteractionResult.SUCCESS;
    }
}
