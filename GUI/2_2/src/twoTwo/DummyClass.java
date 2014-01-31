package twoTwo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class DummyClass extends JDialog{
	public DummyClass() {
		setTitle("Properties");
		setBackground(new Color(221, 160, 221));
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(129, 10, 143, 36);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(129, 80, 143, 36);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(129, 141, 143, 36);
		getContentPane().add(comboBox_2);
		
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
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(129, 211, 143, 36);
		getContentPane().add(comboBox_3);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(221, 160, 221));
		btnOk.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 14));
		btnOk.setBounds(78, 257, 105, 36);
		getContentPane().add(btnOk);
	}
}
