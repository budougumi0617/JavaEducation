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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author budougumi0617
 * @note 現状では、readCSVFileは、それが期待する入力形式に関して、厳格すぎると同時に
 * 寛容すぎます。入力の終わりに空行があると、IOExceptionをスローしますので、厳格すぎます。
 * ４つ以上のカンマを持つ行でも例外が発生しませんので、寛容すぎます。この両方の問題を修正しなさい。
 * 
 */
public class CSVEditClass {

	static int CELLS = 4;

	public static List<String[]> readCSVFile(Readable source, int numberOfCells)
			throws IOException {
		CELLS = numberOfCells;
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = "^(.*)";
		 for(int i = 1; i<numberOfCells; i++){
			exp += ",(.*)";
		 }
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		Pattern verify = Pattern.compile(",");
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line == null){
				
				break;
			}
			Matcher m = verify.matcher(line);
			int count = 0;
			int s =0;
			while (m.find(s)) {
		        count++;
		        s = m.end();
		    }
			if (count != CELLS -1){
				throw new IOException("input format error : " + line);
			}
			String[] cells = null;
			if (line != null) {
				cells = new String[CELLS];
				MatchResult match = in.match();
				for (int i = 0; i < CELLS; i++) {
					cells[i] = match.group(i + 1);
				}
				vals.add(cells);
				in.nextLine();
			}else {
				throw new IOException("input format error");
			}
		}
		IOException ex = in.ioException();
		if (ex != null) {
			throw ex;
		}
		return vals;
	}
	
	public static void main(String[] args) {
		String fileName = "test.csv";
		createFile(fileName);
		File file = new File(fileName);
		FileReader fr;
		List<String[]> list = null;
		try {
			fr = new FileReader(file);
			list = CSVEditClass.readCSVFile(fr, 5);
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
			pw.println("10, 23,43, 20,40");
			pw.println("1, 2, 3, 4, 56");
			pw.println();
			pw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
