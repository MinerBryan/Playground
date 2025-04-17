package com.minerbryan.playground.registries.helpers;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

import static com.minerbryan.playground.registries.BlockRegistry.BLOCKS;
import static com.minerbryan.playground.registries.ItemRegistry.registerBlockItem;

public class BlockRegistryHelper {
    protected static DeferredBlock<LeavesBlock> registerBasicLeaves(String name) {
        return registerBlock(name, () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    }

    protected static DeferredBlock<LeavesBlock> registerLeaves(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new LeavesBlock(properties));
    }

    protected static DeferredBlock<FenceBlock> registerBasicFence(String name) {
        return registerBlock(name, () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    }

    protected static DeferredBlock<FenceBlock> registerFence(String name, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new FenceBlock(properties));
    }

    protected static DeferredBlock<FenceGateBlock> registerBasicFenceGate(String name) {
        return registerBlock(name, () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
    }

    protected static DeferredBlock<FenceGateBlock> registerFenceGate(String name, WoodType type, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new FenceGateBlock(type, properties));
    }

    protected static DeferredBlock<DoorBlock> registerBasicDoor(String name) {
        return registerBlock(name, () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    }

    protected static DeferredBlock<DoorBlock> registerDoor(String name, BlockSetType type, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new DoorBlock(type, properties));
    }

    protected static DeferredBlock<TrapDoorBlock> registerBasicTrapdoor(String name) {
        return registerBlock(name, () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
    }

    protected static DeferredBlock<TrapDoorBlock> registerTrapdoor(String name, BlockSetType type, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new TrapDoorBlock(type, properties));
    }

    protected static DeferredBlock<SaplingBlock> registerBasicSapling(String name, TreeGrower grower) {
        return registerBlock(name, () -> new SaplingBlock(grower, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    }

    protected static DeferredBlock<SaplingBlock> registerSapling(String name, TreeGrower grower, BlockBehaviour.Properties properties) {
        return registerBlock(name, () -> new SaplingBlock(grower, properties));
    }

    protected static DeferredBlock<Block> registerBasicBlock(String name, BlockBehaviour.Properties properties) {
        DeferredBlock<Block> deferredBlock = BLOCKS.registerSimpleBlock(name, properties);
        registerBlockItem(name, deferredBlock);
        return deferredBlock;
    }

    protected static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> deferredBlock = BLOCKS.register(name, block);
        registerBlockItem(name, deferredBlock);
        return deferredBlock;
    }
}
