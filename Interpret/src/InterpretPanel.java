import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.ListSelectionListener;

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

	public JTextField inputClassName;
	public JTextField inputInsField;

	public ActionListener actionListener;
	JList cstList;
	JButton btnShow;
	JTextArea consoleMessage;
	JList objectList;
	JButton cstCreateBtn;
	JList methodList;
	DefaultListModel methodListModel;

	JList arrayList;
	JTable fieldParamTable;
	private JButton filedUpdatBtn;
	private JButton executeBtn;
	private JButton btnAddObj;

	private ListSelectionListener listSelectionListener;
	private JScrollPane cstPane;
	private JTable cstParamTable;
	private JTable methodParamTable;
	public JTable arrayParamTable;
	public FunctionReflection fr;
	public JTextField inputObjectNameField;
	public JTextField arraySize;

	public static void main(String[] args) {
		InterpretPanel frame = new InterpretPanel();

		/*
		 * frame.setDefaultCloseOperation(JFrame.
		 * EXIT_ON_CLOSE); frame.setBounds(10, 10,
		 * 660, 500); frame.setTitle("Interpret");
		 * frame.setVisible(true);
		 */
	}

	InterpretPanel() {
		getContentPane().setBackground(new Color(204, 153, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(10, 10, 660, 500);
		setTitle("Interpret");

		fr = new FunctionReflection();
		actionListener = new MyActionListener(this);
		listSelectionListener = new MyListSelectionListener(this);
		setBounds(new Rectangle(0, 22, 700, 500));
		getContentPane().setBounds(new Rectangle(100, 100, 700, 500));
		setFont(new Font("Inconsolata", Font.PLAIN, 12));
		setForeground(new Color(102, 102, 102));
		setTitle("Interpret");
		setBackground(new Color(204, 153, 255));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 291, 462);
		panel.setBackground(new Color(204, 153, 255));
		getContentPane().add(panel);
		panel.setLayout(null);

		inputClassName = new JTextField();
		inputClassName.setText("java.lang.String");
		inputClassName.setBackground(new Color(204, 204, 255));
		inputClassName.setBounds(102, 10, 153, 19);
		panel.add(inputClassName);
		inputClassName.setColumns(10);

		JTabbedPane instansePane = new JTabbedPane(JTabbedPane.TOP);
		instansePane.setBounds(12, 80, 255, 217);
		panel.add(instansePane);

		objectList = new JList(fr.objListModel);
		objectList.setBackground(new Color(204, 204, 255));
		objectList.addListSelectionListener(listSelectionListener);
		instansePane.addTab("Object", null, objectList, null);

		arrayList = new JList(fr.arrayListModel);
		arrayList.setBackground(new Color(204, 204, 255));
		arrayList.addListSelectionListener(listSelectionListener);
		instansePane.addTab("Array", null, arrayList, null);
		instansePane.setBackgroundAt(1, new Color(204, 204, 255));

		JScrollPane consolePanel = new JScrollPane();
		consolePanel.setBounds(12, 307, 255, 143);
		panel.add(consolePanel);

		consoleMessage = new JTextArea();
		consoleMessage.setBackground(new Color(204, 204, 255));
		consolePanel.setViewportView(consoleMessage);

		btnShow = new JButton("show");
		btnShow.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 12));
		btnShow.setBounds(208, 39, 71, 21);
		btnShow.setActionCommand("showCst");
		btnShow.addActionListener(actionListener);
		panel.add(btnShow);

		JLabel className = new JLabel("Class Name");
		className.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 12));
		className.setBounds(12, 10, 90, 22);
		panel.add(className);
		
		arraySize = new JTextField();
		arraySize.setBackground(new Color(204, 204, 255));
		arraySize.setBounds(46, 36, 35, 28);
		panel.add(arraySize);
		arraySize.setColumns(10);
		
		JLabel arraySizeLabel = new JLabel("Size");
		arraySizeLabel.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 12));
		arraySizeLabel.setBounds(12, 42, 46, 16);
		panel.add(arraySizeLabel);
		
		JButton btnCreateArray = new JButton("Create Array");
		btnCreateArray.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 11));
		btnCreateArray.setBounds(85, 36, 111, 29);
		btnCreateArray.setActionCommand("createArray");
		btnCreateArray.addActionListener(actionListener);
		panel.add(btnCreateArray);

		JTabbedPane classMamberpane = new JTabbedPane();
		classMamberpane.setBounds(291, 0, 347, 462);
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

		cstList = new JList();
		cstList.setBounds(12, 10, 307, 97);
		cstList.addListSelectionListener(listSelectionListener);

		cstPane = new JScrollPane();
		cstPane.setBounds(12, 10, 307, 97);
		cstTabPanel.add(cstPane);
		cstPane.getViewport().setView(cstList);

		cstCreateBtn = new JButton("create");
		cstCreateBtn.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 16));
		cstCreateBtn.setActionCommand("create");
		cstCreateBtn.addActionListener(actionListener);
		cstCreateBtn.setBounds(95, 366, 112, 43);
		cstTabPanel.add(cstCreateBtn);

		cstParamTable = new JTable(fr.cstParamTableModel);
		String[] data = { "", "" };
		fr.cstParamTableModel.addRow(data);
		JScrollPane constructorVariablePanel = new JScrollPane(cstParamTable);
		constructorVariablePanel.setLocation(12, 119);
		constructorVariablePanel.setSize(307, 200);
		constructorVariablePanel.setPreferredSize(new Dimension(308, 219));
		cstTabPanel.add(constructorVariablePanel);

		classMamberpane.addTab("Field", fieldTabPanel);
		fieldTabPanel.setLayout(null);

		JLabel fieldLabel = new JLabel("Field List");
		fieldLabel.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 12));
		fieldLabel.setBounds(12, 10, 127, 22);
		fieldTabPanel.add(fieldLabel);

		fieldParamTable = new JTable(fr.fieldParamTableModel);
		JScrollPane fieldPanel = new JScrollPane(fieldParamTable);
		fieldPanel.setLocation(12, 44);
		fieldPanel.setSize(307, 257);
		fieldPanel.setPreferredSize(new Dimension(307, 210));
		fieldTabPanel.add(fieldPanel);

		filedUpdatBtn = new JButton("update");
		filedUpdatBtn.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 12));
		filedUpdatBtn.setBounds(116, 313, 91, 21);
		filedUpdatBtn.setActionCommand("fieldUpdate");
		filedUpdatBtn.addActionListener(actionListener);
		fieldTabPanel.add(filedUpdatBtn);
		classMamberpane.addTab("Method", methodTabPanel);

		JLabel lblMethodList = new JLabel("Method List");
		lblMethodList.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 12));
		lblMethodList.setBounds(12, 10, 143, 22);
		methodTabPanel.add(lblMethodList);

		JScrollPane methodPane = new JScrollPane();
		methodPane.setBounds(12, 29, 307, 180);
		methodTabPanel.add(methodPane);
		methodList = new JList();
		methodList.setBounds(12, 29, 307, 146);
		methodList.addListSelectionListener(listSelectionListener);
		methodTabPanel.add(methodList);
		methodPane.getViewport().setView(methodList);

		executeBtn = new JButton("execute");
		executeBtn.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 12));
		executeBtn.setBounds(105, 388, 121, 28);
		executeBtn.setActionCommand("execute");
		executeBtn.addActionListener(actionListener);
		methodTabPanel.add(executeBtn);

		methodParamTable = new JTable(fr.methodParamTableModel);
		data = new String[] { "", "" };
		fr.methodParamTableModel.addRow(data);
		JScrollPane methodVariablePanel = new JScrollPane(methodParamTable);

		inputObjectNameField = new JTextField("foo");
		inputObjectNameField.setBounds(156, 331, 163, 28);
		cstTabPanel.add(inputObjectNameField);
		inputObjectNameField.setColumns(10);

		JLabel lblObjectName = new JLabel("Object Name");
		lblObjectName.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 12));
		lblObjectName.setBounds(12, 331, 124, 28);
		cstTabPanel.add(lblObjectName);
		methodVariablePanel.setBounds(12, 219, 307, 164);
		methodTabPanel.add(methodVariablePanel);

		getContentPane().add(classMamberpane);

		JPanel arrayListTub = new JPanel();
		arrayListTub.setBackground(new Color(204, 153, 255));
		classMamberpane.addTab("ArrayList", null, arrayListTub, null);
		arrayListTub.setLayout(null);

		arrayParamTable = new JTable(fr.arrayParamTableModel);
		JScrollPane arrayValuePanel = new JScrollPane(arrayParamTable);
		arrayValuePanel.setBounds(12, 10, 297, 268);
		arrayListTub.add(arrayValuePanel);

		inputInsField = new JTextField();
		inputInsField.setBounds(12, 318, 297, 19);
		arrayListTub.add(inputInsField);
		inputInsField.setColumns(10);

		btnAddObj = new JButton("Add Obj");
		btnAddObj.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 12));
		btnAddObj.setBounds(100, 358, 139, 54);
		btnAddObj.setActionCommand("addObj");
		btnAddObj.addActionListener(actionListener);
		arrayListTub.add(btnAddObj);
		
		JLabel lbInputInsField = new JLabel("Input add Object name");
		lbInputInsField.setFont(new Font("ゆたぽん（コーディング）Backsl", Font.PLAIN, 12));
		lbInputInsField.setBounds(12, 288, 209, 24);
		arrayListTub.add(lbInputInsField);
		setVisible(true);
	}

	public JPanel createListElemment(String className) {
		JPanel args = new JPanel();
		args.setLayout(new GridLayout(1, 2));
		// args.setBounds(12, 352, 197, 44);
		// args.setLayout(new GridLayout(1, 2));

		JLabel argType = new JLabel(className);
		// argType.setBounds(0, 0, 140, 44);
		args.add(argType);

		JTextField argValue = new JTextField();
		// argValue.setBounds(137, 0, 60, 44);
		args.add(argValue);
		argValue.setColumns(10);

		return args;
	}

	public void viewParam(JList targetList, Class[] params) {
		targetList.removeAll();

		if (params.length == 0) {
			targetList.add(new JLabel(""));
		}
		targetList.add(new JLabel("testse"));
		for (int i = 0; i < params.length; i++) {
			targetList.add(createListElemment(params[i].toString()));
			targetList.add(new JLabel(params[i].toString()));
		}

	}

	public void viewParam(JPanel targetPanel, Class[] params) {
		targetPanel.removeAll();
		targetPanel.setLayout(new ScrollPaneLayout());
		if (params.length == 0) {
			targetPanel.add(new JLabel(""));
		}
		targetPanel.add(new JLabel("testse"));
		targetPanel.add(new JTextField(""));
		for (int i = 0; i < params.length; i++) {
			targetPanel.add(new JLabel(params[i].getName()));
			targetPanel.add(new JTextField());
		}

	}

	public void outputConsole(String result) {
		consoleMessage.append(result + "\n");
	}
}
