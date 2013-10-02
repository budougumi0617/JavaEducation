
public class StrSearch {

	public int countChar(String str, String s){
		int result = 0;
		int start = str.indexOf(s);
		while(-1 != start){
			result++;
			start = str.indexOf(s, start+1);
		}

		return result;
	}

	public static void main(String args[]){
		String testStr = "testeseeeeetset";
		String targetChar = "es";
		StrSearch testSearch = new StrSearch();
		System.out.println("in [" + testStr + "]:" + targetChar+ " count = " + testSearch.countChar(testStr, targetChar));
		targetChar = "ee";
		System.out.println("in [" + testStr + "]:" + targetChar+ " count = " + testSearch.countChar(testStr, targetChar));
	}

}

