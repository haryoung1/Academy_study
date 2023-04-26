package com.lec.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jeju.dao.BookMarkDao;
import com.lec.jeju.vo.BookMark;

@Service
public class BookMarkServiceImpl implements BookMarkService {
	@Autowired
	private BookMarkDao bookMarkDao;

	@Override
	public List<BookMark> getBookmarkHotelList(String mid) {
		return bookMarkDao.bookmarkHotel(mid);
	}

	@Override
	public List<BookMark> getBookmarkResList(String mid) {
		return bookMarkDao.bookmarkRes(mid);
	}

	@Override
	public List<BookMark> getBookmarkSpotList(String mid) {
		return bookMarkDao.bookmarkSpot(mid);
	}

	@Override
	public int addHotelBookmark(BookMark bookmark) {
		return bookMarkDao.addHotel(bookmark);
	}

	@Override
	public int addResBookmark(BookMark bookmark) {
		return bookMarkDao.addRes(bookmark);
	}

	@Override
	public int addSpotBookmark(BookMark bookmark) {
		return bookMarkDao.addSpot(bookmark);
	}

	@Override
	public int deleteHotelBookmark(String mid, String hname) {
		return bookMarkDao.deleteHotelMark(mid, hname);
	}

	@Override
	public int deleteResBookmark(String mid, String rname) {
		return bookMarkDao.deleteResMark(mid, rname);
	}

	@Override
	public int deleteSpotBookmark(String mid, String sname) {
		return bookMarkDao.deleteSpotMark(mid, sname);
	}

}