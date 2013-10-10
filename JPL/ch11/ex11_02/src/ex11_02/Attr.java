/*
 * @file
 * @par File Name:
 * Attr.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/10/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


package ex11_02;

/*
 * 第3章のAtttrクラスをジェネリッククラスに書き直しなさい。
 */
public class Attr <E> {
	private final String name;
	private E value = null;

	public Attr(String name){
		this.name = name;
	}

	public Attr(String name, E value){
		this.name = name;
		this.value = value;
	}

	public String getName(){
		return name;
	}
	public E getValue(){
		return value;
	}

	public Object setValue(E newValue){
		E oldval = value;
		value = newValue;
		return oldval;
	}

	public String toString(){
		return name + "='" + value.toString() + "'";
	}
}
