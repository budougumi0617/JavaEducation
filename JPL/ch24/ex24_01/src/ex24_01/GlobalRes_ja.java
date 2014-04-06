package ex24_01;



public class GlobalRes_ja extends GlobalRes{
	
	
	public Object[][] getContents() {
		return contents;
	}
	
	private static final Object[][] contents =  {
		{GlobalRes.HELLO, "おはよう in ja.java"},
		{GlobalRes.GOODBYE, "さようなら"},
	};
}
