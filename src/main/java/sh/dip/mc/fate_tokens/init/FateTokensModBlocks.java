
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package sh.dip.mc.fate_tokens.init;

import sh.dip.mc.fate_tokens.block.GravestoneBlock;
import sh.dip.mc.fate_tokens.FateTokensMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class FateTokensModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, FateTokensMod.MODID);
	public static final RegistryObject<Block> GRAVESTONE = REGISTRY.register("gravestone", () -> new GravestoneBlock());
}
