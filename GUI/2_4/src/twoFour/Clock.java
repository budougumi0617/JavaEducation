package twoFour;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

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
	private Preferences prefs = Preferences.systemNodeForPackage(this
			.getClass());
	public int windowPositonX = this.intLoad("windowPositonX", 100);
	public int windowPositonY = this.intLoad("windowPositonY", 100);
	private Toolkit tk;
	private Dimension dim;
	private Point wSize;

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
			g.setFont(new Font(fontName, Font.PLAIN, owner.fontSize));
			this.setBackground(backColor);
			this.setForeground(fontColor);
			this.setFont(fontType);
			owner.setFont(fontType);
			// System.out.println("fontSize = " + owner.getFontSize());
			System.out.println("fontType = " + owner.getFontName());
			g.drawString(h + ":" + m + ":" + s, (int) (strWidth * 0.05),
					(int) (strHeight * 0.5));

		}

		public void run() {
			while (a == true) {
				h = String.format("%1$02d",
						Calendar.getInstance().get(Calendar.HOUR_OF_DAY)); // 時を代入
				m = String.format("%1$02d",
						Calendar.getInstance().get(Calendar.MINUTE)); // 分を代入
				s = String.format("%1$02d",
						Calendar.getInstance().get(Calendar.SECOND)); // 秒を代入
				strWidth = (int) (fontSize * 5 * 1.1);
				strHeight = (int) (fontSize * 1.5);
				if (strHeight < 200)
					strHeight = 200;
				mainClock.setSize(strWidth - 8, strHeight - 16);
				// System.out.println("Height = " + (int)(strHeight));
				owner.setSize(strWidth - 8, strHeight);
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
		prefs = Preferences.systemRoot().node("/gui");
		mainClock = new MainPanel(this);
		wSize = new Point();
		setScreenSize();
		this.setSize(strWidth, strHeight);
		this.setLayout(new BorderLayout());
		this.add(mainClock, BorderLayout.CENTER);
		this.fontType = new Font(this.fontName, Font.PLAIN, this.fontSize);
		this.dialog = new MyProperties(this);
		windowPositonX = this.intLoad("windowPositonX", 100);
		windowPositonY = this.intLoad("windowPositonY", 100);
		this.setLocation(windowPositonX, windowPositonY);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					prefs.putInt("windowPositonX", getX());
					prefs.putInt("windowPositonY", getY());
					System.out.println("end  prefs.putInt(windowPositonX, wsize.x):" + getX());
					System.out.println("end  prefs.putInt(windowPositonY, wsize.y):" + getY());
					prefs.flush();
				} catch (BackingStoreException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void componentMoved(ComponentEvent e) {
				windowPositonX = getX();
				windowPositonY = getY();
				wSize.setLocation(windowPositonX, windowPositonY);
				System.out.println("return getInt() :" + getX()
						+ " Y: " + getY());
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO 自動生成されたメソッド・スタブ

			}
		});
	}

	public void setScreenSize() {
		tk = getToolkit();
		dim = tk.getScreenSize();
		wSize.x = dim.width;
		wSize.y = dim.height;
	}

	boolean a = true;

	public static void main(String args[]) {

		// フレーム作成
		Clock clock = new Clock("Shimizu's Clock");
		Thread th = new Thread(clock.mainClock);
		// clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			return Color.BLACK;
		else if (obj.equals("WHITE"))
			return Color.WHITE;
		else if (obj.equals("BLUE"))
			return Color.BLUE;
		else if (obj.equals("RED"))
			return Color.RED;
		else
			return Color.WHITE;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Prop") {
			dialog.setSize(400, 600);
			dialog.setVisible(true);
		}

	}

	public int intLoad(String key, int def) {
		System.out.println("Get int Data :" + key);
		System.out.println("return getInt() :" + prefs.getInt(key, def));
		return prefs.getInt(key, def);
	}

	public void intSave(String key, int data) {
		System.out.println("Save int Data : " + key);
		try {
			prefs.putInt(key, data);
			prefs.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

}

class FillIcon implements Icon {
	int width, height;
	Color color = Color.BLACK;

	public FillIcon(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}

	public int getIconWidth() {
		return width;
	}

	public int getIconHeight() {
		return height;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
