/**
 * @file
 * @par File Name:
 * WhichChasrs.java
 * @author budougumi0617
 * @date Created on 2013/12/30
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex22_02;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author budougumi0617 WhichCharsクラスは、
 *         Unicode範囲の上位の文字を記録するのに問題を抱えています。
 *         それは、上位の文字は
 *         、下位の範囲に関して多くの使用されないビットを残してしまうことです。
 *         出現した文字ごとにCharacterオブジェクトをHashSetに保存することで
 *         、この問題を解決しなさい。
 */
public class WhichChars {
	private HashSet<Character> used = new HashSet<Character>();

	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			used.add(str.charAt(i));
		}
	}

	public String toString() {
		String desc = "[";
		Iterator<Character> it = used.iterator();
		while (it.hasNext()) {
			desc += it.next();
		}
		/*
		 * for (int i = used.(0);i >= 0;i =
		 * used.nextSetBit(i+1)){ desc += (char)i;
		 * }
		 */
		return desc + "]";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WhichChars wc = new WhichChars("Hello World!! today is 2/18.");
		System.out.println(wc.toString());
	}

}
