
public class ChangeNum {
	public static String addDot(String num){
		String result = "";
		int i = num.length() % 3;
		int j = 0;
		result = num.substring(0, i) ;
		while(i < num.length()){
			if (0 == (j % 3) && i != 0)
				result = result.concat(",");
			result = result.concat(String.valueOf(num.charAt(i++)));
			j++;
		}
		return result;
	}

	public static void main(String[] args) {
		String test= "32323232";
		test = ChangeNum.addDot(test);
		System.out.println(test);



	}

}
