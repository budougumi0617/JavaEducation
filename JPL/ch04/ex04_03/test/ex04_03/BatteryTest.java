/*
 * @file
 * @par File Name:
 * BatteryTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/23
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex04_03;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yoichiro Shimizu
 *
 */
public class BatteryTest {

	Battery targetClass;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * {@link ex04_03.Battery#empty()} のためのテスト・メソッド。
	 */
	@Test
	public void testEmpty() {
		targetClass = new Battery(2.5);
		assertThat(targetClass.empty(), is(false));
	}

	/**
	 * {@link ex04_03.Battery#Battery(double)} のためのテスト・メソッド。
	 */
	@Test
	public void testBattery() {
		targetClass = new Battery(0);
		assertThat(targetClass.empty(), is(true));
	}

}
