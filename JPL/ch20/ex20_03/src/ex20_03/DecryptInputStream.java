/*
 * @file
 * @par File Name:
 * DecryptInputStream.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/11
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {
	private final int key;

	public DecryptInputStream(InputStream in, int key) {
		super(in);
		this.key = key;
	}

	public int read() throws IOException {
		int c = super.read();
		c = c ^ key;
		return c;
	}

	public int read(byte[] b, int off, int len) throws IOException {
		int ret = super.read(b, off, len);
		for (int i = off; i < b.length; i++) {
			int tmp = b[i] ^ key;
			b[i] = (byte) tmp;
		}
		return ret;
	}
}
