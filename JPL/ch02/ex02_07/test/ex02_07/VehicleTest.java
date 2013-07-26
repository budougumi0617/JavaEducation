package ex02_07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void VehicleConstTest() {
		Vehicle TestCar = new Vehicle();
		assertThat(TestCar.MyId, is(0));
	}

	@Test
	public void StringTest() {
		Vehicle TestCar = new Vehicle("TEST");
		assertThat(TestCar.owner, is("TEST"));
	}
}
