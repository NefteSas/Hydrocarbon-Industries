package io.github.hydrocarbonindustries.machines;

import io.github.hydrocarbonindustries.chemistry.ChemicalCombination;
import io.github.hydrocarbonindustries.chemistry.ChemicalMolecules;
import io.github.hydrocarbonindustries.core;
import io.github.hydrocarbonindustries.mixes.Mix;
import io.github.hydrocarbonindustries.mixes.StandartMixes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;


public class Bobulator extends Block {

	public Bobulator(Settings settings) {
		super(settings);
	}

	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (world.isClient) {
			return ActionResult.SUCCESS;
		} else {

			core.LOGGER.debug("GG");

			return ActionResult.CONSUME;
		}


	}
}
