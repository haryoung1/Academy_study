package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lec.ex.service.*;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);

	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if (command.equals("/main.do")) { // 첫 실행화면
			viewPage = "main/main.jsp";
			
		/* * * * * * * * * * * * * * * * * * * * * * * * * * *  *
		 * * * * * * * * * * * member 관련요청 * * * * * * * *  * 
		 * * * * * * * * * * * * * * * * * * * * * * * * * * *  */
		}else if (command.equals("/midConfirm.do")) { 
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/midConfirm.jsp";
		}else if (command.equals("/memailConfirm.do")) {
			service = new MemailConfirmService();
			service.execute(request, response);
			viewPage = "member/mmailConfirm.jsp";
		}else if (command.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		}else if(command.equals("/join.do")) {
			service = new JoinService();
			service.execute(request, response);
			viewPage = "loginView.do";
		}else if (command.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		}else if (command.equals("/login.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if (command.equals("/logout.do")) {
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * * * * * * * * * * * 어드민 관련요청 * * * * * * * * * * *  
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * * * * * * * * * * * 파일첨부게시판 관련요청 * * * * * * * * * 
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * */	
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	} // actuonDo
} // Controller
