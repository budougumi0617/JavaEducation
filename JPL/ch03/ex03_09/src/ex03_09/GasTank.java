/*
 * @file
 * @par File Name:
 * GassaTank.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_09;

public class GasTank extends EnergySource {
	private double energy = 0;

	public GasTank(double gass) {
		this.energy = gass;
	}

	boolean empty() {
		return (this.energy <= 0);
	}

}
