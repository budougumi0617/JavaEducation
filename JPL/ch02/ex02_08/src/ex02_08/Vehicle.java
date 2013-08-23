/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex02_08;

/**
 * @author Yoichiro Shimizu
 * 
 */
public class Vehicle {
	public double speed;
	public double angle;
	public String owner = "<unnamed>";

	public int myId;
	private static int nextId = 0;

	Vehicle() {
		myId = nextId++;
	}

	Vehicle(String name) {
		owner = name;
		myId = nextId++;
	}

	public void print() {
		System.out.println("ID: " + myId);
		System.out.println("Speed: " + speed);
		System.out.println("方向 = " + angle);
		System.out.println("所有者 = " + owner);
	}

}