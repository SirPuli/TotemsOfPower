package com.sirpuli.totems.enchantments;

import com.sirpuli.totems.TotemsOfPower;
import com.sirpuli.totems.item.Totem;
import com.sirpuli.totems.item.TotemItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

public class SpeedEnchantment extends Enchantment {
    protected SpeedEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
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
    public static class SpeedEffect{
        static  int tick = 0;
        static  boolean isTotemInHand = false;
        static Random rand = new Random();

        @SubscribeEvent
        public static void applyEffect(TickEvent.PlayerTickEvent event){
            PlayerEntity playerEntity = event.player;
            if (event.player.getHeldItemOffhand().getItem() instanceof Totem){
                Item heldItem = playerEntity.getHeldItemOffhand().getItem();
                playerEntity.addPotionEffect((new EffectInstance(Effects.SPEED, 21, 1, false, false)));
                tick++;
                if (tick >= 1000 && rand.nextInt(300) == 69){
                    playerEntity.getHeldItemOffhand().damageItem(1, playerEntity, (onBreak) -> {
                        onBreak.sendBreakAnimation(playerEntity.getActiveHand());
                    });
                }
            }
        }

    }
}
