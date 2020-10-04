package com.sirpuli.totems.item;

import com.sirpuli.totems.TotemsOfPower;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("all")
public class TotemItem {
    public static final ItemGroup TOTEMS = new ItemGroup(ItemGroup.GROUPS.length, "totems"){

        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon(){
            return new ItemStack(TotemItem.TEST_TOTEM.get());
        }
    };

    public static final Item.Properties CREATIVE_TAB = new Item.Properties().group(TOTEMS);

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TotemsOfPower.MOD_ID);


    public static final RegistryObject<Item> TEST_TOTEM = ITEMS.register("test_totem", () -> new Totem(TotemStats.SPEED, CREATIVE_TAB, 0));


    public static final boolean isTotem(Item item){
        if (item.getCreativeTabs().equals(TOTEMS)){
            return true;
        }
        return false;
    }

}





