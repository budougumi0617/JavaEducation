/*
 * @file
 * @par File Name:
 * MemoryCheck.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/14
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex17_01;

public class MemoryCheck {

	/*
	 * 実行結果
	 *  Start ProgramMemory :254190536 
	 *  Create ObjectsMemory :244234168 
	 *  after GCMemory :254022392
	 */

	public static void printMemory(String state) {
		Runtime rt = Runtime.getRuntime();
		System.out.println(state + "Memory :" + rt.freeMemory());
	}

	public static void main(String[] args) {
		MemoryCheck.printMemory("Start Program");
		for (int i = 0; i < 100000000; i++)
			new MemoryCheck();
		MemoryCheck.printMemory("Create Objects");
		Runtime.getRuntime().gc();
		MemoryCheck.printMemory("after GC");

	}

}
