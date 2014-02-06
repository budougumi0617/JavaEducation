/**
 * @file
 * @par File Name:
 * SortLineOfFile.java
 * @author budougumi0617
 * @date Created on 2014/02/06
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex21_01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * @author budougumi0617
 * @note ファイルを開いて１行ずつ読み込み、各行String.CompereToを使用して
 *       ソートされたListに保存するプログラムを書きなさい
 *       。練習問題20_04で作成した行を読み込むクラスが役立ちます。
 */
public class SortLineOfFile {
	static File file;
	static PrintWriter pw;

	public List<String> saveLineWithList(String input) {
		
		LinkedList<String> list = new LinkedList<String>();
		FileReader fr = null;
		try {
			fr = new FileReader(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		LineNumberReader in = new LineNumberReader(fr);
		String lines = null;
		try {
			while ((lines = in.readLine()) != null) {
				int i = 0;
				for(;i<list.size();i++){
					if(lines.compareTo(list.get(i)) <= 0){
						//System.out.println("true :" + lines + " " + list.get(i));
						break;
					}
				}
				list.add(i, lines);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "file";
		createFile(name);
		SortLineOfFile slof = new SortLineOfFile();
		System.out.println("11 20 :result :" + "11".compareTo("20"));
		System.out.println("11 111 :result :" + "11".compareTo("111"));
		System.out.println("20 111 :result :" + "20".compareTo("111"));
		System.out.println("-----------------------");
		List<String> result = slof.saveLineWithList(name);
		for(Iterator<String> i = result.iterator(); i.hasNext();){
			String line = i.next();
			System.out.println(line);
		}


	}
	protected void finalize() throws Throwable {
		if (pw != null) {
			pw.close();
		}
	}
	public static void createFile(String fileName) {
		try {
			file = new File(fileName);

			pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

			pw.println("Today max tmp is ");
			pw.println(10);
			pw.println("test Test file FILE ");
			pw.println(111);
			pw.println("testTestfileFILE");
			pw.println(20);
			pw.println("testTestfileFILE");
			pw.println(11);
			pw.println(".");
			pw.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
