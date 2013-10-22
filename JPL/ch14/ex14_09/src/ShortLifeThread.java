
public class ShortLifeThread extends Thread{
	public ShortLifeThread(ThreadGroup g, String name){
		super(g, name);
	}
	public void run(){
		try {
			sleep(40000);
			System.out.println("Thread End :" + getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
