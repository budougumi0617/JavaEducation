/*
 * @file
 * @par File Name:
 * VehicleTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/23
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex02_04;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yoichiro Shimizu
 *
 */
public class VehicleTest {

	Vehicle targetClass;
	
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

	@Test
	public void test() {
		targetClass.speed = 10;
		targetClass.angle = 20;
		targetClass.owner = "test";
		targetClass.MyId = 1;
		
		assertThat(targetClass.speed, is(10.));
		assertThat(targetClass.angle, is(20.));
		assertThat(targetClass.owner, is("test"));
		assertThat(targetClass.MyId, is(1));
		
	}

}
