package com.sirpuli.totems.item;

import com.sirpuli.totems.TotemsOfPower;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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
            return new ItemStack(TotemItem.TOTEM_OF_SPEED_TIER_0.get());
        }
    };

    public static final Item.Properties CREATIVE_TAB = new Item.Properties().group(TOTEMS);

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TotemsOfPower.MOD_ID);

    /*Effect IDs:
    0: SPEED BOOST
    1: FIRE RESISTANCE
    2: JUMP BOOST
    3: LUCK
     */
    public static final RegistryObject<Item> TOTEM_OF_SPEED_TIER_0 = ITEMS.register("totem_of_speed_tier_0", () -> new Totem(TotemStats.SPEED_TIER_0, CREATIVE_TAB, 0));
    public static final RegistryObject<Item> TOTEM_OF_SPEED_TIER_1 = ITEMS.register("totem_of_speed_tier_1", () -> new Totem(TotemStats.SPEED_TIER_1, CREATIVE_TAB, 0));
    public static final RegistryObject<Item> TOTEM_OF_SPEED_TIER_2 = ITEMS.register("totem_of_speed_tier_2", () -> new Totem(TotemStats.SPEED_TIER_2, CREATIVE_TAB, 0));
    public static final RegistryObject<Item> TOTEM_OF_SPEED_TIER_3 = ITEMS.register("totem_of_speed_tier_3", () -> new Totem(TotemStats.SPEED_TIER_3, CREATIVE_TAB, 0));

    public static final RegistryObject<Item> TOTEM_OF_FIRE_RESISTANCE = ITEMS.register("totem_of_fire_resistance", () -> new Totem(TotemStats.FIRE,  CREATIVE_TAB, 1));

    public static final RegistryObject<Item> TOTEM_OF_JUMPING_TIER_0 = ITEMS.register("totem_of_jumping_tier_0", () -> new Totem(TotemStats.JUMP_TIER_0, CREATIVE_TAB, 2));
    public static final RegistryObject<Item> TOTEM_OF_JUMPING_TIER_1 = ITEMS.register("totem_of_jumping_tier_1", () -> new Totem(TotemStats.JUMP_TIER_1, CREATIVE_TAB, 2));

    public static final RegistryObject<Item> TOTEM_OF_LUCK = ITEMS.register("totem_of_luck", () -> new Totem(TotemStats.LUCK, CREATIVE_TAB, 3));


}





