/**
 * @file
 * @par File Name:
 * Resource.java
 * @author budougumi0617
 * @date Created on 2014/01/13
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex17_04;

/**
 * @author budougumi0617
 * 
 */
public interface Resource {
	void use(Object key, Object... args);
	void release();
}
