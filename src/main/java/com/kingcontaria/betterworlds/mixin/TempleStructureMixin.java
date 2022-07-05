package com.kingcontaria.betterworlds.mixin;

import net.minecraft.structure.TempleStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TempleStructure.class)
public class TempleStructureMixin {

    @Mutable
    @Shadow private int distance;

    @Shadow private int field_4960;

    @Inject(method = "<init>()V", at = @At("TAIL"))
    private void test(CallbackInfo ci) {
        distance /= 1.5;
        field_4960 /= 1.5;
    }

}
