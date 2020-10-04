package com.sirpuli.totems.enchantments;

import com.sirpuli.totems.TotemsOfPower;
import com.sirpuli.totems.item.TotemItem;
import net.minecraft.enchantment.AquaAffinityEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

 @SuppressWarnings("all")
public class TotemEnchantment {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, TotemsOfPower.MOD_ID);

    protected static EnchantmentType TOTEM = EnchantmentType.create("totem", item -> item.getCreativeTabs().equals(TotemItem.TOTEMS));
    protected static EquipmentSlotType[] EQUIPMENT_SLOT_TYPE = new EquipmentSlotType[] {EquipmentSlotType.OFFHAND};

    public static final RegistryObject<Enchantment> TOTEM_SPEED =
            ENCHANTMENTS.register("totem_speed", () -> new SpeedEnchantment(Enchantment.Rarity.RARE, TOTEM, EQUIPMENT_SLOT_TYPE));
}

