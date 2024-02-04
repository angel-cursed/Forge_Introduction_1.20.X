package net.angel_cursed.mc_mod.datagen;

import net.angel_cursed.mc_mod.MCMod;
import net.angel_cursed.mc_mod.block.ModBlocks;
import net.angel_cursed.mc_mod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MCMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.AURELITE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AURELITE_BLOCK.get(),
                        ModBlocks.RAW_AURELITE_BLOCK.get(),
                        ModBlocks.AURELITE_ORE.get(),
                        ModBlocks.DEEPSLATE_AURELITE_ORE.get(),
                        ModBlocks.END_STONE_AURELITE_ORE.get(),
                        ModBlocks.NETHER_AURELITE_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get(),
                        ModBlocks.AURELITE_SLAB.get(),
                        ModBlocks.AURELITE_STAIRS.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.AURELITE_ORE.get(),
                        ModBlocks.DEEPSLATE_AURELITE_ORE.get(),
                        ModBlocks.END_STONE_AURELITE_ORE.get(),
                        ModBlocks.NETHER_AURELITE_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AURELITE_BLOCK.get(),
                        ModBlocks.RAW_AURELITE_BLOCK.get(),
                        ModBlocks.SOUND_BLOCK.get(),
                        ModBlocks.AURELITE_STAIRS.get(),
                        ModBlocks.AURELITE_SLAB.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.AURELITE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.AURELITE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.AURELITE_WALL.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
