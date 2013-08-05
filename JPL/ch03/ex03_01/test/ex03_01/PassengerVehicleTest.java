/*
 * @file
 * @par File Name:
 * PassengerVehicleTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_01;

import junit.framework.TestCase;

public class PassengerVehicleTest extends TestCase {

	public void toStringTest() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		System.out.println(TestCar.toString());
	}

	public void passengerVehicleTest() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		assertEquals(TestCar.getOwner(), "TEST");
	}

	public void setSeatNumTest() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		TestCar.setSeatNum(0);
		assertEquals(TestCar.getSeatNum(), 0);
	}

	public void getSeatNumTest() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		TestCar.setSeatNum(4);
		assertEquals(TestCar.getSeatNum(), 4);

	}

	public void addSeatedNumTest() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		TestCar.addSeatedNum();
		TestCar.addSeatedNum();
		assertEquals(TestCar.getSeatedNum(), 2);
	}

	public void getSeatedNumTest() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		assertEquals(TestCar.getSeatedNum(), 0);
	}

}
