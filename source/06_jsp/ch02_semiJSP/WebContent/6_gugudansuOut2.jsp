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
		int su1 = Integer.parseInt(request.getParameter("su1"));
	int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<h2><%=su1%>단부터
		<%=su2%>단까지 구구단 출력
	</h2>
	<%
		for (int j = su1; j <= su2; j++) {
	%>
	<%=j%>단
	<%
		}
	%>
	<%
		for (int i = 1; i <= 9; i++) {
	%>
	<p>
		<%
			for (int j = su1; j <= su2; j++) {
		%>
		<%=j + " * " + i + " = " + (j * i)%>
		<%
			}
		%>
		<%
			}
		%>
	</p>
=======
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<style>
	h3 {
	text-align:center;
	}
	td {
	padding : 7px;
	border-left: 1px solid blue;
	border-right: 1px solid blue;
	}
	#back {
	width : 150px; 
	}
	p {
	text-align: center;
	}
</style>
<body>
	<%
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<h3><%=su1 %>단부터  <%=su2 %>단까지 구구단 출력</h3>
	<table>
	<% for (int i=1 ; i<10 ; i++) { %>
		<tr>
	<% for (int j=su1 ; j<=su2 ; j++) { %>
			<td><p><%= j + " x " + i + " = " + (i*j) %></p></td>
	<%} %>
		</tr>
	<%} %>
	</table>
		<form action="6_gugudansuInput2.jsp" method="get">
			<p><input id="back" type="submit" value="뒤로가기"></p>
		</form>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>