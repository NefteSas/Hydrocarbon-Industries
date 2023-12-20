package io.github.hydrocarbonindustries.innerapi;

import io.github.hydrocarbonindustries.chemistry.ChemicalSimple;

import java.util.HashMap;

public class ChemistrySimpleRegistry {

	private static HashMap<String, ChemicalSimple> registry = new HashMap<>();

	public static ChemicalSimple registrate(ChemicalSimple target) {

		if (!registry.containsKey(target.getSmartName())) {

			registry.put(target.getSmartName(), target);


		} else {

			throw new Error("Trying to register what already registrated [ " + target.getSmartName() + "]");

		}

		return target;

	}

	public static ChemicalSimple getFromId(String smartName) {

		return registry.get(smartName);

	}

}
