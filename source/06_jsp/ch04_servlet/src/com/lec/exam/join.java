package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwChk = request.getParameter("pwChk");
		String birth = request.getParameter("birth");
		String hobby = request.getParameter("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String maileSend = request.getParameter("maileSend");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.print("<link href=\"/ch04_servlet/css/quiz5.css\" rel=\"stylesheet\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<caption>회원가입정보</caption>");
		out.println("<tr><th>이름 : " + name + "<br></tr></th>");
		out.println("<tr><th>아이디 : " + id + "<br></tr></th>");
		out.println("<tr><th>비번 : " + pw + "<br></tr></th>");
		out.println("<tr><th>생년월일 : " + birth + "<br></tr></th>");
		out.println("<tr><th>취미 : " + hobby + "<br></tr></th>");
		out.println("<tr><th>성별 : " + gender + "<br></tr></th>");
		out.println("<tr><th>이메일 : " + email + "<br></tr></th>");
		out.println("<tr><th>메일수신동의 : " + maileSend + "<br></tr></th>");
		out.println("</table>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}
