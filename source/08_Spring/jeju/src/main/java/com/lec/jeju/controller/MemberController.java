package com.lec.jeju.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.jeju.service.MemberSerivce;
import com.lec.jeju.vo.Member;

@Controller
@RequestMapping(value = "member")
public class MemberController {
	@Autowired
	private MemberSerivce memberService;

	// 회원가입 View
	@RequestMapping(params = "method=join", method = RequestMethod.GET)
	public String join() {
		return "member/join";
	}

	// ID 중복확인
	@RequestMapping(params = "method=idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		model.addAttribute("idConfirmResult", memberService.idConfirm(mid));
		return "member/idConfirm";
	}

	// 회원가입 DB처리
	@RequestMapping(params = "method=join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mDto") Member member, Model model, HttpSession session, MultipartHttpServletRequest mRequest) {
		model.addAttribute("joinResult", memberService.joinMember(member, session, mRequest));
		return "member/login";
	}

	// 로그인 View
	@RequestMapping(params = "method=login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	// 로그인 처리
	@RequestMapping(params = "method=login", method = RequestMethod.POST)
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

	// 로그아웃
	@RequestMapping(params = "method=logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:main.do";
	}

	// 정보수정 View
	@RequestMapping(params = "method=modify", method = RequestMethod.GET)
	public String modify() {
		return "member/modify";
	}

	// 로그인 후 정보수정으로 갈때
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modify1() {
		return "member/modify";
	}

	// 정보수정 처리
	@RequestMapping(params = "method=modify", method = RequestMethod.POST) // 정보수정 처리
	public String modify(@ModelAttribute("mDto") Member member, HttpSession httpSession, Model model) {
		model.addAttribute("modifyResult", memberService.modifyMember(member, httpSession));
		return "forward:main.do";
	}
	// 회원탈퇴 View
}


























