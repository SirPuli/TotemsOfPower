package com.sirpuli.totems.enchantments;

import com.sirpuli.totems.TotemsOfPower;
import com.sirpuli.totems.item.Totem;
import com.sirpuli.totems.item.TotemItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.swing.text.html.parser.Entity;
import java.util.Random;

public class TotemEnchantments extends Enchantment {

    protected TotemEnchantments(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
        super(rarityIn, typeIn, slots);
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return false;
    }

    @Mod.EventBusSubscriber(modid = TotemsOfPower.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class SpeedEffect {
        static int tick = 0;
        static Random rand = new Random();
        static String totemInHand = null;

        @SubscribeEvent
        public static void applyEffect(TickEvent.PlayerTickEvent event) {
            PlayerEntity playerEntity = event.player;
            if (isTotemInHand(playerEntity)) {
                switch (totemInHand) {
                    case "totem_of_speed":
                        playerEntity.addPotionEffect((new EffectInstance(Effects.SPEED, 21, 0, false, false)));
                        tick++;
                        if (tick >= 1000 && rand.nextInt(300) == 69) {
                            playerEntity.getHeldItemOffhand().damageItem(1, playerEntity, (onBreak) -> {
                                onBreak.sendBreakAnimation(playerEntity.getActiveHand());
                            });
                        }
                        break;
                    case "totem_of_fire_resistance":
                        break;
                    case "totem_of_jumping":
                        break;

                }
            }
        }

        public static boolean isTotemInHand(LivingEntity livingEntity) {

            ItemStack itemstack = null;
            for (Hand hand : Hand.values()) {
                ItemStack itemstack1 = livingEntity.getHeldItem(hand);
                if (itemstack1.getItem() == Items.TOTEM_OF_UNDYING) {
                    itemstack = itemstack1.copy();
                    itemstack1.shrink(1);
                    totemInHand = itemstack.toString();
                    TotemsOfPower.LOGGER.info(itemstack.toString());
                    return true;
                }
            }
            totemInHand = null;
            return false;
        }
    }
}

