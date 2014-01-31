package twoTwo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

/*
 * @file
 * @par File Name:
 * MyActionListener.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/19
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

/**
 * @author Yoichiro Shimizu
 * 
 */
public class MyActionListener implements ActionListener {
	MyProperties myProperties;

	MyActionListener(MyProperties myProperties) {
		this.myProperties = myProperties;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		String cmd = evt.getActionCommand();
		if (cmd.equals("OK")) {
			myProperties.setVisible(false);
		} else if (cmd.equals("NG")) {
			myProperties.setVisible(false);
		} else if (cmd.equals("fontType")) {
			if (myProperties.fontType.getSelectedIndex() == 0) {
				myProperties.owner.setFontName(Font.SERIF);
			}
			if (myProperties.fontType.getSelectedIndex() == 1) {
				myProperties.owner.setFontName(Font.SANS_SERIF);
				System.out.println("font = SANS");
			}
			myProperties.owner.fontType = new Font(
					myProperties.owner.getFontName(), Font.PLAIN,
					myProperties.owner.getFontSize());
		}
		if (cmd.equals("fontSize")) {
			if (myProperties.fontSize.getSelectedIndex() == 0)
				myProperties.owner.setFontSize(50);
			if (myProperties.fontSize.getSelectedIndex() == 1)
				myProperties.owner.setFontSize(100);
			if (myProperties.fontSize.getSelectedIndex() == 2) {
				myProperties.owner.setFontSize(150);
				System.out.println("fontSize = 150");
			}
			myProperties.owner.fontType = new Font(
					myProperties.owner.getFontName(), Font.PLAIN,
					myProperties.owner.getFontSize());
		}
		if (cmd.equals("fontColor")) {
			changeFontColor(myProperties.fontColor);
		}
		if (cmd.equals("backColor")) {
			changeBackground(myProperties.backColor);
		}
	}

	void changeFontColor(JComboBox obj) {
		if (obj.getSelectedIndex() == 0)
			myProperties.owner.setFontColor("BLACK");
		if (obj.getSelectedIndex() == 1) {
			myProperties.owner.setFontColor("WHITE");
			System.out.println("fontcolor = white");
			System.out.println("owner.fontcolor = "
					+ myProperties.owner.getFontColor());
		}
		if (obj.getSelectedIndex() == 2)
			myProperties.owner.setFontColor("BLUE");
	}

	void changeBackground(JComboBox obj) {
		if (obj.getSelectedIndex() == 0)
			myProperties.owner.setBackColor("BLACK");
		if (obj.getSelectedIndex() == 1)
			myProperties.owner.setBackColor("WHITE");
		if (obj.getSelectedIndex() == 2) {
			myProperties.owner.setBackColor("BLUE");
			System.out.println("backcolor = blue");
			System.out.println("owner.backcolor = "
					+ myProperties.owner.getBackColor());
		}
	}
}
