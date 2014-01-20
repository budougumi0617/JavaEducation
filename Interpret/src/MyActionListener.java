import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/*
 * @file
 * @par File Name:
 * MyActionListener.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/12/19
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

/**
 * @author Yoichiro Shimizu
 * 
 */
public class MyActionListener implements ActionListener {
	InterpretPanel mainWindow;
	FunctionReflection fr;

	MyActionListener(InterpretPanel window) {
		mainWindow = window;
		fr = window.fr;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed
	 * (java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		String cmd = evt.getActionCommand();
		System.out.println(mainWindow.inputClassName.getText());
		if (cmd.equals("showCst")) {
			System.out.println("showCst");
			try {
				mainWindow.cstList.setListData(fr.getClassConstractor(Class
						.forName(mainWindow.inputClassName.getText())));

			} catch (ClassNotFoundException e) {
				mainWindow.outputConsole(e.toString());
			}
		} else if (cmd.equals("create")) {
			System.out.println("create");
			Object args[] = fr.getArgs(fr.cstParamTableModel);
			Object createdObj = null;
			try {
				createdObj = fr.makeInstanceByConstructor(
						(Constructor<?>) mainWindow.cstList.getSelectedValue(),
						args);
				fr.putObject(mainWindow.inputObjectNameField.getText(),
						createdObj);

			} catch (Throwable e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				mainWindow.outputConsole(e.getCause().toString());
			}

		} else if (cmd.equals("execute")) {
			System.out.println("execute");
			Object args[] = fr.getArgs(fr.methodParamTableModel);
			try {
				Object obj = fr.objectMap.get(mainWindow.objectList
						.getSelectedValue());
				Method m = fr.methodMap.get(mainWindow.methodList
						.getSelectedValue());
				mainWindow.outputConsole("invoke result : "
						+ fr.methodInvoke(obj, m, args));
			} catch (Throwable e) {
				e.printStackTrace();
				mainWindow.outputConsole("invoke result : " + e.toString());
			}
		} else if (cmd.equals("fieldUpdate")) {
			System.out.println("fieldUpdate");
			Object targetObject = fr.objectMap.get(mainWindow.objectList
					.getSelectedValue());
			String fieldName = fr.fieldParamTableModel.getValueAt(mainWindow.fieldParamTable.getSelectedRow(), 0).toString();
			System.out.println("fieldName : " + fieldName);
			Object value = fr.fieldParamTableModel.getValueAt(mainWindow.fieldParamTable.getSelectedRow(), 1).toString();
			System.out.println("value : " + value);
			try {
				fr.setField(targetObject, fieldName, value);
			} catch (Throwable e) {
				e.printStackTrace();
				mainWindow.outputConsole("Change field result : " + e.toString());
			}
		} else if (cmd.equals("select")) {

		} else if (cmd.equals("addObj")) {

		}

	}
}
