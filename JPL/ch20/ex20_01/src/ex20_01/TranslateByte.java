/*
 * @file
 * @par File Name:
 * TranslateByte.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/01
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex20_01;

import java.io.IOException;

/**
 * @author Yoichiro Shimizu
 * 
 */
public class TranslateByte {

	/**
	 * Example Call : java TranslateByte b B 
	 * and type any string.
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		byte from = (byte) args[0].charAt(0);
		byte to = (byte) args[1].charAt(0);
		int b;
		while ((b = System.in.read()) != -1) {
			System.out.write(b == from ? to : b);
		}
	}

}
