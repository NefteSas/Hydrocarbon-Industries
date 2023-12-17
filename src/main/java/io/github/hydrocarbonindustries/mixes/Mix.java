package io.github.hydrocarbonindustries.mixes;

import io.github.hydrocarbonindustries.chemistry.ChemicalCombination;
import io.github.hydrocarbonindustries.chemistry.ChemicalMolecule;
import io.github.hydrocarbonindustries.core;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Mix extends Item {

	private Logger LOGGER = LoggerFactory.getLogger("FF");

	private int  volume; //милибакеты
	private ChemicalCombination composition;

	private NbtCompound nbtCompound;

	public int getVolumeByClass(ChemicalMolecule finding) {
		return (int) Math.round(composition.getCombination().get(finding) * volume);
	}


	@Override
	public void postProcessNbt(NbtCompound nbt) {

		core.LOGGER.debug("POSTPROCESS_SHIT");

		super.postProcessNbt(nbt);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		ItemStack thisStack = user.getStackInHand(hand);

		NbtCompound getted = thisStack.getOrCreateNbt();

		if (getted.contains("volume")) {

			getted.putInt("volume", getted.getInt("volume") + 50);

		} else {

			getted.putInt("volume", 50);

		}

		System.out.print(String.valueOf(getted.getInt("volume")));

		thisStack.writeNbt(getted);

		return super.use(world, user, hand);






	}

	public void addItemStackToMix(ItemStack config) {

		if (config.getItem().getClass() == Mix.class) { //Если мы работаем с  айтемами

		}
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);

		tooltip.add(Text.literal(String.valueOf(stack.getOrCreateNbt().getInt("volume"))));

	}



	public void setComposition(ChemicalCombination newCombination, int newVolume) {

		composition = newCombination;
		volume = newVolume;

	}

	public Mix(Settings settings, MixConfiguration configuration) {
		super(settings);

		settings.maxCount(1);

		this.composition = configuration.composition; //Тут состав. В процентах. Кол-во чего-то будет выщитываться в зависимости от объема.

		this.volume = configuration.volumeMb;
	}


	public static class MixConfiguration{
		public ChemicalCombination composition;
		public int volumeMb;

		public MixConfiguration(ChemicalCombination constructComposition, int volumeConstruct) {

			/**
			 * @param volumeConstruct - Объем смеси в милибакитах
			 *
			 *
			 */

			composition = constructComposition;

			volumeMb = volumeConstruct;
		}

	}



}
