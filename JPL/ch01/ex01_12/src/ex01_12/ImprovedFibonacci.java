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
		// TODO 自動生成されたメソッド・スタブ
		int lo = 1;
		int hi = 1;
		String result = "1: " + lo;

		System.out.println(result);
		for (int i = 2; i <= MAX_INDEX; i++) {
			result = i + ": " + hi;
			if (hi % 2 == 0)
				result += "*";
			else
				result += "";
			System.out.println(result);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
