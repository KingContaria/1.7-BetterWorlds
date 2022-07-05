package com.kingcontaria.betterworlds.mixin;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BiomeDecorator.class)
public abstract class BiomeDecoratorMixin {

    @Shadow protected abstract void generateOre(int count, Feature feature, int minHeight, int maxHeight);

    @Redirect(method = "generateOres", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/BiomeDecorator;generateOre(ILnet/minecraft/world/gen/feature/Feature;II)V", ordinal = 1))
    private void moreGravel(BiomeDecorator instance, int count, Feature feature, int minHeight, int maxHeight) {
        this.generateOre(count * 2, feature, minHeight, maxHeight);
    }

    @Redirect(method = "generateOres", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/BiomeDecorator;generateOre(ILnet/minecraft/world/gen/feature/Feature;II)V", ordinal = 2))
    private void moreCoal(BiomeDecorator instance, int count, Feature feature, int minHeight, int maxHeight) {
        this.generateOre((int) (count * 1.5), feature, minHeight, maxHeight);
    }

    @Redirect(method = "generateOres", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/BiomeDecorator;generateOre(ILnet/minecraft/world/gen/feature/Feature;II)V", ordinal = 3))
    private void moreIron(BiomeDecorator instance, int count, Feature feature, int minHeight, int maxHeight) {
        this.generateOre(count * 2, feature, minHeight, maxHeight);
    }

}
