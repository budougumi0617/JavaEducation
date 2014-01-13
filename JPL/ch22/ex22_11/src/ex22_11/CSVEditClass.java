/**
 * @file
 * @par File Name:
 * readCSVTable.java
 * @author budougumi0617
 * @date Created on 2013/12/30
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex22_11;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * @author budougumi0617 Scannerではなく、
 *         StreamToknizerを利用したreadCSVFileを書きなさい。
 * 
 */
public class CSVEditClass {

	static final int CELLS = 4;

	public static List<String[]> readCSVFile(Readable source)
			throws IOException {
		InputStreamReader sr = (InputStreamReader) source;
		StreamTokenizer st = new StreamTokenizer(sr);
		st.eolIsSignificant(true);
		st.ordinaryChar('-');
		st.ordinaryChars('0', '9');
		st.whitespaceChars(' ', ' ');
		st.whitespaceChars(',', ',');
		List<String[]> vals = new ArrayList<String[]>();
		int tokenType;
		int count = 0;
		while ((tokenType = st.nextToken()) != StreamTokenizer.TT_EOF) {
			String[] cells = null;
			if (count == 0) {
				cells = new String[CELLS];
			}
			if (tokenType == StreamTokenizer.TT_NUMBER) {
				cells[count] = Double.toString(st.nval);
			} else {
				throw new IOException("input format error");
			}
			count++;
			if (count == CELLS) {
				count = 0;
			}

		}

		return vals;
	}
}
