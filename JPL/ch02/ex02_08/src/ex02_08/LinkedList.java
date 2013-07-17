/*
 * @file
 * @par File Name:
 * LinkedList.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex02_08;

/**
 * @author Yoichiro Shimizu
 * 
 */

public class LinkedList {
	public Object data;
	public LinkedList next;

	LinkedList(Object Obj, LinkedList NextData) {
		this.data = Obj;
		this.next = NextData;
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

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Vehicle car = new Vehicle("Satoh");
		car.speed = 10;
		car.angle = 0;
		LinkedList arg3 = new LinkedList(car, null);

		car = new Vehicle("Mike");
		car.speed = 50;
		car.angle = 20;
		LinkedList arg2 = new LinkedList(car, arg3);

		car = new Vehicle("Bob");
		car.speed = 100;
		car.angle = 10;
		LinkedList arg1 = new LinkedList(car, arg2);

		arg1.show();
	}
}
