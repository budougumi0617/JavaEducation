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

import java.util.Random;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Dice {
	int result = 0;
	Random rand = new Random();
	int roll(){
		
		result = rand.nextInt(6) + 1; //整数の乱数でよい
		return result;
	}

}
