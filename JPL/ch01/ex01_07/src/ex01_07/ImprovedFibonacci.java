/*
 * @file
 * @par File Name:
 * ImprovedFibonacci.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex01_07;

/**
 * @author Yoichiro Shimizu
 *
 */
public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	/**
	 * P8 練習問題 1.7 iが逆順に値が減るImprovedFibonacci
	 * 偶数要素に' * 'を付けて、フィボナッチ数列の
	 * 最初のほうの要素を表示する
	 */
	public static void main(String[] args) {
		int lowValue = 1;
		int highValue = 1;
		String mark;

		System.out.println(MAX_INDEX + ": " + lowValue);
		for (int i = MAX_INDEX - 1; i > 0; i--) {
			if (highValue % 2 == 0) {
				mark = "*";
			} else {
				mark = "";
			}
			System.out.println(i + ": " + highValue + mark);
			highValue = lowValue + highValue;
			lowValue = highValue - lowValue;
		}
	}
}
