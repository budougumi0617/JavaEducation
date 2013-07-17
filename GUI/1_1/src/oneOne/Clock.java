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

import java.awt.*;
import java.awt.event.*;
import java.awt.Image.*;
import java.util.Calendar;



public class Clock extends Frame implements ActionListener,Runnable{
	/**
	 *  Windowを作成し、デジタル時計を描画するJavaアプリケーション
	 *  フリー素材　http://digilog.client.jp/
	 */
	private static final long serialVersionUID = 1L;
		static String h;           //時を入れる変数を宣言
		static String m;           //分を入れる変数を宣言
		static String s;           //秒を入れる変数を宣言
		private int fontSize = 100;
		FontMetrics fo;
		private int strWidth = 100;
		private int strHeight = 100;
		private Color fontColor = Color.white;
		private Color backColor = Color.black;
		private String fontName = "Serif";

		public void update(Graphics g){
		    paint(g);
		}
		Clock(){
			this.setTitle("Shimizu's Clock");
			this.setSize(strWidth,strHeight);

		}

		boolean a = true;

		//インスタンス化
		static Clock f = new Clock();
		static Thread th = new Thread(f);




		public static void main(String args[])
		{

			//フレーム作成
			f.setVisible(true);
			f.addWindowListener(new CloseWindow());


			th.start();   //スレッドスタート
		}
		public void run(){
			while(a==true){
				h = String.format("%1$02d", Calendar.getInstance().get(Calendar.HOUR_OF_DAY)); //時を代入
				m = String.format("%1$02d", Calendar.getInstance().get(Calendar.MINUTE));      //分を代入
				s= String.format("%1$02d", Calendar.getInstance().get(Calendar.SECOND));       //秒を代入

				f.setSize((int)(strWidth*1.5), (int)(strHeight*1.5) );
				repaint();

				try
				{
					Thread.sleep(500);  //スリープ0.5秒
				}catch(InterruptedException e){
				}
			}
		}
	public void paint(Graphics g)
	{
		Image offImage = createImage((int)(strWidth*1.5), (int)(strHeight*1.5) );
		Graphics offGraph = offImage.getGraphics();
		offGraph.setFont(new Font(fontName , Font.PLAIN , this.fontSize));
		offGraph.setColor(this.fontColor);
		setBackground(this.backColor);
		offGraph.drawString(h+":"+m+":"+s,strWidth/4,(int)(strHeight*1.1));
		g.drawImage(offImage, 0, 0, this);
		fo = offGraph.getFontMetrics();
		strWidth = fo.stringWidth("00:00:00");
		strHeight = fo.getHeight();
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
    }


}
