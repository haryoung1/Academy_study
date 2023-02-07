<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="5_gugudanSuOut.jsp" method="get">
	<!-- 웹에서 method는 get or post 이 2개만 주로 사용함. -->
		<p>원하는 단수 <input type="number" name="su" required="required"></p>
		<p><input type="submit" value="구구단 출력"></p>
	</form>
</body>
</html>