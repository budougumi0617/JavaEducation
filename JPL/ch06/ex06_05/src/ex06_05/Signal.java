/*
 * @file
 * @par File Name:
 * Signal.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex06_05;

public enum Signal {
	GREEN("GREEN") {
		String getColor() {
			return this.name;
		};
	},
	YELOW("YELOW") {
		String getColor() {
			return this.name;
		};
	},
	RED("RED") {
		String getColor() {
			return this.name;
		};
	};

	String name;

	Signal(String name) {
		this.name = name;
	}

	abstract String getColor();
}
