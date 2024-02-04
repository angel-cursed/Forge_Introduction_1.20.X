package net.angel_cursed.mc_mod.block;

import net.angel_cursed.mc_mod.MCMod;
import net.angel_cursed.mc_mod.block.custom.SoundBlock;
import net.angel_cursed.mc_mod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.StairBlock;

import java.lang.reflect.Type;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCMod.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        RegisterBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static final RegistryObject<Block> AURELITE_ORE = registerBlock("aurelite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).instrument(NoteBlockInstrument.BASEDRUM), UniformInt.of(5, 10)));

    public static final RegistryObject<Block> END_STONE_AURELITE_ORE = registerBlock("end_stone_aurelite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).sound(SoundType.NETHERRACK), UniformInt.of(5, 10)));

    public static final RegistryObject<Block> NETHER_AURELITE_ORE = registerBlock("nether_aurelite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).instrument(NoteBlockInstrument.BASEDRUM), UniformInt.of(5, 10)));

    public static final RegistryObject<Block> AURELITE_BLOCK = registerBlock("aurelite_block",
            () -> new Block(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_AURELITE_BLOCK = registerBlock("raw_aurelite_block",
            () -> new Block(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> DEEPSLATE_AURELITE_ORE = registerBlock("deepslate_aurelite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).instrument(NoteBlockInstrument.BASEDRUM), UniformInt.of(5, 10)));


    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> AURELITE_STAIRS = registerBlock("aurelite_stairs",
            () -> new StairBlock(() -> ModBlocks.AURELITE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(ModBlocks.AURELITE_BLOCK.get())));

    public static final RegistryObject<Block> AURELITE_SLAB = registerBlock("aurelite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ModBlocks.AURELITE_BLOCK.get())));

    public static final RegistryObject<Block> AURELITE_PRESSURE_PLATE = registerBlock("aurelite_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> AURELITE_BUTTON = registerBlock("aurelite_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(ModBlocks.AURELITE_BLOCK.get()), BlockSetType.IRON, 20, true));
    public static final RegistryObject<Block> AURELITE_FENCE = registerBlock("aurelite_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(ModBlocks.AURELITE_BLOCK.get())));

    public static final RegistryObject<Block> AURELITE_FENCE_GATE = registerBlock("aurelite_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(ModBlocks.AURELITE_BLOCK.get()), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> AURELITE_WALL = registerBlock("aurelite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ModBlocks.AURELITE_BLOCK.get())));

    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }
}
