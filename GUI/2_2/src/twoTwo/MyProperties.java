package twoTwo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyProperties extends JDialog{
	JComboBox cbBackColor;
	JComboBox cbFontType;
	JComboBox cbFontColor;
	JComboBox cbFontSize;
	Color myColor;
	public Clock owner;
	private ActionListener actionListener;
	MyCellRenderer fontRenderer = new MyCellRenderer();
	MyCellRenderer backRenderer = new MyCellRenderer();
	DefaultComboBoxModel fontColorModel = new DefaultComboBoxModel();
	DefaultComboBoxModel backColorModel = new DefaultComboBoxModel();
	FillIcon blackIcon = new FillIcon(Color.BLACK, 20, 20);
	FillIcon whiteIcon = new FillIcon(Color.WHITE, 20, 20);
	FillIcon blueIcon = new FillIcon(Color.BLUE, 20, 20);
	FillIcon redIcon = new FillIcon(Color.RED, 20, 20);
	FillIcon yellowIcon = new FillIcon(Color.YELLOW, 20, 20);
	
	public MyProperties(Clock clock) {
		owner = clock;
		
		actionListener = new MyActionListener(this);
		setTitle("Properties");
		//setMinimumSize(new Dimension(200, 280));
		setBounds(100, 100, 278, 321);
		myColor = new Color(241, 160, 241);
		setBackground(myColor);
		getContentPane().setBackground(myColor);
		getContentPane().setLayout(null);
		getContentPane().setBounds(0, 0, 280, 320);
		
		
		
		fontColorModel.addElement(new ComboLabel("black", blackIcon));
		fontColorModel.addElement(new ComboLabel("White", whiteIcon));
		fontColorModel.addElement(new ComboLabel("Blue", blueIcon));
		fontColorModel.addElement(new ComboLabel("Red", redIcon));
		fontColorModel.addElement(new ComboLabel("Yellow", yellowIcon));
		
		backColorModel.addElement(new ComboLabel("black", blackIcon));
		backColorModel.addElement(new ComboLabel("White", whiteIcon));
		backColorModel.addElement(new ComboLabel("Blue", blueIcon));
		backColorModel.addElement(new ComboLabel("Red", redIcon));
		backColorModel.addElement(new ComboLabel("Yellow", yellowIcon));
		
		
		
		
		JLabel lblFontType = new JLabel("FontType");
		lblFontType.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 14));
		lblFontType.setBounds(33, 14, 84, 29);
		getContentPane().add(lblFontType);
		
		
		
		JLabel lblFontSize = new JLabel("FontSize");
		lblFontSize.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 14));
		lblFontSize.setBounds(31, 81, 84, 34);
		getContentPane().add(lblFontSize);
		
		JLabel lblFontColor = new JLabel("FontColor");
		lblFontColor.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 14));
		lblFontColor.setBounds(31, 141, 86, 34);
		
		getContentPane().add(lblFontColor);
		
		JLabel lblBackColor = new JLabel("BackColor");
		lblBackColor.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 14));
		lblBackColor.setBounds(29, 209, 86, 38);
		getContentPane().add(lblBackColor);
		
		cbFontType = new JComboBox();
		cbFontType.setBounds(129, 10, 143, 36);
		getContentPane().add(cbFontType);
		cbFontType.addItem("Serif");
		cbFontType.addItem("SansSerif");
		cbFontType.addActionListener(actionListener);
		cbFontType.setActionCommand("fontType");
		
		cbFontSize = new JComboBox();
		cbFontSize.setBounds(129, 80, 143, 36);
		getContentPane().add(cbFontSize);
		cbFontSize.addItem("Small");
		cbFontSize.addItem("Middle");
		cbFontSize.addItem("Large");
		cbFontSize.addActionListener(actionListener);
		cbFontSize.setActionCommand("fontSize");
		cbFontColor = new JComboBox(fontColorModel);
		cbFontColor.setBounds(129, 141, 143, 36);
		
		getContentPane().add(cbFontColor);
		cbFontColor.addActionListener(actionListener);
		cbFontColor.setActionCommand("fontColor");
		cbFontColor.setRenderer(fontRenderer);
		
		
		
		
		cbBackColor = new JComboBox(backColorModel);
		cbBackColor.setBounds(129, 211, 143, 36);
		cbBackColor.addActionListener(actionListener);
		cbBackColor.setActionCommand("backColor");
		cbBackColor.setRenderer(backRenderer);
		getContentPane().add(cbBackColor);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(221, 160, 221));
		btnOk.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 14));
		btnOk.setBounds(78, 257, 105, 36);
		btnOk.addActionListener(actionListener);
		getContentPane().add(btnOk);
	}

}

