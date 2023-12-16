package io.github.hydrocarbonindustries.mixin;

import io.github.hydrocarbonindustries.Ingots.hciMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;


@Mixin(Items.class)
public class ItemMaterialsMixin {

	@Redirect(
		slice = @Slice(
			from = @At(
				value = "CONSTANT",
				args= {
					"stringValue=iron_ingot" //Сюда айдишник предмета в регистре
				},
				ordinal = 0
			)
		),
		at = @At(
			value = "NEW",
			target = "Lnet/minecraft/item/Item;*", //Класс, насколько я понимюа
			ordinal = 0
		),
		method = "<clinit>")
	private static Item iron_ingot(Item.Settings setting) {

		return hciMaterial.IRON_INGOT(setting);
	}

	@Redirect(
		slice = @Slice(
			from = @At(
				value = "CONSTANT",
				args= {
					"stringValue=coal" //Сюда айдишник предмета в регистре
				},
				ordinal = 0
			)
		),
		at = @At(
			value = "NEW",
			target = "Lnet/minecraft/item/Item;*", //Класс, насколько я понимюа
			ordinal = 0
		),
		method = "<clinit>")
	private static Item coal(Item.Settings setting) {

		return hciMaterial.CoalPiece(setting);
	}


}
