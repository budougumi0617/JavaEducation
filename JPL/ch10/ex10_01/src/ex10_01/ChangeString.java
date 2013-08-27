/*
 * @file
 * @par File Name:
 * CheckString.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/27
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex10_1;

public class ChangeString {

	public String Change(String before){
		String after = "";
		for(int i = 0; i < before.length(); i++){
			if(before.charAt(i) == 't'){
				after = after + '\t';
			}else if(before.charAt(i) == 'n'){
				after = after + '\n';
			}else if(before.charAt(i) == 'b'){
				after = after +'\b';
			}else if(before.charAt(i) == 'r'){
				after = after +'\r';
			}else if(before.charAt(i) == 'f'){
				after = after +'\f';
			}else if(before.charAt(i) == '\\'){
				after = after +'\\';
			}else if(before.charAt(i) == '\''){
				after = after +'\'';
			}else if(before.charAt(i) == '\"'){
				after = after +'\"';
			}else{
				after = after + before.charAt(i);
			}
		}
		return after;
	}
	public static void main(String[] args){
		ChangeString test = new ChangeString();
		System.out.println(test.Change("test"));
		System.out.println(test.Change("testbtestrtest"));
	}

}
