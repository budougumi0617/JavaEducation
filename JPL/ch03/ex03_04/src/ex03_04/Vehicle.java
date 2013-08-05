/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_04;

public class Vehicle {
	private double speed;
	private double angle;
	private String owner = "<unnamed>";

	private final int MyId;// 変更を許さないべき
	private static int NextId = 0;
	public static final int TURN_LEFT = -1;
	public static final int TURN_RIGHT = 1;

	Vehicle() {
		MyId = NextId++;
	}

	Vehicle(String name) {
		owner = name;
		MyId = NextId++;
	}

	public double getSpeed() {
		return speed;
	}

	public double getAngle() {
		return angle;
	}

	public int getMyId() {
		return MyId;
	}

	public String getOwner() {
		return owner;
	}

	static int getMaxId() {
		return NextId - 1;
	}

	public void changeSpeed(double NowSpeed) {
		this.speed = NowSpeed;
	}

	public void stop() {
		this.speed = 0.0;
	}

	public void turn(double NewAngle) {
		this.angle = NewAngle;
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

}
