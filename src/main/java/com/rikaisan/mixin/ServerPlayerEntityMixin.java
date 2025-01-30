package com.rikaisan.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.rikaisan.RespectWorldSpawn;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameMode;
import net.minecraft.world.SaveProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {

	// No need to do much, Adventure mode already has this behaviour.
	@Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/SaveProperties;getGameMode()Lnet/minecraft/world/GameMode;"), method = "getWorldSpawnPos")
	private GameMode getGameMode(SaveProperties instance, @Local(argsOnly = true) ServerWorld world) {
		return world.getGameRules().getBoolean(RespectWorldSpawn.RESPECT_SPAWN_HEIGHT) ? GameMode.ADVENTURE : instance.getGameMode();
	}

	// Enforce the facing angle of newly joined players.
	@ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;refreshPositionAndAngles(Lnet/minecraft/util/math/Vec3d;FF)V"), index = 1)
	private float modifyAngle(float requestedYaw, @Local(argsOnly = true) ServerWorld world) {
		return world.getGameRules().getBoolean(RespectWorldSpawn.RESPECT_SPAWN_ROTATION) ? world.getSpawnAngle() : requestedYaw;
	}
}