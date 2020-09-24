package com.wang.junit.service;

/**
 * define a future service
 * @date 2020/9/24 11:19
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
public class FutureService<T> implements Future<T> {
	/**
	 * task's state
	 */
	private static boolean IS_DONE = false;

	private T result;

	@Override
	public T get() throws InterruptedException {
		synchronized (this) {
			if (!IS_DONE) {
				this.wait();
			}
			return result;
		}
	}

	public void finish(T date) {
		synchronized (this) {
			this.result = date;
			IS_DONE = true;
			this.notify();
		}
	}

	@Override
	public boolean isDone() {
		return false;
	}
}
