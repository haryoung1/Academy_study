<<<<<<< HEAD
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>동전이 있는곳을 맞춰봐</header>
	<%
	int num = Integer.parseInt(request.getParameter("num"));
	int random = (int) (Math.random() * 3 + 1);
	if (num != random) {
		String msg = 
				"Wrong! Try Again!<br> (" + num + "은(는) 아니고 정답은 " + random + ")";

		msg = URLEncoder.encode(msg,"utf-8");
		response.sendRedirect("exam.jsp?msg=" + msg);
	}
	%>
	<h2>
		정답 입니다!<br>
		동전이 있던 곳은 <%=num %>번 입니다.
	</h2>
	<h2>
		<button onclick="location.href='exam.jsp'">다시 도전</button>
	</h2>
=======
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String no1 = request.getParameter("no1");
		String no2 = request.getParameter("no2");
		String no3 = request.getParameter("no3");
		
	%>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>