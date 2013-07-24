package ex02_10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VhicleTest {

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
	public void testSpeed() {
		Vehicle TestCar = new Vehicle("TEST");
		assertThat(TestCar.speed, is(0.0));
		TestCar.speed = 10.0;
		assertThat(TestCar.speed, is(10.0));
	}

	@Test
	public void testAngle() {
		Vehicle TestCar = new Vehicle("TEST");
		assertThat(TestCar.angle, is(0.0));
		TestCar.angle = 5.0;
		assertThat(TestCar.angle, is(5.0));
	}

	@Test
	public void testGetMyId() {

		Vehicle TestCar_4 = new Vehicle("TEST_4");
		int resultValue = Vehicle.GetMaxId();
		assertThat(TestCar_4.MyId, is(resultValue));

		Vehicle TestCar_5 = new Vehicle("TEST_5");
		resultValue = Vehicle.GetMaxId();
		assertThat(TestCar_5.MyId, is(resultValue));
	}

	@Test
	public void getMaxIdTest() {
		Vehicle TestCar = new Vehicle("TEST");
		int resultValue = Vehicle.GetMaxId();
		assertThat(Vehicle.GetMaxId(), is(resultValue));
	}

	@Test
	public void testToString() {
		Vehicle TestCar = new Vehicle("TEST");
		assertThat(TestCar.toString(), is(anything()));
	}
}
