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
import java.util.Objects;
import java.util.Random;


@Mod.EventBusSubscriber(modid = TotemsOfPower.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AddTotemEffect {
    static int tick = 0;
    static Random rand = new Random();
    static String totemInHand = "alma";
    static int amplifier = 0;

    @SubscribeEvent
    public static void applyEffect(TickEvent.PlayerTickEvent event) {
        PlayerEntity playerEntity = event.player;
        if (isTotemInOffHand(playerEntity)) {
            switch (totemEffect(playerEntity.getHeldItemOffhand().getItem().toString())) {
                case "speed":
                    addEffectToPlayer(playerEntity, Effects.SPEED, amplifier);
                    tick++;
                    if (tick >= 1000 && rand.nextInt(300) == 69) {
                        damageTotem(playerEntity, 1);
                        tick = 0;
                    }
                    break;
                case "fire_resistance":
                    if (playerEntity.isBurning()) {
                        addEffectToPlayer(playerEntity, Effects.FIRE_RESISTANCE, amplifier);
                        tick++;
                        if (tick > 20) {
                            damageTotem(playerEntity, 1);
                            tick = 0;
                        }
                    }
                    break;
                case "jump":
                    addEffectToPlayer(playerEntity, Effects.JUMP_BOOST, amplifier);
                    tick++;
                    if (tick >= 1000 && rand.nextInt(300) == 69) {
                        damageTotem(playerEntity, 1);
                        tick = 0;
                    }
                    break;
                case "luck":
                    addEffectToPlayer(playerEntity, Effects.LUCK, amplifier);
                    if (tick >= 1000 && rand.nextInt(300) == 69) {
                        damageTotem(playerEntity, 1);
                        tick = 0;
                    }
            }
        }
    }

    public static boolean isTotemInOffHand(PlayerEntity playerEntity) {
        return playerEntity.getHeldItemOffhand().getItem() instanceof Totem;
    }

    public static String totemEffect(String itemName) {
        switch (itemName) {
            case "totem_of_speed_tier_0":
                amplifier = 0;
                return "speed";
            case "totem_of_speed_tier_1":
                amplifier = 1;
                return "speed";
            case "totem_of_speed_tier_2":
                amplifier = 2;
                return "speed";
            case "totem_of_speed_tier_3":
                amplifier = 3;
                return "speed";
            case "totem_of_fire_resistance":
                amplifier = 0;
                return "fire_resistance";
            case "totem_of_jumping_tier_0":
                amplifier = 0;
                return "jump";
            case "totem_of_jumping_tier_1":
                amplifier = 1;
                return "jump";
            case "totem_of_luck":
                amplifier = 0;
                return "luck";
            default:
                return "alma";
        }
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


