package io.github.hydrocarbonindustries.machines;

import io.github.hydrocarbonindustries.Core;
import io.github.hydrocarbonindustries.machines.machinebased.Machine;
import io.github.hydrocarbonindustries.machines.machinebased.MachineBlockEntity;
import io.github.hydrocarbonindustries.machines.machinebased.MachineScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.item.BlockItem;
import net.minecraft.screen.ScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class MachineEntityTypes {

	public static final Machine MACHINE_BLOCK = new Machine(QuiltBlockSettings.of(Material.BAMBOO));

	public static final ScreenHandlerType<MachineScreenHandler> MACHINE_SCREEN_HANDLER_SCREEN_HANDLER_TYPE;

	static {
		MACHINE_SCREEN_HANDLER_SCREEN_HANDLER_TYPE = new ScreenHandlerType<MachineScreenHandler>(

			MachineScreenHandler::new

		);
		Registry.register(Registry.BLOCK, new Identifier(Core.MOD_ID, "burbulator"), MACHINE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(Core.MOD_ID, "burbulator"), new BlockItem(MACHINE_BLOCK, new QuiltItemSettings()));
	}

	public static final BlockEntityType<MachineBlockEntity> MACHINE_BLOCK_ENTITY_BLOCK_ENTITY_TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Core.MOD_ID, "burbolator_entity"),

		QuiltBlockEntityTypeBuilder.create(MachineBlockEntity::new, MACHINE_BLOCK).build());


}
