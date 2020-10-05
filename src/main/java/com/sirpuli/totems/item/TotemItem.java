package com.sirpuli.totems.item;

import com.sirpuli.totems.TotemsOfPower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("all")
public class TotemItem {


    public static final ItemGroup TOTEMS = new ItemGroup(ItemGroup.GROUPS.length, "totems_of_power") {

        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(TotemItem.TOTEM_OF_SPEED.get());
        }
    };

    public static final Item.Properties CREATIVE_TAB = new Item.Properties().group(TOTEMS);

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TotemsOfPower.MOD_ID);

    public static final RegistryObject<Item> TOTEM_OF_SPEED = ITEMS.register("totem_of_speed_tier_0", () -> new Totem(TotemStats.SPEED_TIER_0, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_FIRE_RESISTANCE = ITEMS.register("totem_of_fire_resistance", () -> new Totem(TotemStats.FIRE,  CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_JUMPING = ITEMS.register("totem_of_jumping_tier_0", () -> new Totem(TotemStats.JUMP_TIER_0, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_LUCK = ITEMS.register("totem_of_luck", () -> new Item(CREATIVE_TAB));


}





