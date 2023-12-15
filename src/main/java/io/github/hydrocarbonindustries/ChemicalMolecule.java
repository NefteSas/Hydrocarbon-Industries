package io.github.hydrocarbonindustries;

public class ChemicalMolecule {

	private String name;
	private String chem_formula_text;

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
