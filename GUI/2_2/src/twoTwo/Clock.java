package twoTwo;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Clock extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static String h; // 時を入れる変数を宣言
	static String m; // 分を入れる変数を宣言
	static String s; // 秒を入れる変数を宣言
	private int strWidth = 500;
	private int strHeight = 200;
	private int fontSize = 100;
	public Font fontType;

	private Color fontColor = Color.white;
	private Color backColor = Color.black;
	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public Color getBackColor() {
		return backColor;
	}

	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}

	private MyProperties dialog;

	public int getFontSize() {
		return fontSize;
	}

	public String getFontName() {
		return fontName;
	}

	class MainPanel extends JPanel implements Runnable {
		Clock owner;
		FontMetrics fo;
		private static final long serialVersionUID = 1L;

		public MainPanel(Clock owner) {
			this.owner = owner;
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(fontColor);
			g.setFont(fontType);
			this.setBackground(backColor);
			this.setForeground(fontColor);
			this.setFont(fontType);
			owner.setFont(fontType);
			//System.out.println("fontSize = " + owner.getFontSize());
			//System.out.println("fontType = " + owner.getFontName());
			g.drawString(h + ":" + m + ":" + s, (int)(strWidth * 0.05), (int)(strHeight * 0.5));

		}

		public void run() {
			while (a == true) {
				h = String.format("%1$02d",
						Calendar.getInstance().get(Calendar.HOUR_OF_DAY)); // 時を代入
				m = String.format("%1$02d",
						Calendar.getInstance().get(Calendar.MINUTE)); // 分を代入
				s = String.format("%1$02d",
						Calendar.getInstance().get(Calendar.SECOND)); // 秒を代入
				strWidth = (int)(fontSize * 5 * 1.1);
				strHeight = (int)(fontSize * 1.5);
				if(strHeight < 200) strHeight = 200;
				mainClock.setSize(strWidth-8, strHeight-16);
				//System.out.println("Height = " + (int)(strHeight));
				owner.setSize(strWidth-8, strHeight);
				repaint();
				try {
					Thread.sleep(500); // スリープ0.5秒
				} catch (InterruptedException e) {
				}
			}
		}
	}




	private String fontName = "Serif";
	MainPanel mainClock;

	// JPanel mainClock;

	Clock(String title) {
		super(title);
		mainClock = new MainPanel(this);
		this.setSize(strWidth, strHeight);
		this.setSize(strWidth, strHeight);
		this.setLayout(new BorderLayout());
		this.add(mainClock,BorderLayout.CENTER);
		this.fontType = new Font(this.fontName, Font.PLAIN, this.fontSize);
		this.dialog = new MyProperties(this);
	}

	boolean a = true;

	public static void main(String args[]) {

		// フレーム作成
		Clock clock = new Clock("Shimizu's Clock");
		Thread th = new Thread(clock.mainClock);
		clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// clock.setSize(clock.strWidth, clock.strHeight);
		clock.setJMenuBar(clock.createMenu());

		clock.setVisible(true);
		clock.setFontColor("WHITE");
		th.start(); // スレッドスタート
	}

	private JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		// [Menu]
		JMenu menuMenu = new JMenu("Menu");
		menuMenu.addActionListener(this);
		menuBar.add(menuMenu);
		// [Menu]-[Properties]
		JMenuItem propMenu = new JMenuItem("Prop");
		propMenu.addActionListener(this);
		menuMenu.add(propMenu);

		return menuBar;
	}

	public void setFontName(String obj) {
		this.fontName = obj;
	}

	public void setFontSize(int size) {
		this.fontSize = size;
	}

	public void setFontColor(String obj) {
		this.fontColor = returnColor(obj);
		System.out.println("fontColor = " + returnColor(obj));
	}

	public void setBackColor(String obj) {
		this.backColor = returnColor(obj);
		System.out.println("Clock backColor = " + returnColor(obj));
	}

	public Color returnColor(String obj) {
		if (obj.equals("BLACK"))
			return Color.black;
		else if (obj.equals("WHITE"))
			return Color.white;
		else if (obj.equals("BLUE"))
			return Color.blue;
		else
			return Color.white;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Prop"){
			dialog.setVisible(true);
		}

	}
}




