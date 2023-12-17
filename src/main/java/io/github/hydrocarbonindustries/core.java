package io.github.hydrocarbonindustries;

import io.github.hydrocarbonindustries.Ingots.hciIngotMaterial;
import io.github.hydrocarbonindustries.machines.Bobulator;
import io.github.hydrocarbonindustries.mixes.StandartMixes;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class core implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Hydrocarbon Industries");

	public static final String MOD_ID = "hci";

	public static final Block BOBULATOR = new Bobulator(QuiltBlockSettings.of(Material.BAMBOO));

	@Override
	public void onInitialize(ModContainer mod) {

		new hciIngotMaterial();

		new StandartMixes();

		Registry.register(Registry.BLOCK, new Identifier(core.MOD_ID, "bobulator"), BOBULATOR);
		Registry.register(Registry.ITEM, new Identifier(core.MOD_ID, "bobulator"), new BlockItem(BOBULATOR, new Item.Settings()));
	}
}
