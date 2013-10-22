

public class ExcecuteAddNumber extends Thread{

	private MultiThreadAddNumber result;
	private int number = 0;

	ExcecuteAddNumber(int number, MultiThreadAddNumber obj){
		this.number = number;
		this.result = obj;
	}

	public void run(){
		try {
			result.addNumber(100);
			for(;;){
				result.subNumber(number);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e){
			return;
		}
	}

	public static void main(String[] args) {
		MultiThreadAddNumber result = new MultiThreadAddNumber();
		ExcecuteAddNumber threadA = new ExcecuteAddNumber(3, result);
		ExcecuteAddNumber threadB = new ExcecuteAddNumber(5, result);
		threadA.start();
		threadB.start();

	}

}
