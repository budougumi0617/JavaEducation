/*
 * @file
 * @par File Name:
 * VehicleTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/09/08
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex04_01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yoichiro Shimizu
 * 
 */
public class VehicleTest {
	public Vehicle targetClass;
	private PrintStream defaultOutStream;
	private ByteArrayOutputStream resultOutStream;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		targetClass = new Vehicle();
		defaultOutStream = System.out;
		resultOutStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(new BufferedOutputStream(resultOutStream)));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.setOut(defaultOutStream);
	}

	private String joinStrings(String... strs) {
		String newLine = System.getProperty("line.separator");
		String result = "";
		for (String s : strs) {
			result += s + newLine;
		}
		return result;
	}

	/**
	 * {@link ex04_01.Vehicle#Vehicle()} のためのテスト・メソッド。
	 */
	@Test
	public void testVehicle() {
		targetClass = new Vehicle();
		assertThat(targetClass.getOwner(), is("<unnamed>"));
	}

	/**
	 * {@link ex04_01.Vehicle#Vehicle(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testVehicleString() {
		String result = "test";
		targetClass = new Vehicle(result);
		assertThat(targetClass.getOwner(), is(result));
	}

	/**
	 * {@link ex04_01.Vehicle#Vehicle(ex04_01.EnergySource)} のためのテスト・メソッド。
	 */
	@Test
	public void testVehicleEnergySource() {
		EnergySource es = new GasTank(30.);
		targetClass = new Vehicle(es);
		assertThat(targetClass.getEnergySource(), is(es));
	}

	/**
	 * {@link ex04_01.Vehicle#Vehicle(java.lang.String, ex04_01.EnergySource)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testVehicleStringEnergySource() {
		EnergySource es = new GasTank(10);
		String ownerName = "foo";
		targetClass = new Vehicle(ownerName, es);
		assertThat(targetClass.getOwner(), is(ownerName));
		assertThat(targetClass.getEnergySource(), is(es));
	}

	/**
	 * {@link ex04_01.Vehicle#getSpeed()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetSpeed() {
		assertThat(targetClass.getSpeed(), is(0.));
		double result = 10.;
		targetClass.changeSpeed(result);
		assertThat(targetClass.getSpeed(), is(result));

	}

	/**
	 * {@link ex04_01.Vehicle#getAngle()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetAngle() {
		assertThat(targetClass.getAngle(), is(0.));
		targetClass.turn(Vehicle.TURN_LEFT);
		assertThat(targetClass.getAngle(), is(-90.));

	}

	/**
	 * {@link ex04_01.Vehicle#getMyId()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetMyId() {
		@SuppressWarnings("static-access")
		int result = targetClass.getMaxId() + 1;
		targetClass = new Vehicle();
		assertThat(targetClass.getMyId(), is(result));
	}

	/**
	 * {@link ex04_01.Vehicle#getOwner()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetOwner() {
		String result = "test";
		targetClass = new Vehicle(result);
		assertThat(targetClass.getOwner(), is(result));
	}

	/**
	 * {@link ex04_01.Vehicle#getMaxId()} のためのテスト・メソッド。
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testGetMaxId() {
		int result = targetClass.getMyId();
		assertThat(targetClass.getMaxId(), is(result));
	}

	/**
	 * {@link ex04_01.Vehicle#changeSpeed(double)} のためのテスト・メソッド。
	 */
	@Test
	public void testChangeSpeed() {
		assertThat(targetClass.getSpeed(), is(0.));
		double result = 33.3;
		targetClass.changeSpeed(result);
		assertThat(targetClass.getSpeed(), is(result));
	}

	/**
	 * {@link ex04_01.Vehicle#stop()} のためのテスト・メソッド。
	 */
	@Test
	public void testStop() {
		targetClass.changeSpeed(10.);
		targetClass.stop();
		assertThat(targetClass.getSpeed(), is(0.));
	}

	/**
	 * {@link ex04_01.Vehicle#turn(double)} のためのテスト・メソッド。
	 */
	@Test
	public void testTurnDouble() {
		double result = 55.5;
		targetClass.turn(result);
		assertThat(targetClass.getAngle(), is(result));
	}

	/**
	 * {@link ex04_01.Vehicle#turn(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testTurnInt() {
		targetClass.turn(Vehicle.TURN_RIGHT);
		assertThat(targetClass.getAngle(), is(90.));
	}

	/**
	 * {@link ex04_01.Vehicle#print()} のためのテスト・メソッド。
	 */
	@Test
	public void testPrint() {
		targetClass.print();
		System.out.flush();
		assertThat(resultOutStream.toString(),
				is("ID: " + targetClass.getMyId()
						+ "\r\nSpeed: 0.0\r\n方向 = 0.0\r\n所有者 = <unnamed>\r\n"));
	}

	/**
	 * {@link ex04_01.Vehicle#start()} のためのテスト・メソッド。
	 */
	@Test
	public void testStart() {
		targetClass = new Vehicle(new GasTank(0.));
		targetClass.start();
		System.out.flush();
		String result = "You Can't Start";
		result = joinStrings(result);
		assertThat(resultOutStream.toString(), is(result));
		result = joinStrings("You Can Start");
		targetClass = new Vehicle(new GasTank(10.));
		resultOutStream.reset();
		targetClass.start();
		System.out.flush();
		assertThat(resultOutStream.toString(), is(result));
	}

	/**
	 * {@link ex04_01.Vehicle#updateOriginId()} のためのテスト・メソッド。
	 */
	@Test
	public void testUpdateOrginId() {

	}
}
