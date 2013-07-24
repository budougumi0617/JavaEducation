package ex02_08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedTest {

	@Test
	public void LinkedListTest() {
		Vehicle car = new Vehicle("Satoh");
		LinkedList TestNo0 = new LinkedList(car, null);
		LinkedList TestNo1 = new LinkedList(car, TestNo0);
		assertThat(TestNo1.next, is(TestNo0));
		assertThat(TestNo1.data instanceof Vehicle, is(true));
}

}
