package cn.wa.net.common.util;

import org.apache.log4j.Logger;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 先进先出队列
 * @author liupd
 * @param <T>
 */
public class FIFOQueue<T> {

	private Logger logger = Logger.getLogger(FIFOQueue.class);

	/**
	 * 队列容量大小
	 */
	private int capability;

	private ConcurrentLinkedQueue<T> msgQueue = new ConcurrentLinkedQueue<T>();

	private Object lock = new Object();

	public FIFOQueue() {
	}

	/**
	 * 返回队列的容量大小
	 * @return
	 */
	public synchronized int capability() {
		return capability;
	}

	/**
	 * 返回当前队列大小
	 * @return
	 */
	public synchronized int size() {
		return msgQueue.size();
	}

	/**
	 * 返回当前队列是否为空
	 * @return
	 */
	public synchronized boolean isEmpty() {
		return (msgQueue.size() <= 0 ? true : false);
	}

	/**
	 * 将指定内容元素message放入队列中
	 * @param message
	 * 指定放入队列中的内容元素
	 */
	public void push(T message) {
		synchronized (lock) {
			msgQueue.add(message);
		}
	}

	/**
	 * 取出队列中第一个内容元素
	 * @return 队列中第一个内容元素
	 */
	public T pop() {
		synchronized (lock) {
			T message = null;
			if (!isEmpty()) {
				message = msgQueue.poll();
				lock.notifyAll();
			}
			return message;
		}
	}

}

