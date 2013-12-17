/*
 * @file
 * @par File Name:
 * OutputResultOfSearchWord.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/15
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex20_05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

/**
 * @author Yoichiro Shimizu 指定されたファイルを読み込んで、指定された単語を検索するプログラムを作成しなさい。
 *         単語が発見された全ての行を、行の前に行番号をつけて表示しなさい。
 */
public class OutputResultOfSearchWord {
	static File file;
	static PrintWriter pw;

	public void findWord(String match, String fileName) {
		FileReader fileIn = null;
		try {
			fileIn = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		LineNumberReader in = new LineNumberReader(fileIn);
		String lines = "";
		try {
			while ((lines = in.readLine()) != null) {
				//System.out.println("Check Line : " + in.getLineNumber()); //For Debug
				String[] words = lines.split(" ");
				for (String word : words) {
					if (word.equals(match)) {
						System.out.println("\"" + word + "\" at line "
								+ in.getLineNumber());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected void finalize() throws Throwable {
		if (pw != null) {
			pw.close();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		args = new String[2];
		args[0] = "test";
		args[1] = "test.txt";
		createFile(args[1]);
		OutputResultOfSearchWord orosw = new OutputResultOfSearchWord();
		if (args.length != 2) {
			throw new IllegalArgumentException("Need word and file ");
		}

		orosw.findWord(args[0], args[1]);
	}

	public static void createFile(String fileName) {
		try {
			file = new File(fileName);

			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

			pw.println("Today max tmp is ");
			pw.println(10);
			pw.println("test Test file FILE ");
			pw.println("testTestfileFILE");
			pw.println("testTestfileFILE");
			pw.println(".");
			pw.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
