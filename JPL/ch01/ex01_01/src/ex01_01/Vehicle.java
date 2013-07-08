package ex01_01;

public class Vehicle {
	public double speed;				//速度
	public double angle;				//方向
	public String owner;				//所有
	public long VehicleID;				//車単位のID
	public static long NextVehicleID=0;	//次の乗り物の識別番号

	public void print(){
		System.out.println("ID : " + VehicleID);
		System.out.println("速度 : " + speed);
		System.out.println("方向 : " + angle);
		System.out.println("所有者 : " + owner);
	}

	public static void main(String args[]){
		Vehicle car1 = new Vehicle();
		car1.speed = 60.0;
		car1.angle = Math.PI * 1/6;
		car1.owner = "Taro";
		car1.VehicleID=Vehicle.NextVehicleID;
		Vehicle.NextVehicleID++;

		Vehicle car2 = new Vehicle();
		car2.speed = 60.0;
		car2.angle = Math.PI * 1/3;
		car2.owner = "Hanako";
		car2.VehicleID=Vehicle.NextVehicleID;
		Vehicle.NextVehicleID++;

		car1.print();
		car2.print();





	}
}