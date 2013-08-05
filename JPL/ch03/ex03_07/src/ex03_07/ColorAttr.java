/*
 * @file
 * @par File Name:
 * ColorAttr.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex03_07;

public class ColorAttr extends Attr {
	private ScreenColor myColor;

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}

	public ColorAttr(String name) {
		this(name, "transparent");
	}

	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}

	public Object setValue(Object newValue) {
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}

	public ScreenColor setVlue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	public ScreenColor getColor() {
		return myColor;
	}

	protected void decodeColor() {
		if (getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}

	public boolean equals(ColorAttr ca) {
		return this.getValue().equals(ca.getValue());
	}

	public int hashCode() {
		return getValue().hashCode();
	}

	public static void main(String[] args) {
		ColorAttr red = new ColorAttr("test", "red");
		ColorAttr red2 = new ColorAttr("test", "red");
		ColorAttr blue = new ColorAttr("test", "blue");
		System.out.println(red.hashCode());
		System.out.println(red2.hashCode());
		System.out.println(blue.hashCode());
		System.out.println(red.equals(red2));
		System.out.println(red.equals(blue));
	}
}