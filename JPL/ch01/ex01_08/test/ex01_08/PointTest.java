/*
 * @file
 * @par File Name:
 * PointTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex01_08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yoichiro Shimizu
 * 
 */
public class PointTest {
	Point targetClass;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		targetClass = new Point();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClearMethod() {
		targetClass.clear();
		assertThat(targetClass.x, is(0.));
		assertThat(targetClass.y, is(0.));
	}

	@Test
	public void testCopyMethod() {
		double resultX = 10.;
		double resultY = 20.;
		Point resultPoint = new Point();
		resultPoint.x = resultX;
		resultPoint.y = resultY;
		targetClass.copy(resultPoint);
		assertThat(targetClass.x, is(resultX));
		assertThat(targetClass.y, is(resultY));
	}
	@Test
	public void testMoveMethod() {
		double resultX = 10.;
		double resultY = 20.;
		targetClass.move(resultX, resultY);
		assertThat(targetClass.x, is(resultX));
		assertThat(targetClass.y, is(resultY));
	}

	@Test
	public void testMethod() {
		double resultX = 2.;
		double resultY = 5.;
		double result = Math.sqrt( resultX * resultX + resultY * resultY);
		Point resultPoint = new Point();
		targetClass.clear();
		resultPoint.x = resultX;
		resultPoint.y = resultY;
		assertThat(targetClass.distance(resultPoint), is(result));

	}

}
