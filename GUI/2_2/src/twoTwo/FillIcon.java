/**
 * @file
 * @par File Name:
 * FillIcon.java
 * @author budougumi0617
 * @date Created on 2014/01/31
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package twoTwo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * @author budougumi0617
 * @note no comment
 */
public class FillIcon implements Icon {
	int width, height;
	Color color = Color.BLACK;

	public FillIcon(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}

	public int getIconWidth() {
		return width;
	}

	public int getIconHeight() {
		return height;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
