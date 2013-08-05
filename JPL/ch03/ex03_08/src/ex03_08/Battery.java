/*
 * @file
 * @par File Name:
 * Battery.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_08;

public class Battery extends EnergySource {
	private double Energy = 0;

	public Battery(double elec) {
		this.Energy = elec;
	}

	boolean empty() {
		return (this.Energy <= 0);
	}

}
