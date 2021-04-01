package com.antonio32a.examplemod.core;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.Property;
import club.sk1er.vigilance.data.PropertyType;
import com.antonio32a.examplemod.ExampleMod;

import java.io.File;

public class Config extends Vigilant {
    @Property(
        type = PropertyType.SWITCH,
        name = "Gaming",
        description = "Are you gaming?",
        category = "Main"
    )
    public boolean gaming = true;

    public Config() {
        super(new File(ExampleMod.configLocation));
        initialize();
    }
}