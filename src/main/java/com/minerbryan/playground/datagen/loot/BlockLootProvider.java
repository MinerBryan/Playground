package com.minerbryan.playground.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

import java.util.HashMap;
import java.util.Set;

public class BlockLootProvider extends BlockLootSubProvider {
    protected BlockLootProvider(HolderLookup.Provider provider){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), new HashMap<>(), provider);
    }
}
