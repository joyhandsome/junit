package com.wang.junit.service;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

/**
 * define a future service
 * @date 2020/9/24 11:29
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
@Component
public class TaskWorker<T> implements Worker<T> {
	@Override
	public void submit(Runnable runnable) {
		new Thread(() -> {
			System.out.println("runnable");
		}).start();
	}

	@Override
	public Future<T> submit(Callable<T> callable) {
		final FutureService<T> futureService = new FutureService<>();
		new Thread(() -> {
			T result = null;
			try {
				result = callable.call();
				futureService.finish(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		return futureService;
	}
}
