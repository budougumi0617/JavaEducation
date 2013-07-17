/*
 * @file
 * @par File Name:
 * ImprovedFibonacci.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex01_10;

/**
 * P17 練習問題 1.10
 * bool値を保持する配列
 */
public class NumBool
{
	public int x;
	public boolean even;

	/**
	 * P17 練習問題 1.10
	 * 結果を表示する
	 */
	public String print()
	{
		String result = Integer.toString(this.x); //文字列配列に数値をセット
		if (this.even == true) // 偶数だった場合はアスタリスクを文字列にセット
			result += " *";
		else
			result += "";
		return result; // 文字列を返す。
	}

	/**
	 * P17 練習問題 1.10
	 * 結果をセットする
	 */
	public void set(int hi)
	{
		this.x = hi; //もらった数値を配列にセット
		if (x % 2 == 0) //偶数だった場合は真をセット
			even = true;
		else
			even = false;
	}
}