/*
 * @file
 * @par File Name:
 * LookupClass.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex01_15;

interface Lookup {
	/**
	 * nameと関連付けられた値を返す。
	 * そのような値がなければnullを返す。
	 */
	Object find(String name);
}

interface AddRemoveLookup extends Lookup{
	Object add(String name, Object value);
	void remove(String name);
}


public class LookupClass implements AddRemoveLookup{
	private Object[] values = new Object[100];
	private String[] names = new String[100];

	public Object find (String name){
		for(int i = 0;names[i] != null; i++){
			if (names[i].equals(name))
			return values[i];
		}
		return null; //Not Find
	}


	public Object add(String name, Object value) {
		for(int i = 0; i < names.length; i++){
			if( names[i] == null){
			names[i] =  new String();
			values[i] = new Object();
			names[i] = name;
			values[i] = value;
			return names;
			}
		}
		return null;
	}

	public void remove(String name) {
		for(int i = 0; i < names.length; i++){
			if (names[i].equals(name)){
				names[i] = null;
				values[i] = null;
				return;
			}
		}
		return;
	}
}
