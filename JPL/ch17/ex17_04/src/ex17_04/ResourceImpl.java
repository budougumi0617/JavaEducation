/**
 * @file
 * @par File Name:
 * ResourceImpl.java
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
public class ResourceImpl implements Resource {
	Object key;
	boolean needsRelease = false;

	/**
	 * 
	 */
	public ResourceImpl(Object key) {
		this.key = key;
		System.out.println("Setting External Resource.");
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see ex17_03.Resource#use(java.lang.Object, java.lang.Object[])
	 */
	public void use(Object key, Object... args) {
		if (this.key.equals(key)) {
			throw new IllegalArgumentException("wrong key");
		}
		System.out.println("Use Resource : ");
		for (Object arg : args) {
			System.out.println(arg.toString());
		}

	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see ex17_03.Resource#release()
	 */
	public synchronized void release() {
		if (needsRelease) {
			needsRelease = false;
			System.out.println("Release Resource");
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
