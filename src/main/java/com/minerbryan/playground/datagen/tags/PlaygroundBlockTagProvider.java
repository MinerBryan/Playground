package com.minerbryan.playground.datagen.tags;

import com.minerbryan.playground.PlaygroundMod;
import com.minerbryan.playground.registries.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class PlaygroundBlockTagProvider extends BlockTagsProvider {
    public PlaygroundBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup, PlaygroundMod.MODID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(PlaygroundTags.Blocks.NEBULA_LOGS).add(BlockRegistry.NEBULA_LOG.get(), BlockRegistry.NEBULA_WOOD.get());

        tag(BlockTags.NEEDS_IRON_TOOL).add(BlockRegistry.STELLARIUM_ORE.get(), BlockRegistry.STELLARIUM_BLOCK.get());

        tag(BlockTags.LOGS).add(BlockRegistry.NEBULA_LOG.get()).replace(false);
        tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(BlockRegistry.NEBULA_LOG.get()).replace(false);
        tag(BlockTags.LOGS_THAT_BURN).addTag(PlaygroundTags.Blocks.NEBULA_LOGS).replace(false);
        tag(BlockTags.PLANKS).add(BlockRegistry.NEBULA_PLANKS.get());
        tag(BlockTags.LEAVES).add(BlockRegistry.NEBULA_LEAVES.get());
        tag(BlockTags.SAPLINGS).add(BlockRegistry.NEBULA_SAPLING.get());

        tag(BlockTags.WOODEN_SLABS).add(BlockRegistry.NEBULA_SLABS.get());
        tag(BlockTags.WOODEN_STAIRS).add(BlockRegistry.NEBULA_STAIRS.get());
        tag(BlockTags.DOORS).add(BlockRegistry.STELLARIUM_DOOR.get()).replace(false);
        tag(BlockTags.WOODEN_DOORS).add(BlockRegistry.NEBULA_DOOR.get()).replace(false);
        tag(BlockTags.TRAPDOORS).add(BlockRegistry.STELLARIUM_TRAPDOOR.get()).replace(false);
        tag(BlockTags.WOODEN_TRAPDOORS).add(BlockRegistry.NEBULA_TRAPDOOR.get());
        tag(BlockTags.FENCE_GATES).add(BlockRegistry.NEBULA_FENCE_GATE.get());
        tag(BlockTags.WOODEN_FENCES).add(BlockRegistry.NEBULA_FENCE.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES).add(BlockRegistry.NEBULA_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_BUTTONS).add(BlockRegistry.NEBULA_BUTTON.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                BlockRegistry.RAW_STELLARIUM_BLOCK.get(),
                BlockRegistry.STELLARIUM_BLOCK.get(),
                BlockRegistry.STELLARIUM_ORE.get(),
                BlockRegistry.STELLARIUM_DOOR.get(),
                BlockRegistry.STELLARIUM_TRAPDOOR.get()

        );

        tag(BlockTags.MINEABLE_WITH_HOE).add(
                BlockRegistry.NEBULA_LEAVES.get()
        );

    }
}
