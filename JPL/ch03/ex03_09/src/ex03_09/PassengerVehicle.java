/*
 * @file
 * @par File Name:
 * PassengerVehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_09;

public class PassengerVehicle extends Vehicle implements Cloneable {
	private int seatNum;
	private int seatedNum;

	public PassengerVehicle(String owner) {
		super(owner);
		this.seatNum = 1; // Car must have a seat,
		this.seatedNum = 0;
	}

	public final void SetSeatNum(int n) {
		this.seatNum = n;
	}

	public int GetSeatNum() {
		return this.seatNum;
	}

	public void AddSeatedNum() {
		this.seatedNum = this.seatedNum + 1;
	}

	public int GetSeatedNum() {
		return this.seatedNum;
	}

	public String toString() {
		return super.toString() + " 座席数" + seatNum + " 座っている人数" + seatedNum;
	}

	public static void main(String args[]) {
		PassengerVehicle bmw = new PassengerVehicle("Mike");
		bmw.SetSeatNum(5);
		try {
			PassengerVehicle bmw2 = (PassengerVehicle) bmw.clone();
			bmw2.setOwner("Bob");
			System.out.println(bmw);
			System.out.println(bmw2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
