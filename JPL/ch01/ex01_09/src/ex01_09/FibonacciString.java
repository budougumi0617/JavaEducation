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

	/**
	 * P17 練習問題 1.9 数列を配列に保存するFibonacci
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
			int lo = 1;
			int hi = 1;
			int[] result = new int[BUF_MAX]; // int配列オブジェクト生成
			System.out.println(TITLE);
			result[0] = lo;

			for(int i = 1; hi < 50; i++){ //hiが50以下の間ループ
				result[i] = hi;
				hi = lo + hi; //new hi
				lo  = hi - lo;	/* new lo is (Sum - Old lo)
				 						That is Old hi*/
			}
			for(int j = 0; 0 != result[j]; j++){ //result配列の値が0出ない間ループ
				System.out.println(result[j]);
			}
	}

}
