package io.github.hydrocarbonindustries.innerapi;

import io.github.hydrocarbonindustries.chemistry.ChemicalSimple;
import io.github.hydrocarbonindustries.chemistry.SolutionSimple;
import io.github.hydrocarbonindustries.mixes.FluidChemicalMixSimple;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

import java.util.HashMap;

public class NBTChemistry {

	public static final String CHEM_COMPOUND_UNDER_NBT = "chemcompound";

	public static void appendSolutionSimpleToItemStack(SolutionSimple mix, ItemStack stack) {

		if (stack.getItem().getClass() != FluidChemicalMixSimple.class) {return;}

		NbtCompound chemCompound = stack.getOrCreateSubNbt(CHEM_COMPOUND_UNDER_NBT);


		for (ChemicalSimple key : mix.getContent().keySet() ) {

			if (key == null) {continue;}

			chemCompound.putInt(key.getSmartName(), mix.getContent().get(key));

		}

	}
	public static SolutionSimple translateNBTToSolutionSimple(ItemStack stack) {

		if (stack.getItem().getClass() != FluidChemicalMixSimple.class) {return null;}

		HashMap<ChemicalSimple, Integer> bufferMix = new HashMap<>();

		stack.getOrCreateSubNbt(CHEM_COMPOUND_UNDER_NBT).getKeys().forEach((key) -> {

				bufferMix.put(ChemistrySimpleRegistry.getFromId(key),
					stack.getOrCreateSubNbt(CHEM_COMPOUND_UNDER_NBT).getInt(key));

			}
			);

		return new SolutionSimple(bufferMix);

	}

}
