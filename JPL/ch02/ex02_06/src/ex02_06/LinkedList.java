/*
 * @file
 * @par File Name:
 * LinkedList.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex02_06;

/**
 * @author Yoichiro Shimizu
 * 
 */

public class LinkedList {
	public Object data;
	public LinkedList next;

	public void show() {
		Vehicle obj = (Vehicle) this.data;
		obj.print();
		if (this.next != null) {
			next.show();
		}
	}

	public static void main(String[] args) {
		LinkedList arg1 = new LinkedList();
		LinkedList arg2 = new LinkedList();
		LinkedList arg3 = new LinkedList();
		Vehicle car = new Vehicle();
		car.speed = 100;
		car.angle = 10;
		car.owner = "Bob";
		car.MyId = Vehicle.NextId++;

		arg1.data = car;
		arg1.next = arg2;

		car = new Vehicle();
		car.speed = 50;
		car.angle = 20;
		car.owner = "Mike";
		car.MyId = Vehicle.NextId++;
		arg2.data = car;
		arg2.next = arg3;

		car = new Vehicle();
		car.speed = 10;
		car.angle = 0;
		car.owner = "Satoh";
		car.MyId = Vehicle.NextId++;
		arg3.data = car;
		arg3.next = null;
		arg1.show();
	}

}
