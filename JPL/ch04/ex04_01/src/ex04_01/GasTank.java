/*
 * @file
 * @par File Name:
 * GassTank.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex04_01;

public class GasTank implements EnergySource {
	private double energy = 0;

	public GasTank(double gass) {
		this.energy = gass;
	}

	public boolean empty() {
		return (this.energy <= 0);

	}

}
