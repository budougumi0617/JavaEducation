/*
 * @file
 * @par File Name:
 * Bubble.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/28
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex14_07;

public class Babble extends Thread {
	static boolean doYield;
	static int howOften;
	private String word;

	/*
	 * システム環境：Windows7 64bit 実行引数：false 3 Did Didnot test1 test2 test3
	 * 実行結果は常に異なる。実行のたびに生成したスレッドが 実行されるタイミングが異なる。
	 */

	Babble(String whatSay) {
		word = whatSay;
	}

	public void run() {
		for (int i = 0; i < howOften; i++) {
			System.out.println(word);
			if (doYield)
				Thread.yield();
		}
	}

	public static void main(String[] args) {
		doYield = new Boolean(args[0]).booleanValue();
		howOften = Integer.parseInt(args[1]);

		for (int i = 2; i < args.length; i++)
			new Babble(args[i]).start();

	}

}
