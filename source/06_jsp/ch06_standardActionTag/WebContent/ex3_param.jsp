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
	<%-- ex3_param.jsp?n=1 --%>
	<h1>ex3_param.jsp 이무니다.</h1>
	<jsp:forward page="ex4.jsp">
		<jsp:param value="aaa" name="id"/>
		<jsp:param value="111" name="pw"/>
=======
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- ex3_param.jsp?n=1 --%>
	<h1>ex3_param.jsp 입니다.</h1>
	<jsp:forward page="ex4.jsp">
		<jsp:param name="id" value="aaa" />
		<jsp:param name="pw" value="111" />
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
	</jsp:forward>
</body>
</html>