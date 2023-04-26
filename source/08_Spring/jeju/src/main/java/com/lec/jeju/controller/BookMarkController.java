package com.lec.jeju.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.jeju.service.BookMarkService;
import com.lec.jeju.vo.BookMark;

@Controller
@RequestMapping("bookmark")
public class BookMarkController {
	@Autowired
	private BookMarkService bookMarkService;

	@RequestMapping(value = "MyAll", method = RequestMethod.GET)
	public String all(Model model, HttpSession session) {
		String mid = (String) session.getAttribute("mid");
		if (mid == null || mid.equals("")) {
			System.out.println("로그인 안되어있음");
			return "redirect:/main.do";
		} else {
			int hotelCount = bookMarkService.HotelCount(mid, session);
			int ResCount = bookMarkService.ResCount(mid, session);
			int spotCount = bookMarkService.SpotCount(mid, session);
			session.setAttribute("hotelCount", hotelCount);
			session.setAttribute("resCount", ResCount);
			session.setAttribute("spotCount", spotCount);
			model.addAttribute("hotelCount", hotelCount);
			model.addAttribute("ResCount", ResCount);
			model.addAttribute("spotCount", spotCount);
		}
		return "bookmark/bookMarkAll";
	}

	@RequestMapping(value = "hotelList", method = { RequestMethod.GET, RequestMethod.POST })
	public String hotelList(String mid, Model model) {
		List<BookMark> hotelList = bookMarkService.getBookmarkHotelList(mid);
		model.addAttribute("hotelList", hotelList);
		return "bookmark/hotelList";
	}
}
