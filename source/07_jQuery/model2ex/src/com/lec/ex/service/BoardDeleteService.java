package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;

public class BoardDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.delete(fid);
		if (result == bDao.SUCCESS) {
			request.setAttribute("boaredResult", "글 삭제 성공");
		} else {
			request.setAttribute("boaredResult", "글삭제 실패");
		}
	}

}
