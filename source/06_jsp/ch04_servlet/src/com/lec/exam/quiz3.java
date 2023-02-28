package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz3")
public class quiz3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numStr = request.getParameter("num");
		response.setContentType("text/html; charset=UTF-8");
		if (numStr == null) {
			response.getWriter().print("넘어온 파라미터가 없습니다");
		} else {
			int num = Integer.parseInt(numStr);
			int sum = 0;
			for (int i = 0; i <= num; i++) {
				sum += i;
			}
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<head>");
			out.print("<link href=\"/ch04_servlet/css/quiz3.css\" rel=\"stylesheet\">");
			out.print("</head>");
			out.print("<body>");
			out.print("<h2>1부터 " + num + "까지 누적합은 " + sum + "</h2>");
			out.print("</body>");
			out.print("</html>");
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
