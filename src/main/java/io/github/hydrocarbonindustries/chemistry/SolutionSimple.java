package io.github.hydrocarbonindustries.chemistry;

import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionSimple {

	private HashMap<ChemicalSimple, Integer> content = new HashMap<>();

	private Integer voulme = 0;

	public void setContent(HashMap<ChemicalSimple, Integer> content) {
		this.content = content;

		recalculateVoulme();
	}

	public HashMap<ChemicalSimple, Integer> getContent() {
		return content;
	}

	private void recalculateVoulme() {

		voulme = 0;

		content.forEach((k,v) -> {

			if (v != null) {
				voulme += v;
			}


		});

	}

	public void addSomething(ChemicalSimple whatToAdd, Integer amount) {

		if (this.content.containsKey(whatToAdd) && this.content.get(whatToAdd) != null) {

			this.content.put(whatToAdd, this.content.get(whatToAdd) + amount);

		} else {

			this.content.put(whatToAdd, amount);

		}

		recalculateVoulme();

	}

	public List<Text> toText()
	{

		List<Text> text = new ArrayList<>();

		text.add(Text.literal("Volume: " + getVoulme() + "mb"));

		content.forEach((k,v) -> {

			if (v != null) {

				text.add(Text.literal(k.getStupidName() + ": " + String.valueOf(v) + "mb"));

			}


		});

		return text;
	}
	public void removeSomething(ChemicalSimple whatToRemove, Integer amount) {

		if (this.content.containsKey(whatToRemove)) {

			if (this.content.get(whatToRemove) - amount > 0) {

				this.content.put(whatToRemove, this.content.get(whatToRemove) - amount);

			}

		}

	}

	public Integer getVoulme() {

		recalculateVoulme();

		return voulme;
	}

	public SolutionSimple(HashMap<ChemicalSimple, Integer> startContent) {

		this.setContent(startContent);

	}
}
