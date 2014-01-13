/**
 * @file
 * @par File Name:
 * ResourceManager.java
 * @author budougumi0617
 * @date Created on 2014/01/13
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */
package ex17_04;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

/**
 * @author budougumi0617 刈り取りスレッドを修正して、すべての割り当てられたリソースが開放されるまで、
 *         シャットダウン後も生き続けるようにしなさい。
 */
public final class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread reaper;
	boolean shutdown = false;

	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		reaper = new ReaperThread();
		reaper.start();

		System.out.println("Initialized Resource...");
	}

	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			reaper.interrupt();
		}
	}

	public synchronized Resource getResource(Object key) {
		if (shutdown) {
			throw new IllegalStateException();
		}
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		return res;

	}

	public class ReaperThread extends Thread {

		public void run() {
			// ReferenceQueueに参照可能なオブジェクトがなくなるまで続行
			while (true) {
				try {
					Reference<?> ref = queue.remove(); // リファレンスがなくなるまで続け
					Resource res = null;
					synchronized (ResourceManager.this) {
						res = refs.get(ref); // Mapの中身を取り出している
						refs.remove(ref);
					}
					res.release();
					ref.clear();
				} catch (InterruptedException ex) {
					// 割り込まれても終了はしない。
					System.out.println("ResourceManager is shutdown.");
				}
				// ReferenceQueueに参照可能なオブジェクトがあるか確認
				if (queue.poll() == null) {
					break;
				}
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
