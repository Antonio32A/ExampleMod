package com.antonio32a.examplemod.mixins;

import com.antonio32a.examplemod.ExampleMod;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Inject(method = "startGame", at = @At("RETURN"))
    public void startGame(CallbackInfo ci) {
        ExampleMod.INSTANCE.getLogger().info("Hello from ExampleMod!");
    }
}