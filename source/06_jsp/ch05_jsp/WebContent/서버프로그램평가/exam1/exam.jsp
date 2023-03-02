<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<body>
	<div class="btn">
	<header>동전이 있는곳을 맞춰봐</header>
	<form action="examPro.jsp" method="get">
		<button class="btn1" name="num" value="1">1번</button>
		<button class="btn2" name="num" value="2">2번</button>
		<button class="btn3" name="num" value="3">3번</button>
	</div>
	</form>
	<div id="msg">
		<%
			String msg = request.getParameter("msg");
		if (msg != null) {
			out.print(msg);
		}
		%>
	</div>
=======
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="examPro.jsp">
		<table>
			<tr>
				<td><button onclick="location.href='examPro'" name="no1">1번</button></td>
				<td><button onclick="location.href='examPro'" name="no2">2번</button></td>
				<td><button onclick="location.href='examPro'" name="no3">3번</button></td>
			</tr>
			
		</table>
	</form>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>