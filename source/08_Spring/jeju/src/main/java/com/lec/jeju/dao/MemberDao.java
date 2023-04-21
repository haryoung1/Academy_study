package com.lec.jeju.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lec.jeju.vo.Member;

@Mapper
public interface MemberDao {
	public int idConfirm(String mid);

	public int joinMember(Member member);

	public int loginCheck(Member member);

	public Member getDetailMember(String mid);

	public int modifyMember(Member member);

	public int DeleteMember(Member member);

	public int getReview(String mid);

	public int getSoptComment(String mid);

	public int getResComment(String mid);

	public int getHotelComment(String mid);

	public int bookmarkSpot(String mid);

	public int bookmarkRes(String mid);

	public int bookmarkHotel(String mid);
}
