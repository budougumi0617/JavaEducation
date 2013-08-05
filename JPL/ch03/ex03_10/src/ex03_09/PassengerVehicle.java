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

	public PassengerVehicle(String ownerName) {
		super(ownerName);
		this.seatNum = 1; // Car must have a seat,
		this.seatedNum = 0;
	}

	public final void setSeatNum(int n) {
		this.seatNum = n;
	}

	public int getSeatNum() {
		return this.seatNum;
	}

	public void addSeatedNum() {
		this.seatedNum = this.seatedNum + 1;
	}

	public int getSeatedNum() {
		return this.seatedNum;
	}

	public String toString() {
		return super.toString() + " 座席数" + seatNum + " 座っている人数" + seatedNum;
	}

	public static void main(String args[]) {
		PassengerVehicle bmw = new PassengerVehicle("Mike");
		bmw.setSeatNum(5);
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
