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
	 * nameと関連付けられた値を返す。 そのような値がなければnullを返す。
	 */
	Object find(String name);
}

interface AddRemoveLookup extends Lookup {
	Object add(String name, Object value);

	void remove(String name);
}

public class LookupClass implements AddRemoveLookup {
	private int maxArray = 100;
	private Object[] valuesObjectArray = new Object[maxArray];
	private String[] namesStringArray = new String[maxArray];

	public Object find(String name) {
		for (int i = 0; i < namesStringArray.length; i++) {
			if (namesStringArray[i] != null) {
				if (namesStringArray[i].equals(name)) {
					return valuesObjectArray[i];
				}
			}
		}
		return null; // Not Find
	}

	public Object add(String name, Object value) {
		for (int i = 0; i < namesStringArray.length; i++) {
			if (namesStringArray[i] == null) {
				namesStringArray[i] = name;
				valuesObjectArray[i] = value;
				return namesStringArray;
			}
		}
		return null;
	}

	public void remove(String name) {
		for (int i = 0; i < namesStringArray.length; i++) {
			if (namesStringArray[i].equals(name)) {
				namesStringArray[i] = null;
				valuesObjectArray[i] = null;
				return;
			}
		}
		return;
	}

	public static void main(String[] args) {
		LookupClass targetClass = new LookupClass();
		String firstString = "testName1";
		String secondString = "testName2";
		String thirdString = "testName3";
		
		targetClass.add(firstString, 10);
		targetClass.add(secondString, 20);
		targetClass.add(thirdString, 30);
		
		System.out.println("find result : " + targetClass.find(firstString));
		targetClass.remove(secondString);
		System.out.println("find result : " + targetClass.find(thirdString));

	}

}
