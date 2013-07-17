/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex02_13;

/**
 * @author Yoichiro Shimizu
 * 
 */
public class Vehicle {
	private double speed;
	private double angle;
	private String owner = "<unnamed>";

	private int MyId;
	private static int NextId = 0;

	Vehicle() {
		MyId = NextId++;
	}

	Vehicle(String name) {
		owner = name;
		MyId = NextId++;
	}

	public double GetSpeed() {
		return speed;
	}

	public double GetAngle() {
		return angle;
	}

	public int GetMyId() {
		return MyId; // 変更を許さないべき
	}

	public String GetOwner() {
		return owner;
	}

	static int GetMaxId() {
		return NextId - 1;
	}

	public void print() {
		System.out.println("ID: " + MyId);
		System.out.println("Speed: " + speed);
		System.out.println("方向 = " + angle);
		System.out.println("所有者 = " + owner);
	}

	public String toString() {
		String buf = "ID: " + MyId + "\n" + "速度 " + speed + "\n" + "方向 = "
				+ angle + "\n" + "所有者 = " + owner;
		return buf;
	}

	public static void main(String arg[]) {
		Vehicle bmw320 = new Vehicle("Bob");
		System.out.println(bmw320.toString());

		Vehicle honda = new Vehicle("Mike");
		System.out.println(honda.toString());

		System.out.println("MaxId = " + Vehicle.GetMaxId());
	}
}
