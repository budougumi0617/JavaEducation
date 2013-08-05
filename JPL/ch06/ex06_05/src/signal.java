
public enum signal{
	GREEN("GREEN"){
		String getColor(){ return this.name; };
	},
	YELOW("YELOW"){
		String getColor(){ return this.name; };
	},
	RED("RED"){
		String getColor(){ return this.name; };
	};

	String name;
	signal(String name){ this.name = name; }
	abstract String getColor();
}
