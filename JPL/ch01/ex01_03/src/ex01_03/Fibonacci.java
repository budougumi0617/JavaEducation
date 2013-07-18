/*
 * @file
 * @par File Name:
 * Fibonacci.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/16
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex01_03;

/**
 * @author Yoichiro Shimizu
 *
 */
public class Fibonacci {
	static final int thresholdValue = 50;
	static final String descriptionString = "値が50未満のフィボナッチ数列を表示する";
	static final int startValue = 1;

	/** 値が50未満のフィボナッチ数列を表示する */
	public static void main(String[] args) {
		int lowValue = startValue;
		int highValue = startValue;
		System.out.println(descriptionString);
		System.out.println(lowValue);
		while (highValue < thresholdValue) {
			System.out.println(highValue);
			highValue = lowValue + highValue; // new hi
			lowValue = highValue - lowValue; /*
												* new lo is (Sum - Old lo) That is
												* Old hi
												*/
		}
	}

}
