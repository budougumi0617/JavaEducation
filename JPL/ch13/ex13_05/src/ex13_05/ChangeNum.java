/*
 * @file
 * @par File Name:
 * ObjectNotFoundException.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/10/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex13_05;

/*
 * 10進数を含む文字列を、右から3桁ごとにカンマで区切られた数に変換するメソッドを書きなさい。
 * たとえば、文字列"1543729"が与えられたら、そのメソッドは文字列"1,543,729"を返します。
 */
public class ChangeNum {
	public static String addDot(String num){
		String result = "";
		int i = num.length() % 3;
		int j = 0;
		result = num.substring(0, i) ;
		while(i < num.length()){
			if (0 == (j % 3) && i != 0)
				result = result.concat(",");
			result = result.concat(String.valueOf(num.charAt(i++)));
			j++;
		}
		return result;
	}

	public static void main(String[] args) {
		String test= "32323232";
		test = ChangeNum.addDot(test);
		System.out.println(test);



	}

}
