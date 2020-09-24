package com.wang.junit.service;

import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * define a junit test service
 * @date 2020/9/24 11:35
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
@Service
public class JunitServiceImpl<String> implements JunitService<String> {
	@Resource
	private Worker worker;

	@Override
	public String getResult() {
		Future<String> future = worker.submit((Callable<String>)() -> (String)"callable");
		try {
			return future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
