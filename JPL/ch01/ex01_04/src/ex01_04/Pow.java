/*
 * @file
 * @par File Name:
 * Por.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex01_04;

/**
 * @author Yoichiro Shimizu
 *
 */
public class Pow
{
	static final int thresholdValue = 500;

	/** 等比数列を表示する */
	public static void main(String[] args)
	{
		int baseValue = 2;
		int ratio = 3;
		System.out.println(baseValue + "から開始される比" + ratio + "の等比数列");
		while (baseValue < thresholdValue) {
			System.out.println(baseValue);
			baseValue = baseValue * ratio;
		}
	}

}
