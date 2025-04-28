package com.minerbryan.playground.events;

import com.minerbryan.playground.PlaygroundMod;
import com.minerbryan.playground.datagen.PGRecipeProvider;
import com.minerbryan.playground.datagen.tags.PlaygroundBlockTagProvider;
import com.minerbryan.playground.datagen.tags.PlaygroundItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = PlaygroundMod.MODID)
public class PlaygroundDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new PGRecipeProvider(output, lookup));
        generator.addProvider(event.includeServer(), new PlaygroundBlockTagProvider(output, lookup));
//        generator.addProvider(event.includeServer(), new PlaygroundItemTagProvider(output, lookup));
    }
}
