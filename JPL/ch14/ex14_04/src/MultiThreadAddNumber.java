
public class MultiThreadAddNumber {

	public static int resultNumber = 0;

	MultiThreadAddNumber(){
		resultNumber = 0;
	}

	public static synchronized void addNumber(int number){
		resultNumber += number;
		System.out.println("resultNumber = " + resultNumber);
	}

	public static synchronized int getNumber(){
		return resultNumber;
	}

	public static synchronized int setNumber(int number){
		resultNumber = number;
		return resultNumber;
	}

}
