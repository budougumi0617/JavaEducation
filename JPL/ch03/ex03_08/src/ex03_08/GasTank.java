/*
 * @file
 * @par File Name:
 * GassTank.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_08;

public class GasTank extends EnergySource {
	private double Energy = 0;

	public GasTank(double gass) {
		this.Energy = gass;
	}

	boolean empty() {
		if (this.Energy <= 0) {
			return true;
		} else {
			return false;
		}
	}

}
