/**
 * @file
 * @par File Name:
 * ComboLabel.java
 * @author budougumi0617
 * @date Created on 2014/01/31
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package twoTwo;

import javax.swing.Icon;

/**
 * @author budougumi0617
 * @note no comment
 */
public class ComboLabel {

	String text;
	FillIcon icon;

	ComboLabel(String text, FillIcon icon) {
		this.text = text;
		this.icon = icon;
	}

	public String getText() {
		return text;
	}

	public Icon getIcon() {
		return icon;
	}

}
