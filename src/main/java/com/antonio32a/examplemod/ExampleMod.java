package com.antonio32a.examplemod;

import com.antonio32a.examplemod.commands.ExampleCommand;
import com.antonio32a.examplemod.core.Config;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = ExampleMod.MODID, version =
        ExampleMod.VERSION,
        name = ExampleMod.NAME,
        clientSideOnly = true
)
public class ExampleMod {
    public static final String NAME = "ExampleMod";
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static final String configLocation = "./config/examplemod.toml";

    @Getter private static ExampleMod instance;
    @Getter @Setter private GuiScreen gui;
    @Getter private Logger logger;
    @Getter private Config config;

    public ExampleMod() {
        instance = this;
        logger = LogManager.getLogger();
        config = new Config();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        config.preload();
        ClientCommandHandler.instance.registerCommand(new ExampleCommand());
        this.logger.info("ExampleMod loaded.");
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (gui != null) {
            try {
                Minecraft.getMinecraft().displayGuiScreen(gui);
            } catch (Exception error) {
                error.printStackTrace();
            }
            gui = null;
        }
    }
}