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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD,
		ElementType.PARAMETER, ElementType.LOCAL_VARIABLE })
@interface SimpleStringAnnotation {
	String value();
}

/**
 * 練習問題2.16で作成したLinkedListクラスにドキュメンテーションコメントを追加しなさい。javadocを生成して
 * 、誰かにそのクラスを使用したサンプルプログラムを書いてもらいなさい。
 * その人がサンプルプログラムをかけるまで、必要ならば、コメントを書き直して、同じことを繰り返しなさい。
 * 
 * @author Yoichiro Shimizu
 * @version 1.0
 * 
 */
public class LinkedList {
	/*
	 * Stored Object. 
	 */
	private Object data;

	/**
	 * Next LinkedList
	 */
	private LinkedList next;

	/**
	 * This method is for contain any object in this Class instanse
	 * @param data
	 *            Store object inside
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * This is for connect List
	 * @param next to be connected next
	 */
	public void setNext(LinkedList next) {
		this.next = next;
	}

	/**
	 * Each Value Can assign null value.
	 * 
	 * @param Obj
	 *            Contain Object
	 * @param NextData
	 *            next LinkedList Object
	 */
	LinkedList(Object Obj, LinkedList NextData) {
		this.data = Obj;
		this.next = NextData;
	}

	/**
	 * Get contain Object.
	 * 
	 * @return get private instance member Object
	 */
	public Object GetObject() {
		return data;
	}

	/**
	 * Get next LinkedList Object.
	 * 
	 * @return get private instance member LinkedList.
	 */
	public LinkedList GetLinkedList() {
		return next;
	}

	/**
	 * count number that are connected to this LinkedList object.
	 * 
	 * @return The number of LinkedList that are connected to this LinkedList
	 *         object.
	 */
	public int CountList() {
		int num = 1;
		LinkedList target = this;
		for (; null != target.next; num++) {
			target = target.next;
		}

		return num;
	}

	/**
	 * Print instance data.
	 */
	public void show() {
		if (data instanceof Vehicle) {
			Vehicle obj = (Vehicle) this.data;
			obj.print();
		}
		if (this.next != null) {
			next.show();
		}
	}

	@Override
	/*
	 * (非 Javadoc)
	 * 
	 * @see java.lang.Object#toString() Create instances data.
	 */
	public String toString() {
		String Buf;
		Object Data = this.data;
		Buf = Data.toString();
		Object Next = this.next;
		if (Next != null)
			Buf += Next.toString();
		return Buf;
	}

	/*
	 * Operation check
	 */
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