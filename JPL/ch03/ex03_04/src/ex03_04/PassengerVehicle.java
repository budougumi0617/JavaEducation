/*
 * @file
 * @par File Name:
 * PassengerVehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_04;

public class PassengerVehicle extends Vehicle {
	private int seatNum;
	private int seatedNum;

	public PassengerVehicle(String owner) {
		super(owner);
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
		PassengerVehicle matsuda = new PassengerVehicle("Bob");
		PassengerVehicle toyota = new PassengerVehicle("Jerry");

		System.out.println(bmw.toString());
		matsuda.addSeatedNum();
		matsuda.setSeatNum(4);
		System.out.println(matsuda.toString());
		matsuda.setSeatNum(5);
		matsuda.addSeatedNum();
		System.out.println(matsuda.toString());
		System.out.println(toyota.toString());

	}

}
