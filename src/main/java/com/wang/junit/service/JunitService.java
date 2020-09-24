package com.wang.junit.service;

/**
 * TODO
 * @date 2020/9/24 11:34
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
public interface JunitService<T> {
	/**
	 * define a test method
	 * @return
	 */
	T getResult();
}
