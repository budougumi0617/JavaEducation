/*
 * @file
 * @par File Name:
 * PrintQueue.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/28
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


package ex14_02;

public class PrintQueue {
	private SingleLinkQueue<PrintJob> queue =
			new SingleLinkQueue<PrintJob>();
	public synchronized void add(PrintJob j){
		queue.add(j);
		notifyAll();
	}

	public synchronized PrintJob remove()
		throws InterruptedException
		{
			while (queue.size() == 0)
				wait();
			return queue.remove();
		}
}
