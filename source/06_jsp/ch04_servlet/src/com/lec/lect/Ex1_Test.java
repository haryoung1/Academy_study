package com.lec.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex1")
public class Ex1_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex1_Test() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 글씨 안 꺠지게 해주는 역할
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// name, pw 파라미터로 받아서 브라우저 화면에 출력.
		// 파라미터는 받을때 무조건 String 타입
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		// 만들었으니 이제 화면에 출력.
		response.setContentType("text/html; charset=utf-8"); // 글씨 안 깨지게 해주는 역할
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>이름은 " + name + "</h2>");
		out.println("<h2>비번은 " + pw + "</h2>");
		out.print("</body>");
		out.print("</html>");
		out.close(); // 스트림 닫기 마지막에 꼭 넣어야함.
	}

}
