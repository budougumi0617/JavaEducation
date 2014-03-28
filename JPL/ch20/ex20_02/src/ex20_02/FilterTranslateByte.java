/*
 * @file
 * @par File Name:
 * FilterTranslateByte.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/11
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex20_02;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Yoichiro Shimizu
 * @note TranslateByteクラスをフィルターとして書き直しなさい。
 */
public class FilterTranslateByte extends FilterInputStream {

	private byte from;
	private byte to;

	/**
	 * @param arg0
	 */
	public FilterTranslateByte(InputStream arg0, byte from, byte to) {
		super(arg0);
		this.from = from;
		this.to = to;
	}

	public int read() throws IOException {
		int c = super.read();
		//System.out.println(c);
		if (c != -1) {
			c = (c == from ? to : c);
			//System.out.println("in if() from = "+ from + " to = " + to + " c = " + c);
		}
		return c;
	}
	/**
	 * TODO 未実装
	 */
	@Override
	public int read(byte[] b){
		
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		byte from = (byte) args[0].charAt(0);
		byte to = (byte) args[1].charAt(0);
		FilterInputStream target = new FilterTranslateByte(System.in, from, to);
		int b;
		while ((b = target.read()) != -1) {
			System.out.write(b);
		}
		target.close();
	}

}
