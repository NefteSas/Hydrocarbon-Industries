package io.github.hydrocarbonindustries.mixes;

import io.github.hydrocarbonindustries.chemistry.PREGENChemicalsSimple;
import io.github.hydrocarbonindustries.chemistry.SolutionSimple;
import io.github.hydrocarbonindustries.innerapi.NBTChemistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

public class FluidChemicalMixSimple extends Item {

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		ItemStack current = user.getStackInHand(hand);

		SolutionSimple solutionSimple = NBTChemistry.translateNBTToSolutionSimple(current);

		solutionSimple.addSomething(PREGENChemicalsSimple.DANILIUM, 50);

		NBTChemistry.appendSolutionSimpleToItemStack(solutionSimple, current);



		return super.use(world, user, hand);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

		SolutionSimple current = NBTChemistry.translateNBTToSolutionSimple(stack);

		tooltip.add(Text.literal("Volume: " + String.valueOf(current.getVoulme()) + "Mb"));

		tooltip.add(Text.literal("COMPOUND:"));

		current.getContent().forEach((sample, amount) -> {

			if (sample != null) { tooltip.add(Text.literal(sample.getStupidName() + " - " + amount + "Mb")); }

		});



		super.appendTooltip(stack, world, tooltip, context);
	}

	public FluidChemicalMixSimple(Settings settings) {

		super(settings);
	}
}
