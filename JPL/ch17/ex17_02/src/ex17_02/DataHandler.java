/*
 * @file
 * @par File Name:
 * DataHandler.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/14
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex17_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class DataHandler {
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	public static void main(String[] args) {
		DataHandler testDH = new DataHandler();
		String inputFileName = "c:/temp/test.dat";
		File inputFile = new File(inputFileName);
		String inputFileName2 = "c:/temp/test_2.dat";
		File inputFile2 = new File(inputFileName2);

		System.out.println(testDH.readFile(inputFile));
		System.out.println(testDH.readFile(inputFile2));
		System.out.println(testDH.readFile(inputFile2));
	}

	byte[] readFile(File file) {
		byte[] data;

		if (file.equals(lastFile)) {
			data = lastData.get();
			if (data != null)
				return data;
		}

		data = raedBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;
	}

	public static byte[] raedBytesFromFile(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] line = new byte[1024];
			int len;
			if ((len = fis.read(line)) != -1) {
				fis.close();
				return line;
			}
			fis.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return null;
	}
}