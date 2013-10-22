
public class MultiThreadAddNumber {

	private int resultNumber = 0;

	MultiThreadAddNumber(){
		resultNumber = 0;
	}

	public synchronized void addNumber(int number){
		this.resultNumber += number;
		System.out.println("resultNumber = " + this.resultNumber);
	}

	public synchronized int getNumber(){
		return resultNumber;
	}

	public synchronized int setNumber(int number){
		this.resultNumber = number;
		return resultNumber;
	}

}
