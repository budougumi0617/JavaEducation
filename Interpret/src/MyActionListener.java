import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		fr = new FunctionReflection(mainWindow);
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
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

		} else if (cmd.equals("fieldUpdate")) {

		} else if (cmd.equals("execute")) {

		} else if (cmd.equals("select")) {

		}else if (cmd.equals("addObj")) {

		}

	}
}
