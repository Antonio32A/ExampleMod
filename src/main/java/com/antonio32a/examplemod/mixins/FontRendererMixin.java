package com.antonio32a.examplemod.mixins;

import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(FontRenderer.class)
public abstract class FontRendererMixin {
    @ModifyVariable(method = "renderString", at = @At("HEAD"), ordinal = 0)
    private String adjustRenderStringText(String text) {
        return text.replaceAll("mine", "our").replaceAll("Mine", "Our");
    }
}