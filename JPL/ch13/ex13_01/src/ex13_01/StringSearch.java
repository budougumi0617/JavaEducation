
public class StringSearch {

	public int countChar(String str, char ch){
		int result = 0;
		int start = str.indexOf(ch);
		while(-1 != start){
			result++;
			start = str.indexOf(ch, start+1);
		}

		return result;
	}

	public static void main(String args[]){
		String testStr = "testestset";
		char targetChar = 'a';
		StringSearch testSearch = new StringSearch();
		System.out.println("in [" + testStr + "]:" + targetChar+ " count = " + testSearch.countChar(testStr, targetChar));
		targetChar = 't';
		System.out.println("in [" + testStr + "]:" + targetChar+ " count = " + testSearch.countChar(testStr, targetChar));
	}

}
