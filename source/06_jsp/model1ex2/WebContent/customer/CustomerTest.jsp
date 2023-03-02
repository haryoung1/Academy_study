<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		CustomerDao cDao = CustomerDao.getInstance();
		out.println("<h3>1. 등록된 회원수 : " + cDao.getCustomer() + "</h3>"); 
		out.println("<h3>2. 회원리스트 </h3>");

	%>
</body>
</html>