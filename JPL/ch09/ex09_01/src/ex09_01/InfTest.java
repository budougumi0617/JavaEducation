/*
 * @file
 * @par File Name:
 * InfTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/26
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex09_01;

public class InfTest {
	public static void main(String[] args) {
		Double pi = Double.POSITIVE_INFINITY;
		Double ni = Double.NEGATIVE_INFINITY;

		System.out.println("∞ + ∞  = " + (pi + pi));
		System.out.println("∞ + -∞ = " + (pi + ni));
		System.out.println("∞ - ∞  = " + (pi - pi));
		System.out.println("∞ - -∞ = " + (pi - ni));
		System.out.println("∞ * ∞  = " + (pi * pi));
		System.out.println("∞ * -∞ = " + (pi * ni));
		System.out.println("∞ / ∞  = " + (pi / pi));
		System.out.println("∞ / -∞ = " + (pi / ni));
	}
}