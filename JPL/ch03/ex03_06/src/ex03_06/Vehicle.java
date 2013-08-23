package ex03_06;

public class Vehicle {
	private double speed;
	private double angle;
	private String owner = "<unnamed>";
	private EnergySource es = null;

	private final int myId;// 変更を許さないべき
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

	Vehicle(EnergySource es) {
		this();
		this.es = es;
	}

	public double GetSpeed() {
		return speed;
	}

	public double GetAngle() {
		return angle;
	}

	public int GetMyId() {
		return myId;
	}

	public String GetOwner() {
		return owner;
	}

	static int GetMaxId() {
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
