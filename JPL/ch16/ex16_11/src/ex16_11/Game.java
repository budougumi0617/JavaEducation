/*
 * @file
 * @par File Name:
 * Game.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/02
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex16_11;

public class Game {
	static int count = 0;

	public static void main(String[] args) {
		String name; // Class name
		while ((name = getNextPlayer()) != null) {
			try {
				PlayerLoader loader = new PlayerLoader();
			} catch (Exception e) {
				reportException(name, e);
			}
		}

	}

	static String getNextPlayer() {
		String name;
		switch (count) {
		case 0:
			name = "first";
			break;
		case 1:
			name = "second";
			break;
		default:
			name = null;
			break;
		}
		return name;
	}

	static void reportException(String name, Exception e) {
		System.out.println("error name = " + name.toString());
		e.printStackTrace();
	}
}
