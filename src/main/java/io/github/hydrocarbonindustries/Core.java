package io.github.hydrocarbonindustries;

import io.github.hydrocarbonindustries.mixes.FluidChemicalMixSimple;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Core implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Hydrocarbon Industries");

	public static final FluidChemicalMixSimple TEST = new FluidChemicalMixSimple(new QuiltItemSettings().maxCount(1));

	public static final String MOD_ID = "hci";

	@Override
	public void onInitialize(ModContainer mod) {

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "testmix"), TEST);

	}
}
