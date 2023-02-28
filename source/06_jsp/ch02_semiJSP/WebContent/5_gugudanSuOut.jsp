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
		int su = Integer.parseInt(request.getParameter("su"));
	%>
	<h2><%=su%>단 구구단
	</h2>
	<%
		for (int i = 1; i < 10; i++) {
	%>
		<p><%=su + " x " + i + " = " + (su*i) %></p>
	<%
		}
	%>
</body>
</html>