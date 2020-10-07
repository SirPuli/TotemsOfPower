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
public class ModItem {


    public static final ItemGroup TOTEMS = new ItemGroup(ItemGroup.GROUPS.length, "totems_of_power") {

        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ModItem.TOTEM_OF_SPEED_TIER_0.get());
        }
    };

    public static final Item.Properties CREATIVE_TAB = new Item.Properties().group(TOTEMS);

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TotemsOfPower.MOD_ID);

    /*Effect IDs:
    0: SPEED BOOST
    1: FIRE RESISTANCE
    2: JUMP BOOST
    3: LUCK
    4: HASTE
    5: STRENGTH
    6: REGENERATION
    7: RESISTANCE
    8: NIGHT VISION
    MAYBE:
        9: INVISIBILITY
        10: HEALTH BOOST
        11: ABSORPTION
        12: SATURATION

     */

    //Speed
    public static final RegistryObject<Item> TOTEM_OF_SPEED_TIER_0 = ITEMS.register("totem_of_speed_tier_0", () -> new Totem(TotemStats.SPEED_TIER_0, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_SPEED_TIER_1 = ITEMS.register("totem_of_speed_tier_1", () -> new Totem(TotemStats.SPEED_TIER_1, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_SPEED_TIER_2 = ITEMS.register("totem_of_speed_tier_2", () -> new Totem(TotemStats.SPEED_TIER_2, CREATIVE_TAB));
    //Fire
    public static final RegistryObject<Item> TOTEM_OF_FIRE_RESISTANCE = ITEMS.register("totem_of_fire_resistance", () -> new Totem(TotemStats.FIRE, CREATIVE_TAB));
    //Jump
    public static final RegistryObject<Item> TOTEM_OF_JUMPING_TIER_0 = ITEMS.register("totem_of_jumping_tier_0", () -> new Totem(TotemStats.JUMP_TIER_0, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_JUMPING_TIER_1 = ITEMS.register("totem_of_jumping_tier_1", () -> new Totem(TotemStats.JUMP_TIER_1, CREATIVE_TAB));
    //Luck
    public static final RegistryObject<Item> TOTEM_OF_LUCK = ITEMS.register("totem_of_luck", () -> new Totem(TotemStats.LUCK, CREATIVE_TAB));
    //Haste
    public static final RegistryObject<Item> TOTEM_OF_HASTE_TIER_0 = ITEMS.register("totem_of_haste_tier_0", () -> new Totem(TotemStats.HASTE_TIER_0, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_HASTE_TIER_1 = ITEMS.register("totem_of_haste_tier_1", () -> new Totem(TotemStats.HASTE_TIER_1, CREATIVE_TAB));
    //Strength
    public static final RegistryObject<Item> TOTEM_OF_STRENGTH_TIER_0 = ITEMS.register("totem_of_strength_tier_0", () -> new Totem(TotemStats.STRENGTH_TIER_0, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_STRENGTH_TIER_1 = ITEMS.register("totem_of_strength_tier_1", () -> new Totem(TotemStats.STRENGTH_TIER_1, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_STRENGTH_TIER_2 = ITEMS.register("totem_of_strength_tier_2", () -> new Totem(TotemStats.STRENGTH_TIER_2, CREATIVE_TAB));
    //Regeneration
    public static final RegistryObject<Item> TOTEM_OF_REGENERATION_TIER_0 = ITEMS.register("totem_of_regeneration_tier_0", () -> new Totem(TotemStats.REGENERATION_TIER_0, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_REGENERATION_TIER_1 = ITEMS.register("totem_of_regeneration_tier_1", () -> new Totem(TotemStats.REGENERATION_TIER_1, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_REGENERATION_TIER_2 = ITEMS.register("totem_of_regeneration_tier_2", () -> new Totem(TotemStats.REGENERATION_TIER_2, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_REGENERATION_TIER_3 = ITEMS.register("totem_of_regeneration_tier_3", () -> new Totem(TotemStats.REGENERATION_TIER_3, CREATIVE_TAB));
    //Resistance
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_0 = ITEMS.register("totem_of_resistance_tier_0", () -> new Totem(TotemStats.RESISTANCE_TIER_0, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_1 = ITEMS.register("totem_of_resistance_tier_1", () -> new Totem(TotemStats.RESISTANCE_TIER_1, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_2 = ITEMS.register("totem_of_resistance_tier_2", () -> new Totem(TotemStats.RESISTANCE_TIER_2, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_3 = ITEMS.register("totem_of_resistance_tier_3", () -> new Totem(TotemStats.RESISTANCE_TIER_3, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_4 = ITEMS.register("totem_of_resistance_tier_4", () -> new Totem(TotemStats.RESISTANCE_TIER_4, CREATIVE_TAB));
    public static final RegistryObject<Item> TOTEM_OF_RESISTANCE_TIER_5 = ITEMS.register("totem_of_resistance_tier_5", () -> new Totem(TotemStats.RESISTANCE_TIER_5, CREATIVE_TAB));
    //Night Vision
    public static final RegistryObject<Item> TOTEM_OF_NIGHT_VISION = ITEMS.register("totem_of_night_vision", () -> new Totem(TotemStats.NIGHT_VISION, CREATIVE_TAB));
    //Water Breathing
    public static final RegistryObject<Item> TOTEM_OF_WATER_BREATHING = ITEMS.register("totem_of_water_breathing", () -> new Totem(TotemStats.WATER_BREATHING, CREATIVE_TAB));

}





