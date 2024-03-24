
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package sh.dip.mc.fate_tokens.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FateTokensModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> FATE_TOKENS_ENABLED = GameRules.register("fateTokensEnabled", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> FATE_TOKENS_DEATH_TIMER = GameRules.register("fateTokensDeathTimer", GameRules.Category.PLAYER, GameRules.IntegerValue.create(86400));
}
