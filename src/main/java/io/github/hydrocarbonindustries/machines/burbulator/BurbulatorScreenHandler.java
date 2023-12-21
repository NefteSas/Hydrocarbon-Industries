package io.github.hydrocarbonindustries.machines.burbulator;

import io.github.hydrocarbonindustries.machines.MachineClientEntityShit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class BurbulatorScreenHandler extends ScreenHandler  {

	private final Inventory inventory;

	//This constructor gets called on the client when the server wants it to open the screenHandler,
	//The client will call the other constructor with an empty Inventory and the screenHandler will automatically
	//sync this empty inventory with the inventory on the server.
	public BurbulatorScreenHandler(int syncId, PlayerInventory playerInventory) {
		this(syncId, playerInventory, new SimpleInventory(9));
	}

	//This constructor gets called from the BlockEntity on the server without calling the other constructor first, the server knows the inventory of the container
	//and can therefore directly provide it as an argument. This inventory will then be synced to the client.
	public BurbulatorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(MachineClientEntityShit.BURBULATOR_SCREEN_HANDLER_SCREEN_HANDLER_TYPE, syncId);

		this.inventory = inventory;

	}

	@Override
	public ItemStack quickTransfer(PlayerEntity player, int fromIndex) {
		return null;
	}

	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUse(player);
	}

	// Shift + Player Inv Slot
}
