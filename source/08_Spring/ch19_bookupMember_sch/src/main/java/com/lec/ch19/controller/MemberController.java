package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.service.MemberService;
import com.lec.ch19.vo.Member;

@Controller
@RequestMapping(value = "member") // 공동 요청경로
public class MemberController {
	@Autowired
	private MemberService memberService;

	// member.do?method=join 회원가입 뷰
	@RequestMapping(params = "method=join", method = RequestMethod.GET)
	public String join() {
		return "member/join";
	}

	// localhost:8090/ch19/member.do?method=idConfirm&mid=bbb 아이디 중복확인
	@RequestMapping(params = "method=idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		model.addAttribute("idConfirmResult", memberService.idConfirm(mid));
		return "member/idConfirm";
	}

	@RequestMapping(params = "method=join", method = RequestMethod.POST) // 회원가입 db 처리
	public String join(@ModelAttribute("mDto") Member member, Model model, HttpSession session) {
		model.addAttribute("joinResult", memberService.joinMember(member, session));
//		return "forward:member.domethod=login"; 에러
//		return "redirect:member.domethod=login"; // 모델에 add 한 joinResult 값이 안들어옴.
		return "member/login";
	}

	@RequestMapping(params = "method=login", method = RequestMethod.GET) // 로그인 뷰
	public String login() {
		return "member/login";
	}

	@RequestMapping(params = "method=login", method = RequestMethod.POST) // 로그인 처리
	public String login(String mid, String mpw, String after, HttpSession httpSession, Model model) {
		String loginResult = memberService.loginCheck(mid, mpw, httpSession);
		if (loginResult.equals("로그인 성공")) {
			return "redirect:" + after;
		} else {
			model.addAttribute("loginResult", loginResult); // redirect 사용불가
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			return "member/login";
		}
	}

	@RequestMapping(params = "method=logout", method = RequestMethod.GET) // 로그아웃
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:main.do";
	}

	@RequestMapping(params = "method=modify", method = RequestMethod.GET) // 정보수정 뷰
	public String modify() {
		return "member/modify";
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET) // 로그인 후 정보수정으로 갈때
	public String modify1() {
		return "member/modify";
	}

	@RequestMapping(params = "method=modify", method = RequestMethod.POST) // 정보수정 처리
	public String modify(@ModelAttribute("mDto") Member member, HttpSession httpSession, Model model) {
		model.addAttribute("modifyResult", memberService.modifyMember(member, httpSession));
		return "forward:main.do";
	}
}
