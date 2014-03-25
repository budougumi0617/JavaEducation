package ex24_01;



public class GlobalRes_en extends GlobalRes{
	
	
	public Object[][] getContents() {
		return contents;
	}
	
	private static final Object[][] contents =  {
		{GlobalRes.HELLO, "Hello!"},
		{GlobalRes.GOODBYE, "Good bye!"},
	};
}
