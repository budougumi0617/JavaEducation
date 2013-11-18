/*
 * @file
 * @par File Name:
 * MultiThreadAddNumber.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/28
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


package ex14_04;

public class MultiThreadAddNumber {

	public static int resultNumber = 0;

	MultiThreadAddNumber(){
		resultNumber = 0;
	}

	public static synchronized void addNumber(int number){
		resultNumber += number;
		System.out.println("resultNumber = " + resultNumber);
	}

	public static synchronized int getNumber(){
		return resultNumber;
	}

	public static synchronized int setNumber(int number){
		resultNumber = number;
		return resultNumber;
	}

}
