<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<% String conPath = request.getContextPath(); %>
=======
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<<<<<<< HEAD
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="st" class="com.lec.ex.Student" scope="request"/>
	<jsp:setProperty name="st" property="*"/>
=======
</head>
<body>
	<jsp:useBean id="st" class="com.lec.ex.Student" scope="request"/>
	<jsp:setProperty property="*" name="st"/>
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
	<jsp:forward page="studentResult.jsp"/>
</body>
</html>