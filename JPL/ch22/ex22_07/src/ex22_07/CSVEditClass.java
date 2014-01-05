/**
 * @file
 * @par File Name:
 * readCSVTable.java
 * @author budougumi0617
 * @date Created on 2013/12/30
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex22_07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * @author budougumi0617
 * 期待されるデータのセル数を引数として渡せるようにreadCSVFileを書き直しなさい。
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
