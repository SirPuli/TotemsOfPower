/*******************************************************************************
  Copyright 2020 Gergő Pauli
 ******************************************************************************/

package com.sirpuli.totems.item.totemstats;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum MaxUses implements IItemTier {
    MU60(60),
    MU120(120),
    MU180(180),
    MU300(300);

    private int maxUses;

    MaxUses(int maxUsesIn){
        this.maxUses = maxUsesIn;
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
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
