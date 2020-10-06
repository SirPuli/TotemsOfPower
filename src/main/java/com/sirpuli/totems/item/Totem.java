package com.sirpuli.totems.item;

import com.sirpuli.totems.util.helper.KeyboardHelper;
import com.sirpuli.totems.util.helper.FormatHelper.MCFormat;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class Totem extends TieredItem {

    protected IItemTier stats;
    int effectID;

    /*Effect IDs        | Colors
    0: SPEED BOOST      | YELLOW
    1: FIRE RESISTANCE  | RED
    2: JUMP BOOST       | BLUE
    3: LUCK             | GREEN
     */

    String[] effects = {"speed boost", "fire resistance", "jump boost", "luck"};
    String[] colors = {MCFormat.BOLD + MCFormat.YELLOW, MCFormat.BOLD + MCFormat.RED, MCFormat.BOLD + MCFormat.BLUE, MCFormat.BOLD + MCFormat.GREEN};

    public Totem(IItemTier statsIn, Properties builder, int effectID) {
        super(statsIn, builder);
        this.stats = statsIn;
        this.effectID = effectID;
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
