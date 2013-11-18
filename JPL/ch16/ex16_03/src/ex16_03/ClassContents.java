/*
 * @file
 * @par File Name:
 * ClassContents.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/02
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex16_03;

import java.lang.reflect.Member;

public class ClassContents {

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			c = Vehicle.class;
			System.out.println(c);
			printMembers(c.getFields());
			printMembers(c.getConstructors());
			printMembers(c.getMethods());
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}

	}

	private static void printMembers(Member[] mems) {
		for (Member m : mems) {
			// if (m.getDeclaringClass() == Object.class)
			// continue;
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.lang."));
		}
	}

	public static String strip(String str, String stripChars) {
		str = stripStart(str, stripChars);
		return str;
	}

	public static String stripStart(String str, String stripChars) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return str;
		}
		int start = 0;
		if (stripChars == null) {
			while (start != strLen && Character.isWhitespace(str.charAt(start))) {
				start++;
			}
		} else if (stripChars.length() == 0) {
			return str;
		} else {
			while (start != strLen
					&& stripChars.indexOf(str.charAt(start)) != -1) {
				start++;
			}
		}
		return str.substring(start);
	}
}
