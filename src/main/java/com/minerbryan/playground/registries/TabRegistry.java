package com.minerbryan.playground.registries;

import com.minerbryan.playground.PlaygroundMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;

import static com.minerbryan.playground.registries.BlockRegistry.BLOCKS;

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
                    BLOCKS.getEntries().forEach(holder -> {
                        output.accept(holder.get());
                    });

                    output.accept(ItemRegistry.RADISH.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                    output.accept(ItemRegistry.RAW_STELLARIUM.get());
                    output.accept(ItemRegistry.STELLARIUM_NUGGET.get());
                    output.accept(ItemRegistry.STELLARIUM_INGOT.get());
                })
                .build()
    );

    public static void register(IEventBus bus){
        TABS.register(bus);
    }
}
