public class PassengerVehicle extends Vehicle{
	private int SeatNum;
	private int SeatedNum;

	public PassengerVehicle(String Owner){
		super(Owner);
		this.SeatNum = 1; //Car must have a seat,
		this.SeatedNum = 0;
	}

	public void SetSeatNum(int n){
		this.SeatNum = n;
	}
	public int GetSeatNum(){
		return this.SeatNum;
	}
	public void AddSeatedNum(){
		this.SeatedNum = this.SeatedNum + 1;
	}

	public int GetSeatedNum(){
		return this.SeatedNum;
	}

	public String toString(){
		return super.toString()
				+ " 座席数" + SeatNum
				+ " 座っている人数" + SeatedNum;
	}

	public static void main(String args[]){
		PassengerVehicle Bmw = new PassengerVehicle("Mike");
		PassengerVehicle Matsuda = new PassengerVehicle("Bob");
		PassengerVehicle Toyota = new PassengerVehicle("Jerry");

		System.out.println(Bmw.toString());
		Matsuda.AddSeatedNum();
		Matsuda.SetSeatNum(4);
		System.out.println(Matsuda.toString());
		System.out.println(Toyota.toString());
	}

}
