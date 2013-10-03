
public class ChangeNum {
	public static String addDot(String num, int range, char c){
		String result = "";
		int i = num.length() % range;
		int j = 0;
		result = num.substring(0, i) ;
		while(i < num.length()){
			if (0 == (j % range) && i != 0)
				result = result.concat(String.valueOf(c));
			result = result.concat(String.valueOf(num.charAt(i++)));
			j++;
		}
		return result;
	}

	public static void main(String[] args) {
		String test= "32323232";
		test = ChangeNum.addDot(test, 5, '.');
		System.out.println(test);



	}

}
