<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dto2.BoardDto2"%>
<%@page import="com.lec.dao2.BoardDao2"%>
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
	<a href="xx.jsp">404 TEST</a>
	<%
		BoardDao2 bDao = BoardDao2.getInstance();
		out.println("<h3>1. 글갯수 : " + bDao.getBoardTotalCnt() + "</h3>");
	%>
</body>
</html>