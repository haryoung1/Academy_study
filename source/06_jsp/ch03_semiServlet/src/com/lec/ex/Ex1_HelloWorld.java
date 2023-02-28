package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
@WebServlet(name = "HelloWorld", urlPatterns = { "/HW" })
=======
//@WebServlet(name = "HelloWorld", urlPatterns = { "/HW" })
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
public class Ex1_HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
		System.out.println("doGet 요청");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h1{color:blue;}");

		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요. 첫 Servlet 임다</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

=======
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet 요청");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 스트림 생성
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("h1 {color:blue;}");
		
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요, 첫 Servlet 예제 입니다.</h1>");
		out.println("</body>");		
		out.println("</html>");
		out.close();
	}
	
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost 요청");
		doGet(request, response);
	}
<<<<<<< HEAD

}
=======
}
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
