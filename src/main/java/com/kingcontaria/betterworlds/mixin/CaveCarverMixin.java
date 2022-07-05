package com.kingcontaria.betterworlds.mixin;

import net.minecraft.world.gen.carver.CaveCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(CaveCarver.class)
public class CaveCarverMixin {

    @Redirect(method = "method_4003", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 3))
    private int moreCaves(Random instance, int bound) {
        return instance.nextInt(bound) / 2;
    }

}
