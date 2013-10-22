/*
 * @file
 * @par File Name:
 * Clock.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package oneThree;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;

public class Clock extends Window implements ActionListener, Runnable,
		MouseListener, MouseMotionListener {
	/**
	 * Windowを作成し、デジタル時計を描画するJavaアプリケーション フリー素材　http://digilog.client.jp/
	 */
	private static final long serialVersionUID = 1L;
	static String h; // 時を入れる変数を宣言
	static String m; // 分を入れる変数を宣言
	static String s; // 秒を入れる変数を宣言
	static private int clockX = 0;
	static private int clockY = 0;
	private int x, y;
	private int tx, ty;
	private int fontSize = 100;
	FontMetrics fo;
	private int strWidth = 100;
	private int strHeight = 100;
	private Color fontColor = Color.white;
	private Color backColor = Color.black;
	private String fontName = "Serif";
	private Toolkit tk = getToolkit();
	private Dimension dim;
	private PopupMenu propMenu = new PopupMenu("Menu");

	public void update(Graphics g) {
		paint(g);
	}

	Clock() {
		super(new Frame());
		dim = tk.getScreenSize();
		this.setLocation(dim.width / 2, dim.height / 2);
		this.setName("Shimizu's Clock");
		this.setSize(strWidth, strHeight);
		addMouseListener(this);
		add(propMenu);
		// [Font]
		Menu fontMenu = new Menu("Font");
		fontMenu.addActionListener(this);
		propMenu.add(fontMenu);
		// [Font]-[Serif]
		MenuItem fontSerif = new MenuItem("Serif");
		fontMenu.add(fontSerif);
		// [Font]-[----]
		// menuFile.addSeparator();
		// [Font]-[SansSerif]
		MenuItem fontSansSerif = new MenuItem("SansSerif");
		fontMenu.add(fontSansSerif);
		// [FontSize]
		Menu sizeMenu = new Menu("FontSize");
		sizeMenu.addActionListener(this);
		propMenu.add(sizeMenu);
		// [FontSize]-[Large]
		MenuItem fontLarge = new MenuItem("Large");
		sizeMenu.add(fontLarge);
		// [FontSize]-[Nomal]
		MenuItem fontNormal = new MenuItem("Normal");
		sizeMenu.add(fontNormal);
		// [Color]
		Menu colorMenu = new Menu("Color");
		propMenu.add(colorMenu);
		// [Color]-[White]
		MenuItem colorWhite = new MenuItem("White");
		colorMenu.add(colorWhite);
		// [Color]-[White]
		MenuItem colorBlack = new MenuItem("Black");
		colorMenu.add(colorBlack);
		// [BackColor]
		Menu backColorMenu = new Menu("BackColor");
		propMenu.add(backColorMenu);
		// [BackColor]-[White]
		MenuItem backColorWhite = new MenuItem("White");
		backColorMenu.add(backColorWhite);
		// [BackColor]-[White]
		MenuItem backColorBlack = new MenuItem("Black");
		backColorMenu.add(backColorBlack);
		propMenu.addSeparator();
		// [exit]
		MenuItem closeClock = new MenuItem("exit");
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
		addMouseMotionListener(this);
	}

	boolean a = true;

	// インスタンス化
	static Clock f = new Clock();
	static Thread th = new Thread(f);

	public void mouseClicked(MouseEvent e) {
		if (e.isPopupTrigger())
			propMenu.show(this, e.getX(), e.getY());
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public static void main(String args[]) {

		// フレーム作成
		f.setVisible(true);
		f.addWindowListener(null);

		th.start(); // スレッドスタート
	}

	public void run() {
		while (a == true) {
			h = String.format("%1$02d",
					Calendar.getInstance().get(Calendar.HOUR_OF_DAY)); // 時を代入
			m = String.format("%1$02d",
					Calendar.getInstance().get(Calendar.MINUTE)); // 分を代入
			s = String.format("%1$02d",
					Calendar.getInstance().get(Calendar.SECOND)); // 秒を代入

			f.setSize((int) (strWidth * 1.5), (int) (strHeight * 1.5));
			repaint();

			try {
				Thread.sleep(100); // スリープ0.5秒
			} catch (InterruptedException e) {
			}
		}
	}

	String info = "";// デバッグ用の文字列

	public void paint(Graphics g) {
		// this.setLocation(dim.width / 2 , dim.height / 2);

		// this.setBounds(clockX, clockY, (int)(strWidth*1.5),
		// (int)(strHeight*1.5) );
		System.out.println("paint: clockX = " + clockX + " clockY = " + clockY);

		Image offImage = createImage((int) (strWidth * 1.5),
				(int) (strHeight * 1.5));
		Graphics offGraph = offImage.getGraphics();
		offGraph.setFont(new Font(fontName, Font.PLAIN, this.fontSize));
		offGraph.setColor(this.fontColor);
		setBackground(this.backColor);
		offGraph.drawString(h + ":" + m + ":" + s, strWidth / 4,
				(int) (strHeight * 1));
		g.drawImage(offImage, 0, 0, this);
		fo = offGraph.getFontMetrics();
		strWidth = fo.stringWidth("00:00:00");
		strHeight = fo.getHeight();
		// this.setLocation(clockX, clockY);
		/*
		 * g.setColor(Color.red);
		 * g.drawLine(clockX-7,clockY-7,clockX+7,clockY+7);
		 * g.drawLine(clockX-7,clockY+7,clockX+7,clockY-7);
		 * g.drawString(info,clockX,clockY);
		 */
		g.setColor(Color.black);

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand() == "exit") {
			System.exit(0);
		}
		if (e.getActionCommand() == "Serif")
			this.fontName = "Serif";
		if (e.getActionCommand() == "SansSerif")
			this.fontName = "SansSerif";
		if (e.getActionCommand() == "Large")
			this.fontSize = 100;
		if (e.getActionCommand() == "Normal")
			this.fontSize = 50;
		if (e.getActionCommand() == "Black")
			this.fontColor = Color.black;
		if (e.getActionCommand() == "White")
			this.fontColor = Color.white;
		if (e.getActionCommand() == "BackBlack")
			this.backColor = Color.black;
		if (e.getActionCommand() == "BackWhite")
			this.backColor = Color.white;

	}

	public void setFontName(String obj) {
		this.fontName = obj;
	}

	public void setFontSize(int size) {
		this.fontSize = size;
	}

	public void setFontColor(String obj) {
		this.fontColor = returnColor(obj);
	}

	public void setBackColor(String obj) {
		this.backColor = returnColor(obj);
	}

	public Color returnColor(String obj) {
		if (obj.equals("Black"))
			return Color.black;
		else if (obj.equals("White"))
			return Color.white;
		else if (obj.equals("Blue"))
			return Color.blue;
		else
			return Color.white;
	}

	public void mouseDragged(MouseEvent e) {
		System.out.println("Dragged: clockX = " + clockX + " clockY = "
				+ clockY);
		info = "(" + clockX + ":" + clockY + ")";

	}

	public void mouseMoved(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		if (e.isPopupTrigger()) {
			propMenu.show(this, e.getX(), e.getY());

		}
		clockX = e.getX() - getX();
		clockY = e.getY() - getY();
	}

	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			propMenu.show(this, e.getX(), e.getY());
		} else {
			this.setLocation(e.getX() - clockX, e.getY() - clockY);
		}
	}
}
