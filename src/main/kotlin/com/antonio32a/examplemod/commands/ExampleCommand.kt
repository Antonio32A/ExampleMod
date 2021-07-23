package com.antonio32a.examplemod.commands

import com.antonio32a.examplemod.ExampleMod
import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler

class ExampleCommand : Command("example") {
    @DefaultHandler
    fun handle() {
        EssentialAPI.getGuiUtil().openScreen(ExampleMod.config.gui())
    }
}