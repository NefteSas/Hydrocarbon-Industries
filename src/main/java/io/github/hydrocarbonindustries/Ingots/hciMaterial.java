package io.github.hydrocarbonindustries.Ingots;

import io.github.hydrocarbonindustries.chemistry.ChemicalCombination;
import io.github.hydrocarbonindustries.chemistry.ChemicalMolecule;
import io.github.hydrocarbonindustries.chemistry.ChemicalMolecules;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

public class hciMaterial extends Item {

	public float Purify;

	public HashMap<ChemicalMolecule, Double>  structure;

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);

		tooltip.add(Text.translatable("item.hci.purify_tooltip").append(String.valueOf(this.Purify) + "%"));

		for(ChemicalMolecule key : structure.keySet() ) {

			tooltip.add(Text.literal(key.getChem_formula_text() + " - " + String.valueOf(structure.get(key)) + "%"));

		}
	}

	public hciMaterial(Settings settings, float purify , ChemicalCombination combination) {
		super(settings);
		this.Purify = purify;

		this.structure = combination.getCombination();

	}

	public static hciMaterial IRON_INGOT(Item.Settings settings) {

		HashMap<ChemicalMolecule, Double> prefab = new HashMap<>();

		prefab.put(ChemicalMolecules.FERRUM, 99.5);
		prefab.put(ChemicalMolecules.CARBON, 0.5);

		return new hciMaterial(settings, 2.0F, new ChemicalCombination(prefab));

	}

	public static hciMaterial COAL_PIECE(Item.Settings settings) {

		HashMap<ChemicalMolecule, Double> prefab = new HashMap<>();

		prefab.put(ChemicalMolecules.CARBON, 75.0);
		prefab.put(ChemicalMolecules.SULFUR, 5.0);
		prefab.put(ChemicalMolecules.OXYGEN, 6.0);
		prefab.put(ChemicalMolecules.HYDROGEN, 4.0);

		return new hciMaterial(settings, 67.0F, new ChemicalCombination(prefab));

	}


}
