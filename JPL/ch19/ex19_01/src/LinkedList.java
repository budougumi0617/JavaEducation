/*
 * @file
 * @par File Name:
 * LinkedList.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/12
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex19_01;

/**
 * @author Yoichiro Shimizu
 * 
 */

public class LinkedList {
	private Object data; // 変更を許さない
	private LinkedList next;

	LinkedList(Object Obj, LinkedList NextData) {
		this.data = Obj;
		this.next = NextData;
	}

	public Object GetObject() {
		return data;
	}

	public LinkedList GetLinkedList() {
		return next;
	}

	public int CountList() {
		int num = 1;
		LinkedList target = this;
		for (; null != target.next; num++) {
			target = target.next;
		}

		return num;
	}

	public void show() {
		if (data instanceof Vehicle) {
			Vehicle obj = (Vehicle) this.data;
			obj.print();
		}
		if (this.next != null) {
			next.show();
		}
	}

	public String toString() {
		String Buf;
		Object Data = this.data;
		Buf = Data.toString();
		Object Next = this.next;
		if (Next != null)
			Buf += Next.toString();
		return Buf;
	}

	public static void main(String[] args) {

		Vehicle car = new Vehicle("Satoh");
		LinkedList arg3 = new LinkedList(car, null);

		car = new Vehicle("Mike");
		LinkedList arg2 = new LinkedList(car, arg3);

		car = new Vehicle("Bob");
		LinkedList arg1 = new LinkedList(car, arg2);

		// arg1.show();

		System.out.println("toString = " + arg1.toString());
		System.out.println("CountList = " + arg1.CountList());
	}
}