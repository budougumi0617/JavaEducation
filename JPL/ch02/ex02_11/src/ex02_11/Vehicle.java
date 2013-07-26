/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex02_11;

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

	public void print() {
		System.out.println("ID: " + MyId);
		System.out.println("速度: " + speed);
		System.out.println("方向 = " + angle);
		System.out.println("所有者 = " + owner);
	}

	/**
	 * @return speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed セットする speed
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return angle
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * @param angle セットする angle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * @return owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner セットする owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String toString() {
		String buf = "ID: " + MyId + "\n" + "速度 " + speed + "\n" + "方向 = "
				+ angle + "\n" + "所有者 = " + owner;
		return buf;
	}

}
