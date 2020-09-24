package com.wang.junit.service;

import java.util.concurrent.Callable;

/**
 * work interface
 * @date 2020/9/24 11:27
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
public interface Worker<T> {
	void submit(Runnable runnable);

	Future<T> submit(Callable<T> callable);
}
