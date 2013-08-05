package ex06_01;

public enum Signal {
	GREEN("GREEN"),
	YELOW("YELOW"),
	RED("RED");

	String name;
	Signal(String name){ this.name = name; }
	String getColor(){ return this.name; }
}
