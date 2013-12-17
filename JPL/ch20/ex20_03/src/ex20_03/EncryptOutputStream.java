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

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream {
	private final int key;

	public EncryptOutputStream(OutputStream arg0, int key) {
		super(arg0);
		this.key = key;

	}

	public void write(int b) throws IOException {
		byte tmp = (byte)(b ^ key);
		super.write(tmp);
	}

}
