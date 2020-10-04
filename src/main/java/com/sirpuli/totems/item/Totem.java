package com.sirpuli.totems.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.TieredItem;
import net.minecraft.item.crafting.Ingredient;

public class Totem extends TieredItem {

    public final int tier;


    public Totem(IItemTier totemStat, Properties builder, int totemTier) {
        super(totemStat, builder);
        this.tier = totemTier;
    }
}
