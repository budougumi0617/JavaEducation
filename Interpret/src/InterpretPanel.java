import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

/*
 * @file
 * @par File Name:
 * InterpretPanel.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/19
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

public class InterpretPanel extends JFrame {
	/**
	 * @wbp.nonvisual location=108,-4
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");
	private JTextField txtTest;
	public static void main(String[] args) {
		InterpretPanel frame = new InterpretPanel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 10, 300, 200);
		frame.setTitle("Interpret");
		frame.setVisible(true);
	}

	InterpretPanel() {
		setFont(new Font("Inconsolata", Font.PLAIN, 12));
		setForeground(new Color(102, 102, 102));
		setTitle("Interpret");
		setBackground(new Color(204, 153, 255));
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 255));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtTest = new JTextField();
		txtTest.setBackground(new Color(204, 204, 255));
		txtTest.setText("type Class name");
		txtTest.setBounds(12, 28, 153, 19);
		panel.add(txtTest);
		txtTest.setColumns(10);
		
		JTabbedPane instansePane = new JTabbedPane(JTabbedPane.TOP);
		instansePane.setBounds(12, 80, 167, 217);
		panel.add(instansePane);
		
		JList objectList = new JList();
		instansePane.addTab("Object", null, objectList, null);
		
		JList arrayList = new JList();
		instansePane.addTab("Array", null, arrayList, null);
		JTabbedPane classMamberpane = new JTabbedPane();
		classMamberpane.setBackground(new Color(204, 153, 255));

		JPanel cstTabPanel = new JPanel();
		cstTabPanel.setBackground(new Color(204, 153, 255));

		JPanel methodTabPanel = new JPanel();
		methodTabPanel.setBackground(new Color(204, 153, 255));
		methodTabPanel.setLayout(null);
		JLabel label_1 = new JLabel("Name:");
		label_1.setBounds(12, 8, 31, 13);
		methodTabPanel.add(label_1);
		JTextField textField = new JTextField("", 10);
		textField.setBounds(55, 5, 96, 19);
		methodTabPanel.add(textField);

		JPanel fieldTabPanel = new JPanel();
		fieldTabPanel.setBackground(new Color(204, 153, 255));
		fieldTabPanel.add(new JLabel("Name:"));
		fieldTabPanel.add(new JTextField("", 10));
		
		
		
		classMamberpane.addTab("Cst", cstTabPanel);
		cstTabPanel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(165, 5, 0, 0);
		cstTabPanel.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(12, 10, 307, 150);
		cstTabPanel.add(list_1);
		classMamberpane.addTab("Field", fieldTabPanel);
		classMamberpane.addTab("Method", methodTabPanel);
		

		getContentPane().add(classMamberpane);
		
		JTabbedPane listDisp = new JTabbedPane(JTabbedPane.TOP);
		classMamberpane.addTab("ListDisp", null, listDisp, null);
	}
}
