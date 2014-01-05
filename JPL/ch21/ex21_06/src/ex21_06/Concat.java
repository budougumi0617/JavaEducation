/**
 * @file
 * @par File Name:
 * Concat.java
 * @author budougumi0617
 * @date Created on 2014/01/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex21_06;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * @author budougumi0617 
 * 
 * P463のプログラムConcatを書きなおして、１度に１つのFileInputStreamオブジェクトだけを
 * オープンするEnumerationの実装を使用するようにしなさい。
 */
public class Concat {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		InputStream in; // 文字を読むこむべきストリーム
		if (args.length == 0) {
			in = System.in;
		} else {
			InputStream fileIn, bufIn;
			List<InputStream> inputs = new ArrayList<InputStream>(args.length);
			for (String arg : args) {
				fileIn = new FileInputStream(arg);
				bufIn = new BufferedInputStream(fileIn);
				inputs.add(bufIn);
			}
			Enumeration<InputStream> files = Collections.enumeration(inputs);
			in = new SequenceInputStream(files);
		}
		int ch;
		while ((ch = in.read()) != -1) {
			System.out.write(ch);
		}

	}

}
