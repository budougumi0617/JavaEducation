/*
 * @file
 * @par File Name:
 * Garage.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_09;

import java.util.ArrayList;
import java.util.Iterator;

public class Garage implements Cloneable {
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

	public Garage() {
	}

	public void addVehicle(Vehicle Obj) {
		vehicleList.add(Obj);
	}

	public ArrayList<Vehicle> getGarage() {
		return vehicleList;
	}

	public void print(Garage garage) {
		Iterator<Vehicle> itrator = garage.getGarage().iterator();
		while (itrator.hasNext()) {
			Vehicle vh = itrator.next();
			System.out.println(vh);
		}
	}

	@SuppressWarnings("unchecked")
	public Garage clone() {
		try {
			Garage obj = (Garage) super.clone();
			obj.vehicleList = (ArrayList<Vehicle>) vehicleList.clone();
			return obj;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	public static void main(String args[]) {
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