/*
 * @file
 * @par File Name:
 * testFilter.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/11
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex20_03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yoichiro Shimizu
 * 
 */
public class testFilter {

	DecryptInputStream targetInputClass;
	EncryptOutputStream targetOutputClass;
	PrintWriter pw;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOperation() {
		File newfile = new File("test.txt");
		FileWriter filewriter;
		try {
			newfile.createNewFile();

			filewriter = new FileWriter(newfile);
			BufferedWriter bw = new BufferedWriter(filewriter);
			pw = new PrintWriter(bw);
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		pw.println("testsatesat");
		
		InputStream in = getClass().getResourceAsStream(newfile.toString());
		int key = 10;
		targetInputClass = new DecryptInputStream(in, key);
		try {
			targetOutputClass = new EncryptOutputStream(new FileOutputStream(newfile), key);
		} catch (FileNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		byte[] b = "testtest".getBytes();
		try {
			targetOutputClass.write(b);
			FileInputStream inputStream = new FileInputStream(newfile);
			InputStreamReader r = new InputStreamReader(inputStream);
			byte[] ch = r.read();
			while ((ch = r.read()) != -1) {
			
			}
			targetInputClass.read(ch);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
	}

}
