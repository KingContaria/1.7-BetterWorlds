package com.kingcontaria.betterworlds.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class IngameHudMixin extends DrawableHelper {

    @Shadow @Final private MinecraftClient client;

    @Inject(method = "method_979", at = @At("TAIL"))
    private void addDebugInfo(float bl, boolean i, int j, int par4, CallbackInfo ci) {
        if (this.client.options.debugEnabled) {
            String string = "1.7 BetterWorlds";
            this.drawWithShadow(this.client.textRenderer, string, new Window(this.client, this.client.width, this.client.height).getWidth() - this.client.textRenderer.getStringWidth(string) - 2, 32, 0xE0E0E0);
        }
    }

}
