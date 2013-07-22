package twoThree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.event.MouseInputListener;

public class Clock extends JWindow implements ActionListener,
		MouseInputListener {
	private static final long serialVersionUID = 1L;
	static String h; // 時を入れる変数を宣言
	static String m; // 分を入れる変数を宣言
	static String s; // 秒を入れる変数を宣言
	private int strWidth = 500;
	private int strHeight = 200;
	private int fontSize = 100;
	public Font fontType;
	private JPopupMenu prpMenu;
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

	public int getFontSize() {
		return fontSize;
	}

	public String getFontName() {
		return fontName;
	}

	class MainPanel extends JPanel implements Runnable {
		Clock owner;
		FontMetrics fo;
		private int x = 100, y = 100;
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
			// System.out.println("__LINE__" + "fontSize = " +
			// owner.getFontSize());
			// System.out.println("paintcomp" + "fontType = "+
			// owner.getFontName());
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
				mainClock.setSize(strWidth - 8, strHeight);
				// System.out.println("Height = " + (int)(strHeight));
				owner.setSize(strWidth - 8, strHeight);
				repaint();
				try {
					Thread.sleep(200); // スリープ1秒
				} catch (InterruptedException e) {
				}
			}
		}
	}

	private String fontName = "Serif";
	MainPanel mainClock;

	// JPanel mainClock;

	Clock(String title) {
		this.setName(title);
		mainClock = new MainPanel(this);
		this.setSize(strWidth, strHeight);
		this.setSize(strWidth, strHeight);
		this.setLayout(new BorderLayout());
		this.add(mainClock, BorderLayout.CENTER);
		this.fontType = new Font(this.fontName, Font.PLAIN, this.fontSize);
		this.prpMenu = createPropMenu(mainClock);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	boolean a = true;

	public static void main(String args[]) {

		// フレーム作成
		Clock clock = new Clock("Shimizu's Clock");
		Thread th = new Thread(clock.mainClock);
		// clock.setSize(clock.strWidth, clock.strHeight);

		clock.setVisible(true);
		clock.setFontColor("WHITE");
		th.start(); // スレッドスタート
	}

	private JPopupMenu createPropMenu(JPanel main) {
		// [Properties]
		JPopupMenu propMenu = new JPopupMenu("Prop");
		// propMenu.addAncestorListener(listener)(this);

		main.add(propMenu);
		// [Font]
		JMenu fontMenu = new JMenu("Font");
		fontMenu.addActionListener(this);
		propMenu.add(fontMenu);
		// [Font]-[Serif]
		JMenuItem fontSerif = new JMenuItem("Serif");
		fontMenu.add(fontSerif);
		// [Font]-[----]
		// menuFile.addSeparator();
		// [Font]-[SansSerif]
		JMenuItem fontSansSerif = new JMenuItem("SansSerif");
		fontMenu.add(fontSansSerif);
		// [FontSize]
		JMenu sizeMenu = new JMenu("FontSize");
		sizeMenu.addActionListener(this);
		propMenu.add(sizeMenu);
		// [FontSize]-[Large]
		JMenuItem fontLarge = new JMenuItem("Large");
		sizeMenu.add(fontLarge);
		// [FontSize]-[Nomal]
		JMenuItem fontNormal = new JMenuItem("Normal");
		sizeMenu.add(fontNormal);
		// [Color]
		JMenu colorMenu = new JMenu("Color");
		propMenu.add(colorMenu);
		// [Color]-[White]
		JMenuItem colorWhite = new JMenuItem("White");
		colorMenu.add(colorWhite);
		// [Color]-[White]
		JMenuItem colorBlack = new JMenuItem("Black");
		colorMenu.add(colorBlack);
		// [BackColor]
		JMenu backColorMenu = new JMenu("BackColor");
		propMenu.add(backColorMenu);
		// [BackColor]-[White]
		JMenuItem backColorWhite = new JMenuItem("White");
		backColorMenu.add(backColorWhite);
		// [BackColor]-[White]
		JMenuItem backColorBlack = new JMenuItem("Black");
		backColorMenu.add(backColorBlack);
		propMenu.addSeparator();
		// [exit]
		JMenuItem closeClock = new JMenuItem("exit");
		propMenu.add(closeClock);

		fontSerif.addActionListener(this);
		fontSansSerif.addActionListener(this);
		fontLarge.addActionListener(this);
		fontNormal.addActionListener(this);
		colorWhite.addActionListener(this);
		colorBlack.addActionListener(this);
		backColorWhite.addActionListener(this);
		backColorWhite.setActionCommand("BackWhite");
		backColorBlack.addActionListener(this);
		backColorBlack.setActionCommand("BackBlack");
		closeClock.addActionListener(this);

		return propMenu;
	}

	public void setFontName(String obj) {
		System.out.println("font name = " + obj);
		this.fontName = obj;
	}

	public void setFontSize(int size) {
		System.out.println("font size = " + size);
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
		if (e.getActionCommand() == "exit") {
			System.exit(0);
		}
		if (e.getActionCommand() == "Serif")
			setFontName(Font.SERIF);
		if (e.getActionCommand() == "SansSerif")
			setFontName(Font.SANS_SERIF);
		if (e.getActionCommand() == "Large")
			setFontSize(150);
		if (e.getActionCommand() == "Normal")
			setFontSize(100);
		if (e.getActionCommand() == "Black")
			setFontColor("BLACK");
		if (e.getActionCommand() == "White")
			setFontColor("WHITE");
		if (e.getActionCommand() == "BackBlack")
			setBackColor("BLACK");
		if (e.getActionCommand() == "BackWhite")
			setBackColor("WHITE");
		fontType = new Font(getFontName(), Font.PLAIN, getFontSize());

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 2 || e.getButton() == 3) {
			this.prpMenu.show(this, e.getX(), e.getY());
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private int newClockX = 0;
	private int newClockY = 0;
	private int oldClockX = 0;
	private int oldClockY = 0;
	String info = "";// デバッグ用の文字列

	public void mouseDragged(MouseEvent e) {
		// 時計がマウスに合わせて動く処理
		if (this.equals(e.getSource())) {
			e.consume();
			Point foo = e.getPoint();
			oldClockX = newClockX;
			oldClockY = newClockY;
			newClockX = foo.x;// - x;
			newClockY = foo.y;// - y;
			System.out.println("Dragged: clockX = " + newClockX + " clockY = "
					+ newClockY);
			// System.out.println("Dragged: X = " + x + " Y = " + y);

			this.mainClock.x += (newClockX - oldClockX);
			this.mainClock.y += (newClockY - oldClockY);
			info = "(" + this.mainClock.x + ":" + this.mainClock.y + ")";
			this.setLocation(this.mainClock.x, this.mainClock.y);
			System.out.println(info);
		}
	}

	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

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
