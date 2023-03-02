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
=======
	<!-- 선언부에 선언된 변수는 자동 초기화 -->
	<%!
		String name, id, pw; 
	%>
	<%
		request.setCharacterEncoding("utf-8"); // post방식으로 전송시 추가
		name = request.getParameter("name");
		id   = request.getParameter("id");
		pw	 = request.getParameter("pw");
	%>
	<h2>아이디는 <%=id %></h2>
	<h2>패스워드는 <%=pw %></h2>
	<h2><%=name %>님 반갑습니다</h2>
	<hr>
	<button onclick="history.back();">뒤로 가기</button>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>