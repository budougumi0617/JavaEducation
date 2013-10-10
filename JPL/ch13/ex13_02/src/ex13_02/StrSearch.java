/*
 * @file
 * @par File Name:
 * StrSearch.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/10/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex13_02;
/*
 * 文字列中に、特定文字列が出現する回数を数えるメソッドを書きなさい。
 */
public class StrSearch {

	public int countChar(String str, String s){
		int result = 0;
		int start = str.indexOf(s);
		while(-1 != start){
			result++;
			start = str.indexOf(s, start+1);
		}

		return result;
	}

	public static void main(String args[]){
		String testStr = "testeseeeeetset";
		String targetChar = "es";
		StrSearch testSearch = new StrSearch();
		System.out.println("in [" + testStr + "]:" + targetChar+ " count = " + testSearch.countChar(testStr, targetChar));
		targetChar = "ee";
		System.out.println("in [" + testStr + "]:" + targetChar+ " count = " + testSearch.countChar(testStr, targetChar));
	}

}

