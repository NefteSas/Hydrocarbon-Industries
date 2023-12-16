package io.github.hydrocarbonindustries;

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

	public HashMap<ChemicalMolecule, Float>  structure;

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);

		tooltip.add(Text.translatable("item.hci.purify_tooltip").append(String.valueOf(this.Purify) + "%"));

		for(ChemicalMolecule key : structure.keySet() ) {

			tooltip.add(Text.literal(key.getChem_formula_text() + " - " + String.valueOf(structure.get(key)) + "%"));

		}
	}

	public hciMaterial(Settings settings, float purify , HashMap<ChemicalMolecule, Float> prefab) {
		super(settings);
		this.Purify = purify;

		this.structure = prefab;
		if (prefab == null) {
			this.structure = new HashMap<ChemicalMolecule, Float>();
			structure.put(ChemicalMolecules.DANILIUM, 100.0F);
		}



	}

	public static hciMaterial IRON_INGOT(Item.Settings settings) {

		HashMap<ChemicalMolecule, Float> prefab = new HashMap<ChemicalMolecule, Float>();

		prefab.put(ChemicalMolecules.FERRUM, 99.5F);
		prefab.put(ChemicalMolecules.CARBON, 0.5F);

		return new hciMaterial(settings, 2.0F, prefab);

	}

	public static hciMaterial CoalPiece(Item.Settings settings) {

		HashMap<ChemicalMolecule, Float> prefab = new HashMap<ChemicalMolecule, Float>();

		prefab.put(ChemicalMolecules.CARBON, 75.0F);
		prefab.put(ChemicalMolecules.SULFUR, 5.0F);
		prefab.put(ChemicalMolecules.OXYGEN, 6.0F);
		prefab.put(ChemicalMolecules.HYDROGEN, 4.0F);

		return new hciMaterial(settings, 67.0F, prefab);

	}


}
