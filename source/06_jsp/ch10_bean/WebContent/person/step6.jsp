<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<% String conPath = request.getContextPath(); %>
=======
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<<<<<<< HEAD
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
=======
>>>>>>> 634167439382932c285b4c7ab32bb31f61de1cbf
</head>
<body>
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
	<jsp:setProperty property="*" name="p"/>
	<jsp:forward page="personView.jsp"/>
</body>
</html>