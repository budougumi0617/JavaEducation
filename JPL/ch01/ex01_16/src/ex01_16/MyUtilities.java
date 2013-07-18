/*
 * @file
 * @par File Name:
 * MyUtilities.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex01_16;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class BadDataSetException extends Exception {
	public String fileInfomation;
	public IOException exceptionInfomation;

	public BadDataSetException(String filename, IOException e) {
		fileInfomation = filename;
		exceptionInfomation = e;

	}

	@Override
	/*
	 * (非 Javadoc)
	 * 
	 * @see java.lang.Throwable#getStackTrace()
	 */
	public StackTraceElement[] getStackTrace() {

		return exceptionInfomation.getStackTrace();
	}
}

public class MyUtilities {
	static final int readLimit = 100;

	public double[] getDataSet(String setName) throws BadDataSetException {
		String file = setName + ".dset";
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			return readDataSet(in);
		} catch (IOException e) {
			throw new BadDataSetException(file, e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
	}

	public double[] readDataSet(FileInputStream inputStream) {
		double[] arrayDouble = new double[readLimit];
		BufferedInputStream bufferedStream = new BufferedInputStream(
				inputStream);
		try {
			for (int i = 0; (bufferedStream.read() != -1)
					&& i < arrayDouble.length; i++) {
				try {
					arrayDouble[i] = bufferedStream.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return arrayDouble;
	}
}
