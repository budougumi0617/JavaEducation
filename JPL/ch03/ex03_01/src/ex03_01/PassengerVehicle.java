/*
 * @file
 * @par File Name:
 * PassengerVehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_01;

public class PassengerVehicle extends Vehicle {
	private int SeatNum;
	private int SeatedNum;

	public PassengerVehicle(String Owner) {
		super(Owner);
		this.SeatNum = 1; // Car must have a seat,
		this.SeatedNum = 0;
	}

	public void setSeatNum(int n) {
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
		PassengerVehicle bmw = new PassengerVehicle("Mike");
		PassengerVehicle matsuda = new PassengerVehicle("Bob");
		PassengerVehicle toyota = new PassengerVehicle("Jerry");

		System.out.println(bmw.toString());
		matsuda.addSeatedNum();
		matsuda.setSeatNum(4);
		System.out.println(matsuda.toString());
		System.out.println(toyota.toString());
	}

}
