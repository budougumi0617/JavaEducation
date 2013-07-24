/*
 * @file
 * @par File Name:
 * Cloack.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package oneOne;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Clock extends Frame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;
	static String hourValue; // 時を入れる変数を宣言
	static String minutsValue; // 分を入れる変数を宣言
	static String secondValue; // 秒を入れる変数を宣言
	private int fontSize = 100;
	FontMetrics fo;
	private int clockDataWidth = 100;
	private int clockDataHeight = 100;
	private Color fontColor = Color.white;
	private Color backColor = Color.black;
	private String fontName = "Serif";

	public void update(Graphics graohInstance) {
		paint(graohInstance);
	}

	Clock() {
		this.setTitle("Shimizu's Clock");
		this.setSize(clockDataWidth, clockDataHeight);

	}

	public static void main(String args[]) {
		Clock mainFrame = new Clock();
		Thread threadInstance = new Thread(mainFrame);
		// フレーム作成
		mainFrame.setVisible(true);
		mainFrame.addWindowListener(new CloseWindow());

		threadInstance.start(); // スレッドスタート
	}
	public void run() {
		while (true) {
			hourValue = String.format("%1$02d",
					Calendar.getInstance().get(Calendar.HOUR_OF_DAY)); // 時を代入
			minutsValue = String.format("%1$02d",
					Calendar.getInstance().get(Calendar.MINUTE)); // 分を代入
			secondValue = String.format("%1$02d",
					Calendar.getInstance().get(Calendar.SECOND)); // 秒を代入

			this.setSize((int) (clockDataWidth * 1.5), (int) (clockDataHeight * 1.5));
			repaint();

			try {
				Thread.sleep(500); // スリープ0.5秒
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		Image offImage = createImage((int) (clockDataWidth * 1.5),
				(int) (clockDataHeight * 1.5));
		Graphics offGraph = offImage.getGraphics();
		offGraph.setFont(new Font(fontName, Font.PLAIN, this.fontSize));
		offGraph.setColor(this.fontColor);
		setBackground(this.backColor);
		offGraph.drawString(hourValue + ":" + minutsValue + ":" + secondValue,
				clockDataWidth / 4, (int) (clockDataHeight * 1.1));
		g.drawImage(offImage, 0, 0, this);
		fo = offGraph.getFontMetrics();
		clockDataWidth = fo.stringWidth("00:00:00");
		clockDataHeight = fo.getHeight();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}

}
