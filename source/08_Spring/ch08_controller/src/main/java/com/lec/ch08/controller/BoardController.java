package com.lec.ch08.controller;

import java.util.ArrayList;

//"board/write" "board/content" "board/list" "board/reply"

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch08.dto.Member;

@Controller
@RequestMapping("board") // 공통 요청경로 (어차피 여기는 board 전용 컨트롤러니까 다른놈들이 올 필요가 없음)

public class BoardController {

	@RequestMapping(value = "write")
	public String write() {
		return "board/write"; // 뷰 : "WEB-INF/views/board/write.jsp"
	}

	@RequestMapping(value = "content") // 조합된 요청경로 : /board/content
	public String content(Model model) { // 매개변수를 model로 만들고
		model.addAttribute("id", "aaa"); // model.addAttribute를 해서 정보를 담았다.
		model.addAttribute("pw", "111");
		Member member = new Member("bbb", "222"); // 객체를 담는것도 가능함
		model.addAttribute("member", member);
		return "board/content"; // 뷰단 : 사용자가 볼 페이지
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(); // 빈 ModelAndView 객체 (mav)
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("aaa", "111"));
		list.add(new Member("bbb", "222"));
		mav.addObject("list", list);
		mav.setViewName("board/list"); // 뷰단 : 사용자가 볼 페이지
		return mav;
	}

	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ModelAndView reply(ModelAndView mav) {
		Member member = new Member("ccc", "111");
		mav.addObject("member", member);
		mav.setViewName("board/reply");
		return mav;
	}
}