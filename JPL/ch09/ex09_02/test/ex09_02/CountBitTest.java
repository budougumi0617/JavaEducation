package ex09_02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountBitTest {

	CountBit targetClass;

	@Before
	public void setUp() throws Exception {
		targetClass = new CountBit();
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCheckBitCount() {
		assertThat(targetClass.CheckBitCount(12), is(2));
		assertThat(targetClass.CheckBitCount(24), is(2));
		assertThat(targetClass.CheckBitCount(27), is(4));

	}

}
