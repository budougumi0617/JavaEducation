/*
 * @file
 * @par File Name:
 * ImprovedFibonacci.java
 * @author Yoichiro Shimizu/R/RSI
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex01_12;

/**
 * @author Yoichiro Shimizu/R/RSI
 *
 */
public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;

	/**
	 * P19 練習問題 1.12
	 * ImprovedFibonacciを配列を用いてprintlnするように改良
	 */
	public static void main(String[] args)
	{
		int loｗValue = 1;
		int highValue = 1;
		String result = "1: " + loｗValue;

		System.out.println(result);
		for (int count = 2; count <= MAX_INDEX; count++) {
			result = count + ": " + highValue;
			if (highValue % 2 == 0)
				result += "*";
			else
				result += "";
			System.out.println(result);
			highValue = loｗValue + highValue;
			loｗValue = highValue - loｗValue;
		}
	}
}
