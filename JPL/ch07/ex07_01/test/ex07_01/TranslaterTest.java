package ex07_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TranslaterTest {

	Translater targetClass;

	public TranslaterTest() {
		targetClass = new Translater();
	}

	@Test
	public void testGetUnicode() {
		try {
			System.out.println(targetClass.getUnicode());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
