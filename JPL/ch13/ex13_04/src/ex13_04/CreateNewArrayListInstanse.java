/*
 * @file
 * @par File Name:
 * CreateNewArrayListInstanse.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/10/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex13_04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * "type value"形式の行を持つ入力文字列を読み込むプログラムを書きなさい。
 * typeはラッパークラス名（Boolean, Characterなど）の１つであり、Valueはその型のコンストラクタが
 * 変換できる文字列です。各行に対して、指定された値を持つ、指定された型のオブジェクトを生成してArrayListに
 * 追加しなさい（ArrayListについてはP512の「ArrayList」を参照）全ての行が読み込まれたら最終結果を表示しなさい。
 * 各行は単純に改行文字`\n`で終了していると想定しなさい。
 */
public class CreateNewArrayListInstanse {

	ArrayList<Object> arrayList;

	public CreateNewArrayListInstanse(FileReader inputFile) {
		arrayList = new ArrayList<Object>();
	}

	public static void main(String[] args) {

		FileReader fileReader = CreateNewArrayListInstanse
				.createFileReaderInstanse();
		CreateNewArrayListInstanse targetClass = new CreateNewArrayListInstanse(
				fileReader);

	}

	private static FileReader createFileReaderInstanse() {
		File inputFile = null;
		PrintWriter pw = null;
		try {
			inputFile = File.createTempFile("ex13_04", "txt");
			pw = new PrintWriter(new BufferedWriter(new FileWriter(inputFile)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.println("Boolean true");
		pw.println("Boolean true");
		pw.println("Int 100");
		pw.println("Double 100.0");
		pw.close();

		FileReader fileReader = null;
		try {
			fileReader = new FileReader(inputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileReader;
	}

}
