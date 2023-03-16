package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.AdminDao;
import com.lec.ex.dto.AdminDto;

public class ALoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		AdminDao aDao = AdminDao.getInstance();
		int result = aDao.loginCheck(aid, apw);
		if (result == AdminDao.LOGIN_SUCCESS) { // 로그인 성공
			HttpSession session = request.getSession();
			AdminDto admin = aDao.getAdmin(aid);
			session.setAttribute("admin", admin);
			request.setAttribute("adminLoginResult", "환영 합니다. 관리자님");
		}else {
			request.setAttribute("adminLoginErrorMsg", "아이디와 비번을 확인하세요");
		}
	}

}
