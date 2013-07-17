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
import java.awt.Color;
import java.awt.Component;
import java.awt.List;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.event.*;
import java.awt.GridBagLayout;


class MyProperties extends Dialog implements ActionListener, ItemListener{
	/**
	 *
	 */
	private static final long serialVersionUID = 4152986896575750289L;
	private Clock owner;
	Button okBtn = new Button("OK");
	List fontColor = new List(3, false);
	List backColor = new List(3, false);
	Choice fontSize = new Choice();
	Choice fontType = new Choice();
	Button ngBtn = new Button("NG");
	GridBagLayout gbl = new GridBagLayout();

	public MyProperties(Clock owner) {
		super(owner, "properties", false);
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
		this.addComp(fontType, 1, 0, 1, 1);
		this.addComp(new Label("FontSize", Label.CENTER), 0, 1, 1, 1);
		fontSize.add("Small");
		fontSize.add("Middle");
		fontSize.add("Large");
		fontSize.select(1);
		this.addComp(fontSize, 1, 1, 1, 1);
		this.addComp(new Label("FontColor", Label.CENTER), 0, 2, 1, 1);
		fontColor.add("Black");
		fontColor.add("White");
		fontColor.add("Blue");
		this.addComp(fontColor, 1, 2, 1, 1);
		this.addComp(new Label("BackColor", Label.CENTER), 0, 3, 1, 1);
		backColor.add("Black");
		backColor.add("White");
		backColor.add("Blue");
		this.addComp(backColor, 1, 3, 1, 1);
		this.addComp(okBtn, 0, 4, 2, 2);
		//this.addComp(ngBtn, 0, 1, 0, 2);
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
		if (e.getSource() == fontType){
			Choice cho = (Choice)e.getItemSelectable();
			if (cho.getSelectedIndex() == 0) owner.setFontName("Serif");
			if (cho.getSelectedIndex() == 1) owner.setFontName("SansSerif");
		}
		if (e.getSource() == fontSize){
			Choice cho = (Choice)e.getItemSelectable();
			if (cho.getSelectedIndex() == 0) owner.setFontSize(50);
			if (cho.getSelectedIndex() == 1) owner.setFontSize(100);
			if (cho.getSelectedIndex() == 2) owner.setFontSize(150);
		}

			changeFontColor(fontColor);
			changeBackground(backColor);

	}
	void changeFontColor(List obj) {
		if (obj.getSelectedIndex() == 0) owner.setFontColor("Black");
		if (obj.getSelectedIndex() == 1) owner.setFontColor("White");
		if (obj.getSelectedIndex() == 2) owner.setFontColor("Blue");
	}
	void changeBackground(List obj) {
		if (obj.getSelectedIndex() == 0) owner.setBackColor("Black");
		if (obj.getSelectedIndex() == 1) owner.setBackColor("White");
		if (obj.getSelectedIndex() == 2) owner.setBackColor("Blue");
	}



}
