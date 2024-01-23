package net.angel_cursed.mc_mod.item.custom;

import net.angel_cursed.mc_mod.block.ModBlocks;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                }
            }

            if(!foundBlock) {
                outputNoValuableFound(player);
            }
        }
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.mc_mod.metal_detector.no_valuables"));
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Valuable Found: " + I18n.get(block.getDescriptionId())
                + " at (" + below.getX() + "," + below.getY() + "," + below.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(Blocks.IRON_ORE) || blockState.is(Blocks.DIAMOND_ORE) || blockState.is(Blocks.GOLD_ORE) || blockState.is(Blocks.DEEPSLATE_DIAMOND_ORE)
                || blockState.is(Blocks.DEEPSLATE_GOLD_ORE) || blockState.is(Blocks.DEEPSLATE_IRON_ORE) || blockState.is(ModBlocks.AURELITE_ORE.get())
                || blockState.is(ModBlocks.DEEPSLATE_AURELITE_ORE.get()) || blockState.is(ModBlocks.END_STONE_AURELITE_ORE.get())
                || blockState.is(ModBlocks.NETHER_AURELITE_ORE.get());
    }
}
