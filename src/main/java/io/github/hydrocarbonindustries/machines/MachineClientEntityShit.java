package io.github.hydrocarbonindustries.machines;

import io.github.hydrocarbonindustries.Core;
import io.github.hydrocarbonindustries.machines.burbulator.BurbulatorScreen;
import io.github.hydrocarbonindustries.machines.burbulator.BurbulatorScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class MachineClientEntityShit{

	public static final ScreenHandlerType<BurbulatorScreenHandler> BURBULATOR_SCREEN_HANDLER_SCREEN_HANDLER_TYPE = new ScreenHandlerType<BurbulatorScreenHandler>(

		BurbulatorScreenHandler::new

	);

	static {

		HandledScreens.register(BURBULATOR_SCREEN_HANDLER_SCREEN_HANDLER_TYPE, BurbulatorScreen::new);

	}


}
