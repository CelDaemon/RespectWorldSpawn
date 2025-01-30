package com.rikaisan.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.rikaisan.RespectWorldSpawn;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.TeleportTarget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(TeleportTarget.class)
public class TeleportTargetMixin {
    // Enforce world spawn angle when respawning using world spawn.
    @ModifyArg(method = "<init>(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/Entity;Lnet/minecraft/world/TeleportTarget$PostDimensionTransition;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/TeleportTarget;<init>(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;FFZZLjava/util/Set;Lnet/minecraft/world/TeleportTarget$PostDimensionTransition;)V"), index = 3)
    private static float enforceAngle(float requestedYaw, @Local(argsOnly = true) ServerWorld world) {
        return world.getGameRules().getBoolean(RespectWorldSpawn.RESPECT_SPAWN_ROTATION) ? world.getSpawnAngle() : requestedYaw;
    }

    // Enforce world spawn angle when respawning from obstructed spawn.
    @ModifyArg(method = "missingSpawnBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/TeleportTarget;<init>(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;FFZZLjava/util/Set;Lnet/minecraft/world/TeleportTarget$PostDimensionTransition;)V"), index = 3)
    private static float obstructedEnforceAngle(float requestedYaw, @Local(argsOnly = true) ServerWorld world) {
        return world.getGameRules().getBoolean(RespectWorldSpawn.RESPECT_SPAWN_ROTATION) ? world.getSpawnAngle() : requestedYaw;
    }
}
