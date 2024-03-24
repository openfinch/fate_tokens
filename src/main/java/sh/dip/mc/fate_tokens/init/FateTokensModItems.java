
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package sh.dip.mc.fate_tokens.init;

import sh.dip.mc.fate_tokens.item.FateTokenItem;
import sh.dip.mc.fate_tokens.FateTokensMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class FateTokensModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FateTokensMod.MODID);
	public static final RegistryObject<Item> GRAVESTONE = block(FateTokensModBlocks.GRAVESTONE);
	public static final RegistryObject<Item> FATE_TOKEN = REGISTRY.register("fate_token", () -> new FateTokenItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
