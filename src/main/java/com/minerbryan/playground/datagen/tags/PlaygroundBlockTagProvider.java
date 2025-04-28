package com.minerbryan.playground.datagen.tags;

import com.minerbryan.playground.PlaygroundMod;
import com.minerbryan.playground.registries.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class PlaygroundBlockTagProvider extends BlockTagsProvider {
    public PlaygroundBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup, PlaygroundMod.MODID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(PlaygroundTags.Blocks.NEBULA_LOGS)
                .add(BlockRegistry.NEBULA_LOG.get()
                );
    }
}
