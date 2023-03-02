<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
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
=======
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% // http://localhost:8090/ch02_semiJSP/5_gugudanSuOut.jsp?su=4
		int su = Integer.parseInt(request.getParameter("su"));
	%>
	<h2><%=su %>단 구구단</h2>
	<%for (int i=1; i<10 ; i++) { %>
		<%-- <p><%=su %> X <%=i %> = <%=su*i %></p> --%>
		<p><%=su + " X " + i + " = " + (su*i) %></p>
	<% } %>

>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>