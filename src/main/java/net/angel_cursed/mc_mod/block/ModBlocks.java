package net.angel_cursed.mc_mod.block;

import net.angel_cursed.mc_mod.MCMod;
import net.angel_cursed.mc_mod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
            () -> new Block(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).instrument(NoteBlockInstrument.BASEDRUM)));

    public static final RegistryObject<Block> END_STONE_AURELITE_ORE = registerBlock("end_stone_aurelite_ore",
            () -> new Block(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).sound(SoundType.NETHERRACK)));

    public static final RegistryObject<Block> NETHER_AURELITE_ORE = registerBlock("nether_aurelite_ore",
            () -> new Block(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).instrument(NoteBlockInstrument.BASEDRUM)));

    public static final RegistryObject<Block> AURELITE_BLOCK = registerBlock("aurelite_block",
            () -> new Block(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_AURELITE_BLOCK = registerBlock("raw_aurelite_block",
            () -> new Block(BlockBehaviour.Properties.of().explosionResistance(1200).requiresCorrectToolForDrops().destroyTime(6.0F).sound(SoundType.METAL)));

    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }
}
