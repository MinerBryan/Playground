package com.minerbryan.playground.registries;

import com.minerbryan.playground.PlaygroundMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TabRegistry {
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "playground" namespace
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PlaygroundMod.MODID);


    // Creates a creative tab with the id "playground:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = TABS.register(
            "example_tab",
            () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.playground")) //The language key for the title of your CreativeModeTab
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> ItemRegistry.RADISH.get().getDefaultInstance())
                .displayItems((parameters, output) -> {
                    output.accept(ItemRegistry.RADISH.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                    output.accept(BlockRegistry.BISMUTH_BLOCK.get());
                    output.accept(BlockRegistry.EXAMPLE_BLOCK_ENTITY.get());
                    output.accept(BlockRegistry.STELLARIUM_ORE.get());
                    output.accept(ItemRegistry.RAW_STELLARIUM.get());
                    output.accept(ItemRegistry.STELLARIUM_INGOT.get());
//                    output.accept(BlockRegistry.RAW_STELLARIUM_BLOCK.get());
                    output.accept(BlockRegistry.STELLARIUM_BLOCK.get());
                    output.accept(BlockRegistry.STELLARIUM_DOOR.get());
                    output.accept(BlockRegistry.STELLARIUM_TRAPDOOR.get());
                    output.accept(BlockRegistry.NEBULA_SAPLING.get());
                    output.accept(BlockRegistry.NEBULA_LEAVES.get());
                    output.accept(BlockRegistry.NEBULA_LOG.get());
                    output.accept(BlockRegistry.NEBULA_WOOD.get());
                    output.accept(BlockRegistry.NEBULA_PLANKS.get());
                    output.accept(BlockRegistry.NEBULA_FENCE.get());
                    output.accept(BlockRegistry.NEBULA_FENCE_GATE.get());
                    output.accept(BlockRegistry.NEBULA_DOOR.get());
                    output.accept(BlockRegistry.NEBULA_TRAPDOOR.get());
                })
                .build()
    );

    public static void register(IEventBus bus){
        TABS.register(bus);
    }

    // Add the example block item to the building blocks tab
//    private void addCreative(BuildCreativeModeTabContentsEvent event)
//    {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
//            event.accept(EXAMPLE_BLOCK_ITEM);
//    }
}
