package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;

public class BoardModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		BoardDao bDao = BoardDao.getInstance();
		BoardDto bDto = bDao.modifyView_replyView(fid);
		request.setAttribute("board", bDto);

	}

}
