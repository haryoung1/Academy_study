<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<<<<<<< HEAD
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>ex6_param_include.jsp파일입니다</h1>
=======
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h2>ex6_param_include.jsp 파일 입니다</h2>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
	<hr>
	<jsp:include page="ex4.jsp">
		<jsp:param value="1" name="n"/>
		<jsp:param value="aaa" name="id"/>
		<jsp:param value="111" name="pw"/>
	</jsp:include>
	<hr>
<<<<<<< HEAD
	<h1>다시 ex6_param_include.jsp파일입니다</h1>
=======
	<h1>다시 ex6_param_include.jsp 파일 입니다</h1>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</body>
</html>