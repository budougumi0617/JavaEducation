/*
 * @file
 * @par File Name:
 * IgnoreComment.java
 * @author budougumi0617
 * @date Created on 2014/03/25
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex22_10;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author budougumi0617
 * @note スキャナーのデリミタの一部としてコメントパターンを使用して、コメントを無視して入力を トークンに分解するメソッドを書きなさい。
 */
public class IgnoreComment {

	public static void main(String args[]) {
		StringReader targetString = new StringReader("Test String\n"
				 + "#This line is comment line.\n"
				+ "After block is comment. #comment line\n"
				+ "#Test Strings\n");
		List<String> resultStrings =  readTokens(targetString);
		for (String string : resultStrings) {
			System.out.println(string);
		}

	}

	public static List<String> readTokens(Readable source) {

		Scanner in = new Scanner(source);

		List<String> tokens = new ArrayList<String>();

		Pattern COMMENT = Pattern.compile("#.*", Pattern.MULTILINE);

		String comment = null;

		while (in.hasNext()) {
			if (in.hasNext(COMMENT)) {
				comment = in.findWithinHorizon(COMMENT, 0);
				in.nextLine();
			} else {
				tokens.add(in.next());
			}
		}
		return tokens;
	}
}