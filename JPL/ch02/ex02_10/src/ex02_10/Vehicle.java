/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex02_10;

/**
 * @author Yoichiro Shimizu
 * 
 */
public class Vehicle {
	public double speed;
	public double angle;
	public String owner = "<unnamed>";

	public int MyId;
	private static int NextId = 0;

	Vehicle() {
		MyId = NextId++;
	}

	Vehicle(String name) {
		owner = name;
		MyId = NextId++;
	}

	static int GetMaxId() {
		return NextId - 1;
	}

	public void show(String name) {
		System.out.println(name);
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
		bmw320.speed = 100;
		bmw320.angle = 10;
		System.out.println(bmw320.toString());

		Vehicle honda = new Vehicle("Mike");
		honda.speed = 90;
		honda.angle = -10;
		System.out.println(honda.toString());

		System.out.println("MaxId = " + Vehicle.GetMaxId());
	}
}
