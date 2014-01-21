import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
 * @file
 * @par File Name:
 * MyChangeLisner.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/20
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

/**
 * @author Yoichiro Shimizu
 * 
 */
public class MyListSelectionListener implements ListSelectionListener {
	InterpretPanel mainWindow;
	FunctionReflection fr;

	/**
	 * 
	 */
	public MyListSelectionListener(InterpretPanel window) {
		mainWindow = window;
		fr = window.fr;
	}

	/*
	 * viewParam(argList,
	 * fr.getConstructorParamType((Constructor<?>)
	 * cstList .getSelectedValue()));
	 */

	/*
	 * (非 Javadoc)
	 * 
	 * @see
	 * javax.swing.event.ListSelectionListener
	 * #valueChanged(javax.swing.event
	 * .ListSelectionEvent)
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println("List select");
		if (e.getSource().equals(mainWindow.cstList)) {
			System.out.println("cstList");
			fr.cstParamTableModel.setRowCount(0);
			Type[] paramList = fr
					.getConstructorParamType((Constructor<?>) mainWindow.cstList
							.getSelectedValue());
			setParam(fr.cstParamTableModel, paramList);

		} else if (e.getSource().equals(mainWindow.methodList)) {
			System.out.println("method list");
			fr.methodParamTableModel.setRowCount(0);

			Type[] paramList = fr.getMethodParamType((Method) fr
					.getMethodMap(mainWindow.methodList.getSelectedValue()
							.toString()));
			for (Type t : paramList) {
				System.out.println(t.toString());
			}
			setParam(fr.methodParamTableModel, paramList);
		} else if (e.getSource().equals(mainWindow.objectList)) {
			System.out.println("method list");
			Method[] methods = fr.getClassMethod(fr.objectMap.get(
					mainWindow.objectList.getSelectedValue()).getClass());
			fr.setMethodMap(methods);
			mainWindow.methodList.setListData(fr.methodSortedList.toArray());
			Object obj = fr.objectMap.get(mainWindow.objectList
					.getSelectedValue());
			List<String> list = fr.getFieldList(obj);
			for (String s : list) {
				System.out.println(s);
				try {
					System.out.println(fr.getField(obj, s));
				} catch (Throwable e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
			}
			setField(fr.fieldParamTableModel, obj, list);
		} else if (e.getSource().equals(mainWindow.arrayList)) {
			System.out.println("array list");
			Object[] array = fr.arrayMap.get(mainWindow.arrayList
					.getSelectedValue());
			int length = array.length;
			fr.arrayParamTableModel.setRowCount(0);
			for (int i = 0; i < length; i++) {
				Object[] result = { i, Array.get(array, i) };
				fr.arrayParamTableModel.addRow(result);
			}

		}

	}

	void setParam(DefaultTableModel tableModel, Type[] inputTypes) {
		for (Type t : inputTypes) {
			Object[] s = null;
			System.out.println(t.getClass() + "isArray = "
					+ ((Class<?>) t).isArray());
			if (((Class<?>) t).isArray()) {
				s = new Object[] { ((Class<?>) t).getComponentType() + "[]", "" };
			} else {
				s = new Object[] { t, "" };
			}
			tableModel.addRow(s);
		}
	}

	void setField(DefaultTableModel tableModel, Object obj,
			List<String> fieldList) {
		fr.fieldParamTableModel.setRowCount(0);
		for (String s : fieldList) {
			try {
				Object[] result = { s, fr.getField(obj, s) };
				tableModel.addRow(result);
			} catch (Throwable e) {
				break;
			}
		}
	}
}
