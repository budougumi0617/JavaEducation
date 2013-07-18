/*
 * @file
 * @par File Name:
 * ImprovedFibonacci.java
 * @author Yoichiro Shimizu/R/RSI
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex01_13;

/**
 * @author Yoichiro Shimizu/R/RSI
 *
 */
public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;

	/**
	 * P20 練習問題 1.7
	 * ImprovedFibonacciをprintfで実装
	 */
	public static void main(String[] args)
	{
		int lowValue = 1;
		int highValue = 1;
		String mark = "";

		System.out.printf("%d: %d%n", 1, lowValue);
		for (int i = 2; i <= MAX_INDEX; i++) {
			if (highValue % 2 == 0)
				mark = "*";
			else
				mark = "";
			System.out.printf("%d: %d%s %n", i, highValue, mark);
			highValue = lowValue + highValue;
			lowValue = highValue - lowValue;
		}
	}
}
