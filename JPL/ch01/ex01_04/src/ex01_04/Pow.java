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

	/** 等比数列を表示する */
	public static void main(String[] args)
	{
			int base = 2;
			int ratio = 3;
			System.out.println( base + "から開始される比" + ratio + "の等比数列");
			while (base < 500){
				System.out.println(base);
				base = base* ratio;
			}
	}

}
