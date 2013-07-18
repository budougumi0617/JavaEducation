/*
 * @file
 * @par File Name:
 * FibonacciNamedConstant.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex01_06;

/**
 * @author Yoichiro Shimizu
 *
 */
public class FibonacciNamedConstant {

	static final int thretholdValue = 50;
	static final String TITLE = "値が" + thretholdValue + "未満のフィボナッチ数列を表示する";

	/** 値がthretholdValue未満のフィボナッチ数列を表示する */
	public static void main(String[] args) {
		int lowValue = 1;
		int highValue = 1;
		System.out.println(TITLE);
		System.out.println(lowValue);
		while (highValue < thretholdValue) {
			System.out.println(highValue);
			highValue = lowValue + highValue; //new hi
			lowValue = highValue - lowValue; /* new lo is (Sum - Old lo)
												That is Old hi*/
		}
	}

}
