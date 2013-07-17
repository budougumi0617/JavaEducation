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
		// TODO 自動生成されたメソッド・スタブ
		int lo = 1;
		int hi = 1;
		String mark;

		System.out.printf("%d: %d%n", 1, lo);
		for (int i = 2; i <= MAX_INDEX; i++) {
			if (hi % 2 == 0)
				mark = "*";
			else
				mark = "";
			System.out.printf("%d: %d%s %n", i, hi, mark);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
