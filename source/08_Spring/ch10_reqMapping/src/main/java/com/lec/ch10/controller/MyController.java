package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}

//	@RequestMapping(value = "student")
//	public String student(String id, Model model, HttpServletRequest request) {
//		String method = request.getMethod(); // GET 또는 POST
//		model.addAttribute("method", method);
//		model.addAttribute("id", id);
//		return "studentId";
//	}

	@RequestMapping(value = "student", method = RequestMethod.GET)
	public String student(String id, Model model) {
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentId";
	}

	@RequestMapping(value = "student", method = RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView mav) {
		mav.addObject("method", "POST");
		mav.addObject("id", id);
		mav.setViewName("studentId");
		return mav;
	}

	@RequestMapping(value = "studentOk", method = RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}

	@RequestMapping(value = "studentNg", method = RequestMethod.GET)
	public String studentNg() {
		return "studentNg";
	}

	@RequestMapping(value = "studentNg", method = RequestMethod.POST)
	public ModelAndView studentNg(ModelAndView mav) {
		mav.setViewName("studentNg");
		return mav;
	}

	@RequestMapping(value = "idConfirm", method = RequestMethod.POST)
	public String idConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if (id.equals("aaa")) {
			// 제대로 된 id를 입력한 경우 "studentOk.do" 요청
			// return "forward:studentOk.do";
			return "redirect:studentOk.do"; // redirect를 쓸 경우 : POST를 하든 GET방식을 하든, studentOK.do를 무조건 GET 방식으로 요청하게 된다.
		} else {
			// confirm 실패된 id를 입력한 경우 "studentNg.do" 요청
			return "forward:studentNg.do"; // studentNg.do를 idConfirm 요청 방식과 같은 방식으로 요청 (post)
		}
	}

	@RequestMapping(value = "fullPath", method = RequestMethod.GET)
	public String fullPath() {
//		return "redirect:http://www.naver.com";
		return "redirect:http://localhost:8090/ch10/temp/fullPath.jsp";
	}
}
