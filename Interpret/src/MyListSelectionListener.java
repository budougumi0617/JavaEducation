import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

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
			
		}

	}
	void setParam(DefaultTableModel tableModel, Type[] inputTypes){
		for (Type t : inputTypes) {
			Object[] s = { t, "" };
			tableModel.addRow(s);
		}
	}
}
