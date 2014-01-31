package twoTwo;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

class MyProperties extends JDialog {
	/**
	 *
	 */
	private static final long serialVersionUID = 4152986896575750289L;
	public Clock owner;
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
	private ActionListener actionListener;

	public MyProperties(Clock owner) {
		
		super(owner, "properties", false);
		this.owner = owner;
		actionListener = new MyActionListener(this);
		this.setLayout(new GridLayout(0, 2));
		
		okBtn.addActionListener(actionListener);
		ngBtn.addActionListener(actionListener);
		fontSize.addActionListener(actionListener);
		fontSize.setActionCommand("fontSize");
		fontType.addActionListener(actionListener);
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
		fontColor.addActionListener(actionListener);
		fontColor.setActionCommand("fontColor");
		fontColor.setRenderer(fontRenderer);
		this.add(fontColor);

		fontColor.setSelectedIndex(1);
		// this.addComp(fontColor, 1, 2, 1, 1);
		this.add(new JLabel("BackColor", JLabel.CENTER));
		// this.addComp(new JLabel("BackColor", JLabel.CENTER), 0, 3, 1, 1);
		backColor = new JComboBox(backModel);
		backColor.addActionListener(actionListener);
		backColor.setActionCommand("backColor");
		backColor.setRenderer(backRenderer);
		this.add(backColor);
		// this.addComp(backColor, 1, 3, 1, 1);
		this.add(okBtn);
		this.add(ngBtn);
		okBtn.setSize(20, 40);
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
