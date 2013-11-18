/*
 * @file
 * @par File Name:
 * MultiThreadAddNumber.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/28
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex14_03;

public class MultiThreadAddNumber {

	private int resultNumber = 0;

	MultiThreadAddNumber(){
		resultNumber = 0;
	}

	public synchronized void addNumber(int number){
		this.resultNumber += number;
		System.out.println("resultNumber = " + this.resultNumber);
	}

	public synchronized int getNumber(){
		return resultNumber;
	}

	public synchronized int setNumber(int number){
		this.resultNumber = number;
		return resultNumber;
	}

}
