package ex06_02;
public class Vehicle {
	enum Turn{
		TURN_LEFT,TURN_RIGHT,
	}
	private double speed;
	private double angle;
	private String owner = "<unnamed>";

	private int MyId;//変更を許さないべき
	private static int NextId = 0;

	Vehicle(){
		MyId = NextId++;
	}
	Vehicle(String name){
		owner = name;
		MyId = NextId++;
	}

	public double GetSpeed()
	{
		return speed;
	}

	public double GetAngle()
	{
		return angle;
	}

	public int GetMyId()
	{
		return MyId;
	}

	public String GetOwner()
	{
		return owner;
	}
	static int GetMaxId(){
		return NextId -1;
	}

	public void changeSpeed(double NowSpeed)
	{
		this.speed = NowSpeed;
	}

	public void stop()
	{
		this.speed = 0.0;
	}

	public void turn (double NewAngle)
	{
		this.angle = NewAngle;
	}

	public void turn (Turn turn)
	{
		switch(turn){
		case TURN_LEFT: this.angle -= 45.0;break;
		case TURN_RIGHT: this.angle += 0.0;break;
		default: this.angle += 0;
		}
	}

	public void print() {
        System.out.println("ID: " + MyId);
        System.out.println("Speed: " + speed);
        System.out.println("方向 = "+ angle);
        System.out.println("所有者 = "+ owner);
    }

	public String toString(){
		String buf = "ID: " + MyId + "\n"
						+ "速度 " + speed + "\n"
						+ "方向 = "+ angle + "\n"
						+ "所有者 = " + owner ;
		return buf;
	}

	public static void main (String arg[])
	{
		Vehicle bmw320 = new Vehicle("Bob");
		System.out.println(bmw320.toString());

		Vehicle honda = new Vehicle("Mike");
		System.out.println(honda.toString());

		System.out.println("MaxId = " + Vehicle.GetMaxId());
	}
}
