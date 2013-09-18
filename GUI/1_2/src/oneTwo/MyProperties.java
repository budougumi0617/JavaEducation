/*
 * @file
 * @par File Name:
 * MyProperties.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package oneTwo;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class MyProperties extends Dialog implements ActionListener, ItemListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 4152986896575750289L;
	private Clock owner;
	Button okBtn = new Button("OK");
	String[] colorName = new String[13];
	List fontColor = new List(2, false);
	List backColor = new List(2, false);
	Choice fontSize = new Choice();
	Choice fontType = new Choice();
	Button ngBtn = new Button("NG");
	GridBagLayout gbl = new GridBagLayout();

	public MyProperties(Clock owner) {
		super(owner, "properties", false);
		setColorName(colorName);
		this.owner = owner;
		okBtn.addActionListener(this);
		ngBtn.addActionListener(this);
		fontColor.addItemListener(this);
		fontSize.addItemListener(this);
		fontType.addItemListener(this);
		backColor.addItemListener(this);
		this.setLayout(gbl);
		this.addComp(new Label("FontType", Label.CENTER), 0, 0, 1, 1);
		fontType.add("Serif");
		fontType.add("SansSerif");
		fontType.add("Monospaced");
		fontType.add("DialogInput");
		fontType.add("Dialog");
		this.addComp(fontType, 1, 0, 1, 1);
		this.addComp(new Label("FontSize", Label.CENTER), 0, 1, 1, 1);
		fontSize.add("Small");
		fontSize.add("Middle");
		fontSize.add("Large");
		fontSize.select(1);
		this.addComp(fontSize, 1, 1, 1, 1);
		this.addComp(new Label("FontColor", Label.CENTER), 0, 4, 1, 1);
		for (String color : colorName) {
			fontColor.add(color);
		}
		this.addComp(fontColor, 1, 5, 1, 1);
		this.addComp(new Label("BackColor", Label.CENTER), 0, 15, 1, 1);
		for (String color : colorName) {
			backColor.add(color);
		}
		this.addComp(backColor, 1, 15, 1, 1);
		this.addComp(okBtn, 0, 20, 2, 2);
		// this.addComp(ngBtn, 0, 1, 0, 2);
	}

	private void setColorName(String[] colorName) {
		try {
			colorName[0] = "BLACK";
			colorName[1] = "BLUE";
			colorName[2] = "CYAN";
			colorName[3] = "DARK_GRAY";
			colorName[4] = "GRAY";
			colorName[5] = "GREEN";
			colorName[6] = "LIGHT_GRAY";
			colorName[7] = "MAGENTA";
			colorName[8] = "ORANGE";
			colorName[9] = "PINK";
			colorName[10] = "RED";
			colorName[11] = "WHITE";
			colorName[12] = "YELLOW";

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	void addComp(Component b, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints((Component) b, gbc);
		add((Component) b);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "OK") {
			this.setVisible(false);
		}

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == fontType) {
			Choice cho = (Choice) e.getItemSelectable();
			if (cho.getSelectedIndex() == 0)
				owner.setFontName("Serif");
			if (cho.getSelectedIndex() == 1)
				owner.setFontName("SansSerif");
			if (cho.getSelectedIndex() == 2)
				owner.setFontName("Monospaced");
			if (cho.getSelectedIndex() == 3)
				owner.setFontName("DialogInput");
			if (cho.getSelectedIndex() == 4)
				owner.setFontName("Dialog");
		}
		if (e.getSource() == fontSize) {
			Choice cho = (Choice) e.getItemSelectable();
			if (cho.getSelectedIndex() == 0)
				owner.setFontSize(50);
			if (cho.getSelectedIndex() == 1)
				owner.setFontSize(100);
			if (cho.getSelectedIndex() == 2)
				owner.setFontSize(150);
		}

		changeFontColor(fontColor);
		changeBackground(backColor);

	}

	void changeFontColor(List obj) {
		if (obj.getSelectedIndex() == 0)
			owner.setFontColor("BLACK");
		else if (obj.getSelectedIndex() == 1)
			owner.setFontColor("BLUE");
		else if (obj.getSelectedIndex() == 2)
			owner.setFontColor("CYAN");
		else if (obj.getSelectedIndex() == 3)
			owner.setFontColor("DARK_GRAY");
		else if (obj.getSelectedIndex() == 4)
			owner.setFontColor("GRAY");
		else if (obj.getSelectedIndex() == 5)
			owner.setFontColor("GREEN");
		else if (obj.getSelectedIndex() == 6)
			owner.setFontColor("LIGHT_GRAY");
		else if (obj.getSelectedIndex() == 7)
			owner.setFontColor("MAGENTA");
		else if (obj.getSelectedIndex() == 8)
			owner.setFontColor("ORANGE");
		else if (obj.getSelectedIndex() == 9)
			owner.setFontColor("PINK");
		else if (obj.getSelectedIndex() == 10)
			owner.setFontColor("RED");
		else if (obj.getSelectedIndex() == 11)
			owner.setFontColor("WHITE");
		else if (obj.getSelectedIndex() == 12)
			owner.setFontColor("YELLOW");

	}

	void changeBackground(List obj) {
		if (obj.getSelectedIndex() == 0)
			owner.setBackColor("BLACK");
		else if (obj.getSelectedIndex() == 1)
			owner.setBackColor("BLUE");
		else if (obj.getSelectedIndex() == 2)
			owner.setBackColor("CYAN");
		else if (obj.getSelectedIndex() == 3)
			owner.setBackColor("DARK_GRAY");
		else if (obj.getSelectedIndex() == 4)
			owner.setBackColor("GRAY");
		else if (obj.getSelectedIndex() == 5)
			owner.setBackColor("GREEN");
		else if (obj.getSelectedIndex() == 6)
			owner.setBackColor("LIGHT_GRAY");
		else if (obj.getSelectedIndex() == 7)
			owner.setBackColor("MAGENTA");
		else if (obj.getSelectedIndex() == 8)
			owner.setBackColor("ORANGE");
		else if (obj.getSelectedIndex() == 9)
			owner.setBackColor("PINK");
		else if (obj.getSelectedIndex() == 10)
			owner.setBackColor("RED");
		else if (obj.getSelectedIndex() == 11)
			owner.setBackColor("WHITE");
		else if (obj.getSelectedIndex() == 12)
			owner.setBackColor("YELLOW");

	}

}
