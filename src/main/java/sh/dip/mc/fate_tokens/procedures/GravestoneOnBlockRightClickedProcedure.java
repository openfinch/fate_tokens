package sh.dip.mc.fate_tokens.procedures;

import sh.dip.mc.fate_tokens.init.FateTokensModItems;
import sh.dip.mc.fate_tokens.init.FateTokensModGameRules;
import sh.dip.mc.fate_tokens.init.FateTokensModBlocks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;

public class GravestoneOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity grave_for = null;
		if (world.getLevelData().getGameRules().getBoolean(FateTokensModGameRules.FATE_TOKENS_ENABLED)) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == FateTokensModItems.FATE_TOKEN.get()) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if ((entityiterator.getDisplayName().getString()).equals(new Object() {
						public String getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getString(tag);
							return "";
						}
					}.getValue(world, BlockPos.containing(x, y, z), "grave_display_name"))) {
						grave_for = entityiterator;
					}
				}
				if (grave_for == null) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Looks like that player is offline. You can only resurrect online players."), false);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Clicked with diamond"), false);
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(FateTokensModBlocks.GRAVESTONE.get().defaultBlockState()));
					{
						Entity _ent = grave_for;
						_ent.teleportTo(x, y, z);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
					}
					if (grave_for instanceof ServerPlayer _player)
						_player.setGameMode(GameType.SURVIVAL);
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(FateTokensModItems.FATE_TOKEN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Here lies " + (new Object() {
						public String getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getString(tag);
							return "";
						}
					}.getValue(world, BlockPos.containing(x, y, z), "grave_display_name")) + ".")), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Fate Tokens are disabled on this server. Set gamerule fateTokensEnabled to true to enable them."), false);
		}
	}
}
