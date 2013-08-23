/*
 * @file
 * @par File Name:
 * TypeTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/23
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex07_02;

public class TypeTest {
	public static void main(String[] args) {
		int testInt = 0;
		byte testbyte = 20;
		byte testshort = 20;

		System.out.println(testInt=(int)3.14);
		System.out.println(testInt=(int)3.14f);
		System.out.println(testInt=(int)1000000000000000L);
		System.out.println(testInt=(int)testshort);
		System.out.println(testInt=(int)testbyte);
	}
}
