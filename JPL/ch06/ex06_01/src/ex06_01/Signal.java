/*
 * @file
 * @par File Name:
 * Signal.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex06_01;

public enum Signal {
	GREEN("GREEN"),
	YELOW("YELOW"),
	RED("RED");

	String name;
	Signal(String name){ this.name = name; }
	String getColor(){ return this.name; }
}
