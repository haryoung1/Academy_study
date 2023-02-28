<%@ page language="java" contentType="text/html; charset=UTF-8"
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
</body>
</html>