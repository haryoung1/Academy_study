package com.lec.jeju.controller;

import java.util.List;

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
	private BookMarkService bookmarkService;

	@RequestMapping(value = "hotelList", method = { RequestMethod.GET, RequestMethod.POST })
	public String hotelList(String mid, Model model) {
		List<BookMark> hotelList = bookmarkService.getBookmarkHotelList(mid);
		model.addAttribute("hotelList", hotelList);
		return "bookmark/hotelList";
	}
}
