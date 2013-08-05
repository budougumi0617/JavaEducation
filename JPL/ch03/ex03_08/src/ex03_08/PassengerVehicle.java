/*
 * @file
 * @par File Name:
 * PassengerVhicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_08;

public class PassengerVehicle extends Vehicle implements Cloneable {
	private int SeatNum;
	private int SeatedNum;

	public PassengerVehicle(String Owner) {
		super(Owner);
		this.SeatNum = 1; // Car must have a seat,
		this.SeatedNum = 0;
	}

	public final void setSeatNum(int n) {
		this.SeatNum = n;
	}

	public int getSeatNum() {
		return this.SeatNum;
	}

	public void addSeatedNum() {
		this.SeatedNum = this.SeatedNum + 1;
	}

	public int getSeatedNum() {
		return this.SeatedNum;
	}

	public String toString() {
		return super.toString() + " 座席数" + SeatNum + " 座っている人数" + SeatedNum;
	}

	public static void main(String args[]) {
		PassengerVehicle Bmw = new PassengerVehicle("Mike");
		Bmw.setSeatNum(5);
		try {
			PassengerVehicle Bmw2 = (PassengerVehicle) Bmw.clone();
			Bmw2.setOwner("Bob");
			System.out.println(Bmw);
			System.out.println(Bmw2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
