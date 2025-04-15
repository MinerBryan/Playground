package com.minerbryan.playground.registries;

import com.minerbryan.playground.PlaygroundMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PlaygroundMod.MODID);

    // Creates a new BlockItem with the id "playground:example_block", combining the namespace and path
    public static final DeferredItem<BlockItem> BISMUTH_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("bismuth_block", BlockRegistry.BISMUTH_BLOCK);
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ENTITY_ITEM = ITEMS.register("example_block_entity", () -> new BlockItem(BlockRegistry.EXAMPLE_BLOCK_ENTITY.get(), new Item.Properties()));

    //Ores
    public static final DeferredItem<BlockItem> STELLARIUM_ORE_ITEM = ITEMS.register("stellarium_ore", () -> new BlockItem(BlockRegistry.STELLARIUM_ORE.get(), new Item.Properties()));

    //Raw Blocks
//    public static final DeferredItem<BlockItem> RAW_STELLARIUM_BLOCk_ITEM = ITEMS.register("raw_stellarium_block", ())

    //Metal Blocks
    public static final DeferredItem<BlockItem> STELLARIUM_BLOCK_ITEM = ITEMS.register("stellarium_block", () -> new BlockItem(BlockRegistry.STELLARIUM_BLOCK.get(), new Item.Properties()));

    //Sapling
    public static final DeferredItem<BlockItem> NEBULA_SAPLING_ITEM = ITEMS.register("nebula_sapling", () -> new BlockItem(BlockRegistry.NEBULA_SAPLING.get(), new Item.Properties()));

    //Planks
    public static final DeferredItem<BlockItem> NEBULA_PLANKS_ITEM = ITEMS.register("nebula_planks", () -> new BlockItem(BlockRegistry.NEBULA_PLANKS.get(), new Item.Properties()));

    //Log
    public static final DeferredItem<BlockItem> NEBULA_LOG_ITEM = ITEMS.register("nebula_log", () -> new BlockItem(BlockRegistry.NEBULA_LOG.get(), new Item.Properties()));

    //Wood
    public static final DeferredItem<BlockItem> NEBULA_WOOD_ITEM = ITEMS.register("nebula_wood", () -> new BlockItem(BlockRegistry.NEBULA_WOOD.get(), new Item.Properties()));

    //Leaves
    public static final DeferredItem<BlockItem> NEBULA_LEAVES_ITEM = ITEMS.register("nebula_leaves", () -> new BlockItem(BlockRegistry.NEBULA_LEAVES.get(), new Item.Properties()));

    //Fence
    public static final DeferredItem<BlockItem> NEBULA_FENCE_ITEM = ITEMS.register("nebula_fence", () -> new BlockItem(BlockRegistry.NEBULA_FENCE.get(), new Item.Properties()));

    //Fence Gate
    public static final DeferredItem<BlockItem> NEBULA_FENCE_GATE_ITEM = ITEMS.register("nebula_fence_gate", () -> new BlockItem(BlockRegistry.NEBULA_FENCE_GATE.get(), new Item.Properties()));

    //Doors
    public static final DeferredItem<BlockItem> NEBULA_DOOR_ITEM = registerBlockItem("nebula_door", BlockRegistry.NEBULA_DOOR.get());
    public static final DeferredItem<BlockItem> STELLARIUM_DOOR_ITEM = registerBlockItem("stellarium_door", BlockRegistry.STELLARIUM_DOOR.get());

    //Trapdoors
    public static final DeferredItem<BlockItem> NEBULA_TRAPDOOR_ITEM = registerBlockItem("nebula_trapdoor", BlockRegistry.NEBULA_TRAPDOOR.get());
    public static final DeferredItem<BlockItem> STELLARIUM_TRAPDOOR_ITEM = registerBlockItem("stellarium_trapdoor", BlockRegistry.STELLARIUM_TRAPDOOR.get());


    // Creates a new food item with the id "playground:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> RADISH = ITEMS.registerSimpleItem("radish", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    // Materials
    public static final DeferredItem<Item> STELLARIUM_INGOT = ITEMS.register("stellarium_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_STELLARIUM = ITEMS.register("raw_stellarium", () -> new Item(new Item.Properties()));

    protected static DeferredItem<BlockItem> registerBlockItem(String name, Block block) {
        return ITEMS.register(name, () -> new BlockItem(block, new Item.Properties()));
    }
    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
