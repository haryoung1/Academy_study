package com.lec.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	// 첫실행시 => http:localhost:8090/ch08/ 의 요청처리 로직
	@RequestMapping("/")
	public String home() {
		return "main"; // view 전달 "/WEB-INF/views/" + "main" + ".jsp"
	}
}
