package com.lec.ch09.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch09.vo.MemberDto;

@Controller
@RequestMapping("member") // 공통요청 경로
public class MemberController {
	// 모든 요청 경로의 jsp 페이지
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}

	@ModelAttribute("list")
	public ArrayList<String> list() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		return list;
	}

	@RequestMapping(value = "join1", method = RequestMethod.GET) // ★ 1번 방법 파일첨부 할때 씀 ★
	public String join(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}

	@RequestMapping(value = "join2", method = RequestMethod.GET) // 2번 방법도 마찬가지로 매우 입력할게 많아서 비효율적이다.
	public String join2(@RequestParam("name") String membername, @RequestParam("id") String memberId,
			@RequestParam("pw") String memberPW, @RequestParam("age") int memberAge,
			@RequestParam("email") String memberEmail, @RequestParam("address") String memberAddress, Model model) {
		model.addAttribute("name", membername);
		model.addAttribute("id", memberId);
		model.addAttribute("pw", memberPW);
		model.addAttribute("age", memberAge);
		model.addAttribute("email", memberEmail);
		model.addAttribute("address", memberAddress);
		return "member/result1";
	}

	@RequestMapping(value = "join3", method = RequestMethod.GET) // ★ 3번 방법 : ex 로그인 처리 할때
	public String join3(String name, String id, String pw, int age, String email, String address, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}

//	@RequestMapping(value = "join4", method = RequestMethod.GET) // 상위호환 방법이 있어서 잘 사용 안함.
//	public String join4(String name, String id, String pw, int age, String email, String address, Model model) {
//		MemberDto member = new MemberDto();
//		member.setName(name);
//		member.setId(id);
//		member.setPw(pw);
//		member.setAge(age);
//		member.setEmail(email);
//		member.setAddress(address);
//		model.addAttribute("member", member);
//		return "member/result4";
//	}
	@RequestMapping(value = "join4", method = RequestMethod.GET)
	public String join4(MemberDto memberDto, Model model) {
		model.addAttribute("member", memberDto);
		return "member/result4";
	}

	@RequestMapping(value = "join5")
	public String join5(MemberDto memberDto) { // ★ 제일 많이 사용하는 방법
		return "member/result5";
	}

	@RequestMapping(value = "join6")
	public String join6(@ModelAttribute("member") MemberDto memberDto) {
		return "member/result4";
	}
}
