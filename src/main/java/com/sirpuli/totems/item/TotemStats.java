package com.sirpuli.totems.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum TotemStats implements IItemTier {
    /*Effect IDs        | Colors        | amplifiers
    0: SPEED BOOST      | YELLOW        | 0, 1, 2
    1: FIRE RESISTANCE  | RED           | 0
    2: JUMP BOOST       | BLUE          | 0, 1
    3: LUCK             | GREEN         | 0
    4: HASTE            | GOLD          | 0, 1
    5: STRENGTH         | DARK RED      | 0, 0, 1
    6: REGENERATION     | DARK GREEN    | Custom
    7: RESISTANCE       | BLACK         | 0, 0, 1, 1, 2, 3
    8: NIGHT VISION     | WHITE         | 0
    9: WATER BREATHING  | DARK BLUE     | 0
    MAYBE:
        INVISIBILITY
        HEALTH BOOST
        ABSORPTION
        SATURATION
  */
    SPEED_TIER_0(60, 0),
    SPEED_TIER_1(120, 0),
    SPEED_TIER_2(120, 0),
    FIRE(300, 1),
    JUMP_TIER_0(60, 2),
    JUMP_TIER_1(120, 2),
    LUCK(120, 3),
    HASTE_TIER_0(60, 4),
    HASTE_TIER_1(120, 4),
    STRENGTH_TIER_0(60, 5),
    STRENGTH_TIER_1(120, 5),
    STRENGTH_TIER_2(120, 5),
    REGENERATION_TIER_0(60, 6),
    REGENERATION_TIER_1(120, 6),
    REGENERATION_TIER_2(120, 6),
    REGENERATION_TIER_3(180, 6),
    RESISTANCE_TIER_0(60, 7),
    RESISTANCE_TIER_1(120, 7),
    RESISTANCE_TIER_2(120, 7),
    RESISTANCE_TIER_3(180, 7),
    RESISTANCE_TIER_4(180, 7),
    RESISTANCE_TIER_5(180, 7),
    NIGHT_VISION(120, 8),
    WATER_BREATHING(120, 9);

    private final int maxUses;
    private final int ID;

    TotemStats(int maxUsesIn, int id) {
        this.maxUses = maxUsesIn;
        this.ID = id;
    }

    public int getID() {
        return ID;
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
