package ex12_01;
/*
 * @file
 * @par File Name:
 * Vehicle.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/10/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


public class Vehicle implements Cloneable{
	private double speed;
	private double angle;
	private String owner = "<unnamed>";

	private int MyId;//変更を許さないべき
	private static int NextId = 0;
	public static final int TURN_LEFT = -1;
	public static final int TURN_RIGHT= 1;


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

	public void SetOwner(String owner)
	{
		this.owner = owner;
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

	public void turn (int Lr)
	{
		if (Lr == Vehicle.TURN_LEFT)
			this.angle -= 45.0;
		else if (Lr ==  Vehicle.TURN_RIGHT)
			this.angle += 45.0;
		else{
			;
		}

	}

	public void print()
	{
        System.out.println("ID: " + MyId);
        System.out.println("Speed: " + speed);
        System.out.println("方向 = "+ angle);
        System.out.println("所有者 = "+ owner);
    }

	public String toString()
	{
		String buf = "ID: " + MyId + "\n"
						+ "速度 " + speed + "\n"
						+ "方向 = "+ angle + "\n"
						+ "所有者 = " + owner ;
		return buf;
	}


	public Vehicle clone() throws CloneNotSupportedException {
		try{
			Vehicle obj = (Vehicle)super.clone();
			obj.MyId = NextId++;
			return obj;
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}
}
