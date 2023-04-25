package com.lec.jeju.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.jeju.vo.BookMark;

@Mapper
public interface BookMarkDao {
	// 호텔 북마크 추가
	int insertHotelMark(BookMark bookmark);

	// 식당 북마크 추가

	int insertResMark(BookMark bookmark);

	// 관광지 북마크 추가

	int insertSpotMark(BookMark bookmark);

	// 호텔 북마크 삭제

	int deleteHotelMark(String mid, String hname);

	// 식당 북마크 삭제

	int deleteResMark(String mid, String rname);

	// 관광지 북마크 삭제

	int deleteSpotMark(String mid, String sname);

	// 북마크한 리스트중 호텔만 출력

	List<BookMark> selectBookmarkHotel(String mid);

	// 북마크한 리스트중 식당만 출력

	List<BookMark> selectBookmarkRes(String mid);

	// 북마크한 리스트중 관광지만 출력
	List<BookMark> selectBookmarkSpot(String mid);
}
