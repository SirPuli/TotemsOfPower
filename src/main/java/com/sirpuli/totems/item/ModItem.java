/*******************************************************************************
  Copyright 2020 Gergő Pauli
 ******************************************************************************/

package com.sirpuli.totems.item;

import com.sirpuli.totems.TotemsOfPower;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("all")
public class ModItem {


    public static final ItemGroup TOTEMS = new ItemGroup(ItemGroup.GROUPS.length, "totems_of_power") {

        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItem.TOTEM_OF_SPEED_TIER_0.get());
        }
    };

    public static final Properties DEFAULT_64 = new Properties().group(TOTEMS).maxDamage(64);
    public static final Properties DEFAULT_100 = new Properties().group(TOTEMS).maxDamage(100);
    public static final Properties DEFAULT_128 = new Properties().group(TOTEMS).maxDamage(128);
    public static final Properties DEFAULT_150 = new Properties().group(TOTEMS).maxDamage(150);
    public static final Properties DEFAULT_300 = new Properties().group(TOTEMS).maxDamage(300);


    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TotemsOfPower.MOD_ID);

    /*Effect IDs        | Colors        | amplifiers
    0: SPEED BOOST      | YELLOW        | 0, 1, 2
    1: FIRE RESISTANCE  | RED           | 0
    2: JUMP BOOST       | BLUE          | 0, 1
    3: LUCK             | GREEN         | 0
    4: HASTE            | GOLD          | 0, 1
    5: STRENGTH         | DARK RED      | 0, 0, 1
    6: REGENERATION     | DARK GREEN    | 1, 1, 2, 2 *Does not apply the Regeneration effect, insted directly heals the player when injured*
    7: RESISTANCE       | BLACK         | 0, 0, 1, 1, 2, 3
    8: NIGHT VISION     | WHITE         | 0
    9: WATER BREATHING  | DARK BLUE     | 0
    MAYBE:
        INVISIBILITY
        HEALTH BOOST
        ABSORPTION
        SATURATION
  */

    //Speed +
    public static final RegistryObject<Item> TOTEM_OF_SPEED_TIER_0 = ITEMS.register("totem_of_speed_tier_0", () -> new Totem(DEFAULT_64, 0));
    public static final RegistryObject<Item> TOTEM_OF_SPEED_TIER_1 = ITEMS.register("totem_of_speed_tier_1", () -> new Totem(DEFAULT_128, 0));
    public static final RegistryObject<Item> TOTEM_OF_SPEED_TIER_2 = ITEMS.register("totem_of_speed_tier_2", () -> new Totem(DEFAULT_64, 0));
    //Fire +
    public static final RegistryObject<Item> TOTEM_OF_FIRE_RESISTANCE = ITEMS.register("totem_of_fire_resistance", () -> new Totem(DEFAULT_300, 1));
    //Jump +
    public static final RegistryObject<Item> TOTEM_OF_JUMPING_TIER_0 = ITEMS.register("totem_of_jumping_tier_0", () -> new Totem(DEFAULT_64, 2));
    public static final RegistryObject<Item> TOTEM_OF_JUMPING_TIER_1 = ITEMS.register("totem_of_jumping_tier_1", () -> new Totem(DEFAULT_128, 2));
    //Luck +
    public static final RegistryObject<Item> TOTEM_OF_LUCK = ITEMS.register("totem_of_luck", () -> new Totem(DEFAULT_64, 3));
    //Haste +
    public static final RegistryObject<Item> TOTEM_OF_HASTE_TIER_0 = ITEMS.register("totem_of_haste_tier_0", () -> new Totem(DEFAULT_64, 4));
    public static final RegistryObject<Item> TOTEM_OF_HASTE_TIER_1 = ITEMS.register("totem_of_haste_tier_1", () -> new Totem(DEFAULT_64, 4));
    //Strength +
    public static final RegistryObject<Item> TOTEM_OF_STRENGTH_TIER_0 = ITEMS.register("totem_of_strength_tier_0", () -> new Totem(DEFAULT_64, 5));
    public static final RegistryObject<Item> TOTEM_OF_STRENGTH_TIER_1 = ITEMS.register("totem_of_strength_tier_1", () -> new Totem(DEFAULT_128, 5));
    public static final RegistryObject<Item> TOTEM_OF_STRENGTH_TIER_2 = ITEMS.register("totem_of_strength_tier_2", () -> new Totem(DEFAULT_64, 5));
    //Regeneration +
    public static final RegistryObject<Item> TOTEM_OF_REGENERATION_TIER_0 = ITEMS.register("totem_of_regeneration_tier_0", () -> new Totem(DEFAULT_100, 6));
    public static final RegistryObject<Item> TOTEM_OF_REGENERATION_TIER_1 = ITEMS.register("totem_of_regeneration_tier_1", () -> new Totem(DEFAULT_150, 6));
    public static final RegistryObject<Item> TOTEM_OF_REGENERATION_TIER_2 = ITEMS.register("totem_of_regeneration_tier_2", () -> new Totem(DEFAULT_100, 6));
    public static final RegistryObject<Item> TOTEM_OF_REGENERATION_TIER_3 = ITEMS.register("totem_of_regeneration_tier_3", () -> new Totem(DEFAULT_150, 6));
    //Resistance +
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_0 = ITEMS.register("totem_of_resistance_tier_0", () -> new Totem(DEFAULT_64, 7));
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_1 = ITEMS.register("totem_of_resistance_tier_1", () -> new Totem(DEFAULT_128, 7));
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_2 = ITEMS.register("totem_of_resistance_tier_2", () -> new Totem(DEFAULT_64, 7));
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_3 = ITEMS.register("totem_of_resistance_tier_3", () -> new Totem(DEFAULT_128, 7));
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_4 = ITEMS.register("totem_of_resistance_tier_4", () -> new Totem(DEFAULT_64, 7));
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_5 = ITEMS.register("totem_of_resistance_tier_5", () -> new Totem(DEFAULT_64, 7));
    //Night Vision +
    public static final RegistryObject<Item> TOTEM_OF_NIGHT_VISION = ITEMS.register("totem_of_night_vision", () -> new Totem(DEFAULT_128, 8));
    //Water Breathing
    public static final RegistryObject<Item> TOTEM_OF_WATER_BREATHING = ITEMS.register("totem_of_water_breathing", () -> new Totem(DEFAULT_128, 9));

}





