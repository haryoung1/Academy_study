package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numStr = request.getParameter("num");
		response.setContentType("text/html; charset=UTF-8");
		if (numStr == null) {
<<<<<<< HEAD
			response.getWriter().print("넘어온 파라미터 없슴");
=======
			response.getWriter().print("넘어온 파라미터가 없습니다");
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
		} else {
			int num = Integer.parseInt(numStr);
			int sum = 0;
			for (int i = 0; i <= num; i++) {
				sum += i;
			}
<<<<<<< HEAD
=======
			
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
			PrintWriter out = response.getWriter(); // 스트림 생성
			out.print("<html>");
			out.print("<head>");
			out.print("<link href=\"/ch03_semiServlet/css/ex2.css\" rel=\"stylesheet\">");
			out.print("</head>");
			out.print("<body>");
<<<<<<< HEAD
			out.print("<h2>1부터 " + num + "까지의 누적합은" + sum + "</h2>");
			out.print("</body>");
			out.print("</html>");
			out.close();

=======
			out.print("<h2>1부터 " + num + "까지의 누적합은 " + sum + "</h2>");
			out.print("</body>");
			out.print("</html>");
			out.close();
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
