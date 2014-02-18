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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
		st.eolIsSignificant(false);
		st.ordinaryChar('-');
		st.parseNumbers();
		st.whitespaceChars(' ', ' ');
		st.whitespaceChars(',', ',');
		List<String[]> vals = new ArrayList<String[]>();
		int tokenType;
		int count = 0;
		String[] cells = new String[CELLS];
		while ((tokenType = st.nextToken()) != StreamTokenizer.TT_EOF) {
			
			if (tokenType == StreamTokenizer.TT_NUMBER) {
				cells[count] = Double.toString(st.nval);
				count++;
			} else {
				throw new IOException("input format error : " + tokenType + " " + StreamTokenizer.TT_NUMBER);
			}
			
			if (count == CELLS) {
				count = 0;
				vals.add(cells);
				cells = new String[CELLS];
			}

		}

		return vals;
	}
	public static void main(String[] args) {
		String fileName = "test.csv";
		createFile(fileName);
		File file = new File(fileName);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e2) {
			// TODO 自動生成された catch ブロック
			e2.printStackTrace();
		}
		InputStreamReader isr = new InputStreamReader(fis);
		List<String[]> list = null;
		try {
			list = CSVEditClass.readCSVFile(isr);
		} catch (FileNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		for(String[] s : list){
			for(int i = 0; i < s.length; i++){
				System.out.print(s[i] + ", ");
			}
			System.out.println();
		}
	}
	public static void createFile(String fileName) {
		try {
			File file = new File(fileName);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
					file)));
			pw.println("10, 23,43, 20");
			pw.println("1, 2, 3, 4");
			pw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
