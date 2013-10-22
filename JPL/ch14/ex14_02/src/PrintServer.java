
public class PrintServer implements Runnable {
	private final PrintQueue requests = new PrintQueue();
	public PrintServer(){
		new Thread(this, "worker").start();
	}
	public void run() {

		if("worker".equals(Thread.currentThread().getName())){
			for(;;){
				try {
					realPrint(requests.remove());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else{
			System.out.println("Thread don't current Thread");
		}
	}

	private void realPrint(PrintJob job){
		System.out.println("Print Now");
	}
	public static void main(String[] args){
		PrintServer test = new PrintServer();
		PrintJob testJob = new PrintJob();
		test.requests.add(testJob);

	}
}
