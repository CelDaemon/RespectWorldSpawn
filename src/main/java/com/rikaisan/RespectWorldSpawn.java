package com.rikaisan;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RespectWorldSpawn implements ModInitializer {
	public static final String MOD_ID = "respectworldspawn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final GameRules.Key<GameRules.BooleanRule> RESPECT_SPAWN_HEIGHT =  GameRuleRegistry.register("respectSpawnHeight", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));
	public static final GameRules.Key<GameRules.BooleanRule> RESPECT_SPAWN_ROTATION =  GameRuleRegistry.register("respectSpawnRotation", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));

	@Override
	public void onInitialize() {
		LOGGER.info("Respecting YOUR spawn logic since 2025!");
		LOGGER.info("Obligatory Meow!");
	}
}