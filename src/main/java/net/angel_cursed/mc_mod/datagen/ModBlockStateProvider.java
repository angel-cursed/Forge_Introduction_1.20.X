package net.angel_cursed.mc_mod.datagen;

import net.angel_cursed.mc_mod.MCMod;
import net.angel_cursed.mc_mod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MCMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AURELITE_BLOCK);
        blockWithItem(ModBlocks.RAW_AURELITE_BLOCK);
        blockWithItem(ModBlocks.END_STONE_AURELITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_AURELITE_ORE);
        blockWithItem(ModBlocks.NETHER_AURELITE_ORE);
        blockWithItem(ModBlocks.SOUND_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
