package net.angel_cursed.mc_mod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties KOHLRABI = new FoodProperties.Builder().nutrition(5).saturationMod(1.5F)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP,200),0.5f).build();

    public static final FoodProperties PANCAKES = new FoodProperties.Builder().nutrition(3).saturationMod(1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,200),1.0f).build();
}
