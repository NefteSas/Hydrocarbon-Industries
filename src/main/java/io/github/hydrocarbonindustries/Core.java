package io.github.hydrocarbonindustries;

import io.github.hydrocarbonindustries.machines.MachineClientEntityShit;
import io.github.hydrocarbonindustries.machines.MachineEntityTypes;
import io.github.hydrocarbonindustries.mixes.FluidChemicalMixSimple;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Core implements ModInitializer, ClientModInitializer {
	//TODO Запилить:
	// - Заставить машину заливать/тратить из смеси
	// - Запилить пирожки с шпинатом и сыром, посыпленные аскарбинками (Дают бафф, который настакивается if n > 3 , игрок умирает и вместо него спавнится камень из почек)
	// - Трость. Дает сильный прирост здоровью, если игрок под действием обезболивающего.
	public static final Logger LOGGER = LoggerFactory.getLogger("Hydrocarbon Industries");

	public static final FluidChemicalMixSimple TEST = new FluidChemicalMixSimple(new QuiltItemSettings().maxCount(1));

	public static final String MOD_ID = "hci";

	@Override
	public void onInitialize(ModContainer mod) {

		new MachineEntityTypes();

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "testmix"), TEST);

	}

	@Override
	public void onInitializeClient(ModContainer mod) {

		new MachineClientEntityShit();

	}
}
