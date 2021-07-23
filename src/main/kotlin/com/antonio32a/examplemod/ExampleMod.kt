package com.antonio32a.examplemod

import com.antonio32a.examplemod.commands.ExampleCommand
import com.antonio32a.examplemod.core.Config
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(
    modid = ExampleMod.MODID,
    version = ExampleMod.VERSION,
    name = ExampleMod.NAME,
    clientSideOnly = true,
    acceptedMinecraftVersions = "[1.8.9]",
    modLanguageAdapter = "gg.essential.api.utils.KotlinAdapter"
)
object ExampleMod {
    const val NAME = "ExampleMod"
    const val MODID = "examplemod"
    const val VERSION = "1.0"
    const val configLocation = "./config/examplemod.toml"

    var logger: Logger = LogManager.getLogger()
    var config: Config = Config()

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent?) {
        config.preload()
        ExampleCommand().register()
        logger.info("ExampleMod loaded.")
    }
}