/*
 * @file
 * @par File Name:
 * Point.java
 * @author Yoichiro Shimizu/R/RSI
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex01_08;

/**
 * @author Yoichiro Shimizu/R/RSI
 *
 */
public class Point {
	public double x, y;
	/**
	 * P14 練習問題 1.8 Pointオブジェクトにメソッドを追加したもの
	 * 追加メソッド：
	 * 渡されたオブジェクトの値からを自分の座標に設定するメソッド
	 */
	public void clear()
	{
		this.x = 0.0;
		this.y = 0.0;
	}
	public double distance(Point that )
	{
		double xdiff = this.x - that.x;
		double ydiff = this.y - that.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}
	public void move(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public void copy(Point that)
	{
		this.x = that.x;
		this.y = that.y;
	}
}
