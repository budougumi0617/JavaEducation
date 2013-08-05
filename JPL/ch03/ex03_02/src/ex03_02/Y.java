/*
 * @file
 * @par File Name:
 * Y.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_02;

public class Y extends X {
	protected int yMask = 0xff00;

	public Y() {
		PrintStep();
		fullMask |= yMask;
		PrintStep();
	}

	public void PrintStep() {
		System.out.printf("%-2d 0x%04x 0x%04x 0x%04x\n", super.GetStep(),
				super.GetxMask(), yMask, super.GetfullMask());
		PlusStep();
	}

	public static void main(String[] args) {
		System.out.printf("%2s : %-6s %-6s %-6s\n", "Step", "xMask", "yMask",
				"fullMask");
		@SuppressWarnings("unused")
		Y y = new Y();
	}
}
