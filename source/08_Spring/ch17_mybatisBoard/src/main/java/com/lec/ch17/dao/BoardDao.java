package com.lec.ch17.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch17.dto.Board;

@Mapper
public interface BoardDao {
	public List<Board> boardList(Board board);

	public int totCnt();

	public Board write(Board board);

	public int hitup(int bid);

	public Board detail(int bid);

	public int modify(Board board);

	public int delete(int bid);
	
	public int boardReplyPreStep(Board board);
	
	public int boardReply(Board board);
}