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
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Yoichiro Shimizu
 * @note TranslateByteプログラムをメソッドに書き直してInputStreamの内容を
 *       OutputStreamに変換するようにしなさい。変換マッピングとストリームはメソッドの
 *       パラメータとして渡します、本性で述べられる各InputStreamとOutputStreamについて、
 *       その型のストリームに対して操作を行うために、変換メソッドを使用する新たなmainメソッド
 *       を書きなさい。もし入力と出力で一対となるストリームならば、1つのmainメソッドで 両方を扱うことが出来ます。
 */
public class TranslateByte {

	/**
	 * 間違っている。
	 * @param from
	 * @param to
	 * @param buf
	 * @return
	 */
	byte[] translateInputStream(final byte from, final byte to, byte[] buf) {
		byte[] result = new byte[256];
		for (int i = 0; i < buf.length; i++) {
			result[i] = (buf[i] == from ? to : buf[i]);
		}
		return result;
	}
	
	/** 正解*/
	public static OutputStream translate(byte from, byte to, InputStream in,
			OutputStream out) throws IOException {
		int b;
		while ((b = in.read()) != -1) {
			out.write(b == from ? to : b);
		}
		return out;
	}

	/**
	 * Example Call : java TranslateByte b B and type any string.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		args = new String[2];
		args[0] = "t";
		args[1] = "T";
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
