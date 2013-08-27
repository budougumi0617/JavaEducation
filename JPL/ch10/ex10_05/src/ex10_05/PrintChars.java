/*
 * @file
 * @par File Name:
 * PrintChars.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/27
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex10_05;

public class PrintChars {
	
	public void print(char start, char end){
		String result = "";
		for(int i = (int)start; i <= (int)end; i++){
			result += (char)i;
		}
		System.out.println(result);
		return;
	}
	public static void main(String[] args) {
		PrintChars test = new PrintChars();
		test.print('a', 'f');
	}

}
