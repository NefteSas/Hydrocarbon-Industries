package io.github.hydrocarbonindustries;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class hciMaterial extends Item {

	public float Purify = 0F;


	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);

		tooltip.add(Text.translatable("item.hci.purify_tooltip").append("Fe \n" + String.valueOf(this.Purify) + "%"));
	}

	public hciMaterial(Settings settings, float purify) {
		super(settings);
		this.Purify = purify;
		System.out.print("SET HUI ZALUPA");
	}

	public static hciMaterial IRON_INGOT(Item.Settings settings) {
		System.out.print("SET HUI ZALUPA");
		return new hciMaterial(settings, 60.0F);

	}
}
