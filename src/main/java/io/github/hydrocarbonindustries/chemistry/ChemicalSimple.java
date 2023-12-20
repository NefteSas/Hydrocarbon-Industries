package io.github.hydrocarbonindustries.chemistry;

public class ChemicalSimple {
	public static final double WATER_SOLVENT_POWER = 1.0;
	private String stupidName;
	private Double powerAsSolvent;
	private String smartName;

	public String getStupidName() {
		return stupidName;
	}
	public String getSmartName() {
		return stupidName;
	}
	public double getPowerAsSolvent() {
		return powerAsSolvent;
	}

	public ChemicalSimple(String _stupidName, String _smartName, double _powerAsSolvent) {
		this.stupidName = _stupidName;
		this.smartName = _smartName;
		this.powerAsSolvent = _powerAsSolvent;

	}

}
