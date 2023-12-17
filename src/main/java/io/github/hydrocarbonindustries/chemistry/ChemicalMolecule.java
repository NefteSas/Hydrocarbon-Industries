package io.github.hydrocarbonindustries.chemistry;

public class ChemicalMolecule {

	private final String name;
	private final String chem_formula_text;

	public ChemicalMolecule(String name, String chem_formula_text){

		this.name = name;
		this.chem_formula_text = chem_formula_text;

	}

	public String getName(){
		return this.name;
	}

	public String getChem_formula_text() {
		return this.chem_formula_text;
	}
}
