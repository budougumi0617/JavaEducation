/*
 * @file
 * @par File Name:
 * Battery.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_09;

public class Battery extends EnergySource {
	private double energy = 0;

	public Battery(double elec) {
		this.energy = elec;
	}

	boolean empty() {
		return (this.energy <= 0);
	}

}
