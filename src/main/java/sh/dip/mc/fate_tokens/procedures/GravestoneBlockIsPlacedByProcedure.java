package sh.dip.mc.fate_tokens.procedures;

import sh.dip.mc.fate_tokens.init.FateTokensModGameRules;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GravestoneBlockIsPlacedByProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.getLevelData().getGameRules().getBoolean(FateTokensModGameRules.FATE_TOKENS_ENABLED)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Fate Tokens are disabled on this server. Set gamerule fateTokensEnabled to true to enable them."), false);
		}
	}
}
