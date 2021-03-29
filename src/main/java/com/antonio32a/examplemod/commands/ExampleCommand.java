package com.antonio32a.examplemod.commands;

import club.sk1er.mods.core.ModCore;
import com.antonio32a.examplemod.ExampleMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class ExampleCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "example";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/example";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        ModCore.getInstance().getGuiHandler().open(ExampleMod.getInstance().getConfig().gui());
    }
}