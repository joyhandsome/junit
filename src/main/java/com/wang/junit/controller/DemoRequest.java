package com.wang.junit.controller;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * demo request
 * @date 2020/9/24 13:22
 * @since JDK 11
 * @version v1.0.0
 * @author wang-junhao
 */
@Data
@Accessors(chain = true)
public class DemoRequest {
	private String string;
	private int value;
	private Integer value2;
}
