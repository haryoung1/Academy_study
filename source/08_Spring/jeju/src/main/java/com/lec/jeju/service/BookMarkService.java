package com.lec.jeju.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.lec.jeju.vo.BookMark;

public interface BookMarkService {
	List<BookMark> getBookmarkHotelList(String mid);

	List<BookMark> getBookmarkResList(String mid);

	List<BookMark> getBookmarkSpotList(String mid);

	int addHotelBookmark(BookMark bookmark);

	int addResBookmark(BookMark bookmark);

	int addSpotBookmark(BookMark bookmark);

	int deleteHotelBookmark(String mid, String hname);

	int deleteResBookmark(String mid, String rname);

	int deleteSpotBookmark(String mid, String sname);
	
	Integer SpotCount(String mid, HttpSession session);
	
	Integer HotelCount(String mid, HttpSession session);
	
	Integer ResCount(String mid, HttpSession session);
}

