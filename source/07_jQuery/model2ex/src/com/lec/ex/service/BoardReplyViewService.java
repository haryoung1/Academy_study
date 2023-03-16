package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;

public class BoardReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid")); // 원글의 글 번호
		BoardDao bDao = BoardDao.getInstance();
		BoardDto originBoard = bDao.modifyView_replyView(fid);
		request.setAttribute("originBoard", originBoard); // 답변글을 달려는 글의 원글정보


	}

}
