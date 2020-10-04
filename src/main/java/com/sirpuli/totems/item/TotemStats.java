package com.sirpuli.totems.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;

public enum TotemStats implements IItemTier {

    SPEED(
            Effects.SPEED,
            new int[] {0,1,1,2},
            new int[] {100, 100, 150, 200 }
    );

    private final Effect effect;
    private final int[] amplifiers;
    private final int[] durability;



    TotemStats(Effect effectIn, int[] amplifiersIn, int[] durabilityIn) {
        this.effect = effectIn;
        this.amplifiers = amplifiersIn;
        this.durability = durabilityIn;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getAmplifiers(int tier) {
        return amplifiers[tier];
    }

    @Override
    public int getMaxUses() {
        return 150;
    }

    @Override
    public float getEfficiency() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getHarvestLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return null;
    }
}
