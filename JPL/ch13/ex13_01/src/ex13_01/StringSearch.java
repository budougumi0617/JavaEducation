/*
 * @file
 * @par File Name:
 * ObjectNotFoundException.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/10/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex13_01;


/*
 * 文字列中に、指定された文字が出現する回数を数えるメソッドを書きなさい。
 */
public class StringSearch {

	public int countChar(String str, char ch){
		int result = 0;
		int start = str.indexOf(ch);
		while(-1 != start){
			result++;
			start = str.indexOf(ch, start+1);
		}

		return result;
	}

	public static void main(String args[]){
		String testStr = "testestset";
		char targetChar = 'a';
		StringSearch testSearch = new StringSearch();
		System.out.println("in [" + testStr + "]:" + targetChar+ " count = " + testSearch.countChar(testStr, targetChar));
		targetChar = 't';
		System.out.println("in [" + testStr + "]:" + targetChar+ " count = " + testSearch.countChar(testStr, targetChar));
	}

}
