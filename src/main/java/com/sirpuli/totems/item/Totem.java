package com.sirpuli.totems.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.TieredItem;

public class Totem extends TieredItem {

    int tier;

    public Totem(IItemTier statsIn, Properties builder, int tierIn) {
        super(statsIn, builder);
        this.tier = tierIn;
    }
}
