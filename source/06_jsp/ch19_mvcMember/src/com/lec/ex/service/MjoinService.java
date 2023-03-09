package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MjoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mphoto = request.getParameter("mphoto");
		String mbirth = request.getParameter("mbirth");
		String maddress = request.getParameter("maddress");
		int result = 0;
		MemberDao mDao = MemberDao.getInstance();
		MemberDto 
		
		// id 중복체크
		if (result == mDao.MEMBER_NONEXISTENT ) {
			MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
		}
	}
}
