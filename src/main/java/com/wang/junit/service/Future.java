package com.wang.junit.service;

/**
 * future interface
 * @date 2020/9/24 11:17
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
public interface Future<T> {
	/**
	 * blocked to get return result
	 * @return
	 */
	T get() throws InterruptedException;

	/**
	 * get task's state
	 * @return
	 */
	boolean isDone();
}
