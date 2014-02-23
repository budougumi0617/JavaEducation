/**
 * @file
 * @par File Name:
 * MyCellRenderer.java
 * @author budougumi0617
 * @date Created on 2014/01/31
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package twoTwo;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * @author budougumi0617
 * @note no comment
 */
public class MyCellRenderer extends JLabel implements ListCellRenderer {

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		ComboLabel data = (ComboLabel) value;
		setText(data.getText());
		setIcon(data.getIcon());

		return this;
	}

}
