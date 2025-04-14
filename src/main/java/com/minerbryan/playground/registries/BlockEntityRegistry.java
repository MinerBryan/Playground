package com.minerbryan.playground.registries;

import com.minerbryan.playground.PlaygroundMod;
import com.minerbryan.playground.entity.ExampleBlockEntityEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PlaygroundMod.MODID);

    public static final Supplier<BlockEntityType<ExampleBlockEntityEntity>> EXAMPLE_BEE = BLOCKENTITIES.register("example_bee", () -> BlockEntityType.Builder.of(ExampleBlockEntityEntity::new, BlockRegistry.EXAMPLE_BLOCK_ENTITY.get()).build(null));

    public static void register(IEventBus bus){
        BLOCKENTITIES.register(bus);
    }
}
