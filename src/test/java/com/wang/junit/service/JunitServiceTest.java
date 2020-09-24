package com.wang.junit.service;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * junit test
 * @date 2020/9/24 11:41
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
@SpringBootTest
public class JunitServiceTest {
	//if a service isn't implement,annotation @MockBean will auto inject service to spring.
	// @MockBean
	// private JunitService<String> junitService;

	@Resource
	private JunitService<String> junitService;

	@Test
	public void testString() {
		//given method simulate a method's return.
		// BDDMockito.given(junitService.getResult()).willReturn("callmock");
		String str = junitService.getResult();
		assert str.equals("callmock");
	}
}
