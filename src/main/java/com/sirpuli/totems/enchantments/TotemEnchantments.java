package com.sirpuli.totems.enchantments;

import com.sirpuli.totems.TotemsOfPower;
import com.sirpuli.totems.item.Totem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
            if (isTotemInOffHand(playerEntity)) {
                switch (totemInHand) {
                    case "totem_of_speed_tier_0":
                        playerEntity.addPotionEffect((new EffectInstance(Effects.SPEED, 21, 0, false, false)));
                        tick++;
                        if (tick >= 1000 && rand.nextInt(300) == 69) {
                            playerEntity.getHeldItemOffhand().damageItem(1, playerEntity, (onBreak) -> onBreak.sendBreakAnimation(Hand.OFF_HAND));
                            tick = 0;
                        }
                        break;
                    case "totem_of_fire_resistance":
                        playerEntity.addPotionEffect((new EffectInstance(Effects.FIRE_RESISTANCE, 21, 0, false, false)));
                        tick++;
                        if (playerEntity.isBurning() && tick > 20) {
                            playerEntity.getHeldItemOffhand().damageItem(1, playerEntity, (onBreak) -> onBreak.sendBreakAnimation(Hand.OFF_HAND));
                            tick = 0;
                        }
                        break;
                    case "totem_of_jumping":
                        playerEntity.addPotionEffect((new EffectInstance(Effects.JUMP_BOOST, 21, 0, false, false)));
                        tick++;
                        if (tick >= 1000 && rand.nextInt(300) == 69){
                            playerEntity.getHeldItemOffhand().damageItem(1, playerEntity, (onBreak) -> onBreak.sendBreakAnimation(Hand.OFF_HAND));
                            tick = 0;
                        }
                        break;

                }
            }
        }

        public static boolean isTotemInOffHand(PlayerEntity playerEntity) {

            if (playerEntity.getHeldItemOffhand().getItem() instanceof Totem){
                totemInHand = playerEntity.getHeldItemOffhand().getItem().toString();
                return true;
            }
            totemInHand = null;
            return false;
        }

//        public static boolean isTotemInHand(LivingEntity livingEntity) {
//
//            for (Hand hand : Hand.values()) {
//                ItemStack itemstack = livingEntity.getHeldItem(hand);
//                if (itemstack.getItem() instanceof Totem) {
//                    heldBy = hand;
//                    totemInHand = itemstack.toString();
//                    TotemsOfPower.LOGGER.info(itemstack.toString());
//                    return true;
//                }
//            }
//            TotemsOfPower.LOGGER.info("totem nincs a kézben");
//            totemInHand = null;
//            return false;
//        }
    }
}

