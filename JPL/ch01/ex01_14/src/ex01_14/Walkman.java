/*
 * @file
 * @par File Name:
 * Walkman.java
 * @author Yoichiro Shimizu/R/RSI
 * @date Created on 2013/07/17
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex01_14;

/**
 * P23 練習問題 1.14
 * ウォークマン製品のクラス構造の作成
 */
public class Walkman {
	private Plug plug;

	public void setPlug(Plug plug) {

	}

	public Plug getPlug() {
		return this.plug;
	}

	public void Play() {

	}
}

class NewWalkman extends Walkman
{
	private Plug subPlug;

	public void setSubPlug(Plug plug)
	{

	}

	public Plug getSubPlug()
	{
		return this.subPlug;
	}

}

class SpecialWalkman extends NewWalkman
{
	public void talk()
	{

	}
}
