import java.util.*;

public class Garage implements Cloneable{
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	public Garage(){}
	public void addVehicle(Vehicle Obj)
	{
		vehicleList.add(Obj); 
	}
	public ArrayList<Vehicle> getGarage()
	{
		return vehicleList;
	}
	public void print(Garage garage){
		Iterator<Vehicle> it = garage.getGarage().iterator();
		while(it.hasNext()){
			Vehicle vh = it.next();
			System.out.println(vh);
		}		
	}
	
	@SuppressWarnings("unchecked")
	public Garage clone() {
		try{
			Garage obj = (Garage)super.clone();
			obj.vehicleList = (ArrayList<Vehicle>) vehicleList.clone();
			return obj;
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}
	public static void main(String args[]){
		Garage myGarage = new Garage();
		myGarage.addVehicle(new Vehicle("Mike"));
		myGarage.addVehicle(new Vehicle("Bob"));
		Garage cloneGarage = myGarage.clone();
		cloneGarage.addVehicle(new Vehicle("Suzuki"));
		myGarage.print(myGarage);
		System.out.println("Clone Garage");
		myGarage.print(cloneGarage);
	}
}