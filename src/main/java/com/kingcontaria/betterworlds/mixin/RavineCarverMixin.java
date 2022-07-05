package com.kingcontaria.betterworlds.mixin;

import net.minecraft.world.gen.carver.RavineCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(RavineCarver.class)
public class RavineCarverMixin {

    @Redirect(method = "method_4003", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 0))
    private int noRavines(Random instance, int bound) {
        return bound;
    }

}
