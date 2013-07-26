package ex02_11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void LinkedListConstTest() {
		Vehicle car = new Vehicle("Satoh");
		LinkedList TestNo0 = new LinkedList(car, null);
		LinkedList TestNo1 = new LinkedList(car, TestNo0);
		assertThat(TestNo1.next, is(TestNo0));
	}

	@Test
	public void getObjectTest() {
		Vehicle car = new Vehicle("Satoh");
		LinkedList TestNo1 = new LinkedList(car, null);
		assertTrue(TestNo1.data instanceof Vehicle);
	}

	@Test
	public void getLinkedListTest() {
		Vehicle car = new Vehicle("Satoh");
		LinkedList TestNo0 = new LinkedList(car, null);
		LinkedList TestNo1 = new LinkedList(car, TestNo0);
		assertThat(TestNo1.next, is(TestNo0));
	}

	@Test
	public void showTest() {
		Vehicle car = new Vehicle("Satoh");
		LinkedList TestNo0 = new LinkedList(car, null);
		TestNo0.show();
	}

	@Test
	public void toStringTest() {
		Vehicle car = new Vehicle("Satoh");
		LinkedList TestNo0 = new LinkedList(car, null);
		TestNo0.toString();
	}

}
