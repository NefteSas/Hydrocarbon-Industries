package io.github.hydrocarbonindustries.machines;

import io.github.hydrocarbonindustries.machines.machinebased.MachineScreen;
import io.github.hydrocarbonindustries.machines.machinebased.MachineScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class MachineClientEntityShit{



	public MachineClientEntityShit() {
		HandledScreens.register(MachineEntityTypes.MACHINE_SCREEN_HANDLER_SCREEN_HANDLER_TYPE, MachineScreen::new);
	}


}
