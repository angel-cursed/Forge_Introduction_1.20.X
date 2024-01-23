package net.angel_cursed.mc_mod.item;

import net.angel_cursed.mc_mod.MCMod;
import net.angel_cursed.mc_mod.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AURELITE.get()))
                    .title(Component.translatable("creativetab.mod_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.AURELITE.get());
                        output.accept(ModItems.RAW_AURELITE.get());

                        output.accept(ModBlocks.AURELITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_AURELITE_ORE.get());
                        output.accept(ModBlocks.NETHER_AURELITE_ORE.get());
                        output.accept(ModBlocks.END_STONE_AURELITE_ORE.get());

                        output.accept(ModBlocks.AURELITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_AURELITE_BLOCK.get());

                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModBlocks.SOUND_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
