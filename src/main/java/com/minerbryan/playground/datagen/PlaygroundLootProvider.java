package com.minerbryan.playground.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class PlaygroundLootProvider extends LootTableProvider {
    public PlaygroundLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries){
        super(output, Set.of(), List.of(

        ), registries);
    }
}
