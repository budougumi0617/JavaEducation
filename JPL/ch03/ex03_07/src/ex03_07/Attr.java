/*
 * @file
 * @par File Name:
 * Attr.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


package ex03_07;

public class Attr {
	private final String name;
	private Object value = null;

	public Attr(String name){
		this.name = name;
	}

	public Attr(String name, Object value){
		this.name = name;
		this.value = value;
	}

	public String getName(){
		return name;
	}
	public Object getValue(){
		return value;
	}

	public Object setValue(Object newValue){
		Object oldval = value;
		value = newValue;
		return oldval;
	}

	public String toString(){
		return name + "='" + value + "'";
	}
}
