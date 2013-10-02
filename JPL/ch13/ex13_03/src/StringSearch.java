
public class StringSearch {

	public static int countChar(String str, char ch){
		int result = 0;
		int start = str.indexOf(ch);
		while(-1 != start){
			result++;
			start = str.indexOf(ch, start+1);
		}

		return result;
	}

}
