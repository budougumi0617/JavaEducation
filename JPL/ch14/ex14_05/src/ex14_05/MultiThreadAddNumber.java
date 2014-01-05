/*
 * @file
 * @par File Name:
 * MultiThreadAddNumber.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/28
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


package ex14_05;

public class MultiThreadAddNumber {

	public static int resultNumber = 0;

	MultiThreadAddNumber(){
		resultNumber = 0;
	}

	public void addNumber(int number){
		synchronized(MultiThreadAddNumber.class){
			resultNumber += number;
			System.out.println("resultNumber = " + resultNumber);
		}
	}
	public void subNumber(int number){
		synchronized(MultiThreadAddNumber.class){
			resultNumber -= number;
			System.out.println("resultNumber = " + resultNumber);
		}
	}

	public int getNumber(){
		synchronized(MultiThreadAddNumber.class){
			return resultNumber;
		}
	}

	public int setNumber(int number){
		synchronized(MultiThreadAddNumber.class){
			resultNumber = number;
			return resultNumber;
		}
	}

}
