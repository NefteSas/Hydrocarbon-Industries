package io.github.hydrocarbonindustries.machines;

import io.github.hydrocarbonindustries.Core;
import io.github.hydrocarbonindustries.machines.burbulator.BurbulatorBlock;
import io.github.hydrocarbonindustries.machines.burbulator.BurbulatorBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class MachineEntityTypes {

	public static final BurbulatorBlock BURBULATOR_BLOCK = new BurbulatorBlock(QuiltBlockSettings.of(Material.BAMBOO));

	static {
		Registry.register(Registry.BLOCK, new Identifier(Core.MOD_ID, "burbulator"), BURBULATOR_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(Core.MOD_ID, "burbulator"), new BlockItem(BURBULATOR_BLOCK, new QuiltItemSettings()));
	}

	public static final BlockEntityType<BurbulatorBlockEntity> BURBULATOR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Core.MOD_ID, "burbolator_entity"),

		QuiltBlockEntityTypeBuilder.create(BurbulatorBlockEntity::new, BURBULATOR_BLOCK).build());


}
