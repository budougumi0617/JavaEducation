package twoThree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.event.MouseInputListener;

/**
 * 
 * @author budougumi0617
 * @note JFrameではなくJWindowクラスを使用して、フレーム枠のないデジタル時計にする 。
 *       課題2-2のダイアログ指定できた属性は、マウスの右クリックでポップアップメニューを表示
 *       して、カスケード形式で選択出来るようにする(ダイアログは開かない)。 時計内をマウスの左ボタンでクリックしたまま
 *       、デスクトップ上でウインドウを移動させることができるようにする。
 */
public class Clock extends JWindow implements MouseInputListener,
		ActionListener {
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
			// System.out.println("__LINE__" +
			// "fontSize = " +
			// owner.getFontSize());
			// System.out.println("paintcomp" +
			// "fontType = "+
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
				// System.out.println("Height = "
				// + (int)(strHeight));
				owner.setSize(strWidth - 8, strHeight);
				repaint();
				try {
					Thread.sleep(500); // スリープ1秒
				} catch (InterruptedException e) {
				}
			}
		}
	}

	private String fontName = "Serif";
	MainPanel mainClock;

	// JPanel mainClock;

	Clock(GraphicsConfiguration gc) {
		super(gc);
		mainClock = new MainPanel(this);
		this.setSize(strWidth, strHeight);
		this.setLayout(new BorderLayout());
		this.add(mainClock, BorderLayout.CENTER);
		this.fontType = new Font(this.fontName, Font.PLAIN, this.fontSize);
		this.prpMenu = createPropMenu(mainClock);
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	boolean a = true;

	public static void main(String args[]) {

		// フレーム作成
		Clock clock = new Clock(GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration());
		Thread th = new Thread(clock.mainClock);
		// clock.setSize(clock.strWidth,
		// clock.strHeight);

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
		JMenuItem fontDialog = new JMenuItem("Dialog");
		fontMenu.add(fontDialog);
		JMenuItem fontDialogInput = new JMenuItem("Dialog_input");
		fontMenu.add(fontDialogInput);
		JMenuItem fontMonospaced = new JMenuItem("Monospaced");
		fontMenu.add(fontMonospaced);
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
		JMenuItem colorRed = new JMenuItem("Red");
		colorMenu.add(colorRed);
		JMenuItem colorBlue = new JMenuItem("Blue");
		colorMenu.add(colorBlue);
		JMenuItem colorYellow = new JMenuItem("Yellow");
		colorMenu.add(colorYellow);
		JMenuItem colorPink = new JMenuItem("Pink");
		colorMenu.add(colorPink);
		// [BackColor]
		JMenu backColorMenu = new JMenu("BackColor");
		propMenu.add(backColorMenu);
		// [BackColor]-[White]
		JMenuItem backColorWhite = new JMenuItem("White");
		backColorMenu.add(backColorWhite);
		// [BackColor]-[White]
		JMenuItem backColorBlack = new JMenuItem("Black");
		backColorMenu.add(backColorBlack);
		JMenuItem backColorRed = new JMenuItem("Red");
		backColorMenu.add(backColorRed);
		JMenuItem backColorBlue = new JMenuItem("Blue");
		backColorMenu.add(backColorBlue);
		JMenuItem backColorYellow = new JMenuItem("Yellow");
		backColorMenu.add(backColorYellow);
		JMenuItem backColorPink = new JMenuItem("Pink");
		backColorMenu.add(backColorPink);
		propMenu.addSeparator();
		// [exit]
		JMenuItem closeClock = new JMenuItem("exit");
		propMenu.add(closeClock);

		fontSerif.addActionListener(this);
		fontSansSerif.addActionListener(this);
		fontDialog.addActionListener(this);
		fontDialogInput.addActionListener(this);
		fontMonospaced.addActionListener(this);
		
		fontLarge.addActionListener(this);
		fontNormal.addActionListener(this);
		colorWhite.addActionListener(this);
		colorBlack.addActionListener(this);
		colorBlue.addActionListener(this);
		colorPink.addActionListener(this);
		colorYellow.addActionListener(this);
		colorRed.addActionListener(this);
		backColorWhite.addActionListener(this);
		backColorWhite.setActionCommand("BackWhite");
		backColorBlack.addActionListener(this);
		backColorBlack.setActionCommand("BackBlack");
		backColorRed.addActionListener(this);
		backColorRed.setActionCommand("BackRed");
		backColorBlue.addActionListener(this);
		backColorBlue.setActionCommand("BackBlue");
		backColorYellow.addActionListener(this);
		backColorYellow.setActionCommand("BackYellow");
		backColorPink.addActionListener(this);
		backColorPink.setActionCommand("BackPink");
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
		else if (obj.equals("PINK"))
			return Color.pink;
		else if (obj.equals("RED"))
			return Color.red;
		else if (obj.equals("YELLOW"))
			return Color.yellow;
		else
			return Color.white;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("getActionCommand() " + e.getActionCommand());
		if (e.getActionCommand() == "exit") {
			System.exit(0);
		}
		if (e.getActionCommand() == "Serif")
			setFontName(Font.SERIF);
		if (e.getActionCommand() == "SansSerif")
			setFontName(Font.SANS_SERIF);
		if (e.getActionCommand() == "Dialog")
			setFontName(Font.DIALOG);
		if (e.getActionCommand() == "Dialog_input")
			setFontName(Font.DIALOG_INPUT);
		if (e.getActionCommand() == "Monospaced")
			setFontName(Font.MONOSPACED);
		if (e.getActionCommand() == "Large")
			setFontSize(150);
		if (e.getActionCommand() == "Normal")
			setFontSize(100);
		if (e.getActionCommand() == "Black")
			setFontColor("BLACK");
		if (e.getActionCommand() == "White")
			setFontColor("WHITE");
		if ((e.getActionCommand() == "Pink"))
			setFontColor("PINK");
		if ((e.getActionCommand() == "Blue"))
			setFontColor("BLUE");
		if ((e.getActionCommand() == "Yellow"))
			setFontColor("YELLOW");
		if ((e.getActionCommand() == "Red"))
			setFontColor("RED");
		if (e.getActionCommand() == "BackBlack")
			setBackColor("BLACK");
		if (e.getActionCommand() == "BackWhite")
			setBackColor("WHITE");
		if ((e.getActionCommand() == "BackPink"))
			setBackColor("PINK");
		if ((e.getActionCommand() == "BackBlue"))
			setBackColor("BLUE");
		if ((e.getActionCommand() == "BackYellow"))
			setBackColor("YELLOW");
		if ((e.getActionCommand() == "BackRed"))
			setBackColor("RED");
		fontType = new Font(getFontName(), Font.PLAIN, getFontSize());

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 2 || e.getButton() == 3) {
			this.prpMenu.show(this, e.getX(), e.getY());
		}
	}

	private int newClockX = 0;
	private int newClockY = 0;
	private int oldClockX = 0;
	private int oldClockY = 0;
	String info = "";// デバッグ用の文字列

	public void mousePressed(MouseEvent e) {
		Point foo = e.getLocationOnScreen();
		newClockX = foo.x;
		newClockY = foo.y;

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

	public void mouseDragged(MouseEvent e) {
		// 時計がマウスに合わせて動く処理

		Point foo = e.getLocationOnScreen();
		oldClockX = newClockX;
		oldClockY = newClockY;
		newClockX = foo.x;// - x;
		newClockY = foo.y;// - y;
		System.out.println("Dragged: clockX = " + newClockX + " clockY = "
				+ newClockY);
		System.out.println("Dragged: oldX = " + oldClockX + " oldY = "
				+ oldClockY);

		Point oldPoint = this.getLocationOnScreen();
		this.mainClock.x = oldPoint.x + (newClockX - oldClockX);
		this.mainClock.y = oldPoint.y + (newClockY - oldClockY);
		info = "(" + this.mainClock.x + ":" + this.mainClock.y + ")";

		this.setLocation(this.mainClock.x, this.mainClock.y);

		System.out.println(info);

	}

	public void mouseMoved(MouseEvent e) {
		/*
		 * Point nowPoint = e.getPoint(); oldClockX = newClockX; oldClockY =
		 * newClockY; newClockX = nowPoint.x; newClockY = nowPoint.y;
		 * this.mainClock.x += (newClockX - oldClockX); this.mainClock.y +=
		 * (newClockY - oldClockY);
		 */
		// this.setLocation(this.mainClock.x,
		// this.mainClock.y);

	}
}
