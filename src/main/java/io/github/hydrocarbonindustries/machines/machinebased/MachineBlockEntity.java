package io.github.hydrocarbonindustries.machines.machinebased;

import io.github.hydrocarbonindustries.Core;
import io.github.hydrocarbonindustries.machines.MachineEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class MachineBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, Inventory {
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);

	public MachineBlockEntity(BlockPos pos, BlockState state) {
		super(MachineEntityTypes.MACHINE_BLOCK_ENTITY_BLOCK_ENTITY_TYPE, pos, state);
	}

	//These Methods are from the NamedScreenHandlerFactory Interface
	//createMenu creates the ScreenHandler itself
	//getDisplayName will Provide its name which is normally shown at the top

	@Override
	public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
		//We provide *this* to the screenHandler as our class Implements Inventory
		//Only the Server has the Inventory at the start, this will be synced to the client in the ScreenHandler
		return new MachineScreenHandler(syncId, playerInventory, this);
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
	public void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		Inventories.writeNbt(nbt, this.inventory);
	}

	@Override
	public int size() {
		return inventory.size();
	}

	@Override
	public boolean isEmpty() {
		return inventory.isEmpty();
	}

	@Override
	public ItemStack getStack(int slot) {
		return inventory.get(slot);
	}

	@Override
	public ItemStack removeStack(int slot, int amount) {
		return inventory.remove(slot);
	}

	@Override
	public ItemStack removeStack(int slot) {
		return inventory.remove(slot);
	}

	@Override
	public void setStack(int slot, ItemStack stack) {
		this.inventory.set(slot, stack);
	}

	@Override
	public boolean canPlayerUse(PlayerEntity player) {
		return true;
	}

	@Override
	public void clear() {

	}
}
