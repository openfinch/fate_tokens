
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package sh.dip.mc.fate_tokens.init;

import sh.dip.mc.fate_tokens.FateTokensMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class FateTokensModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FateTokensMod.MODID);
	public static final RegistryObject<CreativeModeTab> FATE_TOKENS = REGISTRY.register("fate_tokens",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.fate_tokens.fate_tokens")).icon(() -> new ItemStack(FateTokensModBlocks.GRAVESTONE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(FateTokensModItems.FATE_TOKEN.get());
			})

					.build());
}
