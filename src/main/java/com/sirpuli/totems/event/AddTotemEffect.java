/*******************************************************************************
  Copyright 2020 Gergő Pauli
 ******************************************************************************/

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
    static int amplifier = 0;

    @SubscribeEvent
    public static void applyEffect(TickEvent.PlayerTickEvent event) {
        PlayerEntity playerEntity = event.player;
        if (isTotemInOffHand(playerEntity)) {
            switch (totemEffect(playerEntity.getHeldItemOffhand().getItem().toString())) {
                case "speed":
                    normalTotemEvent(playerEntity, Effects.SPEED, 21, amplifier, 1);
                    break;
                case "fire_resistance":
                    if (playerEntity.isBurning()) {
                        addEffectToPlayer(playerEntity, Effects.FIRE_RESISTANCE, 21, amplifier);
                        tick++;
                        if (tick > 20) {
                            damageTotem(playerEntity, 1);
                            tick = 0;
                        }
                    }
                    break;
                case "jump":
                    normalTotemEvent(playerEntity, Effects.JUMP_BOOST, 21, amplifier, 1);
                    break;
                case "luck":
                    normalTotemEvent(playerEntity, Effects.LUCK, 21, amplifier, 1);
                    break;
                case "haste":
                    normalTotemEvent(playerEntity, Effects.HASTE, 21, amplifier, 1);
                    break;
                case "strength":
                    normalTotemEvent(playerEntity, Effects.STRENGTH, 21, amplifier, 1);
                    break;
                case "regen":
                    if (playerEntity.getHealth() < playerEntity.getMaxHealth()){
                        tick++;
                        if (tick > 20) {
                            playerEntity.heal(amplifier);
                            damageTotem(playerEntity, 1);
                            tick = 0;
                        }
                    }
                    break;
                case "resistance":
                    normalTotemEvent(playerEntity, Effects.RESISTANCE, 21, amplifier, 1);
                    break;
                case "night":
                    addEffectToPlayer(playerEntity, Effects.NIGHT_VISION, 201, 0);
                    tick++;
                    if (tick > 200){
                        damageTotem(playerEntity, 1);
                        tick = 0;
                    }
                case "water":
                    normalTotemEvent(playerEntity, Effects.WATER_BREATHING, 21, amplifier, 1);
                    break;
                case "alma":
                    tick = 0;

            }
        }
    }

    public static boolean isTotemInOffHand(PlayerEntity playerEntity) {
        return playerEntity.getHeldItemOffhand().getItem() instanceof Totem;
    }
    /*Effect IDs        | Colors        | amplifiers
    0: SPEED BOOST      | YELLOW        | 0, 1, 2
    1: FIRE RESISTANCE  | RED           | 0
    2: JUMP BOOST       | BLUE          | 0, 1
    3: LUCK             | GREEN         | 0
    4: HASTE            | GOLD          | 0, 1
    5: STRENGTH         | DARK RED      | 0, 0, 1
    6: REGENERATION     | DARK GREEN    | Custom
    7: RESISTANCE       | BLACK         | 0, 0, 1, 1, 2, 3
    8: NIGHT VISION     | WHITE         | 0
    9: WATER BREATHING  | DARK BLUE     | 0
    MAYBE:
        INVISIBILITY
        HEALTH BOOST
        ABSORPTION
        SATURATION
     */

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
            case "totem_of_haste_tier_0":
                amplifier = 0;
                return "haste";
            case "totem_of_haste_tier_1":
                amplifier = 1;
                return "haste";
            case "totem_of_strength_tier_0":
            case "totem_of_strength_tier_1":
                amplifier = 0;
                return "strength";
            case "totem_of_strength_tier_2":
                amplifier = 1;
                return "strength";
            case "totem_of_regeneration_tier_0":
            case "totem_of_regeneration_tier_1":
                amplifier = 1;
                return "regen";
            case "totem_of_regeneration_tier_2":
            case "totem_of_regeneration_tier_3":
                amplifier = 2;
                return "regen";
            case "totem_of_resistance_tier_0":
            case "totem_of_resistance_tier_1":
                amplifier = 0;
                return "resistance";
            case "totem_of_resistance_tier_2":
            case "totem_of_resistance_tier_3":
                amplifier = 1;
                return "resistance";
            case "totem_of_resistance_tier_4":
                amplifier = 2;
                return "resistance";
            case "totem_of_resistance_tier_5":
                amplifier = 3;
                return "resistance";
            case "totem_of_night_vision":
                return "night";
            case "totem_of_water_breathing":
                return "water";
            default:
                return "alma";
        }
    }

    public static void addEffectToPlayer(PlayerEntity playerEntity, Effect effect, int duration, int amplifier) {
        playerEntity.addPotionEffect((new EffectInstance(effect, 21, amplifier, false, false)));
    }

    public static void damageTotem(PlayerEntity playerEntity, int amount) {
        playerEntity.getHeldItemOffhand().damageItem(amount, playerEntity, (onBreak) -> {
            onBreak.sendBreakAnimation(Hand.OFF_HAND);
        });
    }

    public static void  normalTotemEvent(PlayerEntity playerEntity, Effect effect, int duration, int amplifier, int damageAmount){
        addEffectToPlayer(playerEntity, effect,duration, amplifier);
        tick++;
        if (tick >= 20 && rand.nextInt(100) == 69) {
            damageTotem(playerEntity, damageAmount);
            tick = 0;
        }
    }
}


