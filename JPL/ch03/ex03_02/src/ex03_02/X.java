/*
 * @file
 * @par File Name:
 * X.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_02;

public abstract class X {
	{
		PrintStep();
	}

	protected int xMask = 0x00ff;
	{
		PrintStep();
	}
	protected int fullMask;
	private static int step = 0;

	public X() {
		PrintStep();
		fullMask = xMask;
		PrintStep();
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}

	public void PlusStep() {
		step++;
	}

	public int GetStep() {
		return step;
	}

	public int GetfullMask() {
		return fullMask;
	}

	public int GetxMask() {
		return xMask;
	}

	abstract void PrintStep();

}
