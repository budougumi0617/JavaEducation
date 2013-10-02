import java.awt.Point;

import junit.framework.TestCase;


public class AttrTest extends TestCase {

	public void testAttrString() {
		Attr<String> test = new Attr<String>("test");
		assertEquals(test.getName(), "test");

	}

	public void testAttrStringE() {
		Point testPoint = new Point(10, 20);
		Attr<Point> test = new Attr<Point>("test", testPoint);
		assertEquals(test.getValue(), testPoint);
	}

	public void testSetValue() {
		Attr<Point> test = new Attr<Point>("test", null);
		test.setValue(new Point());
		Point pointTest = test.getValue();
		pointTest.x = 10;
		assertEquals(test.getValue(), pointTest);
	}



}
