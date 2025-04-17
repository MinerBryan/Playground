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

    // Creates a new food item with the id "playground:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> RADISH = ITEMS.registerSimpleItem("radish", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    // Materials
    public static final DeferredItem<Item> STELLARIUM_INGOT = ITEMS.register("stellarium_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_STELLARIUM = ITEMS.register("raw_stellarium", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STELLARIUM_NUGGET = ITEMS.register("stellarium_nugget", () -> new Item(new Item.Properties()));

    public static DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<?> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
