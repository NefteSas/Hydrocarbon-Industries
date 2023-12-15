package io.github.hydrocarbonindustries.mixin;

import io.github.hydrocarbonindustries.core;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class TitleScreenMixin {
	@Inject(method = "use", at = @At("HEAD"))
	public void exampleMod$onInit(CallbackInfo ci) {
		core.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
