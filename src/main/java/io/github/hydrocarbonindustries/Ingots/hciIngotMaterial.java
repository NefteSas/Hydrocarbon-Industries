package io.github.hydrocarbonindustries.Ingots;


import io.github.hydrocarbonindustries.chemistry.ChemicalCombination;
import io.github.hydrocarbonindustries.chemistry.ChemicalMolecule;
import io.github.hydrocarbonindustries.chemistry.ChemicalMolecules;
import io.github.hydrocarbonindustries.core;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class hciIngotMaterial {
	public static final hciMaterial STEEL_INGOT;

	static {
		STEEL_INGOT = Registry.register(Registry.ITEM, new Identifier(core.MOD_ID, "steel_ingot"), new hciMaterial(new Item.Settings(), 8, new ChemicalCombination(new HashMap<>() {{
			put(ChemicalMolecules.FERRUM, 99.0);
			put(ChemicalMolecules.CARBON, 1.0);
		}})));
	}





}
