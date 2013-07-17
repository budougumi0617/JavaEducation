/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex02_05;

/**
 * @author Yoichiro Shimizu
 * 
 */

public class Vehicle {
	public double speed;
	public double angle;
	public String owner;

	public int MyId;
	static int NextId = 0;

	public void show(String name) {
		System.out.println(name);
		System.out.println("ID: " + MyId);
		System.out.println("Speed: " + speed);
		System.out.println("  方向 = " + angle);
		System.out.println("  所有者 = " + owner);
	}

	public static void main(String arg[]) {
		Vehicle bmw320 = new Vehicle();
		bmw320.speed = 100;
		bmw320.angle = 10;
		bmw320.owner = "Bob";
		bmw320.MyId = Vehicle.NextId++;
		bmw320.show("BMW");

		Vehicle honda = new Vehicle();
		honda.speed = 90;
		honda.angle = -10;
		honda.owner = "Mike";
		honda.MyId = Vehicle.NextId++;
		honda.show("HONDA");
	}
}
