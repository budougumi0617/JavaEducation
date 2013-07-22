package twoOne;


import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Clock extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	static String h; // 時を入れる変数を宣言
	static String m; // 分を入れる変数を宣言
	static String s; // 秒を入れる変数を宣言
	private int strWidth = 300;
	private int strHeight = 200;
	private int fontSize = 100;
	FontMetrics fo;
	private Color fontColor = Color.white;
	private Color backColor = Color.black;
	private String fontName = "Serif";
	JPanel mainClock;

	Clock(String title) {
		super(title);
		mainClock = new JPanel();
		this.setSize(strWidth, strHeight);
		this.setSize(strWidth,strHeight);
	}

	boolean a = true;

	public static void main(String args[]) {

		// フレーム作成
		Clock clock = new Clock("Shimizu's Clock");
		Thread th = new Thread(clock);
		clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clock.setSize(clock.strWidth, clock.strHeight);
		clock.setJMenuBar(clock.createMenu());
		clock.setVisible(true);

		th.start(); // スレッドスタート
	}

	private JMenuBar createMenu(){
		JMenuBar menuBar = new JMenuBar();
		//[Menu]
		JMenu menuMenu = new JMenu("Menu");
		//menuMenu.addActionListener(this);
		menuBar.add(menuMenu);
		//[Menu]-[Properties]
		JMenuItem propMenu = new JMenuItem("Prop");
		//propMenu.addActionListener(this);
		menuMenu.add(propMenu);
		// [Font]
        JMenu fontMenu = new JMenu("Font");
        //fontMenu.addActionListener(this);
        menuBar.add(fontMenu);
        // [Font]-[Serif]
        JMenuItem fontSerif = new JMenuItem("Serif");
        fontMenu.add(fontSerif);
        // [Font]-[----]
        fontMenu.addSeparator();
        // [Font]-[SansSerif]
        JMenuItem fontSansSerif = new JMenuItem("SansSerif");
        fontMenu.add(fontSansSerif);
        // [FontSize]
        JMenu sizeMenu = new JMenu("FontSize");
        //sizeMenu.addActionListener(this);
        menuBar.add(sizeMenu);
        // [FontSize]-[Large]
        JMenuItem fontLarge = new JMenuItem("Large");
        sizeMenu.add(fontLarge);
        // [FontSize]-[Nomal]
        JMenuItem fontNormal = new JMenuItem("Normal");
        sizeMenu.add(fontNormal);
        // [Color]
        JMenu colorMenu = new JMenu("Color");
        menuBar.add(colorMenu);
        // [Color]-[White]
        JMenuItem colorWhite = new JMenuItem("White");
        colorMenu.add(colorWhite);
     // [Color]-[White]
        JMenuItem colorBlack = new JMenuItem("Black");
        colorMenu.add(colorBlack);
     // [BackColor]
        JMenu backColorMenu = new JMenu("BackColor");
        menuBar.add(backColorMenu);
        // [BackColor]-[White]
        JMenuItem backColorWhite = new JMenuItem("White");
        backColorMenu.add(backColorWhite);
     // [BackColor]-[White]
        JMenuItem backColorBlack = new JMenuItem("Black");
        backColorMenu.add(backColorBlack);
/*
        fontSerif.addActionListener(this);
        fontSansSerif.addActionListener(this);
        fontLarge.addActionListener(this);
        fontNormal.addActionListener(this);
        colorWhite.addActionListener(this);
        colorBlack.addActionListener(this);
        backColorWhite.addActionListener(this);
        */
        backColorWhite.setActionCommand("BackWhite");
        //backColorBlack.addActionListener(this);
        backColorBlack.setActionCommand("BackBlack");

		return menuBar;
	}

	public void run() {
		while (a == true) {
			h = String.format("%1$02d",
					Calendar.getInstance().get(Calendar.HOUR_OF_DAY)); // 時を代入
			m = String.format("%1$02d",
					Calendar.getInstance().get(Calendar.MINUTE)); // 分を代入
			s = String.format("%1$02d",
					Calendar.getInstance().get(Calendar.SECOND)); // 秒を代入

			this.setSize(strWidth, strHeight);

			repaint();
			try {
				Thread.sleep(500); // スリープ0.5秒
			} catch (InterruptedException e) {
			}
		}
	}

	public void paintComponent(Graphics g) {
		mainClock.paintComponents(g);
		g.drawString(h + ":" + m + ":" + s, 30, 30);
	}
	public void setFontName(String obj){
		this.fontName = obj;
	}
	public void setFontSize(int size){
		this.fontSize = size;
	}
	public void setFontColor(String obj){
		this.fontColor = returnColor(obj);
	}
	public void setBackColor(String obj){
		this.backColor = returnColor(obj);
	}
	public Color returnColor(String obj){
		if(obj.equals("Black"))
			return Color.black;
		else if(obj.equals("White"))
			return Color.white;
		else if(obj.equals("Blue"))
			return Color.blue;
		else
			return Color.white;
	}
}
