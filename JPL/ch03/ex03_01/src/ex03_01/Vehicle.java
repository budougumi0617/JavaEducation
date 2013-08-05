/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_01;

public class Vehicle {
	private double speed;
	private double angle;
	private String owner = "<unnamed>";

	private int myId;// 変更を許さないべき
	private static int nextId = 0;
	public static final int TURN_LEFT = -1;
	public static final int TURN_RIGHT = 1;

	Vehicle() {
		myId = nextId++;
	}

	Vehicle(String name) {
		owner = name;
		myId = nextId++;
	}

	public double getSpeed() {
		return speed;
	}

	public double getAngle() {
		return angle;
	}

	public int getMyId() {
		return myId;
	}

	public String getOwner() {
		return owner;
	}

	static int getMaxId() {
		return nextId - 1;
	}

	public void changeSpeed(double nowSpeed) {
		this.speed = nowSpeed;
	}

	public void stop() {
		this.speed = 0.0;
	}

	public void turn(double newAngle) {
		this.angle = newAngle;
	}

	public void turn(int angle) {
		if (angle == Vehicle.TURN_LEFT)
			this.angle -= 45.0;
		else if (angle == Vehicle.TURN_RIGHT)
			this.angle += 45.0;
		else {
			;
		}

	}

	public void print() {
		System.out.println("ID: " + myId);
		System.out.println("Speed: " + speed);
		System.out.println("方向 = " + angle);
		System.out.println("所有者 = " + owner);
	}

	public String toString() {
		String buf = "ID: " + myId + "\n" + "速度 " + speed + "\n" + "方向 = "
				+ angle + "\n" + "所有者 = " + owner;
		return buf;
	}

}
