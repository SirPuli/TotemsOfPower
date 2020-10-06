package com.sirpuli.totems.event;

import com.sirpuli.totems.TotemsOfPower;
import com.sirpuli.totems.item.Totem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.swing.*;
import java.util.Random;


@Mod.EventBusSubscriber(modid = TotemsOfPower.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AddEffect {
    static int tick = 0;
    static Random rand = new Random();
    static String totemInHand = null;

    @SubscribeEvent
    public static void applyEffect(TickEvent.PlayerTickEvent event) {
        PlayerEntity playerEntity = event.player;
        if (isTotemInOffHand(playerEntity)) {
            switch (totemInHand) {
                case "totem_of_speed_tier_0":
                    addEffectToPlayer(playerEntity, Effects.SPEED, 0);
                    tick++;
                    if (tick >= 1000 && rand.nextInt(300) == 69) {
                        damageTotem(playerEntity, 1);
                        tick = 0;
                    }
                    break;
                case "totem_of_fire_resistance":
                    addEffectToPlayer(playerEntity, Effects.FIRE_RESISTANCE, 0);
                    tick++;
                    if (playerEntity.isBurning() && tick > 20) {
                        damageTotem(playerEntity, 1);
                        tick = 0;
                    }
                    break;
                case "totem_of_jumping":
                    addEffectToPlayer(playerEntity, Effects.JUMP_BOOST, 0);
                    tick++;
                    if (tick >= 1000 && rand.nextInt(300) == 69) {
                        damageTotem(playerEntity, 1);
                        tick = 0;
                    }
                    break;
            }
        }
    }

    public static boolean isTotemInOffHand(PlayerEntity playerEntity) {

        if (playerEntity.getHeldItemOffhand().getItem() instanceof Totem) {
            totemInHand = playerEntity.getHeldItemOffhand().getItem().toString();
            return true;
        }
        totemInHand = null;
        return false;
    }

    public static void addEffectToPlayer(PlayerEntity playerEntity, Effect effect, int amplifier) {
        playerEntity.addPotionEffect((new EffectInstance(effect, 21, amplifier, false, false)));
    }

    public static void damageTotem(PlayerEntity playerEntity, int amount) {
        playerEntity.getHeldItemOffhand().damageItem(amount, playerEntity, (onBreak) -> onBreak.sendBreakAnimation(Hand.OFF_HAND));
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


