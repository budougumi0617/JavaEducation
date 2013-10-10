package ex12_01;
/*
 * @file
 * @par File Name:
 * ObjectNotFoundException.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/10/03
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
public class ObjectNotFoundException extends Exception{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public final Object objectData;
	ObjectNotFoundException(Object obj){
		super("Not Found named \"" + obj.toString() + "\" found");
		objectData = obj;
	}

}
