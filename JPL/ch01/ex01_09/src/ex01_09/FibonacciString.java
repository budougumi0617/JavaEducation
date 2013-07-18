/*
 * @file
 * @par File Name:
 * FibonacciString.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex01_09;

/**
 * @author Yoichiro Shimizu
 *
 */
public class FibonacciString {
	static final String TITLE = "値が50未満のフィボナッチ数列を表示する";
	static final int BUF_MAX = 20; //配列要素数の最大値
	static final int thretholdValue = 50;

	/**
	 * P17 練習問題 1.9 数列を配列に保存するFibonacci
	 */
	public static void main(String[] args) {
			int lowValue = 1;
			int highValue = 1;
			int[] result = new int[BUF_MAX]; // int配列オブジェクト生成
			System.out.println(TITLE);
			result[0] = lowValue;

			for(int i = 1; highValue < thretholdValue; i++){ //highValueが50以下の間ループ
				result[i] = highValue;
				highValue = lowValue + highValue; //new hi
				lowValue  = highValue - lowValue;	/* new lo is (Sum - Old lo)
				 						That is Old hi*/
			}
			for(int j = 0; 0 != result[j]; j++){ //result配列の値が0出ない間ループ
				System.out.println(result[j]);
			}
	}

}
