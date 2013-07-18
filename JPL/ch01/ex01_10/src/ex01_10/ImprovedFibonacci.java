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
 * @author Yoichiro Shimizu
 *
 */
public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;

	/**
	 * P17 練習問題 1.10
	 * bool値を保持する配列を用いてImprovedFibonacciを改良する
	 */
	public static void main(String[] args)
	{
		int lowValue = 1;
		int highValue = 1;
		NumBool[] arrayNumeBool = new NumBool[MAX_INDEX];
		for (int i = 0; i < MAX_INDEX; i++)
			arrayNumeBool[i] = new NumBool();
		arrayNumeBool[0].set(lowValue);
		for (int i = 2; i <= MAX_INDEX; i++) {
			arrayNumeBool[i - 1].set(highValue);
			highValue = lowValue + highValue;
			lowValue = highValue - lowValue;
		}
		for (int j = 0; j < MAX_INDEX; j++)
		{
			System.out.println(j + 1 + ":" + arrayNumeBool[j].print()); //jは1から
		}
	}

}
