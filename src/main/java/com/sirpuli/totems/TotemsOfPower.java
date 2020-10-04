package com.sirpuli.totems;

import com.sirpuli.totems.item.TotemItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("totems")
public class TotemsOfPower
{
    public static final String MOD_ID = "totems";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static TotemsOfPower instance;

    public TotemsOfPower() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        TotemItem.ITEMS.register(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
