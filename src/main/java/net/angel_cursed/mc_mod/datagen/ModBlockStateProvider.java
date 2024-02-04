package net.angel_cursed.mc_mod.datagen;

import net.angel_cursed.mc_mod.MCMod;
import net.angel_cursed.mc_mod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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
        blockWithItem(ModBlocks.AURELITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_AURELITE_ORE);
        blockWithItem(ModBlocks.NETHER_AURELITE_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock((StairBlock) ModBlocks.AURELITE_STAIRS.get(), blockTexture(ModBlocks.AURELITE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.AURELITE_SLAB.get()), blockTexture(ModBlocks.AURELITE_BLOCK.get()), blockTexture(ModBlocks.AURELITE_BLOCK.get()));

        blockItem(ModBlocks.AURELITE_STAIRS);
        blockItem(ModBlocks.AURELITE_SLAB);
        blockItem(ModBlocks.AURELITE_PRESSURE_PLATE);
        blockItem(ModBlocks.AURELITE_FENCE_GATE);

        buttonBlock((ButtonBlock) ModBlocks.AURELITE_BUTTON.get(), blockTexture(ModBlocks.AURELITE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.AURELITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.AURELITE_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.AURELITE_FENCE.get(), blockTexture(ModBlocks.AURELITE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.AURELITE_FENCE_GATE.get(), blockTexture(ModBlocks.AURELITE_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.AURELITE_WALL.get(), blockTexture(ModBlocks.AURELITE_BLOCK.get()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mc_mod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
