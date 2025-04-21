package com.minerbryan.playground.registries;

import com.minerbryan.playground.PlaygroundMod;
import com.minerbryan.playground.blocks.ExampleBlockEntity;
import com.minerbryan.playground.registries.helpers.BlockRegistryHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.Optional;

//import static com.minerbryan.playground.registries.helpers.BlockRegistryHelper.registerTrapdoor;


//rawr
public class BlockRegistry extends BlockRegistryHelper{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PlaygroundMod.MODID);

    // Creates a new Block with the id "playground:example_block", combining the namespace and path
    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBasicBlock("bismuth_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    public static final DeferredBlock<Block> EXAMPLE_BLOCK_ENTITY = registerBlock("example_block_entity", () -> new ExampleBlockEntity(BlockBehaviour.Properties.of().noOcclusion()));

    //Ore
    public static final DeferredBlock<Block> STELLARIUM_ORE = registerBlock("stellarium_ore", () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)));

    //Raw Blocks
    public static final DeferredBlock<Block> RAW_STELLARIUM_BLOCK = registerBasicBlock("raw_stellarium_block", BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_BLUE));

    //Metal Block
    public static final DeferredBlock<Block> STELLARIUM_BLOCK = registerBasicBlock("stellarium_block", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BLUE));

    //Planks
    public static final DeferredBlock<Block> NEBULA_PLANKS = registerBasicBlock("nebula_planks", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_PURPLE));

    //Stairs
    public static final DeferredBlock<StairBlock> NEBULA_STAIRS = registerBasicStairs("nebula_stairs", NEBULA_PLANKS.get());

    //Slabs
    public static final DeferredBlock<SlabBlock> NEBULA_SLABS = registerBasicSlab("nebula_slab", NEBULA_PLANKS.get());

    //Sapling
    public static final DeferredBlock<SaplingBlock> NEBULA_SAPLING = registerSapling("nebula_sapling",
            new TreeGrower(
                    PlaygroundMod.MODID+":nebula",
                    0.1F,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.of(ConfigFeatureRegistry.NEBULA_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()
            ),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).mapColor(MapColor.COLOR_MAGENTA)
    );

    //Log
    public static final DeferredBlock<Block> NEBULA_LOG = registerBlock("nebula_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.COLOR_PURPLE)));
    //Wood
    public static final DeferredBlock<Block> NEBULA_WOOD = registerBlock("nebula_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.COLOR_PURPLE)));

    //Leaves
    public static final DeferredBlock<LeavesBlock> NEBULA_LEAVES = registerLeaves("nebula_leaves", BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA_LEAVES).mapColor(MapColor.COLOR_MAGENTA));

    //Fences
    public static final DeferredBlock<FenceBlock> NEBULA_FENCE = registerFence("nebula_fence", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).mapColor(MapColor.COLOR_PURPLE));

    //Fence Gates
    public static final DeferredBlock<FenceGateBlock> NEBULA_FENCE_GATE = registerFenceGate("nebula_fence_gate", WoodType.OAK,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.COLOR_PURPLE));

    //Doors
    public static final DeferredBlock<DoorBlock> NEBULA_DOOR = registerDoor("nebula_door", BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_DOOR).mapColor(MapColor.COLOR_PURPLE));
    public static final DeferredBlock<DoorBlock> STELLARIUM_DOOR = registerDoor("stellarium_door", BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR));

    //Trapdoors
    public static final DeferredBlock<TrapDoorBlock> NEBULA_TRAPDOOR = registerTrapdoor("nebula_trapdoor", BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_TRAPDOOR).mapColor(MapColor.COLOR_PURPLE));
    public static final DeferredBlock<TrapDoorBlock> STELLARIUM_TRAPDOOR = registerTrapdoor("stellarium_trapdoor", BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR));

    //Pressure Plates
    public static final DeferredBlock<PressurePlateBlock> NEBULA_PRESSURE_PLATE = registerPressurePlate("nebula_pressure_plate", BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PRESSURE_PLATE).mapColor(MapColor.COLOR_PURPLE));

    //Buttons
    public static final DeferredBlock<ButtonBlock> NEBULA_BUTTON = registerButton("nebula_button", BlockSetType.CHERRY, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_BUTTON).mapColor(MapColor.COLOR_PURPLE));

    // Directly Copied over from MC's Blocks.java file
    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) { return false; }
    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }



    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
