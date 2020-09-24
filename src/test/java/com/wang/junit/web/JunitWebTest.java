package com.wang.junit.web;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.wang.junit.controller.DemoController;
import com.wang.junit.controller.DemoRequest;
import com.wang.junit.service.JunitService;

import reactor.core.publisher.Mono;

/**
 * web junit test class
 * @date 2020/9/24 13:18
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
@WebFluxTest(controllers = DemoController.class)
public class JunitWebTest {
	@Autowired
	private WebTestClient client;

	@MockBean
	private JunitService<String> junitService;

	@Test
	public void testString() throws Exception {
		this.client.get().uri("/demo/string").exchange()
			.expectStatus().isOk()
			.expectBody(String.class).isEqualTo("string");
	}

	@Test
	public void testInt() {
		this.client.get().uri("/demo/int/{value}", 100).exchange()
			.expectStatus().isOk()
			.expectBody(Integer.class).isEqualTo(100);
	}

	@Test
	public void testJson() {
		DemoRequest request = new DemoRequest().setString("string")
			.setValue(100)
			.setValue2(200);
		DemoRequest requestResult = new DemoRequest().setString("string")
			.setValue(100)
			.setValue2(200);
		this.client.post().uri("/demo/json")
			.header(HttpHeaders.CONTENT_TYPE, "application/json")
			.body(Mono.just(request),DemoRequest.class)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk()
			.expectBody(DemoRequest.class).isEqualTo(requestResult);
	}

	@Test
	public void testService() {
		DemoRequest request = new DemoRequest().setString("string")
			.setValue(100)
			.setValue2(200);
		DemoRequest requestResult = new DemoRequest().setString("callable")
			.setValue(100)
			.setValue2(200);
		BDDMockito.given(junitService.getResult()).willReturn("callable");
		this.client.post().uri("/demo/service")
			.header(HttpHeaders.CONTENT_TYPE, "application/json")
			.body(Mono.just(request), DemoRequest.class)
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus().isOk()
			.expectBody(DemoRequest.class)
			.isEqualTo(requestResult);
	}

}
