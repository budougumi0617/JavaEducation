/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex04_01;

public class Vehicle {
	private double speed;
	private double angle;
	private String owner = "<unnamed>";
	private EnergySource es;

	private final int myId;// 変更を許さないべき
	private static int originId = 0;
	public static final int TURN_LEFT = -1;
	public static final int TURN_RIGHT = 1;

	Vehicle() {
		this("", null);
	}

	Vehicle(String name) {
		this(name, null);
	}

	Vehicle(EnergySource es) {
		this("",es);
	}

	Vehicle(String name, EnergySource es) {
		myId = originId;
		owner = name;
		this.es = es;
		updateOrginId();
	}
	
	public EnergySource getEnergySource(){
		return this.es;
	}
	
	
	static final public void updateOrginId() {
		originId++;
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
		return originId - 1;
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
			this.angle -= 90.0;
		else if (angle == Vehicle.TURN_RIGHT)
			this.angle += 90.0;
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

	public static void main(String args[]) {
		Vehicle fit = new Vehicle(new GasTank(10.0));
		Vehicle emptyFit = new Vehicle(new GasTank(0.0));
		Vehicle leaf = new Vehicle(new Battery(100.0));
		Vehicle emptyLeaf = new Vehicle(new Battery(0.0));

		fit.start();
		emptyFit.start();
		leaf.start();
		emptyLeaf.start();
	}
}
