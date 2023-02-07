package com.lec.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex2")
public class Ex2_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 같은 이름의 파라미터 전달 받았을때 (menu, rest)
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		String nation = request.getParameter("nation");
		response.setContentType("text/html; charset=utf-8"); // 글씨 안 깨지게 해주는 역할
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (menu != null) {
			out.println("<h2>선택한 메뉴는 " + Arrays.toString(menu) + "</h2>");
		}else {
			out.println("<h2>선택한 메뉴가 없습니다.</h2>");
		}
		if (rest != null) {
			out.println("<h2>선택한 식당은 " + Arrays.toString(rest) + "</h2>");
		}else {
			out.println("<h2>선택한 식당이 없습니다.</h2>");
		}
		out.println("<h2>선택한 국적은 " + nation + "입니다</h2>");
		out.print("</body>");
		out.print("</html>");
		out.close(); // 스트림 닫기 마지막에 꼭 넣어야함.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}