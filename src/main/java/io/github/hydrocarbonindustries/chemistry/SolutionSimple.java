package io.github.hydrocarbonindustries.chemistry;

import java.util.HashMap;

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

	public void removeSomething(ChemicalSimple whatToRemove, Integer amount) {

		if (this.content.containsKey(whatToRemove)) {

			if (this.content.get(whatToRemove) - amount > 0) {

				this.content.put(whatToRemove, this.content.get(whatToRemove) - amount);

			}

		}

	}

	public Integer getVoulme() {
		return voulme;
	}

	public SolutionSimple(HashMap<ChemicalSimple, Integer> startContent) {

		this.setContent(startContent);

	}
}
