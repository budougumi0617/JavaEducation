
public class PingPong extends Thread {

	private String word;
	private int delay;

	public PingPong(String whatToSay, int delayTime){
		word = whatToSay;
		delay = delayTime;
	}

	public void run(){
		try{
			for(;;){
				System.out.println(word + " ");
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(delay);
			}
		} catch (InterruptedException e){
			return;
		}
	}

	public static void main(String[] args) {
		new PingPong("ping", 3300).start();
		new PingPong("PONG", 10000).start();
		System.out.println("main thread name = : " + Thread.currentThread().getName());
	}

}
