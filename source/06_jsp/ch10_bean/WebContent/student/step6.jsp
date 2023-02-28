<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:useBean id="st" class="com.lec.ex.Student" scope="request"/>
	<jsp:setProperty name="st" property="*"/>
	<jsp:forward page="studentResult.jsp"/>
</body>
</html>