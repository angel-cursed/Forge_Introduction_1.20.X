package net.angel_cursed.mc_mod.item;

import net.angel_cursed.mc_mod.MCMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCMod.MOD_ID);

    public static final RegistryObject<Item> AURELITE = ITEMS.register("aurelite",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> RAW_AURELITE = ITEMS.register("raw_aurelite",
            () -> new Item(new Item.Properties().fireResistant()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
