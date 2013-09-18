/*
 * @file
 * @par File Name:
 * Cloack.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package oneTwo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Clock extends Frame implements ActionListener, Runnable {
	/**
	 * Windowを作成し、デジタル時計を描画するJavaアプリケーション フリー素材　http://digilog.client.jp/
	 */
	private static final long serialVersionUID = 1L;
	static String h; // 時を入れる変数を宣言
	static String m; // 分を入れる変数を宣言
	static String s; // 秒を入れる変数を宣言
	private int fontSize = 100;
	FontMetrics fo;
	private int strWidth = 100;
	private int strHeight = 100;
	private Color fontColor = Color.white;
	private Color backColor = Color.black;
	private String fontName = "Serif";

	public void update(Graphics g) {
		paint(g);
	}

	Clock() {
		this.setTitle("Shimizu's Clock");
		this.setSize(strWidth, strHeight);
		MenuBar menuBar = new MenuBar();
		this.setMenuBar(menuBar);
		// [Menu]
		Menu menuMenu = new Menu("Menu");
		menuMenu.addActionListener(this);
		menuBar.add(menuMenu);
		// [Menu]-[Properties]
		MenuItem propMenu = new MenuItem("Prop");
		propMenu.addActionListener(this);
		menuMenu.add(propMenu);
	}

	boolean a = true;

	// インスタンス化
	static Clock f = new Clock();
	static Thread th = new Thread(f);
	static MyProperties propDialog = new MyProperties(f);

	public static void main(String args[]) {
		/*
		 * Toolkit tk = Toolkit.getDefaultToolkit();
		 * tk.addAWTEventListener(WindowSaver.getInstance(),
		 * AWTEvent.WINDOW_EVENT_MASK);
		 */
		// フレーム作成
		f.setVisible(true);
		f.addWindowListener(new CloseWindow());

		// プロパティ画面準備
		propDialog.setResizable(false);
		propDialog.addWindowListener(new CloseDialog(propDialog));

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
				Thread.sleep(500); // スリープ0.5秒
			} catch (InterruptedException e) {
			}
		}
	}

	public void paint(Graphics g) {
		Image offImage = createImage((int) (strWidth * 1.5),
				(int) (strHeight * 1.5));
		Graphics offGraph = offImage.getGraphics();
		offGraph.setFont(new Font(fontName, Font.PLAIN, this.fontSize));
		offGraph.setColor(this.fontColor);
		setBackground(this.backColor);
		offGraph.drawString(h + ":" + m + ":" + s, strWidth / 4,
				(int) (strHeight * 1.1));
		g.drawImage(offImage, 0, 0, this);
		fo = offGraph.getFontMetrics();
		strWidth = fo.stringWidth("00:00:00");
		strHeight = fo.getHeight();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand() == "Prop") {
			propDialog.setSize(400, 200);
			propDialog.setVisible(true);
		}
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
		if (obj.equals("BLACK"))
			return Color.black;
		else if (obj.equals("CYAN"))
			return Color.CYAN;
		else if (obj.equals("DARK_GRAY"))
			return Color.DARK_GRAY;
		else if (obj.equals("GRAY"))
			return Color.GRAY;
		else if (obj.equals("GREEN"))
			return Color.GREEN;
		else if (obj.equals("LIGHT_GRAY"))
			return Color.LIGHT_GRAY;
		else if (obj.equals("MAGENTA"))
			return Color.MAGENTA;
		else if (obj.equals("ORANGE"))
			return Color.ORANGE;
		else if (obj.equals("PINK"))
			return Color.PINK;
		else if (obj.equals("RED"))
			return Color.RED;
		else if (obj.equals("WHITE"))
			return Color.white;
		else if (obj.equals("BLUE"))
			return Color.blue;
		else if (obj.equals("YELLOW"))
			return Color.YELLOW;
		else
			return Color.white;
	}

}
