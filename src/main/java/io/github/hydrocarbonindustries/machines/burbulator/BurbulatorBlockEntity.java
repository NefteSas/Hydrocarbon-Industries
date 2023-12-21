package io.github.hydrocarbonindustries.machines.burbulator;

import io.github.hydrocarbonindustries.machines.MachineClientEntityShit;
import io.github.hydrocarbonindustries.machines.MachineEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntity;

public class BurbulatorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory{
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);

	public BurbulatorBlockEntity(BlockPos pos, BlockState state) {
		super(MachineEntityTypes.BURBULATOR_ENTITY, pos, state);
	}


	//From the ImplementedInventory Interface


	//These Methods are from the NamedScreenHandlerFactory Interface
	//createMenu creates the ScreenHandler itself
	//getDisplayName will Provide its name which is normally shown at the top

	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		//We provide *this* to the screenHandler as our class Implements Inventory
		//Only the Server has the Inventory at the start, this will be synced to the client in the ScreenHandler
		return new BurbulatorScreenHandler(syncId, playerInventory);
	}

	@Override
	public Text getDisplayName() {
		// for 1.19+
		return Text.translatable(getCachedState().getBlock().getTranslationKey());
		// for earlier versions
		// return new TranslatableText(getCachedState().getBlock().getTranslationKey());
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		Inventories.readNbt(nbt, this.inventory);
	}

	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		Inventories.writeNbt(nbt, this.inventory);
	}
}
