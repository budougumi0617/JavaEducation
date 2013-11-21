import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	public static void main(String[] args) {
		InterpretPanel frame = new InterpretPanel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 10, 300, 200);
		frame.setTitle("Interpret");
		frame.setVisible(true);
	}

	InterpretPanel() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		JTabbedPane tabbedpane = new JTabbedPane();

		JPanel tabPanel1 = new JPanel();
		tabPanel1.add(new JButton("button1"));

		JPanel tabPanel2 = new JPanel();
		tabPanel2.add(new JLabel("Name:"));
		tabPanel2.add(new JTextField("", 10));

		tabbedpane.addTab("tab1", tabPanel1);
		tabbedpane.addTab("tab2", tabPanel2);

		getContentPane().add(tabbedpane);
	}
}
