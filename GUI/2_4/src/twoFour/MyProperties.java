package twoFour;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class MyProperties extends JDialog implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 4152986896575750289L;
	private Clock owner;
	JButton okBtn = new JButton("OK");
	JComboBox fontColor;
	JComboBox backColor;
	JComboBox fontSize = new JComboBox();
	JComboBox fontType = new JComboBox();
	JButton ngBtn = new JButton("Cancel");
	FillIcon black = new FillIcon(Color.BLACK, 20, 20);
	FillIcon white = new FillIcon(Color.WHITE, 20, 20);
	FillIcon blue = new FillIcon(Color.BLUE, 20, 20);
	FillIcon red = new FillIcon(Color.RED, 20, 20);
	FillIcon yellow = new FillIcon(Color.YELLOW, 20, 20);
	FillIcon cyan = new FillIcon(Color.CYAN, 20, 20);
	FillIcon pink = new FillIcon(Color.PINK, 20, 20);
	FillIcon green = new FillIcon(Color.GREEN, 20, 20);
	FillIcon gray = new FillIcon(Color.GRAY, 20, 20);
	FillIcon dark_gray = new FillIcon(Color.DARK_GRAY, 20, 20);
	FillIcon light_gray = new FillIcon(Color.LIGHT_GRAY, 20, 20);
	FillIcon magenta = new FillIcon(Color.MAGENTA, 20, 20);
	FillIcon orange = new FillIcon(Color.ORANGE, 20, 20);
	MyCellRenderer fontRenderer = new MyCellRenderer();
	MyCellRenderer backRenderer = new MyCellRenderer();
	DefaultComboBoxModel fontModel = new DefaultComboBoxModel();
	DefaultComboBoxModel backModel = new DefaultComboBoxModel();
	GridBagLayout gbl = new GridBagLayout();
	
	
	
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String fontfamilys[] = ge.getAvailableFontFamilyNames();

	public MyProperties(Clock owner) {
		super(owner, "properties", false);
		this.owner = owner;
		this.setSize(300, 200);
		getContentPane().setLayout(gbl);
		gbl.columnWidths = new int[] {150, 0, 0, 2};
		gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		okBtn.addActionListener(this);
		ngBtn.addActionListener(this);
		fontSize.addActionListener(this);
		fontSize.setActionCommand("fontSize");
		fontType.addActionListener(this);
		fontType.setActionCommand("fontType");
		fontModel.addElement(new ComboLabel("Black", black));
		fontModel.addElement(new ComboLabel("White", white));
		fontModel.addElement(new ComboLabel("Blue", blue));
		fontModel.addElement(new ComboLabel("Red", red));
		fontModel.addElement(new ComboLabel("Yellow", yellow));
		fontModel.addElement(new ComboLabel("Cyan", cyan));
		fontModel.addElement(new ComboLabel("Pink", pink));
		fontModel.addElement(new ComboLabel("Green", green));
		fontModel.addElement(new ComboLabel("Gray", gray));
		fontModel.addElement(new ComboLabel("Dark_gray", dark_gray));
		fontModel.addElement(new ComboLabel("Light_gray", light_gray));
		fontModel.addElement(new ComboLabel("Magenta", magenta));
		fontModel.addElement(new ComboLabel("Orange", orange));
		backModel.addElement(new ComboLabel("black", black));
		backModel.addElement(new ComboLabel("White", white));
		backModel.addElement(new ComboLabel("Blue", blue));
		backModel.addElement(new ComboLabel("Red", red));
		backModel.addElement(new ComboLabel("Yellow", yellow));
		backModel.addElement(new ComboLabel("Cyan", cyan));
		backModel.addElement(new ComboLabel("Pink", pink));
		backModel.addElement(new ComboLabel("Green", green));
		backModel.addElement(new ComboLabel("Gray", gray));
		backModel.addElement(new ComboLabel("Dark_gray", dark_gray));
		backModel.addElement(new ComboLabel("Light_gray", light_gray));
		backModel.addElement(new ComboLabel("Magenta", magenta));
		backModel.addElement(new ComboLabel("Orange", orange));
		//this.add(new JLabel("FontType", JLabel.CENTER));
		// this.addComp(new JLabel("FontType", JLabel.CENTER), 0, 0, 1, 1);
		for (String fontNameString : fontfamilys) {
			fontType.addItem(makeObj(fontNameString));
		}
		//this.add(fontType);
		JLabel fontTypeLabel = new JLabel("FontType", JLabel.CENTER);
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.anchor = GridBagConstraints.EAST;
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 0;
		gbc_label1.gridy = 0;
		getContentPane().add(fontTypeLabel, gbc_label1);
		
		GridBagConstraints gbc_comboBox1 = new GridBagConstraints();
		gbc_comboBox1.anchor = GridBagConstraints.WEST;
		gbc_comboBox1.gridwidth = 2;
		gbc_comboBox1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox1.gridx = 1;
		gbc_comboBox1.gridy = 0;
		getContentPane().add(fontType, gbc_comboBox1);
		
		JLabel fontSizeLabel = new JLabel("FontSize", JLabel.CENTER);
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.anchor = GridBagConstraints.EAST;
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 0;
		gbc_label2.gridy = 1;
		getContentPane().add(fontSizeLabel, gbc_label2);
		
		//this.add(new JLabel("FontSize", JLabel.CENTER));
		// this.addComp(new JLabel("FontSize", JLabel.CENTER), 0, 1, 1, 1);
		for(int i = 50; i <= 200; i += 10){
			fontSize.addItem(i);
		}
		GridBagConstraints gbc_comboBox2 = new GridBagConstraints();
		gbc_comboBox2.anchor = GridBagConstraints.WEST;
		gbc_comboBox2.gridwidth = 2;
		gbc_comboBox2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox2.gridx = 1;
		gbc_comboBox2.gridy = 1;
		
		getContentPane().add(fontSize, gbc_comboBox2);
		// this.addComp(fontSize, 1, 1, 1, 1);
		//this.add(fontSize);
		//this.add(new JLabel("FontColor", JLabel.CENTER));
		// this.addComp(new JLabel("FontColor", JLabel.CENTER), 0, 2, 1, 1);
		JLabel label3 = new JLabel("FontColor", JLabel.CENTER);
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.anchor = GridBagConstraints.EAST;
		gbc_label3.insets = new Insets(0, 0, 5, 5);
		gbc_label3.gridx = 0;
		gbc_label3.gridy = 2;
		getContentPane().add(label3, gbc_label3);
		
		fontColor = new JComboBox(fontModel);
		fontColor.addActionListener(this);
		fontColor.setActionCommand("fontColor");
		fontColor.setRenderer(fontRenderer);
		GridBagConstraints gbc_comboBox3 = new GridBagConstraints();
		gbc_comboBox3.anchor = GridBagConstraints.WEST;
		gbc_comboBox3.gridwidth = 2;
		gbc_comboBox3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox3.gridx = 1;
		gbc_comboBox3.gridy = 2;
		getContentPane().add(fontColor, gbc_comboBox3);
		//this.add(fontColor);

		
		// this.addComp(fontColor, 1, 2, 1, 1);
		//this.add(new JLabel("BackColor", JLabel.CENTER));
		// this.addComp(new JLabel("BackColor", JLabel.CENTER), 0, 3, 1, 1);
		JLabel label4 = new JLabel("BackColor", JLabel.CENTER);
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.anchor = GridBagConstraints.EAST;
		gbc_label4.insets = new Insets(0, 0, 5, 5);
		gbc_label4.gridx = 0;
		gbc_label4.gridy = 3;
		getContentPane().add(label4, gbc_label4);
		
		backColor = new JComboBox(backModel);
		backColor.addActionListener(this);
		backColor.setActionCommand("backColor");
		backColor.setRenderer(backRenderer);
		GridBagConstraints gbc_comboBox4 = new GridBagConstraints();
		gbc_comboBox4.anchor = GridBagConstraints.WEST;
		gbc_comboBox4.gridwidth = 2;
		gbc_comboBox4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox4.gridx = 1;
		gbc_comboBox4.gridy = 3;
		getContentPane().add(backColor, gbc_comboBox4);
		//this.add(backColor);
		// this.addComp(backColor, 1, 3, 1, 1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		getContentPane().add(okBtn, gbc_btnNewButton);
		GridBagConstraints gbc_btnNg = new GridBagConstraints();
		gbc_btnNg.anchor = GridBagConstraints.WEST;
		gbc_btnNg.gridx = 2;
		gbc_btnNg.gridy = 5;
		getContentPane().add(ngBtn, gbc_btnNg);
		//this.add(okBtn);
		//this.add(ngBtn);
		// this.addComp(okBtn, 0, 4, 2, 2);
		// this.addComp(ngBtn, 0, 1, 0, 2);
		setListDefault();
	}

	void addComp(JComponent b, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints((Component) b, gbc);
		add((Component) b);
	}

	private Object makeObj(final String item) {
		return new Object() {
			public String toString() {
				return item;
			}
		};
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "OK") {
			saveSetting();
			this.setVisible(false);
		} else if (e.getActionCommand() == "Cancel") {
			setListDefault();
			this.setVisible(false);
		}
		System.out.println("Actions 発生元" + e.getActionCommand());
		if (e.getActionCommand() == "fontType") {
			changeFontType(fontType.getSelectedItem());
		}
		if (e.getActionCommand() == "fontSize") {
			changeFontSize(fontSize);
		}
		if (e.getActionCommand() == "fontColor") {
			changeFontColor(fontColor);
		}
		if (e.getActionCommand() == "backColor") {
			changeBackground(backColor);
		}

	}

	public void itemStateChanged(ItemEvent e) {
		System.out.println("ItemEvent 発生元" + e.getSource());
		if (e.getSource() == fontType) {
			changeFontType(fontType.getSelectedItem());
		}
		if (e.getSource() == fontSize) {
			changeFontSize(fontSize);
		}
		if (e.getSource() == fontColor) {
			changeFontColor(fontColor);
		}
		if (e.getSource() == backColor) {
			changeBackground(backColor);
		}
		owner.fontType = new Font(owner.getFontName(), Font.PLAIN,
				owner.getFontSize());
	}

	void changeFontType(Object obj) {
		owner.setFontName(obj.toString());
	}

	void changeFontSize(JComboBox obj) {
		System.out.println("selectedItem : " + obj.getSelectedItem());
			owner.setFontSize((Integer)obj.getSelectedItem());
	}
String getColorString(JComboBox obj){
	String colorName;
	switch (obj.getSelectedIndex()) {
	case 0:
		colorName = "BLACK";
		break;
	case 1:
		colorName = "WHITE";
		break;
	case 2:
		colorName = "BLUE";
		break;
	case 3:
		colorName = "RED";
		break;
	case 4:
		colorName = "YELLOW";
		break;
	case 5:
		colorName = "CYAN";
		break;
	case 6:
		colorName = "PINK";
		break;
	case 7:
		colorName = "GREEN";
		break;
	case 8:
		colorName = "GRAY";
		break;
	case 9:
		colorName = "DARK_GRAY";
		break;
	case 10:
		colorName = "LIGHT_GRAY";
		break;
	case 11:
		colorName = "MAGENTA";
		break;
	case 12:
		colorName = "ORANGE";
		break;
	default:
		colorName = "WHITE";
		break;
	}
	return colorName;
}
	void changeFontColor(JComboBox obj) {
		owner.setFontColor(getColorString(obj));
	}

	void changeBackground(JComboBox obj) {
			owner.setBackColor(getColorString(obj));
	}

	void setListDefault() {
		fontType.setSelectedIndex(owner.intLoad("fontType", 0));
		changeFontType(fontType);
		fontSize.setSelectedIndex(owner.intLoad("fontSize", 10));
		changeFontSize(fontSize);
		fontColor.setSelectedIndex(owner.intLoad("fontColor", 1));
		changeFontColor(fontColor);
		backColor.setSelectedIndex(owner.intLoad("backColor", 0));
		changeBackground(backColor);
	}

	void saveSetting() {
		owner.intSave("fontType", fontType.getSelectedIndex());
		owner.intSave("fontSize", fontSize.getSelectedIndex());
		owner.intSave("fontColor", fontColor.getSelectedIndex());
		owner.intSave("backColor", backColor.getSelectedIndex());
	}

}

class ComboLabel {
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

class MyCellRenderer extends JLabel implements ListCellRenderer {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		ComboLabel data = (ComboLabel) value;
		setText(data.getText());
		setIcon(data.getIcon());

		return this;
	}
}
