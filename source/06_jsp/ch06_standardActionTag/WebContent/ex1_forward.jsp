<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 요청 url : ex1_forward.jsp?n=1 -->
	<h2>ex1_forward.jsp 입니다.</h2>
	<jsp:forward page="ex2_forward.jsp"/> <!-- 주소창의 url 안바뀜 (request 객체 그대로) -->
</body>
</html>