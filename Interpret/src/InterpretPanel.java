import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
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
	private final JLabel label = DefaultComponentFactory.getInstance()
			.createTitle("New JGoodies title");
	private JTextField txtTest;
	private JTextField inputNewValueField;

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
		getContentPane().setLayout(
				new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

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
		
		JScrollPane consolePanel = new JScrollPane();
		consolePanel.setBounds(12, 307, 255, 143);
		panel.add(consolePanel);
		
		JTextArea consoleMessage = new JTextArea();
		consolePanel.setViewportView(consoleMessage);

		JTabbedPane classMamberpane = new JTabbedPane();
		classMamberpane.setBackground(new Color(204, 153, 255));

		JPanel cstTabPanel = new JPanel();
		cstTabPanel.setBackground(new Color(204, 153, 255));

		JPanel methodTabPanel = new JPanel();
		methodTabPanel.setBackground(new Color(204, 153, 255));
		methodTabPanel.setLayout(null);

		JPanel fieldTabPanel = new JPanel();
		fieldTabPanel.setBackground(new Color(204, 153, 255));

		classMamberpane.addTab("Cst", cstTabPanel);
		cstTabPanel.setLayout(null);

		JList cstList = new JList();
		cstList.setBounds(12, 10, 307, 97);
		cstTabPanel.add(cstList);

		JList argList = new JList();
		argList.setBounds(12, 130, 307, 215);
		cstTabPanel.add(argList);
		
		JButton cstCreateBtn = new JButton("create");
		cstCreateBtn.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 16));
		cstCreateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cstCreateBtn.setBounds(95, 366, 112, 43);
		cstTabPanel.add(cstCreateBtn);
		classMamberpane.addTab("Field", fieldTabPanel);
		fieldTabPanel.setLayout(null);
		
		JLabel fieldLabel = new JLabel("Field List");
		fieldLabel.setBounds(12, 10, 127, 22);
		fieldTabPanel.add(fieldLabel);
		
		JList fieldList = new JList();
		fieldList.setBounds(12, 42, 307, 210);
		fieldTabPanel.add(fieldList);
		
		inputNewValueField = new JTextField();
		inputNewValueField.setText("input new value");
		inputNewValueField.setBounds(12, 262, 307, 29);
		fieldTabPanel.add(inputNewValueField);
		inputNewValueField.setColumns(10);
		
		JButton filedUpdatBtn = new JButton("update");
		filedUpdatBtn.setBounds(116, 313, 91, 21);
		fieldTabPanel.add(filedUpdatBtn);
		classMamberpane.addTab("Method", methodTabPanel);
		
		JLabel lblMethodList = new JLabel("Method List");
		lblMethodList.setBounds(12, 10, 143, 22);
		methodTabPanel.add(lblMethodList);
		
		JList list = new JList();
		list.setBounds(12, 42, 307, 146);
		methodTabPanel.add(list);
		
		JButton executeBtn = new JButton("execute");
		executeBtn.setBounds(105, 395, 121, 28);
		methodTabPanel.add(executeBtn);
		
		JButton btnSelect = new JButton("select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelect.setBounds(122, 198, 91, 21);
		methodTabPanel.add(btnSelect);
		
		JList list_1 = new JList();
		list_1.setBounds(12, 229, 307, 164);
		methodTabPanel.add(list_1);

		getContentPane().add(classMamberpane);

		JTabbedPane listDisp = new JTabbedPane(JTabbedPane.TOP);
		classMamberpane.addTab("ListDisp", null, listDisp, null);
	}

	private JPanel createListElemment(String className) {
		JPanel args = new JPanel();
		args.setBounds(12, 352, 197, 44);
		args.setLayout(new GridLayout(1, 2));

		JLabel argType = new JLabel(className);
		argType.setBounds(0, 0, 140, 44);
		args.add(argType);

		argValue = new JTextField();
		argValue.setBounds(137, 0, 60, 44);
		args.add(argValue);
		argValue.setColumns(10);

		return args;
	}

	private void viewParam(JList targetList, Class[] params) {
		targetList.removeAll();
		if (params.length == 0) {
			targetList.add(new JLabel(""));
		}

		for (int i = 0; i < params.length; i++) {
			Class clazz = params[i];
			targetList.add(createListElemment(clazz.getName()));
		}

	}
}
