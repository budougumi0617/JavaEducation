/*
 * @file
 * @par File Name:
 * Attr.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex20_07;


/**
 * TODO 何バイト書くのか
 * ByteArrayStreamクラスをつかう。
 * @author Yoichiro Shimizu
 *
 */
public class Attr {

	private final String name;
	private Object value = null;

	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object newValue) {
		Object oldval = value;
		value = newValue;
		return oldval;
	}

	public String toString() {
		return name + "='" + value + "'";
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
