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

	byte[] translateInputStream(final byte from, final byte to, byte[]buf){
		byte[] result = new byte[256];
		for(int i = 0; i < buf.length; i++){
			result[i] = (buf[i] == from ? to : buf[i]);
		}
		return result;
	}
	
	/**
	 * Example Call : java TranslateByte b B 
	 * and type any string.
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		TranslateByte target = new TranslateByte();
		byte from = (byte) args[0].charAt(0);
		byte to = (byte) args[1].charAt(0);
		byte buf[] = new byte[256];
		byte[] result;
		while ((System.in.read(buf)) != -1) {
			
		}
		result = target.translateInputStream(from, to, buf);
		System.out.println(result);
		
	}

}
