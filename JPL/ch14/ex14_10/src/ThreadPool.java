import java.util.LinkedList;
import java.util.Queue;

/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 */

/**
 * Simple Thread Pool class.
 * 
 * This class can be used to dispatch an Runnable object to be exectued by a
 * thread.
 * 
 * [Instruction] Implement one constructor and three methods. Don't forget to
 * write a Test program to test this class. Pay attention to @throws tags in the
 * javadoc. If needed, you can put "synchronized" keyword to methods. All
 * classes for implementation must be private inside this class. Don't use
 * java.util.concurrent package.
 */
public class ThreadPool {

	private Queue<Runnable> runnableQueue;
	private final int queueMaxSize;
	private Thread threadPool[];
	private Boolean isThreadAvailable;
	private Object threadLock = new Object();

	/**
	 * Constructs ThreadPool.
	 * 
	 * @param queueSize
	 *            the max size of queue
	 * @param numberOfThreads
	 *            the number of threads in this pool.
	 * 
	 * @throws IllegalArgumentException
	 *             if either queueSize or numberOfThreads is less than 1
	 */
	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1) {
			throw new IllegalArgumentException("queueSize was less than 1");
		} else if (numberOfThreads < 1) {
			throw new IllegalArgumentException(
					"numberOfThreads was less than 1");
		} else if (numberOfThreads < numberOfThreads) {
			throw new IllegalArgumentException(
					"queueSize was less than numberOfThreads");
		}
		queueMaxSize = queueSize;
		runnableQueue = new LinkedList<Runnable>();
		threadPool = new Thread[numberOfThreads];
		isThreadAvailable = false;
	}

	/**
	 * Starts threads.
	 * 
	 * @throws IllegalStateException
	 *             if threads has been already started.
	 */
	public void start() {
		synchronized (isThreadAvailable) {
			if (isThreadAvailable) {
				throw new IllegalStateException(
						"Threads has been already started");
			} else {
				isThreadAvailable = true;
			}
		}
	}

	/**
	 * Stop all threads and wait for their terminations.
	 * 
	 * @throws IllegalStateException
	 *             if threads has not been started.
	 */
	public void stop() {
		synchronized (isThreadAvailable) {
			if (!isThreadAvailable) {
				throw new IllegalStateException("threads has not been started");
			} else {
				synchronized (threadPool) {
					Boolean aliveThread = true;
					while (aliveThread) {
						int count = 0;
						for (Thread thread : threadPool) {
							if (thread != null && thread.isAlive()) {
								thread.interrupt();
							} else {
								count++;
							}
						}
						if (count == threadPool.length) {
							aliveThread = false;
						}
					}
				}
				isThreadAvailable = false;
			}
		}
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool. run()
	 * method will be invoked in the thread. If the queue is full, then this
	 * method invocation will be blocked until the queue is not full.
	 * 
	 * @param runnable
	 *            Runnable object whose run() method will be invoked.
	 * 
	 * @throws NullPointerException
	 *             if runnable is null.
	 * @throws IllegalStateException
	 *             if this pool has not been started yet.
	 */
	public synchronized void dispatch(Runnable runnable) {
		if (!isThreadAvailable) {
			throw new IllegalStateException(
					"this pool has not been started yet");
		}
		if (runnable == null) {
			throw new NullPointerException("runnable is null");
		}
		/*
		 * while (runnableQueue.size() > queueMaxSize) { try { wait(); } catch
		 * (InterruptedException e) { e.printStackTrace(); } }
		 */
		synchronized (runnableQueue) {
			runnableQueue.add(runnable);
		}
		synchronized (threadPool) {
			for (Thread thread : threadPool) {
				if (thread == null || !thread.isAlive()) {
					thread = new Thread(runnableQueue.poll());
					thread.start();
					//break;
				}
			}
		}

		notifyAll();
	}
}
