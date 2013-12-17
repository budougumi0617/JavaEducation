/*
 * @file
 * @par File Name:
 * EncryptOutputStream.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/11
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex20_03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class TestMain {

	public static void main(String[] args) throws IOException {

		byte[] plain = new byte[3];
		byte[] encrypt = new byte[3]; 
		byte[] decrypt = new byte[3]; 
		plain[0] = (byte) 0xF0; 
		plain[1] = (byte) 0xE1; 
		plain[2] = (byte) 0xD2; 
		int key = 10;

		System.out.println("Input: OriginalStream");
		for (byte tmp : plain)
			System.out.println(toBinaryString(tmp));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		EncryptOutputStream encos = new EncryptOutputStream(baos, key);
		encos.write(plain);
		encrypt = baos.toByteArray();

		System.out.println("Result: EncryptStream");
		for (byte tmp : encrypt)
			System.out.println(toBinaryString(tmp));

		// 複合化
		ByteArrayInputStream bais = new ByteArrayInputStream(encrypt);
		DecryptInputStream decis = new DecryptInputStream(bais, key);
		decis.read(decrypt);

		System.out.println("Result: DecryptStream");
		for (byte tmp : decrypt)
			System.out.println(toBinaryString(tmp));

	}

	public static String toBinaryString(byte b) {
		char[] buf = new char[8];
		int shift = 1;
		for (int i = 7; i >= 0; i--) {
			if ((shift & b) == 1) {
				buf[i] = '1';
			} else {
				buf[i] = '0';
			}
			b = (byte) (b >> 1);
		}
		return new String(buf);
	}

}