import junit.framework.TestCase;


public class TestPassengerVehicle extends TestCase {

	public void testToString() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		System.out.println(TestCar.toString());
	}

	public void testPassengerVehicle() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		assertEquals(TestCar.GetOwner(), "TEST");
	}

	public void testSetSeatNum() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		TestCar.SetSeatNum(0);
		assertEquals(TestCar.GetSeatNum(), 0);
	}

	public void testGetSeatNum() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		TestCar.SetSeatNum(4);
		assertEquals(TestCar.GetSeatNum(), 4);

	}

	public void testAddSeatedNum() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		TestCar.AddSeatedNum();
		TestCar.AddSeatedNum();
		assertEquals(TestCar.GetSeatedNum(), 2);
	}

	public void testGetSeatedNum() {
		PassengerVehicle TestCar = new PassengerVehicle("TEST");
		assertEquals(TestCar.GetSeatedNum(), 0);
	}

}
