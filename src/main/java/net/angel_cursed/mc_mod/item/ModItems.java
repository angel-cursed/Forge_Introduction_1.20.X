package net.angel_cursed.mc_mod.item;

import net.angel_cursed.mc_mod.MCMod;
import net.angel_cursed.mc_mod.item.custom.FuelItem;
import net.angel_cursed.mc_mod.item.custom.MetalDetectorItem;
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
    public static final RegistryObject<Item> PEAT_BRICK = ITEMS.register("peat_brick",
            () -> new FuelItem(new Item.Properties(), 2000));

    public static final RegistryObject<Item> RAW_AURELITE = ITEMS.register("raw_aurelite",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(512)));

    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)));

    public static final RegistryObject<Item> PANCAKES = ITEMS.register("pancakes",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PANCAKES)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
