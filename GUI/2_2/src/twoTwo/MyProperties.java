package twoTwo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.GridBagLayout;

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
	JButton ngBtn = new JButton("NG");
	FillIcon black = new FillIcon(Color.BLACK, 20, 20);
	FillIcon white = new FillIcon(Color.WHITE, 20, 20);
	FillIcon blue = new FillIcon(Color.BLUE, 20, 20);
	MyCellRenderer fontRenderer = new MyCellRenderer();
	MyCellRenderer backRenderer = new MyCellRenderer();
	DefaultComboBoxModel fontModel = new DefaultComboBoxModel();
	DefaultComboBoxModel backModel = new DefaultComboBoxModel();
	GridBagLayout gbl = new GridBagLayout();

	public MyProperties(Clock owner) {
		super(owner, "properties", false);
		this.owner = owner;
		this.setLayout(new GridLayout(0, 2));
		okBtn.addActionListener(this);
		ngBtn.addActionListener(this);
		fontSize.addActionListener(this);
		fontSize.setActionCommand("fontSize");
		fontType.addActionListener(this);
		fontType.setActionCommand("fontType");
		fontModel.addElement(new ComboLabel("black", black));
		fontModel.addElement(new ComboLabel("White", white));
		fontModel.addElement(new ComboLabel("Blue", blue));
		backModel.addElement(new ComboLabel("black", black));
		backModel.addElement(new ComboLabel("White", white));
		backModel.addElement(new ComboLabel("Blue", blue));
		this.add(new JLabel("FontType", JLabel.CENTER));
		// this.addComp(new JLabel("FontType", JLabel.CENTER), 0, 0, 1, 1);
		fontType.addItem("Serif");
		fontType.addItem("SansSerif");
		this.add(fontType);
		// this.addComp(fontType, 1, 0, 1, 1);
		this.add(new JLabel("FontSize", JLabel.CENTER));
		// this.addComp(new JLabel("FontSize", JLabel.CENTER), 0, 1, 1, 1);
		fontSize.addItem("Small");
		fontSize.addItem("Middle");
		fontSize.addItem("Large");
		// this.addComp(fontSize, 1, 1, 1, 1);
		this.add(fontSize);
		this.add(new JLabel("FontColor", JLabel.CENTER));
		// this.addComp(new JLabel("FontColor", JLabel.CENTER), 0, 2, 1, 1);
		fontColor = new JComboBox(fontModel);
		fontColor.addActionListener(this);
		fontColor.setActionCommand("fontColor");
		fontColor.setRenderer(fontRenderer);
		this.add(fontColor);

		fontColor.setSelectedIndex(1);
		// this.addComp(fontColor, 1, 2, 1, 1);
		this.add(new JLabel("BackColor", JLabel.CENTER));
		// this.addComp(new JLabel("BackColor", JLabel.CENTER), 0, 3, 1, 1);
		backColor = new JComboBox(backModel);
		backColor.addActionListener(this);
		backColor.setActionCommand("backColor");
		backColor.setRenderer(backRenderer);
		this.add(backColor);
		// this.addComp(backColor, 1, 3, 1, 1);
		this.add(okBtn);
		this.add(ngBtn);
		// this.addComp(okBtn, 0, 4, 2, 2);
		// this.addComp(ngBtn, 0, 1, 0, 2);
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

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "OK") {
			this.setVisible(false);
		}
		System.out.println("Actions 発生元" + e.getActionCommand());
		if (e.getActionCommand() == "fontType") {
			if (fontType.getSelectedIndex() == 0){
				owner.setFontName(Font.SERIF);
			}
			if (fontType.getSelectedIndex() == 1){
				owner.setFontName(Font.SANS_SERIF);
				System.out.println("font = SANS");
			}
			owner.fontType = new Font(owner.getFontName(), Font.PLAIN, owner.getFontSize());
		}
		if (e.getActionCommand() == "fontSize") {
			if (fontSize.getSelectedIndex() == 0)
				owner.setFontSize(50);
			if (fontSize.getSelectedIndex() == 1)
				owner.setFontSize(100);
			if (fontSize.getSelectedIndex() == 2){
				owner.setFontSize(150);
				System.out.println("fontSize = 150");
			}
			owner.fontType = new Font(owner.getFontName(), Font.PLAIN, owner.getFontSize());
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
			if (fontType.getSelectedIndex() == 0) {
				owner.setFontName(Font.SERIF);
			}
			if (fontType.getSelectedIndex() == 1){
				owner.setFontName(Font.SANS_SERIF);
			}
		}
		if (e.getSource() == fontSize) {
			if (fontSize.getSelectedIndex() == 0)
				owner.setFontSize(50);
			if (fontSize.getSelectedIndex() == 1)
				owner.setFontSize(100);
			if (fontSize.getSelectedIndex() == 2)
				owner.setFontSize(150);
		}
		if (e.getSource() == fontColor) {
			changeFontColor(fontColor);
		}
		if (e.getSource() == backColor) {
			changeBackground(backColor);
		}
		owner.fontType = new Font(owner.getFontName(), Font.PLAIN, owner.getFontSize());
	}

	void changeFontColor(JComboBox obj) {
		if (obj.getSelectedIndex() == 0)
			owner.setFontColor("BLACK");
		if (obj.getSelectedIndex() == 1) {
			owner.setFontColor("WHITE");
			System.out.println("fontcolor = white");
			System.out.println("owner.fontcolor = " + owner.getFontColor());
		}
		if (obj.getSelectedIndex() == 2)
			owner.setFontColor("BLUE");
	}

	void changeBackground(JComboBox obj) {
		if (obj.getSelectedIndex() == 0)
			owner.setBackColor("BLACK");
		if (obj.getSelectedIndex() == 1)
			owner.setBackColor("WHITE");
		if (obj.getSelectedIndex() == 2) {
			owner.setBackColor("BLUE");
			System.out.println("backcolor = blue");
			System.out.println("owner.backcolor = " + owner.getBackColor());
		}
	}

}
class ComboLabel{
	  String text;
	  FillIcon icon;

	  ComboLabel(String text, FillIcon icon){
	    this.text = text;
	    this.icon = icon;
	  }

	  public String getText(){
	    return text;
	  }

	  public Icon getIcon(){
	    return icon;
	  }
	}

class MyCellRenderer extends JLabel implements ListCellRenderer {
	  public Component getListCellRendererComponent(
	            JList list,
	            Object value,
	            int index,
	            boolean isSelected,
	            boolean cellHasFocus){

	      ComboLabel data = (ComboLabel)value;
	      setText(data.getText());
	      setIcon(data.getIcon());

	    return this;
	  }
	}
