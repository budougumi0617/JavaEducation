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

import java.io.BufferedReader;
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

		try {
			BufferedReader br = new BufferedReader(inputFile);
			String readLine = br.readLine();

			while (readLine != null) {
				String[] splitReadLine = readLine.split(" ");
				System.out.println(readLine);
				if (splitReadLine.length != 2) {
					throw new IOException();
				}
				String types = splitReadLine[0];
				if (types.equals("Boolean")) {
					System.out.println("types is Bool!!");
					// arrayList.add(new Boolean(splitReadLine[1]));
					//arrayList.add(addList(splitReadLine));
				}
				arrayList.add(addList(splitReadLine));

				readLine = br.readLine();
			}

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Object addList(String[] splitReadLine) throws IOException {
		String types = splitReadLine[0];
		if (types.equals("Boolean")) {
			System.out.println("types is Bool!!");
			return new Boolean(splitReadLine[1]);
		} else if (types.equals("Integer")) {
			return new Integer(splitReadLine[1]);
		} else if (types.equals("Double")) {
			return new Double(splitReadLine[1]);
		} else if (types.equals("Byte")) {
			return new Byte(splitReadLine[1]);
		} else if (types.equals("Short")) {
			return new Short(splitReadLine[1]);
		} else if (types.equals("Long")) {
			return new Long(splitReadLine[1]);
		} else if (types.equals("Character")) {
			return new Character(splitReadLine[1].toCharArray()[0]);
		} else if (types.equals("Float")) {
			return new Float(splitReadLine[1]);
		} else {
			throw new IOException();
		}

	}

	public void printArrayList() {
		// TODO
		System.out.println("now implement");
		for (Object data : arrayList) {
			System.out.println(data.getClass() + " " + data.toString());
		}
	}

	public static void main(String[] args) {

		FileReader fileReader = CreateNewArrayListInstanse
				.createFileReaderInstanse();
		CreateNewArrayListInstanse targetClass = new CreateNewArrayListInstanse(
				fileReader);
		targetClass.printArrayList();
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
		pw.println("Integer 100");
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
