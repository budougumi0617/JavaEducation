/*
 * @file
 * @par File Name:
 * PrintLine.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/15
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex21_01;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Yoichiro Shimizu
 * @note 1行全体がそろうまで待つメソッドを使用して、
 * 1度に1行の入力を返すFilterReaderのサブクラスを作成しなさい
 */
public class PrintLine extends FilterReader {

	protected PrintLine(Reader in) {
		super(in);
	}

	/**
	 * 1 行全体が揃うまで read し続け、揃ったら行を返却する。
	 * 
	 * @return
	 * @throws IOException
	 */
	public String readLine() throws IOException {

		String ls = System.getProperty("line.separator");
		StringBuffer sb = new StringBuffer();

		while (!sb.toString().endsWith(ls)) {
			// System.out.println(ready());
			sb.append((char) read());
		}

		return sb.toString();

	}

}
