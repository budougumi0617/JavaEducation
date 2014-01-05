/**
 * @file
 * @par File Name:
 * sumTokenClass.java
 * @author budougumi0617
 * @date Created on 2014/01/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex22_14;

import java.util.StringTokenizer;

/**
 * @author budougumi0617
 * 
 */
public class sumTokenClass {

	public static double sumToken(String str) {
		StringTokenizer tokens = new StringTokenizer(str);
		double result = 0.;
		while (tokens.hasMoreTokens()) {
			try {
				double tokenDuble = Double.parseDouble(tokens.nextToken());
				result += tokenDuble;
			} catch (NumberFormatException e) {
				System.out.println("token is no Number : " + e.getMessage());
			}

		}
		return result;
	}

	public static void main(String[] args) {
		String input = "1 3.5 4.0 -1 -1. hoge 2";
		System.out.println("result = " + sumTokenClass.sumToken(input));
	}

}
