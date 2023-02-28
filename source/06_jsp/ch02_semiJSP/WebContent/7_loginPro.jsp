<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 선언부에 선언된 변수는 자동 초기화다. -->
	<%!
		String name, id,pw;
	%>
	<%
		request.setCharacterEncoding("utf-8");
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
	%>
	<h2>아이디는 <%=id %></h2>
	<h2>비번은 <%=pw %></h2>
	<h2><%=name %>님 어서오십쇼!</h2>
	<hr>
	<button onclick="history.back();">뒤로가기</button>
</body>
</html>