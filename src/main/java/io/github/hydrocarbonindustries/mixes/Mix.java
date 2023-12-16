package io.github.hydrocarbonindustries.mixes;

import io.github.hydrocarbonindustries.ChemicalMolecule;
import net.minecraft.item.Item;

import java.util.HashMap;

public class Mix extends Item {

	private int  volume = 0; //Ведра

	private HashMap<ChemicalMolecule, Float> composition;

	public int GetVolumeByClass(ChemicalMolecule finding) {
		return Math.round(composition.get(finding) * volume); //Рассчитываем объем по процентному содержанию.
	}

	public Mix(Settings settings, MixConfiguration configuration) {
		super(settings);

		this.composition = configuration.composition; //Тут состав. В процентах. Кол-во чего-то будет выщитываться в зависимости от объема.
	}

	public class MixConfiguration{

		private HashMap<ChemicalMolecule, Float> composition;


	}

}
