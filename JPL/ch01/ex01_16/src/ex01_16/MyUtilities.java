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

import java.io.FileInputStream;
import java.io.IOException;

class BadDataSetException extends Exception {
	public String file;
    public IOException e;

}


public class MyUtilities {
	public double[]  getDataSet (String setName)
			throws BadDataSetException
	{
		String file = setName + ".dset";
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			return readDataSet(in);
		} catch (IOException e) {
			throw new BadDataSetException();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e){
				; //無視
			}
		}
	}

	public double[] readDataSet(FileInputStream in)
	{
		double[] x = new double[2];
		return x;
	}
}
