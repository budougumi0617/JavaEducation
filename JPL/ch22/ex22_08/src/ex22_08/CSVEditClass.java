/**
 * @file
 * @par File Name:
 * readCSVTable.java
 * @author budougumi0617
 * @date Created on 2013/12/30
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex22_08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * @author budougumi0617
 * 現状では、readCSVFileは、それが期待する入力形式に関して、厳格すぎると同時に
 * 寛容すぎます。入力の終わりに空行があると、IOExceptionをスローしますので、厳格すぎます。
 * ４つ以上のカンマを持つ行でも例外が発生しませんので、寛容すぎます。この両方の問題を修正しなさい。
 * 
 */
public class CSVEditClass {

	static final int CELLS = 4;

	public static List<String[]> readCSVFile(Readable source)
			throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = "^(.*),(.*),(.*),(.*)";
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[CELLS];
				MatchResult match = in.match();
				for (int i = 0; i < CELLS; i++) {
					cells[i] = match.group(i + 1);
				}
				vals.add(cells);
				in.nextLine();
			} else {
				throw new IOException("input format error");
			}
		}
		IOException ex = in.ioException();
		if (ex != null) {
			throw ex;
		}
		return vals;
	}
}
