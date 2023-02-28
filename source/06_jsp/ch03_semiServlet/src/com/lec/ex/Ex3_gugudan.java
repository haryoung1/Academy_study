package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.provider.certpath.ResponderId;

@WebServlet("/Ex3")
public class Ex3_gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // 스트림 생성
		out.print("<html>");
		out.print("<head>");
		out.print("<link href=\"/ch03_semiServlet/css/ex2.css\" rel=\"stylesheet\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>" + num + "단 구구단 </h2>");
		for (int i = 1; i <= 9; i++) {
			out.printf("<p>%d x %d = %d </p>", num, i, num * i);
		}
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}