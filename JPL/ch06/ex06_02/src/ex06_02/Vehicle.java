/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex06_02;

public class Vehicle {
	enum Turn {
		TURN_LEFT, TURN_RIGHT,
	}

	private double speed;
	private double angle;
	private String owner = "<unnamed>";

	private int myId;// 変更を許さないべき
	private static int nextId = 0;

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

	public void turn(Turn turn) {
		switch (turn) {
		case TURN_LEFT:
			this.angle -= 45.0;
			break;
		case TURN_RIGHT:
			this.angle += 0.0;
			break;
		default:
			this.angle += 0;
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

	public static void main(String arg[]) {
		Vehicle bmw320 = new Vehicle("Bob");
		System.out.println(bmw320.toString());

		Vehicle honda = new Vehicle("Mike");
		System.out.println(honda.toString());

		System.out.println("MaxId = " + Vehicle.getMaxId());
	}
}
