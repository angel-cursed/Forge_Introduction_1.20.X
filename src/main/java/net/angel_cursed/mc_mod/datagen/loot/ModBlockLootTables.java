package net.angel_cursed.mc_mod.datagen.loot;

import net.angel_cursed.mc_mod.block.ModBlocks;
import net.angel_cursed.mc_mod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.AURELITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_AURELITE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.AURELITE_ORE.get(),
                block -> createOreDrop(ModBlocks.AURELITE_ORE.get(), ModItems.RAW_AURELITE.get()));
        this.add(ModBlocks.DEEPSLATE_AURELITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_AURELITE_ORE.get(), ModItems.RAW_AURELITE.get()));
        this.add(ModBlocks.NETHER_AURELITE_ORE.get(),
                block -> createOreDrop(ModBlocks.NETHER_AURELITE_ORE.get(), ModItems.RAW_AURELITE.get()));
        this.add(ModBlocks.END_STONE_AURELITE_ORE.get(),
                block -> createOreDrop(ModBlocks.END_STONE_AURELITE_ORE.get(), ModItems.RAW_AURELITE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
