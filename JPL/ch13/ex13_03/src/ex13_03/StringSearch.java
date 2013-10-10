/*
 * @file
 * @par File Name:
 * ObjectNotFoundException.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/10/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex13_03;

public class StringSearch {

	public static int countChar(String str, char ch){
		int result = 0;
		int start = str.indexOf(ch);
		while(-1 != start){
			result++;
			start = str.indexOf(ch, start+1);
		}

		return result;
	}

}
