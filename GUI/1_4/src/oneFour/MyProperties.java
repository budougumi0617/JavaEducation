package oneFour;

import java.awt.Button;
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
import java.util.prefs.Preferences;

class MyProperties extends Dialog implements ActionListener, ItemListener {

	private static final long serialVersionUID = 4152986896575750289L;
	private Clock owner;
	@SuppressWarnings("unused")
	private Preferences prefs;
	Button okBtn = new Button("OK");
	String[] colorName = new String[13];
	List fontColor = new List(3, false);
	List backColor = new List(3, false);
	List fontSize = new List(3, false);
	List fontType = new List(3, false);
	Button ngBtn = new Button("Cancel");
	GridBagLayout gbl = new GridBagLayout();

	public MyProperties(Clock owner) {
		super(owner, "properties", false);
		this.owner = owner;
		prefs = owner.getPrefs();
		setColorName(colorName);
		okBtn.addActionListener(this);
		ngBtn.addActionListener(this);
		fontColor.addItemListener(this);
		fontSize.addItemListener(this);
		fontType.addItemListener(this);
		backColor.addItemListener(this);
		this.setListDefault();

		this.setLayout(gbl);
		this.addComp(new Label("FontType", Label.RIGHT), 0, 0, 1, 1,
				GridBagConstraints.EAST);
		fontType.add("Serif");
		fontType.add("SansSerif");
		fontType.add("Monospaced");
		fontType.add("DialogInput");
		fontType.add("Dialog");
		this.addComp(fontType, 1, 0, 1, 1, GridBagConstraints.WEST);
		this.addComp(new Label("FontSize", Label.RIGHT), 0, 1, 1, 1,
				GridBagConstraints.EAST);
		fontSize.add("Small");
		fontSize.add("Middle");
		fontSize.add("Large");
		fontSize.select(1);
		this.addComp(fontSize, 1, 1, 1, 1, GridBagConstraints.WEST);
		this.addComp(new Label("FontColor", Label.RIGHT), 0, 2, 1, 1,
				GridBagConstraints.EAST);
		for(String name : colorName){
			fontColor.add(name);
		}
		this.addComp(fontColor, 1, 2, 1, 1, GridBagConstraints.WEST);
		this.addComp(new Label("BackColor", Label.CENTER), 0, 3, 1, 1,
				GridBagConstraints.EAST);
		for(String name : colorName){
			backColor.add(name);
		}
		this.addComp(backColor, 1, 3, 1, 1, GridBagConstraints.EAST);
		this.addComp(okBtn, 1, 4, 1, 2, GridBagConstraints.EAST);
		this.addComp(ngBtn, 2, 4, 1, 2, GridBagConstraints.WEST);
	}

	void addComp(Component b, int x, int y, int w, int h, int anchor) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.anchor = anchor;
		gbl.setConstraints((Component) b, gbc);
		add((Component) b);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "OK") {
			saveSetting();
			this.setVisible(false);
		} else if (e.getActionCommand() == "Cancel") {
			this.setListDefault();
			this.setVisible(false);
		}
	}

	public void itemStateChanged(ItemEvent e) {
		changeFontType(fontType);
		changeFontSize(fontSize);
		changeFontColor(fontColor);
		changeBackground(backColor);
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
	void changeFontType(List obj) {
		if (obj.getSelectedIndex() == 0)
			owner.setFontName("Serif");
		if (obj.getSelectedIndex() == 1)
			owner.setFontName("SansSerif");
		if (obj.getSelectedIndex() == 2)
			owner.setFontName("Monospaced");
		if (obj.getSelectedIndex() == 3)
			owner.setFontName("DialogInput");
		if (obj.getSelectedIndex() == 4)
			owner.setFontName("Dialog");
	}

	void changeFontSize(List obj) {
		if (obj.getSelectedIndex() == 0)
			owner.setFontSize(50);
		if (obj.getSelectedIndex() == 1)
			owner.setFontSize(100);
		if (obj.getSelectedIndex() == 2)
			owner.setFontSize(150);
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

	void setListDefault() {
		fontType.select(owner.intLoad("fontType", 0));
		changeFontType(fontType);
		fontSize.select(owner.intLoad("fontSize", 1));
		changeFontSize(fontSize);
		fontColor.select(owner.intLoad("fontColor", 1));
		changeFontColor(fontColor);
		backColor.select(owner.intLoad("backColor", 0));
		changeBackground(backColor);
	}

	void saveSetting() {
		owner.intSave("fontType", fontType.getSelectedIndex());
		owner.intSave("fontSize", fontSize.getSelectedIndex());
		owner.intSave("fontColor", fontColor.getSelectedIndex());
		owner.intSave("backColor", backColor.getSelectedIndex());
	}

}
