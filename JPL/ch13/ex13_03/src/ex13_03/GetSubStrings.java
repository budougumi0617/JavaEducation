
public class GetSubStrings {
	public static String delimitedString(String from, char start, char end){
		String result;
		int startPos = from.indexOf(start);
		int endPos = from.indexOf(end);
		if (startPos == -1)
			return null;
		else if (endPos == -1)
			return null;
		else if (startPos > endPos)
			return null;
		else {
			result =  from.substring(startPos, endPos+1);

			return result;
		}
	}

	 public static String[] delimitedStrings(String from, char start, char end){
		 int startCount = StringSearch.countChar(from, start);
		 String[] result = new String[startCount];
		 String changeFrom = from;
		 for (int i = 0; i < startCount; ){
			result[i] = delimitedString(changeFrom, start, end);
			changeFrom = changeFrom.substring(changeFrom.indexOf(end)+1);
			if(result[i] != null)
				i++;
		 }
		 return result;
	 }

	 public static void main(String args[]){
		 String testString = "<one><two><<three>><<four>";
		 String[] result = GetSubStrings.delimitedStrings(testString, '<', '>');
		 for ( int i = 0; i < result.length; i++)
			 System.out.println(result[i]);
	 }
}
