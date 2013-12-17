/*
 * @file
 * @par File Name:
 * PlayerLoader.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/18
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex16_11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Yoichiro Shimizu
 * 
 */
public class PlayerLoader extends ClassLoader {
	public Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] buf = byteForClass(name);
			return defineClass(name, buf, 0, buf.length);
		} catch (IOException e) {
			throw new ClassNotFoundException(e.toString());
		}
	}

	protected byte[] byteForClass(String name) throws IOException,
			ClassNotFoundException {
		FileInputStream in = null;
		try {
			in = streamFor(name + ".class");
			int length = in.available();
			if (length == 0) {
				throw new ClassNotFoundException(name);
			}
			byte[] buf = new byte[length];
			in.read(buf);
			return buf;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	private FileInputStream streamFor(String className)
			throws ClassNotFoundException {
		try {
			return new FileInputStream(className);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ClassNotFoundException("Can't find", e.getCause());
		}
	}

}
