package com.kingcontaria.betterworlds.mixin;

import net.minecraft.entity.SpawnEntry;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Biome.class)
public abstract class BiomeMixin {

    @Mutable
    @Shadow @Final public static Biome DESERT_HILLS;
    @Shadow @Final public static Biome DESERT;
    @Mutable
    @Shadow @Final public static Biome SAVANNA_PLATEAU;
    @Shadow @Final public static Biome SAVANNA;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void removeDesertHills(int id, CallbackInfo ci) {
        DESERT_HILLS = DESERT;
        SAVANNA_PLATEAU = SAVANNA;
    }

    @Redirect(method = "<init>", at = @At(value = "NEW", target = "Lnet/minecraft/entity/SpawnEntry;", ordinal = 0))
    private SpawnEntry modifySheepSpawnMechanics(Class type, int weight, int minGroupSize, int maxGroupSize){
        return new SpawnEntry(type, (int) (weight * 2.5), minGroupSize, maxGroupSize);
    }

    @Redirect(method = "<init>", at = @At(value = "NEW", target = "Lnet/minecraft/entity/SpawnEntry;", ordinal = 3))
    private SpawnEntry modifyChickenSpawnMechanics(Class type, int weight, int minGroupSize, int maxGroupSize){
        return new SpawnEntry(type, (int) (weight * 2.5), minGroupSize, maxGroupSize);
    }
}
