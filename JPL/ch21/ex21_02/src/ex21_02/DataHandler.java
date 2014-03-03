/**
 * @file
 * @par File Name:
 * DataHandler.java
 * @author budougumi0617
 * @date Created on 2014/02/06
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex21_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.WeakHashMap;

/**
 * @author budougumi0617
 * @note P400のDataHandlerクラスを書きなおして、
 *       １つのWeakReferenceの代わりに
 *       WeeakHashMapを使用して返されたデータを保持するようにしなさい。
 */
public class DataHandler {
	/**
	 * keyはFILEではなくてLastDataのほう！
	 */
	private WeakHashMap<File, byte[]> lastFileData;

	byte[] readFile(File file) {
		byte[] data = lastFileData.get(file);

		// データを記憶しているか調べる
		if (data != null) {
			return data;
		}

		// 記憶していないので、読みこむ
		data = readBytesFromFile(file);
		lastFileData.put(file, data);
		return data;
	}

	byte[] readBytesFromFile(File file) {
		FileInputStream fis;
		byte buf[] = new byte[256];
		try {
			fis = new FileInputStream(file);
			fis.read(buf);
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return buf;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
