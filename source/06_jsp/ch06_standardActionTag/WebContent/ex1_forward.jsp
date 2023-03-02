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
<<<<<<< HEAD
	<h2>ex1_forward.jsp 입니다.</h2>
	<jsp:forward page="ex2_forward.jsp"/> <!-- 주소창의 url 안바뀜 (request 객체 그대로) -->
=======
	<h2>ex1_forward.jsp입니다.</h2>
	<jsp:forward page="ex2_forward.jsp"/><!-- 주소창의 url이 안바뀜(request 객체가 그대로) -->
	<%--
		response.sendRedirect("ex2_forward.jsp"); // 주소창의 url이 바뀜 = 새로운 요청(새로운 request 객체)
	--%>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>