/*
 * @file
 * @par File Name:
 * VehicleTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/09/08
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex06_02;

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
	 * {@link ex06_02.Vehicle#Vehicle()} のためのテスト・メソッド。
	 */
	@Test
	public void testVehicle() {
		targetClass = new Vehicle();
		assertThat(targetClass.getOwner(), is("<unnamed>"));
	}

	/**
	 * {@link ex06_02.Vehicle#Vehicle(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testVehicleString() {
		String result = "test";
		targetClass = new Vehicle(result);
		assertThat(targetClass.getOwner(), is(result));
	}

	/**
	 * {@link ex06_02.Vehicle#getSpeed()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetSpeed() {
		assertThat(targetClass.getSpeed(), is(0.));
		double result = 10.;
		targetClass.changeSpeed(result);
		assertThat(targetClass.getSpeed(), is(result));

	}

	/**
	 * {@link ex06_02.Vehicle#getAngle()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetAngle() {
		assertThat(targetClass.getAngle(), is(0.));
		targetClass.turn(Vehicle.Turn.TURN_LEFT);
		assertThat(targetClass.getAngle(), is(-90.));

	}

	/**
	 * {@link ex06_02.Vehicle#getMyId()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetMyId() {
		@SuppressWarnings("static-access")
		int result = targetClass.getMaxId() + 1;
		targetClass = new Vehicle();
		assertThat(targetClass.getMyId(), is(result));
	}

	/**
	 * {@link ex06_02.Vehicle#getOwner()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetOwner() {
		String result = "test";
		targetClass = new Vehicle(result);
		assertThat(targetClass.getOwner(), is(result));
	}

	/**
	 * {@link ex06_02.Vehicle#getMaxId()} のためのテスト・メソッド。
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testGetMaxId() {
		int result = targetClass.getMyId();
		assertThat(targetClass.getMaxId(), is(result));
	}

	/**
	 * {@link ex06_02.Vehicle#changeSpeed(double)} のためのテスト・メソッド。
	 */
	@Test
	public void testChangeSpeed() {
		assertThat(targetClass.getSpeed(), is(0.));
		double result = 33.3;
		targetClass.changeSpeed(result);
		assertThat(targetClass.getSpeed(), is(result));
	}

	/**
	 * {@link ex06_02.Vehicle#stop()} のためのテスト・メソッド。
	 */
	@Test
	public void testStop() {
		targetClass.changeSpeed(10.);
		targetClass.stop();
		assertThat(targetClass.getSpeed(), is(0.));
	}

	/**
	 * {@link ex06_02.Vehicle#turn(double)} のためのテスト・メソッド。
	 */
	@Test
	public void testTurnDouble() {
		double result = 55.5;
		targetClass.turn(result);
		assertThat(targetClass.getAngle(), is(result));
	}

	/**
	 * {@link ex06_02.Vehicle#turn(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testTurnInt() {
		targetClass.turn(Vehicle.Turn.TURN_RIGHT);
		assertThat(targetClass.getAngle(), is(90.));
	}

	/**
	 * {@link ex06_02.Vehicle#print()} のためのテスト・メソッド。
	 */
	@Test
	public void testPrint() {
		targetClass.print();
		System.out.flush();
		assertThat(resultOutStream.toString(),
				is("ID: " + targetClass.getMyId()
						+ "\r\nSpeed: 0.0\r\n方向 = 0.0\r\n所有者 = <unnamed>\r\n"));
	}

}
