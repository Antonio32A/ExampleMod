package com.antonio32a.examplemod.core

import com.antonio32a.examplemod.ExampleMod
import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType
import java.io.File

class Config : Vigilant(File(ExampleMod.configLocation)) {
    @Property(type = PropertyType.SWITCH, name = "Gaming", description = "Are you gaming?", category = "Main")
    var gaming = true

    init {
        initialize()
    }
}