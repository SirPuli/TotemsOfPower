/*******************************************************************************
  Copyright 2020 Gergő Pauli
 ******************************************************************************/

package com.sirpuli.totems.item;

import com.sirpuli.totems.util.helper.KeyboardHelper;
import com.sirpuli.totems.util.helper.FormatHelper.MCFormat;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class Totem extends Item {

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
    protected IItemTier stats;
    int effectID;
    String[] effects = {"speed boost", "fire resistance", "jump boost", "luck", "haste", "strength", "regeneration", "resistance", "night vision", "water breathing"};
    String[] colors = {
            MCFormat.BOLD + MCFormat.YELLOW, MCFormat.BOLD + MCFormat.RED,
            MCFormat.BOLD + MCFormat.BLUE, MCFormat.BOLD + MCFormat.GREEN,
            MCFormat.BOLD + MCFormat.GOLD, MCFormat.BOLD + MCFormat.DARK_RED,
            MCFormat.BOLD + MCFormat.DARK_GREEN, MCFormat.BOLD + MCFormat.BLACK,
            MCFormat.BOLD + MCFormat.WHITE, MCFormat.BOLD + MCFormat.DARK_BLUE};

    public Totem(Item.Properties builder, int id) {
        super(builder);
        this.effectID = id;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("When held in the off hand gives " + colors[effectID] + effects[effectID] + MCFormat.RESET + "."));
        } else {
            tooltip.add(new StringTextComponent("Hold" + MCFormat.YELLOW + " Shift " + MCFormat.RESET + "for more information!"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
