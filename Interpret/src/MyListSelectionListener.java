import java.lang.reflect.Constructor;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		fr = new FunctionReflection(mainWindow);
	}

	/*
	 * viewParam(argList, fr.getConstructorParamType((Constructor<?>) cstList
	 * .getSelectedValue()));
	 */

	/*
	 * (非 Javadoc)
	 * 
	 * @see
	 * javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event
	 * .ListSelectionEvent)
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println("List select");
		if (e.getSource().equals(mainWindow.cstList)) {
			System.out.println("cstList");
			mainWindow
					.viewParam(
							mainWindow.cstList,
							fr.getConstructorParamType((Constructor<?>) mainWindow.cstList
									.getSelectedValue()));
		} else if (e.getSource().equals(mainWindow.methodArgList)) {
			System.out.println("method list");
			/*
			 * mainWindow .viewParam( mainWindow.methodModel,
			 * fr.getConstructorParamType((Constructor<?>) mainWindow.cstList
			 * .getSelectedValue()));
			 */
		}

	}

}
