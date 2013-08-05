/*
 * @file
 * @par File Name:
 * Battery.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex04_01;

public class Battery implements EnergySource {
	private double energy = 0;

	public Battery(double elec) {
		this.energy = elec;
	}

	public boolean empty() {
		return (this.energy <= 0);

	}

}
