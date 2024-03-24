
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package sh.dip.mc.fate_tokens.init;

import sh.dip.mc.fate_tokens.block.entity.GravestoneBlockEntity;
import sh.dip.mc.fate_tokens.FateTokensMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class FateTokensModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FateTokensMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> GRAVESTONE = register("gravestone", FateTokensModBlocks.GRAVESTONE, GravestoneBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
