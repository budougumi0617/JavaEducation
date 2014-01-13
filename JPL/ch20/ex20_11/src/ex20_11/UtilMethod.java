/**
 * @file
 * @par File Name:
 * UtilMethod.java
 * @author budougumi0617
 * @date Created on 2014/01/13
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex20_11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author budougumi0617
 * @note no comment
 */
public class UtilMethod {
	public static void createFile(String fileName) {
		try {
			File file = new File(fileName);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
					file)));
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
