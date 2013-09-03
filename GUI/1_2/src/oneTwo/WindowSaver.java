/*
 * @file
 * @par File Name:
 * WindowsServer.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/09/02
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package oneTwo;

import java.awt.AWTEvent;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.AbstractAction;

/**
 * JAVA SWING HACKS P205 #34
 * 
 * @author Yoichiro Shimizu
 * 
 *         How to Use tk = Toolkit.getDefaultToolkit();
 *         tk.addAWTEventListener(WindowSaver.getInstance(),
 *         AWTEvent.WINDOW_EVENT_MASK);
 * 
 */
public class WindowSaver implements AWTEventListener {
	private static WindowSaver saver;
	private Map<String, Frame> frameMap;
	private Toolkit tk;

	private WindowSaver() {
		frameMap = new HashMap<String, Frame>();
	}

	public static WindowSaver getInstance() {
		if (saver == null) {
			saver = new WindowSaver();
		}
		return saver;
	}

	@Override
	public void eventDispatched(AWTEvent evt) {
		try {
			if (evt.getID() == WindowEvent.WINDOW_OPENED) {
				ComponentEvent cev = (ComponentEvent) evt;
				if (cev.getComponent() instanceof Frame) {
					Frame frame = (Frame) cev.getComponent();
					loadSettings(frame);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}

	}

	public static void loadSettings(Frame frame) throws IOException {
		Properties settings = new Properties();
		settings.load(new FileInputStream("configration.props"));
		String name = frame.getName();
		int x = getInt(settings, name + ".x", 100);
		int y = getInt(settings, name + ".y", 100);
		int w = getInt(settings, name + ".w", 500);
		int h = getInt(settings, name + ".h", 500);
		frame.setLocation(x, y);
		frame.setSize(w, h);
		saver.frameMap.put(name, frame);
		frame.validate();
	}

	public static int getInt(Properties props, String name, int value) {
		String v = props.getProperty(name);
		if (v == null) {
			return value;
		}
		return Integer.parseInt(v);
	}

	public static void saveSettings() throws IOException {
		Properties settings = new Properties();
		settings.load(new FileInputStream("configration.props"));

		for (String name : saver.frameMap.keySet()) {
			Frame frame = saver.frameMap.get(name);
			settings.setProperty(name + ".x", " " + frame.getX());
			settings.setProperty(name + ".y", " " + frame.getY());
			settings.setProperty(name + ".w", " " + frame.getWidth());
			settings.setProperty(name + ".h", " " + frame.getHeight());
		}
		settings.store(new FileOutputStream("configration.props"), null);
	}

	public static void main(String[] args) throws Exception {
		Toolkit tk = Toolkit.getDefaultToolkit();
		tk.addAWTEventListener(WindowSaver.getInstance(),
				AWTEvent.WINDOW_EVENT_MASK);
		final Frame frame = new Frame("Hack X");
		frame.setName("WSTes.main");
		// frame.getContentPane().add(new JButton());
		MenuBar mb = new MenuBar();
		Menu menu = new Menu("File");
		// Case of JMenu, JMenu.add()
		menu.addActionListener(new AbstractAction("Quit") {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					WindowSaver.saveSettings();
					System.exit(0);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		mb.add(menu);
		frame.setMenuBar(mb);
		frame.pack();
		frame.setVisible(true);

	}
}
