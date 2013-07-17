/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex02_06;

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

	public void print() {
		System.out.println("ID: " + MyId);
		System.out.println("Speed: " + speed);
		System.out.println("  方向 = " + angle);
		System.out.println("  所有者 = " + owner);
	}
}
