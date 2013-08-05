package ex04_03;

public class GasTank extends EnergySource {
	private double energy = 0;

	public GasTank(double gass) {
		this.energy = gass;
	}

	boolean empty() {
		return (this.energy <= 0);
	}

}
