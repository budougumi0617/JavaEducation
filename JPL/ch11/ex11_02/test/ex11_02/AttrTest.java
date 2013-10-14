/*
 * @file
 * @par File Name:
 * AttrTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/10/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex11_02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.awt.Point;

import junit.framework.TestCase;

import org.junit.Test;

public class AttrTest extends TestCase {

	@Test
	public void testAttrString() {
		Attr<String> test = new Attr<String>("test");
		assertThat(test.getName(), is("test"));

	}

	@Test
	public void testAttrStringE() {
		Point testPoint = new Point(10, 20);
		Attr<Point> test = new Attr<Point>("test", testPoint);
		assertThat(test.getValue(), is(testPoint));
	}

	@Test
	public void testSetValue() {
		Attr<Point> test = new Attr<Point>("test", null);
		test.setValue(new Point());
		Point pointTest = test.getValue();
		pointTest.x = 10;
		assertThat(test.getValue(), is(pointTest));
	}

}
