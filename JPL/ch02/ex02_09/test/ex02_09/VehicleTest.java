package ex02_09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testVehicle() {
		Vehicle TestCar = new Vehicle();
		int resultValue = Vehicle.GetMaxId();
		assertThat(TestCar.MyId, is(resultValue));
	}

	@Test
	public void testVehicle_No2() {
		Vehicle TestCar = new Vehicle("TEST");
		assertThat(TestCar.owner, is("TEST"));
	}

	@Test
	public void getMaxIdTest() {

		int resultValue = Vehicle.GetMaxId() + 1;
		new Vehicle("TEST");
		assertThat(Vehicle.GetMaxId(), is(resultValue));
	}

	@Test
	public void showTest() {
		Vehicle TestCar = new Vehicle("TEST");
		TestCar.show("name");
	}
}
