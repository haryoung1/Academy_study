package com.lec.ch17.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.ch17.dto.Board;

public interface BoardService {
	public List<Board> boardList(String pageNum);

	public int totCnt();

	public Board write(Board board, HttpServletRequest request);
	
	public Board detail(int bid);
	
	public int modify(Board board, HttpServletRequest request);
	
}
