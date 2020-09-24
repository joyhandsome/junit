package com.wang.junit.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wang.junit.service.JunitService;

/**
 * demo service for test
 * @date 2020/9/24 13:19
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	@Resource
	private JunitService<String> junitService;

	@RequestMapping("/string")

	public String getString() {
		return "string";
	}

	@RequestMapping("/int/{value}")
	public int getInt(@PathVariable("value") int value) {
		return value;
	}

	@RequestMapping("/json")
	public String getJson(@RequestBody DemoRequest request) {
		Gson gson = new Gson();
		return gson.toJson(request);
	}

	@RequestMapping("/service")
	public String getService(@RequestBody DemoRequest request) {
		Gson gson = new Gson();
		String str = junitService.getResult();
		request.setString(str);
		return gson.toJson(request);
	}
}
