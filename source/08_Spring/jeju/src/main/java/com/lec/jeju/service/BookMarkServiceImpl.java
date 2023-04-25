package com.lec.jeju.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.jeju.dao.BookMarkDao;
import com.lec.jeju.vo.BookMark;

@Service
public class BookMarkServiceImpl implements BookMarkService {
	@Autowired
	private BookMarkDao bookmarkDao;

	@Override
	public int insertHotelMark(BookMark bookmark) {
		return bookmarkDao.insertHotelMark(bookmark);
	}

	@Override
	public int insertResMark(BookMark bookmark) {
		return bookmarkDao.insertResMark(bookmark);
	}

	@Override
	public int insertSpotMark(BookMark bookmark) {
		return bookmarkDao.insertSpotMark(bookmark);
	}

	@Override
	public int deleteHotelMark(String mid, String hname) {
		return bookmarkDao.deleteHotelMark(mid, hname);
	}

	@Override
	public int deleteResMark(String mid, String rname) {
		return bookmarkDao.deleteResMark(mid, rname);
	}

	@Override
	public int deleteSpotMark(String mid, String sname) {
		return bookmarkDao.deleteSpotMark(mid, sname);
	}

	@Override
	public List<BookMark> selectBookmarkHotel(String mid) {
		return bookmarkDao.selectBookmarkHotel(mid);
	}

	@Override
	public List<BookMark> selectBookmarkRes(String mid) {
		return bookmarkDao.selectBookmarkRes(mid);
	}

	@Override
	public List<BookMark> selectBookmarkSpot(String mid) {
		return bookmarkDao.selectBookmarkSpot(mid);
	}
}