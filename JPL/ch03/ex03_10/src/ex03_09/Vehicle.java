/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_09;

public class Vehicle implements Cloneable {
	private double speed;
	private double angle;
	private String owner = "<unnamed>";
	private EnergySource es = null;

	private int myId;// 変更を許さないべき
	private static int nextId = 0;
	public static final int TURN_LEFT = -1;
	public static final int TURN_RIGHT = 1;

	public Vehicle() {
		myId = nextId++;
	}

	public Vehicle(String name) {
		owner = name;
		myId = nextId++;
	}

	Vehicle(EnergySource es) {
		this();
		this.es = es;
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

	public void setOwner(String owner) {
		this.owner = owner;
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

	public void start() {
		System.out
				.println("You Can" + (this.es.empty() ? "'t" : "") + " Start");
	}

	public Vehicle clone() throws CloneNotSupportedException {
		try {
			Vehicle obj = (Vehicle) super.clone();
			obj.myId = nextId++;
			return obj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
