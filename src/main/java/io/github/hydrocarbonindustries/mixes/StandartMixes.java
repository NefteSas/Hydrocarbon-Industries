package io.github.hydrocarbonindustries.mixes;

import io.github.hydrocarbonindustries.chemistry.ChemicalCombination;
import io.github.hydrocarbonindustries.chemistry.ChemicalMolecules;
import io.github.hydrocarbonindustries.core;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class StandartMixes {

	public static final Mix BASIC_MIX;

	static {

		BASIC_MIX = Registry.register(Registry.ITEM, new Identifier(core.MOD_ID,"chem_mix"), new Mix(new Item.Settings(), new Mix.MixConfiguration(

			new ChemicalCombination(new HashMap<>() {{ put(ChemicalMolecules.DANILIUM, 100.0); }} ), 1000

		)));

	}

}
