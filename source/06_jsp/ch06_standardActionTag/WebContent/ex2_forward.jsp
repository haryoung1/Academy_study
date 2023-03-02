<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
	<%-- ex1_forward.jsp?n=1 을 요청할 때 올 페이지 --%>
	<h1>ex2_forward.jsp 페이지 입니다</h1>
=======
	<!-- ex1_forward.jsp?n=1 을 요청할 때 올 페이지 -->
	<h1>ex2_forward.jsp 페이지 입니다.</h1>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
	<%
		String n = request.getParameter("n");
	%>
	<h2>ex1에서 요청한 n : <%=n %></h2>
</body>
</html>