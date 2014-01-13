/*
 * @file
 * @par File Name:
 * PrintDirOnlySpecifiedTailName.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/15
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex20_11;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 * @author budougumi0617
 * @note ディレクトリと接尾語をパラメータとして取り、
 *       その接尾語を持つ全てのファイルを表示するプログラムをFilenameFilterあるいは
 *       FileFilterを使用して作成しなさい。
 */
public class PrintDirOnlySpecifiedTailName implements FilenameFilter {

	public static void main(String[] args) {
		File dir = new File(args[0]);
		String[] files = dir.list();
		System.out.println(files.length + " dir(s):");
		for (String file : files) {
			System.out.println("\t" + file);
		}
	}

	@Override
	public boolean accept(File dir, String name) {
		return new File(dir, name).isDirectory();
	}
}
