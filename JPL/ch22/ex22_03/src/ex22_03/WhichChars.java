/*
 * @file
 * @par File Name:
 * WhichChars.java
 * @author budougumi0617
 * @date Created on 2014/03/25
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex22_03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author budougumi0617
 * @note 入力文字列中に出現した文字の上位バイト（上位8ビット）ごとにBitSetオブジェクトをHashMapに保存するようにしなさい。
 *       各BitSetオブジェクトは、特定の上位バイトを持っている文字の下位バイトを保存します。
 */
public class WhichChars {

	public static void main(String args[]) {
		WhichChars wc = new WhichChars("test string!!");
		System.out.println(wc.toString());
		wc = new WhichChars("日本語はダイジョウブ？");
		System.out.println(wc.toString());
		wc = new WhichChars("特殊記号はダイジョウブ？(☍﹏⁰)ヾ(❀╹◡╹)ﾉﾞ");
		System.out.println(wc.toString());
	}
	
	
	private Map<Byte, BitSet> usedMap = new HashMap<Byte, BitSet>();

	private static int SHIFT_NUM = Integer.SIZE - 8; // Unicode

	public WhichChars(String inputString) {
		for (int i = 0; i < inputString.length(); i++) {
			int c = inputString.charAt(i);

			byte upperByte = (byte) ((c >>> SHIFT_NUM) & 0xFF);
			int lowerByte = (int) (c & 0xFFFF);

			if (usedMap.containsKey(upperByte)) {
				BitSet used = usedMap.get(upperByte);
				used.set(lowerByte);
			} else {
				BitSet used = new BitSet();
				used.set(lowerByte);
				usedMap.put(upperByte, used);
			}
		}
	}

	public String toString() {

		StringBuilder desc = new StringBuilder();
		desc.append("[");

		for (Map.Entry<Byte, BitSet> entry : usedMap.entrySet()) {
			byte topByte = entry.getKey();
			BitSet used = entry.getValue();

			for (int lowBytes = used.nextSetBit(0); lowBytes >= 0; lowBytes = used
					.nextSetBit(lowBytes + 1)) {
				char ch;
				ch = (char) (topByte << SHIFT_NUM); 
				ch |= (char) lowBytes; 
				desc.append(ch);
			}
		}
		desc.append("]");
		return desc.toString();
	}
}