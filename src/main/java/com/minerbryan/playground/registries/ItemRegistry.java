package com.minerbryan.playground.registries;

import com.minerbryan.playground.PlaygroundMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
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
    public static final DeferredItem<BlockItem> STELLARIUM_ORE_ITEM = registerBlockItem("stellarium_ore", BlockRegistry.STELLARIUM_ORE);

    //Raw Blocks
//    public static final DeferredItem<BlockItem> RAW_STELLARIUM_BLOCk_ITEM = registerBlockItem("raw_stellarium_block", BlockRegistry.RAW_STELLARIUM_BLOCK)

    //Metal Blocks
    public static final DeferredItem<BlockItem> STELLARIUM_BLOCK_ITEM = registerBlockItem("stellarium_block", BlockRegistry.STELLARIUM_BLOCK);

    //Sapling
    public static final DeferredItem<BlockItem> NEBULA_SAPLING_ITEM = registerBlockItem("nebula_sapling", BlockRegistry.NEBULA_SAPLING);

    //Planks
    public static final DeferredItem<BlockItem> NEBULA_PLANKS_ITEM = registerBlockItem("nebula_planks", BlockRegistry.NEBULA_PLANKS);

    //Log
    public static final DeferredItem<BlockItem> NEBULA_LOG_ITEM = registerBlockItem("nebula_log", BlockRegistry.NEBULA_LOG);

    //Wood
    public static final DeferredItem<BlockItem> NEBULA_WOOD_ITEM = registerBlockItem("nebula_wood", BlockRegistry.NEBULA_WOOD);

    //Leaves
    public static final DeferredItem<BlockItem> NEBULA_LEAVES_ITEM = registerBlockItem("nebula_leaves", BlockRegistry.NEBULA_LEAVES);

    //Fence
    public static final DeferredItem<BlockItem> NEBULA_FENCE_ITEM = registerBlockItem("nebula_fence", BlockRegistry.NEBULA_FENCE);

    //Fence Gate
    public static final DeferredItem<BlockItem> NEBULA_FENCE_GATE_ITEM = registerBlockItem("nebula_fence_gate", BlockRegistry.NEBULA_FENCE_GATE);

    //Doors
    public static final DeferredItem<BlockItem> NEBULA_DOOR_ITEM = registerBlockItem("nebula_door", BlockRegistry.NEBULA_DOOR);
    public static final DeferredItem<BlockItem> STELLARIUM_DOOR_ITEM = registerBlockItem("stellarium_door", BlockRegistry.STELLARIUM_DOOR);

    //Trapdoors
    public static final DeferredItem<BlockItem> NEBULA_TRAPDOOR_ITEM = registerBlockItem("nebula_trapdoor", BlockRegistry.NEBULA_TRAPDOOR);
    public static final DeferredItem<BlockItem> STELLARIUM_TRAPDOOR_ITEM = registerBlockItem("stellarium_trapdoor", BlockRegistry.STELLARIUM_TRAPDOOR);


    // Creates a new food item with the id "playground:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> RADISH = ITEMS.registerSimpleItem("radish", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    // Materials
    public static final DeferredItem<Item> STELLARIUM_INGOT = ITEMS.register("stellarium_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_STELLARIUM = ITEMS.register("raw_stellarium", () -> new Item(new Item.Properties()));

    protected static DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<?> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
