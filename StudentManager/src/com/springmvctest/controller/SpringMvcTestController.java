package com.springmvctest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMvcTestController {
	private static final String SUCCESS = "success";

	@RequestMapping("/testCookiValue")
	public String testCookiValue() {
		System.out.println("testCookiValue");
		return SUCCESS;

	}
}
