package com.sirpuli.totems.enchantments;

import com.sirpuli.totems.TotemsOfPower;
import com.sirpuli.totems.item.TotemItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

 @SuppressWarnings("all")
public class TotemEnchantment {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, TotemsOfPower.MOD_ID);

    protected static EnchantmentType TOTEM = EnchantmentType.create("totem_type", item -> item.getCreativeTabs().equals(TotemItem.TOTEMS));
    protected static EquipmentSlotType[] OFFHAND_SLOT_TYPE = new EquipmentSlotType[] {EquipmentSlotType.OFFHAND};

     public static final RegistryObject<Enchantment> SPEED_TOTEM =
            ENCHANTMENTS.register("totem_enchantment", () -> new TotemEnchantments(Enchantment.Rarity.RARE, TOTEM, OFFHAND_SLOT_TYPE));

//    public static final RegistryObject<Enchantment> SPEED_TOTEM =
//            ENCHANTMENTS.register("speed_totem", () -> new SpeedEnchantment(Enchantment.Rarity.RARE, TOTEM, OFFHAND_SLOT_TYPE));
//    public static final RegistryObject<Enchantment> FIRE_TOTEM =
//            ENCHANTMENTS.register("fire_totem", () -> new FireEnchantment(Enchantment.Rarity.VERY_RARE, TOTEM, OFFHAND_SLOT_TYPE));
//    public static final RegistryObject<Enchantment> JUMP_TOTEM =
//            ENCHANTMENTS.register("jump_totem", () -> new JumpEnchantment(Enchantment.Rarity.COMMON, TOTEM, OFFHAND_SLOT_TYPE));
}

