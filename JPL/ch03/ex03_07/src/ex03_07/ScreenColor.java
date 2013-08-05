/*
 * @file
 * @par File Name:
 * ScreenColor.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_07;

public class ScreenColor {
	private String color;

	/**
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            セットする color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	ScreenColor(Object color) {
		this.setColor(color.toString());
	}
}
