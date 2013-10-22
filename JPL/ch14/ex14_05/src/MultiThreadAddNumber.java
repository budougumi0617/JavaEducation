
public class MultiThreadAddNumber {

	public static int resultNumber = 0;
	private final Object lockA = new Object();

	MultiThreadAddNumber(){
		resultNumber = 0;
	}

	public void addNumber(int number){
		synchronized(lockA){
			resultNumber += number;
			System.out.println("resultNumber = " + resultNumber);
		}
	}
	public void subNumber(int number){
		synchronized(lockA){
			resultNumber -= number;
			System.out.println("resultNumber = " + resultNumber);
		}
	}

	public int getNumber(){
		synchronized(lockA){
			return resultNumber;
		}
	}

	public int setNumber(int number){
		synchronized(lockA){
			resultNumber = number;
			return resultNumber;
		}
	}

}
