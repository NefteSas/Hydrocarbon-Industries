package io.github.hydrocarbonindustries;


import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Interface;

import java.util.HashMap;

public class hciMaterials {

	public static final hciMaterial PIG_IRON;
	public static final hciMaterial STEEL_INGOT;

	static {
		PIG_IRON = Registry.register(Registry.ITEM, new Identifier(core.MOD_ID, "pig_iron"), new hciMaterial(new Item.Settings().group(ItemGroup.MATERIALS), 8, new HashMap<ChemicalMolecule, Float>() {{
			put(ChemicalMolecules.FERRUM, 96.0F);
			put(ChemicalMolecules.CARBON, 4.0F);
		}}));

		STEEL_INGOT = Registry.register(Registry.ITEM, new Identifier(core.MOD_ID, "steel_ingot"), new hciMaterial(new Item.Settings().group(ItemGroup.MATERIALS), 8, new HashMap<ChemicalMolecule, Float>() {{
			put(ChemicalMolecules.FERRUM, 99.0F);
			put(ChemicalMolecules.CARBON, 1.0F);
		}}));
	}





}
