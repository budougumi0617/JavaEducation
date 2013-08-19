/*
 * @file
 * @par File Name:
 * SignalTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/19
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex06_05;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yoichiro Shimizu
 * 
 */
public class SignalTest {

	public Signal targetClass;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void signalGreenTest() {
		targetClass = Signal.GREEN;
		assertThat("GREEN", is(targetClass.getColor()));
	}

	@Test
	public void signalYELLOWTest() {
		targetClass = Signal.YELOW;
		assertThat("YELOW", is(targetClass.getColor()));
	}

	@Test
	public void signalRED() {
		targetClass = Signal.RED;
		assertThat("RED", is(targetClass.getColor()));
	}

}
