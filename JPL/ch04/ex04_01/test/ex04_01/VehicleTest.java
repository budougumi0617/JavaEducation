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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yoichiro Shimizu
 * 
 */
public class VehicleTest {
	public Vehicle targetClass;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		targetClass = new Vehicle();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * {@link ex04_01.Vehicle#Vehicle()} のためのテスト・メソッド。
	 */
	@Test
	public void testVehicle() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#Vehicle(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testVehicleString() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#Vehicle(ex04_01.EnergySource)} のためのテスト・メソッド。
	 */
	@Test
	public void testVehicleEnergySource() {
		fail("まだ実装されていません");
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
	}

	/**
	 * {@link ex04_01.Vehicle#getSpeed()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetSpeed() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#getAngle()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetAngle() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#getMyId()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetMyId() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#getOwner()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetOwner() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#getMaxId()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetMaxId() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#changeSpeed(double)} のためのテスト・メソッド。
	 */
	@Test
	public void testChangeSpeed() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#stop()} のためのテスト・メソッド。
	 */
	@Test
	public void testStop() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#turn(double)} のためのテスト・メソッド。
	 */
	@Test
	public void testTurnDouble() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#turn(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testTurnInt() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#print()} のためのテスト・メソッド。
	 */
	@Test
	public void testPrint() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#toString()} のためのテスト・メソッド。
	 */
	@Test
	public void testToString() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#start()} のためのテスト・メソッド。
	 */
	@Test
	public void testStart() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#main(java.lang.String[])} のためのテスト・メソッド。
	 */
	@Test
	public void testMain() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link ex04_01.Vehicle#updateOriginId()} のためのテスト・メソッド。
	 */
	@Test
	public void testUpdateOrginId() {

	}
}
