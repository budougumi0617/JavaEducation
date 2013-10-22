
public class ShowMessageEverySecX extends Thread{
	private final int secX;
	private static int countSec = 0;

	public ShowMessageEverySecX(int milliSec){
		secX = milliSec;
	}

	public void run(){
		try {
			System.out.println("start!!");
			this.printElapsedTime();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void printElapsedTime() throws InterruptedException{

			while(true){
				wait();
				if((this.getCountSec() % secX )== 0)
					System.out.println("Elapsed time:  " + this.getCountSec());
			}
	}

	private synchronized void countSec() {
		try {
			wait(1000);
			countSec++;
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private int getCountSec() {
		return ShowMessageEverySecX.countSec;
	}


	public static void main(String[] args){
		ShowMessageEverySecX threadA = new ShowMessageEverySecX(5);
		ShowMessageEverySecX threadB = new ShowMessageEverySecX(7);
		threadA.start();
		threadB.start();
		for(;;){
			threadA.countSec();
			System.out.println(threadB.getCountSec());
		}


	}
}
