package io.github.hydrocarbonindustries.chemistry;

import java.util.HashMap;

public class ChemicalCombination {

	public HashMap<ChemicalMolecule, Double> combination;

	public HashMap<ChemicalMolecule, Double> getCombination() {
		return combination;
	}

	public void setCombination(HashMap<ChemicalMolecule, Double> combination) {
		this.combination = combination;
	}

	public ChemicalCombination(HashMap<ChemicalMolecule, Double> combination) {

		this.combination = combination;

	}

}
