/*
 * @file
 * @par File Name:
 * ChangeString.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/27
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex10_02;

public class ChangeString {

	public String Change(String before){
		String after = "";
		char ch;
		for(int i = 0; i < before.length(); i++){
			ch = before.charAt(i);
			switch (ch){
				case 't':
					after = after + '\t';
					break;
				case 'n':
					after = after + '\n';
					break;
				case 'b':
					after = after +'\b';
					break;
				case 'r':
					after = after +'\r';
					break;
				case 'f':
					after = after +'\f';
					break;
				case '\\':
					after = after +'\\';
					break;
				case '\'':
					after = after +'\'';
					break;
				case '\"':
					after = after +'\"';
					break;
				default:
					after = after + ch;
			}
		}
		return after;
	}
	public static void main(String[] args){
		ChangeString test = new ChangeString();
		System.out.println(test.Change("test"));
	}

}