/*
 * @file
 * @par File Name:
 * ObjectNotFoundException.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/10/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex13_06;

/*
 * 区切り文字と、区切り文字間の桁数を指定するパラメータを受け付けるようにメソッドを修正しなさい。
 */
public class ChangeNum {
	public static String addDot(String num, int range, char c){
		String result = "";
		int i = num.length() % range;
		int j = 0;
		result = num.substring(0, i) ;
		while(i < num.length()){
			if (0 == (j % range) && i != 0)
				result = result.concat(String.valueOf(c));
			result = result.concat(String.valueOf(num.charAt(i++)));
			j++;
		}
		return result;
	}

	public static void main(String[] args) {
		String test= "32323232";
		test = ChangeNum.addDot(test, 5, '.');
		System.out.println(test);



	}

}
