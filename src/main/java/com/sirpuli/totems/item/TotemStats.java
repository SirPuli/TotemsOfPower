package com.sirpuli.totems.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;

public enum TotemStats implements IItemTier {
    SPEED_TIER_0(
            200
    ),
    SPEED_TIER_1(
            200
    ),
    SPEED_TIER_2(
            200
    ),
    SPEED_TIER_3(
            200
    ),
    FIRE(
            500
    ),
    JUMP_TIER_0(
            200
    ),
    JUMP_TIER_1(
            200
    ),
    LUCK(
            200
    );

    private final int durability;

    TotemStats(int durability) {
        this.durability = durability;
    }


    @Override
    public int getMaxUses() {
        return durability;
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
