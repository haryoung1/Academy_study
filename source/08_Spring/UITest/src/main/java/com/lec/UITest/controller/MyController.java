package com.lec.UITest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.UITest.vo.Member;

@Controller
public class MyController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}

	@RequestMapping(value = "input.do", method = RequestMethod.GET)
	public String input() {
		return "/student/input";
	}

	@RequestMapping(value = "input.do", method = RequestMethod.POST)
	public String result(Member member) {
		return "/student/result";
	}
}
