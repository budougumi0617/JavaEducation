/**
 * @file
 * @par File Name:
 * Dice.java
 * @author budougumi0617
 * @date Created on 2014/02/18
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex22_05;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Dice {
	int result = 0;
	
	int roll(){
		result = (int)(Math.random() * 6) + 1;
		return result;
	}

}
