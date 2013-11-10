/*
 * @file
 * @par File Name:
 * ShortLifeThread.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/28
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


package ex14_09;

public class ShortLifeThread extends Thread{
	public ShortLifeThread(ThreadGroup g, String name){
		super(g, name);
	}
	public void run(){
		try {
			sleep(40000);
			System.out.println("Thread End :" + getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
