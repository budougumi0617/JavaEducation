/*
 * @file
 * @par File Name:
 * PrintFileInformation.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/14
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex20_09;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author Yoichiro Shimizu
 * @note 1つかそれ以上のパス名を渡されて、それが表すファイルについて
 *       得られる全ての情報を表示するメソッドを書きなさい。
 */
public class PrintFileInformation {

	public PrintFileInformation() {

	}

	public void printFileInfo(String[] filesName) throws IOException {
		for (String filename : filesName) {
			System.out.println(filename);
			outputFileInfo(filename);
		}

	}

	private void outputFileInfo(String fileName) throws IOException {
		File src = new File(fileName);

		System.out.println("getName() = " + src.getName());
		System.out.println("getPath() = " + src.getPath());
		System.out.println("getAbsolutePath() = " + src.getAbsolutePath());
		System.out.println("getCanonicalPath() = " + src.getCanonicalPath());
		System.out.println("getParent() = " + src.getParent());
		SimpleDateFormat df = new SimpleDateFormat("yyyy MM/dd HH:mm:ss");
		System.out.println("lastModified() = " + df.format(src.lastModified()));
		System.out.println("exists() = " + src.exists());
		System.out.println("isDirectory() = " + src.isDirectory());
		System.out.println("isFile() = " + src.isFile());
		System.out.println("isAbsolute() = " + src.isAbsolute());
		System.out.println("isHidden() = " + src.isHidden());
		System.out.println("canWrite() = " + src.canWrite());
		System.out.println("canRead() = " + src.canRead());
		System.out.println("canExecute() = " + src.canExecute());
		System.out.println("Volume() = " + src.length());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		args = new String[2];
		args[0] = ".project";
		args[1] = "testest";
		// File src = new File(".." +
		// File.separator, args[0].toString());
		File src2 = new File(".." + File.separator, args[1].toString());
		PrintFileInformation p = new PrintFileInformation();
		try {
			p.printFileInfo(args);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
