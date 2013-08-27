/*
 * @file
 * @par File Name:
 * LinkedListTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/27
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


package ex11_01;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void LinkedListTest() {
		LinkedList<String> testString = new LinkedList<String>();
		LinkedList<String> testStringNext = new LinkedList<String>();
		testString.next = testStringNext;
		testString.data = "first";
		testStringNext.data = "second";
		assertThat(testString.next.data, is("second"));
	}

	@Test
	public void testLinkedListInt() {
		LinkedList<Integer> testString = new LinkedList<Integer>();
		LinkedList<Integer> testStringNext = new LinkedList<Integer>();
		testString.next = testStringNext;
		testString.data = 1;
		testStringNext.data = 2;
		assertThat(testString.next.data, is((Integer) 2));
	}

}
