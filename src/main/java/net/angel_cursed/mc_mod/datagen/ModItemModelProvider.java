package net.angel_cursed.mc_mod.datagen;

import net.angel_cursed.mc_mod.MCMod;
import net.angel_cursed.mc_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MCMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.AURELITE);
        simpleItem(ModItems.RAW_AURELITE);

        simpleItem(ModItems.KOHLRABI);
        simpleItem(ModItems.PANCAKES);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.PEAT_BRICK);
    }

    private void simpleItem(RegistryObject<Item> item){
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MCMod.MOD_ID, "item/" + item.getId().getPath()));
    }

}
