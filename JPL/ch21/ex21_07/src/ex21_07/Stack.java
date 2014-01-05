/**
 * @file
 * @par File Name:
 * Stack.java
 * @author budougumi0617
 * @date Created on 2014/01/04
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex21_07;

import java.util.ArrayList;

/**
 * @author budougumi0617
 * 
 *         スタッククラスはArrayListを内部で保持するべき
 *         理由：ArrayListクラスのサブクラスとした場合、利用を想定していないメソッドを 実行されてしまう可能性がある。
 *         内部でArrayListクラスを保持することで、外部からArrayListのメソッドが呼ばれることをふせぐ。
 * 
 */
public class Stack<E> {
	private ArrayList arrays;

	/**
	 * スタックが空かどうかを判定します。
	 * 
	 * @return
	 */
	boolean empty() {
		return false;

	}

	/**
	 * スタックが空かどうかを判定します。
	 * 
	 * @return
	 */
	E peek() {
		return null;

	}

	/**
	 * スタックの先頭にあるオブジェクトを取り出します。
	 * 
	 * @return
	 */
	E pop() {
		return null;

	}

	/**
	 * スタックの先頭のオブジェクトを削除し、そのオブジェクトを関数の値として返します
	 */
	E push(E item) {
		return item;

	}

	/**
	 * スタックの先頭にオブジェクトを入れます。
	 * 
	 * @param o
	 * @return
	 */
	int search(Object o) {
		return 0;

	}
}
